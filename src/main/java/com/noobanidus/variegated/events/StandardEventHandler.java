package com.noobanidus.variegated.events;

import com.noobanidus.variegated.entity.ai.EntityAILoveTempt;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@SuppressWarnings("unused")
public class StandardEventHandler {
  @SubscribeEvent
  public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
    if (!(event.getEntity() instanceof EntityCreature)) {
      return;
    }
    /*if (event.getEntity() instanceof EntityVillager) {
      ((EntityVillager) event.getEntity()).tasks.addTask(3, new EntityAILoveTempt((EntityVillager) event.getEntity(), 1.5D));
    } else*/
    if (!event.getEntity().isCreatureType(EnumCreatureType.MONSTER, false) && !(event.getEntity() instanceof IMob) && event.getEntity() instanceof EntityAnimal) {
      EntityAnimal animal = (EntityAnimal) event.getEntity();
      EntityAILoveTempt temp;
      try {
        temp = new EntityAILoveTempt(animal, 1D);
      } catch (IllegalArgumentException exception) {
        return;
      }
      animal.tasks.addTask(3, temp);
    }
  }
}
