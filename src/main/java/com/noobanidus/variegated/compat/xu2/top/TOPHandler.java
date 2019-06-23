package com.noobanidus.variegated.compat.xu2.top;

import com.noobanidus.variegated.compat.top.ITOPHandler;
import com.rwtema.extrautils2.blocks.BlockEnderLilly;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import static mcjty.theoneprobe.api.TextStyleClass.OK;
import static mcjty.theoneprobe.api.TextStyleClass.WARNING;

public class TOPHandler implements ITOPHandler {

  @Override
  public void handle(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
    if (blockState.getBlock() instanceof BlockEnderLilly) {
      int growthState = blockState.getValue(BlockEnderLilly.GROWTH_STATE);
      probeInfo.text((growthState == 7) ? OK + "Fully grown" : "Growth: " + WARNING + String.format("%s%%", growthState * 14));
    }
  }
}
