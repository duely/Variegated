package com.noobanidus.variegated.network;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Networking {
  public static final SimpleNetworkWrapper channel = NetworkRegistry.INSTANCE.newSimpleChannel("variegated");

  public static void register () {
    channel.registerMessage(PacketVarInfo.class, PacketVarInfo.class, 0, Side.CLIENT);
  }
}
