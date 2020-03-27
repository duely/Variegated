package com.noobanidus.variegated.potions;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class BoonEffect extends Effect {
  public BoonEffect() {
    super(EffectType.BENEFICIAL, 0xecbb10);
  }

  @Override
  public boolean isReady(int duration, int amplifier) {
    return true;
  }

  @Override
  public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
    if (entityLivingBaseIn instanceof PlayerEntity) {
      PlayerEntity player = (PlayerEntity) entityLivingBaseIn;

      ItemStack stack = player.getHeldItemMainhand();

      if (player.fishingBobber != null) {
        FishingBobberEntity hook = player.fishingBobber;
        int l = EnchantmentHelper.getFishingLuckBonus(stack) + amplifier + 1;

        // TODO: Fix this
        /*        hook.setLuck(l);*/

        switch (amplifier) {
          case 0:
            if (entityLivingBaseIn.ticksExisted % 3 == 0)
              hook.tick();
            break;
          case 1:
            if (entityLivingBaseIn.ticksExisted % 2 == 0)
              hook.tick();
            break;
          case 2:
            hook.tick();
            break;
        }
      }
    }
  }
}

