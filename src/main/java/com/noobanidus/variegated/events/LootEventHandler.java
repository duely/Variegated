package com.noobanidus.variegated.events;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class LootEventHandler {
  @SubscribeEvent(priority = EventPriority.LOWEST)
  public static void onLootTableLoad(LootTableLoadEvent event) {
    if (VariegatedConfig.MobMash.disableLoot) {
      if (event.getName().equals(LootTableList.CHESTS_ABANDONED_MINESHAFT) || event.getName().equals(LootTableList.CHESTS_VILLAGE_BLACKSMITH)) {
        event.getTable().removePool("mob_mash");
      } else if (event.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID) || event.getName().equals(LootTableList.CHESTS_END_CITY_TREASURE) || event.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE) || event.getName().equals(LootTableList.CHESTS_NETHER_BRIDGE)) {
        event.getTable().removePool("mob_mash");
      } else if (event.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON) || event.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR)) {
        event.getTable().removePool("mob_mash");
      }
    }
  }
}
