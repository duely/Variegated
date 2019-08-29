package com.noobanidus.variegated.commands;

import com.google.common.collect.Lists;
import com.noobanidus.variegated.network.Networking;
import com.noobanidus.variegated.network.PacketVarInfo;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
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

public class CommandInfo extends CommandBase {
  public CommandInfo() {
  }

  @Override
  public String getName() {
    return "varinfo";
  }

  @Override
  public String getUsage(ICommandSender sender) {
    return "/varinfo";
  }

  @Override
  public List<String> getAliases() {
    return Collections.singletonList("varinfo");
  }

  @Override
  public int getRequiredPermissionLevel() {
    return 0;
  }

  @Override
  public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
    if (sender instanceof EntityPlayerMP) {
      EntityPlayerMP player = (EntityPlayerMP) sender;
      player.sendMessage(new TextComponentString("Current container (server-side): " + player.openContainer.getClass()));
      PacketVarInfo packet = new PacketVarInfo();
      Networking.channel.sendTo(packet, player);
    }
  }
}
