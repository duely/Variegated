package com.noobanidus.variegated.potions;

import com.noobanidus.variegated.Variegated;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class WingsEffect extends Effect {
  public WingsEffect() {
    super(EffectType.BENEFICIAL, 0x49d1c6);
    setRegistryName(Variegated.MODID, "wings");
  }

  @Override
  public boolean isReady(int duration, int amplifier) {
    return true;
  }
}


