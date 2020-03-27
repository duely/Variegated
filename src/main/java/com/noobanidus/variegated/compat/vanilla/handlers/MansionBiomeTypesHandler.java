package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MansionBiomeTypesHandler {
  public static void init() {
    if (!ConfigManager.vanillaSettings.extraMansions) {
      return;
    }

    try {
      modifyFields();
    } catch (ReflectiveOperationException e) {
      Variegated.LOG.error("[Variegated] Error adjusting biomes for Woodland Mansion.");
      e.printStackTrace();
    }
  }

  public static void modifyFields() throws ReflectiveOperationException {
    // TODO: No more reflection! Just injection.
    Field field = null; //ObfuscationReflectionHelper.findField(WoodlandMansion.class, "field_191072_a");
    field.setAccessible(true);

    Field modifiers = Field.class.getDeclaredField("modifiers");
    modifiers.setAccessible(true);
    modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

    List<Biome> newBiomes = new ArrayList<>();

    newBiomes.addAll(Arrays.asList(Biomes.BIRCH_FOREST, Biomes.BIRCH_FOREST_HILLS, Biomes.FOREST, Biomes.TAIGA, Biomes.GIANT_SPRUCE_TAIGA, Biomes.GIANT_SPRUCE_TAIGA_HILLS, Biomes.GIANT_TREE_TAIGA, Biomes.GIANT_TREE_TAIGA_HILLS, Biomes.MODIFIED_WOODED_BADLANDS_PLATEAU, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA_HILLS, Biomes.SNOWY_TAIGA_MOUNTAINS, Biomes.TALL_BIRCH_FOREST, Biomes.TALL_BIRCH_HILLS, Biomes.WOODED_HILLS, Biomes.WOODED_MOUNTAINS));

/*    if (Loader.isModLoaded("traverse")) {
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:woodlands")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:autumnal_woods")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:thicket")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:forested_hills")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:birch_forested_hills")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:autumnal_wooded_hills")));
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("traverse:snowy_coniferous_forest")));
    }
    if (Loader.isModLoaded("thaumcraft")) {
      newBiomes.add(ForgeRegistries.BIOMES.getValue(new ResourceLocation("thaumcraft:magical_forest")));
    }*/

    field.set(null, newBiomes);

    Variegated.LOG.info("[Variegated] Adjusted Woodland Mansions to spawn in additional biomes.");
  }
}