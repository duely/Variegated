package com.noobanidus.variegated.recipes;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.util.JsonUtils;
import net.minecraftforge.common.crafting.IConditionFactory;
import net.minecraftforge.common.crafting.JsonContext;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.oredict.OreDictionary;

import java.util.function.BooleanSupplier;

@SuppressWarnings("unused")
public class ConditionFactory implements IConditionFactory {
  @Override
  public BooleanSupplier parse(JsonContext context, JsonObject json) {
    String key = JsonUtils.getString(json, "recipe");

    if (key.equalsIgnoreCase("apple")) {
      return () -> !OreDictionary.getOres("ingotSilver", false).isEmpty();
    } else if (key.equalsIgnoreCase("compact")) {
      return () -> Loader.isModLoaded("thaumcraft") && VariegatedConfig.Thaumcraft.enabled;
    } else if (key.equalsIgnoreCase("featherweight")) {
      return () -> VariegatedConfig.enableFeatherweight;
    } else if (key.equalsIgnoreCase("defiled")) {
      return () -> VariegatedConfig.DefiledGround.defiledGroundEnabled;
    }

    throw new JsonParseException("recipeDisable not found!");
  }
}
