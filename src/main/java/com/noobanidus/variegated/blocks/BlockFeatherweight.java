package com.noobanidus.variegated.blocks;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;

@SuppressWarnings("deprecation")
public class BlockFeatherweight extends Block {
  public BlockFeatherweight() {
    super(Material.CLOTH);
    setHardness(0f);
    setTranslationKey("featherweight");
    setRegistryName(Variegated.MODID, "featherweight");
    setCreativeTab(Variegated.TAB);
  }

  @Override
  public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
    super.onBlockHarvested(worldIn, pos, state, player);
    if (!worldIn.isRemote && !player.capabilities.isCreativeMode) {
      player.addItemStackToInventory(new ItemStack(this));
    }
  }

  @Override
  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    return Items.AIR;
  }

  @Override
  public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
    return ItemStack.EMPTY;
  }

  public static class ItemBlockFeatherweight extends ItemBlock {
    public ItemBlockFeatherweight(Block block) {
      super(block);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand handIn) {
      if (!worldIn.isRemote) {
        Vec3d look = player.getLookVec();

        EnumFacing side = EnumFacing.getFacingFromVector((float) look.x, (float) look.y, (float) look.z);

        int x = side == EnumFacing.WEST ? (int) Math.floor(player.getEntityBoundingBox().minX) - 1 : side == EnumFacing.EAST ? (int) Math.floor(player.getEntityBoundingBox().maxX) + 1 : (int) Math.floor(player.posX);
        int y = side == EnumFacing.DOWN ? (int) Math.floor(player.getEntityBoundingBox().minY) - 1 : side == EnumFacing.UP ? (int) Math.floor(player.getEntityBoundingBox().maxY) + 1 : (int) Math.floor(player.posY + player.getEyeHeight());
        int z = side == EnumFacing.NORTH ? (int) Math.floor(player.getEntityBoundingBox().minZ) - 1 : side == EnumFacing.SOUTH ? (int) Math.floor(player.getEntityBoundingBox().maxZ) + 1 : (int) Math.floor(player.posZ);

        BlockPos pos = new BlockPos(x, y, z);
        IBlockState state = worldIn.getBlockState(pos);
        if (worldIn.isAirBlock(pos) || state.getBlock().isReplaceable(worldIn, pos)) {
          worldIn.setBlockState(pos, Registrar.featherweight.getDefaultState());
          if (!player.capabilities.isCreativeMode) {
            player.getHeldItem(handIn).shrink(1);
          }
        }
      }

      return ActionResult.newResult(EnumActionResult.PASS, player.getHeldItem(handIn));
    }
  }
}
