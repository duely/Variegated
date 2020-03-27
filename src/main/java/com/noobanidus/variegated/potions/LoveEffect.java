package com.noobanidus.variegated.potions;

import com.noobanidus.variegated.Variegated;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class LoveEffect extends Effect {
  public LoveEffect() {
    super(EffectType.BENEFICIAL, 0xdb67ba);
    setRegistryName(Variegated.MODID, "attraction");
  }

  @Override
  public boolean isReady(int duration, int amplifier) {
    return true;
  }

  @Override
  public void performEffect(LivingEntity target, int amplifier) {
    if (target instanceof AnimalEntity) {
      AnimalEntity animal = (AnimalEntity) target;
      if (animal.getGrowingAge() == 0 && !animal.isInLove()) {
        animal.setInLove(null);
      }
      target.removePotionEffect(this);
    }
  }
}

