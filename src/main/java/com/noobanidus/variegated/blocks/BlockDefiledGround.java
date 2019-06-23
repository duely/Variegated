package com.noobanidus.variegated.blocks;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.tileentities.TileEntityDefiledGround;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlockDefiledGround extends Block {
  public BlockDefiledGround() {
    super(Material.GROUND);
    setTranslationKey("defiled_ground");
    setRegistryName(Variegated.MODID, "defiled_ground");
    setCreativeTab(Variegated.TAB);
  }

  @Override
  public boolean hasTileEntity(IBlockState state) {
    return VariegatedConfig.DefiledGround.defiledGroundEnabled;

  }

  @Nullable
  @Override
  public TileEntity createTileEntity(World world, IBlockState state) {
    if (VariegatedConfig.DefiledGround.defiledGroundEnabled) {
      return new TileEntityDefiledGround();
    }

    return null;
  }

  @Override
  protected ItemStack getSilkTouchDrop(IBlockState state) {
    return new ItemStack(this);
  }

  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    if (VariegatedConfig.DefiledGround.requireSilkTouch) {
      return Item.getItemFromBlock(Blocks.DIRT);
    } else {
      return Item.getItemFromBlock(this);
    }
  }
}
