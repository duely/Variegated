package com.noobanidus.variegated.compat.thaumcraft.top;

import com.noobanidus.variegated.compat.thaumcraft.blocks.BlockCompressedVisBattery;
import com.noobanidus.variegated.compat.top.ITOPHandler;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import thaumcraft.common.blocks.crafting.BlockVoidSiphon;
import thaumcraft.common.blocks.devices.BlockVisBattery;
import thaumcraft.common.blocks.world.ore.BlockCrystal;
import thaumcraft.common.tiles.crafting.TileVoidSiphon;

import static mcjty.theoneprobe.api.TextStyleClass.OK;
import static mcjty.theoneprobe.api.TextStyleClass.WARNING;

public class TOPHandler implements ITOPHandler {
  @Override
  public void handle(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
    if (blockState.getBlock() instanceof BlockCompressedVisBattery && mode == ProbeMode.EXTENDED) {
      int power = blockState.getValue(BlockCompressedVisBattery.CHARGE);
      probeInfo.text(String.format(OK + "Vis: %s" + ((power == 10) ? " (max)" : ""), power * 9));
    } else if (blockState.getBlock() instanceof BlockVisBattery && mode == ProbeMode.EXTENDED) {
      int power = blockState.getValue(BlockVisBattery.CHARGE);
      probeInfo.text(String.format(OK + "Vis: %s" + ((power == 10) ? " (max)" : ""), power));
    } else if (blockState.getBlock() instanceof BlockCrystal) {
      int size = blockState.getValue(BlockCrystal.SIZE);
      String progress = ((size == 0) ? "25%" : ((size == 1)) ? "50%" : ((size == 2)) ? "75%" : "100%");

      probeInfo.text(((size == 3) ? OK : WARNING) + "Growth: " + progress);
    } else if (blockState.getBlock() instanceof BlockVoidSiphon) {
      TileVoidSiphon siphon = (TileVoidSiphon) world.getTileEntity(data.getPos());

      if (siphon != null) {
        int progress = (int) ((siphon.progress / 2000.f) * 100.f);

        probeInfo.text(((progress < 80) ? WARNING : OK) + String.format("Growth: %d%%", progress));
      } else {
        probeInfo.text(WARNING + "Invalid tile entity for Siphon.");
      }
    }
  }
}
