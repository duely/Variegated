package com.noobanidus.variegated.blocks;

import net.minecraft.block.Block;

public class DefiledGroundBlock extends Block {
  public DefiledGroundBlock(Block.Properties properties) {
    super(properties);
    //super(Material.EARTH);
    //setTranslationKey("defiled_ground");
/*    setRegistryName(Variegated.MODID, "defiled_ground");
    setCreativeTab(Variegated.TAB);*/
  }

/*  @Override
  public boolean hasTileEntity(IBlockState state) {
    return com.noobanidus.variegated.VariegatedConfig.DefiledGround.defiledGroundEnabled;

  }

  @Nullable
  @Override
  public TileEntity createTileEntity(World world, IBlockState state) {
    if (com.noobanidus.variegated.VariegatedConfig.DefiledGround.defiledGroundEnabled) {
      return new TileEntityDefiledGround();
    }

    return null;
  }*/

/*  @Override
  protected ItemStack getSilkTouchDrop(IBlockState state) {
    return new ItemStack(this);
  }

  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    if (com.noobanidus.variegated.VariegatedConfig.DefiledGround.requireSilkTouch) {
      return Item.getItemFromBlock(Blocks.DIRT);
    } else {
      return Item.getItemFromBlock(this);
    }
  }*/
}
