package com.noobanidus.variegated.compat.botania.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import vazkii.botania.api.mana.IManaUsingItem;

import javax.annotation.Nonnull;

public class EnchantmentManabound extends Enchantment {
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
