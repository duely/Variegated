package com.noobanidus.variegated.compat.vanilla.handlers;

// Leaf-walking/swimming code taken from MIT-licensed HorseTweaks
// https://github.com/blay09/HorseTweaks/blob/master/src/main/java/net/blay09/mods/horsetweaks/tweaks/LeafWalkerHandler.java

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class HorseMovementHandler {
  @OnlyIn(Dist.CLIENT)
  @SubscribeEvent
  public static void onSwimEvent(TickEvent.ClientTickEvent event) {
    if (!ConfigManager.vanillaSettings.swimmingEnabled || Minecraft.getInstance().isGamePaused()) {
      return;
    }

    PlayerEntity player = Minecraft.getInstance().player;
    if (player != null && player.getRidingEntity() instanceof AbstractHorseEntity) {
      AbstractHorseEntity horse = (AbstractHorseEntity) player.getRidingEntity();
      if (horse.isInLava() || horse.isInWater()) {
        horse.addVelocity(0f, 0.0125f, 0f);
      }
    }
  }
}
