package com.noobanidus.variegated.compat.bloodmagic.handlers;

import WayofTime.bloodmagic.tile.TileSoulForge;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class HellfireSpeed {
  public static void init () {
    if (VariegatedConfig.BloodMagic.hellfireSpeed != 100) {
      Field field = ObfuscationReflectionHelper.findField(TileSoulForge.class, "ticksRequired");
      Field modifiers = ObfuscationReflectionHelper.findField(Field.class, "modifiers");
      modifiers.setAccessible(true);
      try {
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
      } catch (IllegalAccessException e) {
        Variegated.LOG.info("Unable to adjust Hellfire Forge speed (couldn't remove final)");
        return;
      }

      try {
        field.setInt(TileSoulForge.class, VariegatedConfig.BloodMagic.hellfireSpeed);
      } catch (IllegalAccessException e) {
        Variegated.LOG.info("Unable to adjust Hellfire Forge speed (couldn't set field)");
        e.printStackTrace();
      }
    }
  }
}
