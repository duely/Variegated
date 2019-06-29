package com.noobanidus.variegated.recipes.ingredient;

import com.google.gson.JsonObject;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.IIngredientFactory;
import net.minecraftforge.common.crafting.JsonContext;

import javax.annotation.Nonnull;

public class IngredientSkull extends Ingredient {
  public static IngredientSkull INGREDIENT = new IngredientSkull();

  public IngredientSkull() {
    super(new ItemStack(Items.SKULL, 1, 0), new ItemStack(Items.SKULL, 1, 1), new ItemStack(Items.SKULL, 1, 2), new ItemStack(Items.SKULL, 1, 3), new ItemStack(Items.SKULL, 1, 4), new ItemStack(Items.SKULL, 1, 5));
  }

  public static class Factory implements IIngredientFactory {
    @Nonnull
    @Override
    public Ingredient parse(JsonContext context, JsonObject json) {
      return INGREDIENT;
    }
  }
}
