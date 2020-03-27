package com.noobanidus.variegated.events;

import com.noobanidus.variegated.ConfigManager;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Mod.EventBusSubscriber
@SuppressWarnings("unused")
public class PotionEventHandler {
  public static Set<UUID> flyingPlayers = new HashSet<>();

  @SubscribeEvent
  public static void entityUpdate(LivingEvent.LivingUpdateEvent event) {
    if (ConfigManager.wings) {
      LivingEntity entity = event.getEntityLiving();
      if (!entity.world.isRemote && entity instanceof PlayerEntity) {
        PlayerEntity player = (PlayerEntity) entity;
        if (player.isPotionActive(Registrar.wings)) {
          flyingPlayers.add(player.getUniqueID());
          player.abilities.allowFlying = true;
          player.sendPlayerAbilities();
        } else if (flyingPlayers.contains(player.getUniqueID())) {
          player.abilities.allowFlying = false;
          player.abilities.isFlying = false;
          player.sendPlayerAbilities();
          flyingPlayers.remove(player.getUniqueID());
        }
      }
    }
  }
}
