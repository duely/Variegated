package com.noobanidus.variegated.compat.exotic_birds;

import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReducePackSize {
  public static void init() {
    Set<Class<? extends Entity>> birdSet = new HashSet<>();
    for (ResourceLocation entityRes : EntityList.getEntityNameList()) {
      if (entityRes.getNamespace().equals("exoticbirds")) {
        birdSet.add(EntityList.getClass(entityRes));
      }
    }
    for (Biome biome : Biome.REGISTRY) {
      for (EnumCreatureType type : EnumCreatureType.values()) {
        List<Biome.SpawnListEntry> spawnList = biome.getSpawnableList(type);
        for (Biome.SpawnListEntry entry : spawnList) {
          if (birdSet.contains(entry.entityClass)) {
            entry.maxGroupCount = VariegatedConfig.ExoticBirds.maxPackSize;
            entry.minGroupCount = VariegatedConfig.ExoticBirds.minPackSize;
          }
        }
      }
    }
  }
}
