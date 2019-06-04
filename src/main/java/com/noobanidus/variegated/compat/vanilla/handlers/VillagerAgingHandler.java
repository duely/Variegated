package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class VillagerAgingHandler {

    @SubscribeEvent
    public static void onVillageInteract(PlayerInteractEvent.EntityInteract event) {
        if (!VariegatedConfig.ageVillagers) return;

        ItemStack item = event.getItemStack();

        if (item.isEmpty() || !(event.getTarget() instanceof EntityVillager)) return;

        EntityPlayer player = event.getEntityPlayer();
        if (player.world.isRemote) return;

        EntityVillager villager = (EntityVillager) event.getTarget();

        if (villager.isChild() && item.getItem() == Items.EMERALD) {
            BlockPos pos = villager.getPos();
            ((WorldServer) villager.world).spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, 2, 0, 0, 0, 0.5);

            villager.addGrowth(VariegatedConfig.ageValue);

            if (!player.capabilities.isCreativeMode) {
                item.shrink(1);
            }

            event.setCanceled(true);
        }
    }
}

