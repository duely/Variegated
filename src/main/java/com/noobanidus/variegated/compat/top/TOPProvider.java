package com.noobanidus.variegated.compat.top;

import com.noobanidus.variegated.Variegated;
import mcjty.theoneprobe.api.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInterModComms;

import javax.annotation.Nullable;

public class TOPProvider {
  private static boolean registered;

  public static void init() {
    if (registered) {
      return;
    }

    registered = true;

    FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "com.noobanidus.variegated.compat.top.TOPProvider$GetTheOneProbe");
  }

  @SuppressWarnings("unused")
  public static class GetTheOneProbe implements com.google.common.base.Function<ITheOneProbe, Void> {
    public static ITheOneProbe probe;

    @Nullable
    @Override
    public Void apply(ITheOneProbe theOneProbe) {
      probe = theOneProbe;
      probe.registerProvider(new IProbeInfoProvider() {
        @Override
        public String getID() {
          return "variegated:topprovider";
        }

        @Override
        public void addProbeInfo(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
          Variegated.handlers.forEach((handler) -> handler.handle(mode, probeInfo, player, world, blockState, data));
        }
      });
      return null;
    }
  }
}
