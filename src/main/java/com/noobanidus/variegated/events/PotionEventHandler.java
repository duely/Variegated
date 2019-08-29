package com.noobanidus.variegated.events;

import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;

@Mod.EventBusSubscriber
@SuppressWarnings("unused")
public class PotionEventHandler {
  public static Set<UUID> flyingPlayers = new HashSet<>();

  @SubscribeEvent
  public static void entityUpdate (LivingEvent.LivingUpdateEvent event) {
    if (VariegatedConfig.wings) {
      EntityLivingBase entity = event.getEntityLiving();
      if (!entity.world.isRemote && entity instanceof EntityPlayer) {
        EntityPlayer player = (EntityPlayer) entity;
        if (player.isPotionActive(Registrar.wings)) {
          flyingPlayers.add(player.getUniqueID());
          player.capabilities.allowFlying = true;
          player.sendPlayerAbilities();
        } else if (flyingPlayers.contains(player.getUniqueID())) {
          player.capabilities.allowFlying = false;
          player.capabilities.isFlying = false;
          player.sendPlayerAbilities();
          flyingPlayers.remove(player.getUniqueID());
        }
      }
    }
  }
}
