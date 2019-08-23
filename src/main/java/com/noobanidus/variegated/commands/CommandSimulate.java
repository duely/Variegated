package com.noobanidus.variegated.commands;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class CommandSimulate extends CommandBase {
  public CommandSimulate() {
  }

  @Override
  public String getName() {
    return "enchsim";
  }

  @Override
  public String getUsage(ICommandSender sender) {
    return "/enchsim";
  }

  @Override
  public List<String> getAliases() {
    return Collections.singletonList("enchsim");
  }

  @Override
  public int getRequiredPermissionLevel() {
    return 2;
  }

  @Override
  public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
    sender.sendMessage(new TextComponentString("Beginning enchantment simulation..."));
    List<String> output = new ArrayList<>();
    List<Item> ironItems = Arrays.asList(Items.IRON_HELMET, Items.IRON_BOOTS, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_SWORD, Items.IRON_SHOVEL, Items.IRON_HOE, Items.IRON_AXE, Items.IRON_PICKAXE, Items.SHEARS, Items.SHIELD, Items.BOW, Items.ELYTRA, Items.FLINT_AND_STEEL, Items.FISHING_ROD, Items.TOTEM_OF_UNDYING);
    List<Item> goldItems = Arrays.asList(Items.GOLDEN_HELMET, Items.GOLDEN_BOOTS, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_SWORD, Items.GOLDEN_SHOVEL, Items.GOLDEN_HOE, Items.GOLDEN_AXE, Items.GOLDEN_PICKAXE);
    List<Item> diamondItems = Arrays.asList(Items.DIAMOND_HELMET, Items.DIAMOND_BOOTS, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_SWORD, Items.DIAMOND_SHOVEL, Items.DIAMOND_HOE, Items.DIAMOND_AXE, Items.DIAMOND_PICKAXE);
    int powerMin = 0;
    int powerMax = 75;
    int permutations = 5000;

    output.add("----------------------------");
    output.add("Iron items:");
    simulate(ironItems, output, powerMin, powerMax, permutations);
    output.add("----------------------------");
    output.add("Diamond items:");
    simulate(diamondItems, output, powerMin, powerMax, permutations);
    output.add("----------------------------");
    output.add("Golden items:");
    simulate(goldItems, output, powerMin, powerMax, permutations);

    Path path = Paths.get("enchantment_simulation.log");
    try {
      Files.write(path, output, StandardCharsets.UTF_8);
    } catch (IOException ignored) {
    }
    sender.sendMessage(new TextComponentString("Enchantment simulation complete!"));
  }

  private void simulate(List<Item> items, List<String> output, int powerMin, int powerMax, int permutations) {
    Random random = new Random();
    for (Item item : items) {
      if (item.getRegistryName() == null) {
        continue;
      }
      String name = item.getRegistryName().toString();
      ItemStack stack = new ItemStack(item);
      Object2IntOpenHashMap<String> map = new Object2IntOpenHashMap<>();
      map.defaultReturnValue(0);
      IntArrayList skippedPowers = new IntArrayList();
      for (int i = powerMin; i <= powerMax; i += 5) {
        map.clear();
        for (int j = 0; j < permutations; j++) {
          List<EnchantmentData> data = EnchantmentHelper.buildEnchantmentList(random, stack, i, false);
          if (data.isEmpty()) {
            int q = map.getInt("empty");
            map.put("empty", q + 1);
          }
          for (EnchantmentData ench : data) {
            ResourceLocation res = ench.enchantment.getRegistryName();
            if (res == null) {
              throw new NullPointerException();
            }
            String enchName;
            if (res.getNamespace().equals("minecraft")) {
              enchName = res.getPath();
            } else {
              enchName = res.toString();
            }
            enchName = enchName + " " + ench.enchantmentLevel;
            int val = map.getInt(enchName);
            map.put(enchName, val + 1);
          }
        }
        List<String> keys = Lists.newArrayList(map.keySet());
        if (keys.size() == 1 && keys.get(0).equals("empty")) {
          skippedPowers.add(i);
        } else {
          keys.sort(String::compareTo);
          output.add("    [" + name + "] at power [" + i + "]");
          for (String k : keys) {
            output.add("        [" + k + "] seen [" + String.format("%.1f", (map.getInt(k) / (float) permutations) * 100) + "%] (" + map.getInt(k) + " times)");
          }
        }
      }
      StringJoiner join = new StringJoiner(", ");
      skippedPowers.forEach(i -> join.add("" + i));
      output.add("    [Skipped enchantment power: " + join.toString() + "]");
    }
  }
}
