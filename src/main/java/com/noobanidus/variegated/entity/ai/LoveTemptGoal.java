package com.noobanidus.variegated.entity.ai;

import com.noobanidus.variegated.init.Registrar;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class LoveTemptGoal extends TemptGoal {
  public LoveTemptGoal(CreatureEntity temptedEntityIn, double speedIn) {
    super(temptedEntityIn, speedIn, Ingredient.EMPTY, false);
  }

  @Override
  protected boolean isTempting(ItemStack stack) {
    return closestPlayer.isPotionActive(Registrar.attraction);
  }
}
