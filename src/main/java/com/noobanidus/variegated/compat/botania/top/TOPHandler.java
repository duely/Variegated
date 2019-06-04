package com.noobanidus.variegated.compat.botania.top;

import com.noobanidus.variegated.compat.top.ITOPHandler;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.common.block.BlockIncensePlate;
import vazkii.botania.common.block.tile.TileIncensePlate;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.item.brew.ItemIncenseStick;

import static mcjty.theoneprobe.api.TextStyleClass.OK;
import static mcjty.theoneprobe.api.TextStyleClass.WARNING;

public class TOPHandler implements ITOPHandler {
    @Override
    public void handle(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
        if (blockState.getBlock() instanceof BlockIncensePlate) {
            TileIncensePlate plate = (TileIncensePlate) world.getTileEntity(data.getPos());

            if (plate == null) {
                probeInfo.text(WARNING + "Invalid tile entity for Incense Plate.");
                return;
            }

            int timeLeft = plate.timeLeft / 60 / 20;
            ItemStack stack = plate.getItemHandler().getStackInSlot(0);
            Brew brew = ((ItemIncenseStick) ModItems.incenseStick).getBrew(stack);
            if (stack.isEmpty()) {
                probeInfo.text(WARNING + "No brew.");
            } else {
                String brew_name = I18n.format(brew.getUnlocalizedName());
                probeInfo.text(OK + String.format("Brew: %s", brew_name));
                if (timeLeft == 0) {
                    probeInfo.text(WARNING + "Unlit.");
                } else {
                    probeInfo.text(OK + String.format("%d minutes remaining.", timeLeft));
                }
            }
        }
    }
}
