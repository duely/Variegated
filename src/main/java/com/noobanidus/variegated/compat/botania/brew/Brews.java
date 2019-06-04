package com.noobanidus.variegated.compat.botania.brew;

import WayofTime.bloodmagic.core.RegistrarBloodMagic;
import WayofTime.bloodmagic.item.types.ComponentTypes;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.brew.Brew;
import vazkii.botania.common.item.ModItems;

public class Brews {
    public static void registerBrews() {
        if (Loader.isModLoaded("bloodmagic")) {
            Brew flight_brew = new Brew("flight", "variegated.brew.Wings", 0x99ffff, VariegatedConfig.Botania.WingsCost, new PotionEffect(RegistrarBloodMagic.FLIGHT, 6000));
            flight_brew.setNotBloodPendantInfusable();

            BotaniaAPI.registerBrew(flight_brew);

            Item angelicFeather = Item.REGISTRY.getObject(new ResourceLocation("xreliquary", "angelic_feather"));

            if (angelicFeather == null) {
                angelicFeather = Items.FEATHER;
                Variegated.LOG.error("[Variegated] Reliquary Angelic Feather not found. Botania recipe for Flight Brew was downgraded.");
            }

            BotaniaAPI.registerBrewRecipe(flight_brew, new ItemStack(ModItems.manaResource, 1, 18), ComponentTypes.REAGENT_AIR.getStack(), new ItemStack(Items.GHAST_TEAR, 1, 0), new ItemStack(angelicFeather, 1, 0));
        }
    }
}
