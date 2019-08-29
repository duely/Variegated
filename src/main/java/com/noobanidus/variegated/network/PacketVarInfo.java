package com.noobanidus.variegated.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PacketVarInfo implements IMessage, IMessageHandler<PacketVarInfo, PacketVarInfo> {
  public PacketVarInfo() {
  }

  @Override
  public void fromBytes(ByteBuf buf) {
  }

  @Override
  public void toBytes(ByteBuf buf) {
  }

  @Override
  @SideOnly(Side.CLIENT)
  public PacketVarInfo onMessage(PacketVarInfo message, MessageContext ctx) {
    Minecraft mc = Minecraft.getMinecraft();
    mc.player.sendMessage(new TextComponentString("Current container (client-side): " + mc.player.openContainer.getClass()));
    return null;
  }
}
