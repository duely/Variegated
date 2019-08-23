package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class TrampleHandler {
  @SubscribeEvent
  public static void onTrampleEvent(BlockEvent.FarmlandTrampleEvent event) {
    if (VariegatedConfig.vanillaSettings.cancelTrample) {
      event.setCanceled(true);
    }
  }
}
