package com.noobanidus.variegated.compat.thaumcraft.blocks;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Loader;

import javax.annotation.Nullable;

public class PorousStoneProvider {

  @Nullable
  public static Block provide () {
    if (Loader.isModLoaded("thaumcraft")) {
      return new BlockStonePorousReplacement();
    } else {
      return null;
    }
  }
}
