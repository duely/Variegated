package com.noobanidus.variegated.events;

import com.noobanidus.variegated.entity.ai.LoveTemptGoal;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
@SuppressWarnings("unused")
public class StandardEventHandler {
  @SubscribeEvent
  public static void onEntityJoinWorld(EntityJoinWorldEvent event) {
    if (!(event.getEntity() instanceof CreatureEntity)) {
      return;
    }
    if ((event.getEntity().getType().getClassification() != EntityClassification.MONSTER) && !(event.getEntity() instanceof IMob) && event.getEntity() instanceof AnimalEntity) {
      AnimalEntity animal = (AnimalEntity) event.getEntity();
      LoveTemptGoal temp;
      try {
        temp = new LoveTemptGoal(animal, 1D);
      } catch (IllegalArgumentException exception) {
        return;
      }
      animal.goalSelector.addGoal(3, temp);
    }
  }
}
