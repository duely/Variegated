package com.noobanidus.variegated.entity.ai;

import com.noobanidus.variegated.init.Registrar;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EntityAILoveTempt extends EntityAITempt {
  public EntityAILoveTempt(EntityCreature temptedEntityIn, double speedIn) {
    super(temptedEntityIn, speedIn, Items.AIR, false);
  }

  @Override
  protected boolean isTempting(ItemStack stack) {
    return temptingPlayer.isPotionActive(Registrar.attraction);
  }
}
