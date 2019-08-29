package com.noobanidus.variegated.compat.botania.brew;

import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;

public class Brews {
  public static void registerBrews() {
    if (VariegatedConfig.wings) {
      Brew flight_brew = new Brew("flight", "variegated.brew.Wings", 0x99ffff, VariegatedConfig.Botania.WingsCost, new PotionEffect(Registrar.wings, 6000));
      flight_brew.setNotBloodPendantInfusable();

      BotaniaAPI.registerBrew(flight_brew);
      BotaniaAPI.registerBrewRecipe(flight_brew, new ItemStack(Blocks.GOLD_BLOCK), new ItemStack(Items.FEATHER), new ItemStack(Items.FEATHER));
    }
  }
}
