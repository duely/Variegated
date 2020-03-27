package com.noobanidus.variegated.compat.botania.enchantment;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.recipe.RecipeRuneAltar;
import vazkii.botania.common.block.ModBlocks;
import vazkii.botania.common.item.ModItems;

import javax.annotation.Nonnull;
import java.util.Collections;

public class ManaboundEnchantment extends Enchantment {
  public static void registerEnchantment() {
    if (Loader.isModLoaded("botania")) {
      ItemStack enchantment = new ItemStack(Items.ENCHANTED_BOOK);
      EnchantmentHelper.setEnchantments(Collections.singletonMap(Registrar.manabound, 1), enchantment);
      BotaniaAPI.runeAltarRecipes.put(new ResourceLocation(Variegated.MODID, "manabound"), new RecipeRuneAltar(new ResourceLocation(Variegated.MODID, "manabound"), enchantment, 50000, Ingredient.fromItems(Items.BOOK), Ingredient.fromItems(ModItems.runeMana), Ingredient.fromItems(ModBlocks.manasteelBlock.asItem()), Ingredient.fromItems(ModBlocks.manaDiamondBlock.asItem()), Ingredient.fromItems(ModItems.spellCloth), Ingredient.fromItems(ModItems.manaPearl)));
    }
  }

  public ManaboundEnchantment(String id) {
    super(Rarity.VERY_RARE, EnchantmentType.ALL, EquipmentSlotType.values());
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
    return (item instanceof ArmorItem || item instanceof ToolItem) && !(item instanceof IManaUsingItem);
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
