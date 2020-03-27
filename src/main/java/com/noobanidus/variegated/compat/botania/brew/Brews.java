package com.noobanidus.variegated.compat.botania.brew;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.api.recipe.RecipeBrew;

public class Brews {
  public static ResourceLocation WINGS_BREW = new ResourceLocation(Variegated.MODID, "wings");

  public static void registerBrews() {
    if (ConfigManager.wings && Loader.isModLoaded("botania")) {

      Brew flight_brew = new Brew("flight", "variegated.brew.wings", 0x99ffff, ConfigManager.Botania.WingsCost, new EffectInstance(Registrar.wings, 6000));
      flight_brew.setNotBloodPendantInfusable();

      BotaniaAPI.registerBrew(flight_brew);
      BotaniaAPI.brewRecipes.put(WINGS_BREW, new RecipeBrew(WINGS_BREW, flight_brew, Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_GOLD), Ingredient.fromTag(Tags.Items.FEATHERS)));
    }
  }
}
