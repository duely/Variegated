package com.noobanidus.variegated.tileentities;

import com.noobanidus.variegated.ConfigManager;
import net.minecraft.entity.*;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.List;

public class DefiledGroundTile extends TileEntity implements ITickableTileEntity {
  private int nextSpawn = 0;

  public DefiledGroundTile(TileEntityType<?> tileEntityTypeIn) {
    super(tileEntityTypeIn);
  }

  private long getCurrentTick() {
    if (world.isRemote) return -1;
    return world.getWorldInfo().getGameTime();
  }

  @Override
  public void tick() {
    if (world.isRemote) return;

    if (world.getDifficulty() == Difficulty.PEACEFUL) return;

    BlockPos spawnPoint = getPos().up();

    if (!ConfigManager.DefiledGround.defiledGroundEnabled) return;

    if (ConfigManager.DefiledGround.spawnOnTick) {
      if (nextSpawn <= getCurrentTick()) {
        long increment = ConfigManager.DefiledGround.spawnTickRate + getCurrentTick();
        int variance = 1;
        if (ConfigManager.DefiledGround.tickVariance) {
          variance = world.rand.nextInt(Math.max(1, ConfigManager.DefiledGround.tickVarianceAmount));
          increment += (world.rand.nextBoolean() ? variance : -variance);
        }
        if (nextSpawn == 0) {
          nextSpawn = (world.rand.nextInt(Math.max(1, variance)) + increment) / 2;
          return;
        } else {
          nextSpawn = increment;
        }
      } else {
        return;
      }
    } else {
      if (world.rand.nextInt(ConfigManager.DefiledGround.spawnChance) != 0) {
        return;
      }
    }

    if (ConfigManager.DefiledGround.minimumLight != -1) {
      if (world.getLightFor(LightType.BLOCK, spawnPoint) > ConfigManager.DefiledGround.minimumLight) return;
    }

    if (ConfigManager.DefiledGround.mobCheck) {
      int limit = ConfigManager.DefiledGround.maximumMobs;
      AxisAlignedBB boundingBox = new AxisAlignedBB(getPos()).grow(-ConfigManager.DefiledGround.horizontalRadius, ConfigManager.DefiledGround.verticalRadius, ConfigManager.DefiledGround.horizontalRadius);
      if (world.getEntitiesWithinAABB(LivingEntity.class, boundingBox, (entity) -> entity != null && entity.getType().getClassification() == EntityClassification.MONSTER).size() > limit)
        return;
    }

    Entity mob = getMobForSpawn(world, spawnPoint);
    if (mob == null) return;

    float x = spawnPoint.getX() + 0.5f;
    float y = spawnPoint.getY();
    float z = spawnPoint.getZ() + 0.5f;

    mob.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0f, 0.0f);

    if (mob instanceof MobEntity) {
      if (!ForgeEventFactory.doSpecialSpawn((MobEntity) mob, world, x, y, z, null, SpawnReason.SPAWNER)) {
        ((MobEntity) mob).onInitialSpawn(world, world.getDifficultyForLocation(spawnPoint), SpawnReason.SPAWNER, null, null);
      }
    }

    world.addEntity(mob);
    world.playEvent(2004, spawnPoint, 0);
  }

  private Entity getMobForSpawn(World world, BlockPos pos) {
    List<Biome.SpawnListEntry> entries = world.getBiome(pos).getSpawns(EntityClassification.MONSTER);
    if (entries.isEmpty()) {
      return null;
    }

    Biome.SpawnListEntry entry = entries.get(world.rand.nextInt(entries.size()));

    // TODO: Check if it can spawn
/*    if (entry.entityType == null || !world.setAllowedSpawnTypes((ServerWorld) world).canCreatureTypeSpawnHere(EnumCreatureType.MONSTER, entry, pos)) {
      return null;
    }*/

    return entry.entityType.create(world);
  }
}
