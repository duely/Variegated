package com.noobanidus.variegated.compat.thaumcraft.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import thaumcraft.common.blocks.BlockTC;

public class BlockStonePorousReplacement extends BlockTC {
  public BlockStonePorousReplacement() {
    super(Material.ROCK, "stone_porous");
    this.setHardness(1.0F);
    this.setResistance(5.0F);
    this.setSoundType(SoundType.STONE);
  }
}
