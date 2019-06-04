package com.noobanidus.variegated.compat.bloodmagic.rituals.events;

import WayofTime.bloodmagic.event.RitualEvent;
import WayofTime.bloodmagic.ritual.IMasterRitualStone;
import WayofTime.bloodmagic.ritual.types.RitualMeteor;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class RitualEventHandler {
    @SubscribeEvent
    @Optional.Method(modid = "bloodmagic")
    public static void onRitual(RitualEvent.RitualActivatedEvent event) {
        if (event.getRitual() instanceof RitualMeteor && VariegatedConfig.BloodMagic.meteorEnabled) {
            IMasterRitualStone mrs = event.getRitualStone();
            World world = mrs.getWorldObj();
            BlockPos p = mrs.getBlockPos();

            BlockPos pos = new BlockPos(p.getX(), p.getY() + VariegatedConfig.BloodMagic.y, p.getZ());

            if (world.isAirBlock(pos)) {
                world.setBlockState(pos, Blocks.STONE.getDefaultState());
            }
        }
    }
}
