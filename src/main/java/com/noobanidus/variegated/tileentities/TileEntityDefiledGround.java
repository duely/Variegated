package com.noobanidus.variegated.tileentities;

import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.storage.AnvilChunkLoader;
import net.minecraftforge.event.ForgeEventFactory;

public class TileEntityDefiledGround extends TileEntity implements ITickable {
  /*private final MobSpawnerBaseLogic logic = new MobSpawnerBaseLogic() {
    @Override
    public void broadcastEvent(int id) {
      TileEntityDefiledGround.this.getWorld().addBlockEvent(TileEntityDefiledGround.this.getPos(), Registrar.defiled, id, 0);
    }

    @Override
    public World getSpawnerWorld() {
      return TileEntityDefiledGround.this.getWorld();
    }

    @Override
    public BlockPos getSpawnerPosition() {
      return TileEntityDefiledGround.this.getPos();
    }

    // ????????????????

  };*/

  @Override
  public void update() {
    if (world.isRemote) return;

    if (world.getDifficulty() == EnumDifficulty.PEACEFUL) return;

    BlockPos spawnPoint = getPos().up();

    if (!VariegatedConfig.DefiledGround.defiledGroundEnabled) return;

    if (world.rand.nextInt(VariegatedConfig.DefiledGround.spawnChance) != 0) return;

    if (VariegatedConfig.DefiledGround.minimumLight != -1) {
      if (world.getLightFor(EnumSkyBlock.BLOCK, spawnPoint) > VariegatedConfig.DefiledGround.minimumLight) return;
    }

    if (VariegatedConfig.DefiledGround.mobCheck) {
      int limit = VariegatedConfig.DefiledGround.maximumMobs;
      AxisAlignedBB boundingBox = new AxisAlignedBB(getPos()).grow(-VariegatedConfig.DefiledGround.horizontalRadius, VariegatedConfig.DefiledGround.verticalRadius, VariegatedConfig.DefiledGround.horizontalRadius);
      if (world.getEntitiesWithinAABB(EntityLivingBase.class, boundingBox, (entity) -> entity != null && entity.isCreatureType(EnumCreatureType.MONSTER, false)).size() > limit)
        return;
    }

    EntityLiving mob = getMobForSpawn(world, spawnPoint);
    if (mob == null) return;

    float x = spawnPoint.getX() + 0.5f;
    float y = spawnPoint.getY();
    float z = spawnPoint.getZ() + 0.5f;

    mob.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0f, 0.0f);

    if (!ForgeEventFactory.doSpecialSpawn(mob, world, x, y, z, null)) {
      mob.onInitialSpawn(world.getDifficultyForLocation(spawnPoint), null);
    }

    AnvilChunkLoader.spawnEntity(mob, world);
    world.playEvent(2004, spawnPoint, 0);
  }

  private EntityLiving getMobForSpawn(World world, BlockPos pos) {
    Biome.SpawnListEntry entry = ((WorldServer) world).getSpawnListEntryForTypeAt(EnumCreatureType.MONSTER, pos);

    if (entry == null || entry.entityClass == null || !((WorldServer) world).canCreatureTypeSpawnHere(EnumCreatureType.MONSTER, entry, pos)) {
      return null;
    }

    try {
      return entry.newInstance(world);
    } catch (Exception e) {
      return null;
    }
  }
}
