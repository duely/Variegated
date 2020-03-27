package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class VillagerAgingHandler {

  @SubscribeEvent
  public static void onVillageInteract(PlayerInteractEvent.EntityInteract event) {
    if (!ConfigManager.vanillaSettings.ageVillagers) {
      return;
    }

    ItemStack item = event.getItemStack();

    if (item.isEmpty() || !(event.getTarget() instanceof VillagerEntity)) {
      return;
    }

    PlayerEntity player = event.getPlayer();
    if (player.world.isRemote) {
      return;
    }

    VillagerEntity villager = (VillagerEntity) event.getTarget();

    if (villager.isChild() && item.getItem() == Items.EMERALD) {
      BlockPos pos = villager.getPosition();
      //((ServerWorld) villager.world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 2, 0, 0, 0, 0.5);

      villager.addGrowth(ConfigManager.vanillaSettings.ageValue);

      if (!player.isCreative()) {
        item.shrink(1);
      }

      event.setCanceled(true);
    }
  }
}

