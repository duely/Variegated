package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class AnvilHandler {
  @SubscribeEvent
  public static void onAnvil(AnvilUpdateEvent event) {
    clear(event.getLeft(), event.getRight());
  }

  @SubscribeEvent
  public static void onAnvil(AnvilRepairEvent event) {
    clear(event.getItemResult());
    if (ConfigManager.vanillaSettings.anvilBreakChance != -1) {
      event.setBreakChance((float) ConfigManager.vanillaSettings.anvilBreakChance);
    }
  }

  private static void clear(ItemStack... stacks) {
    if (ConfigManager.vanillaSettings.anvilCostRemoval) {
      for (ItemStack stack : stacks) {
        if (stack.isEmpty()) {
          return;
        }

        CompoundNBT compound = stack.getTag();

        if (compound == null || !compound.contains("RepairCost")) {
          return;
        }

        compound.remove("RepairCost");
      }
    }
  }
}
