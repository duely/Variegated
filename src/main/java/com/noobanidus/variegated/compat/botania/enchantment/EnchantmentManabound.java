package com.noobanidus.variegated.compat.botania.enchantment;

import com.noobanidus.variegated.init.Registrar;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;

import javax.annotation.Nonnull;
import java.util.Collections;

public class EnchantmentManabound extends Enchantment {
  public static void registerEnchantment() {
    if (Loader.isModLoaded("botania")) {
      ItemStack book = new ItemStack(Items.BOOK);
      ItemStack rune = new ItemStack(ModItems.rune, 1, 8);
      ItemStack manaBlock = new ItemStack(ModBlocks.storage, 1, 0);
      ItemStack manaDiamond = new ItemStack(ModBlocks.storage, 1, 3);
      ItemStack cloth = new ItemStack(ModItems.spellCloth);
      ItemStack pearl = new ItemStack(ModItems.manaResource, 1, 1);
      ItemStack enchantment = new ItemStack(Items.ENCHANTED_BOOK);
      EnchantmentHelper.setEnchantments(Collections.singletonMap(Registrar.manabound, 1), enchantment);
      BotaniaAPI.registerRuneAltarRecipe(enchantment, 50000, book, rune, manaBlock, manaDiamond, cloth, pearl);
    }
  }

  public EnchantmentManabound(String id) {
    super(Rarity.VERY_RARE, EnumEnchantmentType.ALL, EntityEquipmentSlot.values());
    setRegistryName(id);
  }

  @Override
  public int getMinEnchantability(int level) {
    return 25;
  }

  @Override
  public int getMaxEnchantability(int level) {
    return 75;
  }

  @Override
  public int getMaxLevel() {
    return 1;
  }

  @Override
  @Nonnull
  public String getName() {
    return "enchantment.variegated.manabound";
  }

  @Override
  public boolean canApply(@Nonnull ItemStack stack) {
    Item item = stack.getItem();
    return (item instanceof ItemArmor || item instanceof ItemTool) && !(item instanceof IManaUsingItem);
  }

  @Override
  public boolean canApplyAtEnchantingTable(ItemStack stack) {
    return canApply(stack);
  }

  @Override
  public boolean isAllowedOnBooks() {
    return true;
  }

  @Override
  public boolean isTreasureEnchantment() {
    return true;
  }
}
