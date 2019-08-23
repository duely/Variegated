package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

@SuppressWarnings("deprecation")
public class StackSizeEtcHandler {
  public static void init() {
    Blocks.END_PORTAL_FRAME.setHardness(50.0F).setResistance(2000.0F).setHarvestLevel("pickaxe", 3);

    int cakeCount = VariegatedConfig.stackSizes.cakeCount;
    if (cakeCount <= 64 && cakeCount > 0) {
      Items.CAKE.setMaxStackSize(cakeCount);
    }

    int enderCount = VariegatedConfig.stackSizes.enderCount;
    if (enderCount <= 64 && enderCount > 0) {
      Items.ENDER_PEARL.setMaxStackSize(enderCount);
    }

    int snowballCount = VariegatedConfig.stackSizes.snowballCount;
    if (snowballCount <= 64 && snowballCount > 0) {
      Items.SNOWBALL.setMaxStackSize(snowballCount);
    }

    int signCount = VariegatedConfig.stackSizes.signCount;
    if (signCount <= 64 && signCount > 0) {
      Items.SIGN.setMaxStackSize(signCount);
    }

    int bookCount = VariegatedConfig.stackSizes.bookCount;
    if (bookCount <= 64 && bookCount > 0) {
      Items.ENCHANTED_BOOK.setMaxStackSize(bookCount);
    }

    int bucketCount = VariegatedConfig.stackSizes.bucketCount;
    if (bucketCount <= 64 && bucketCount > 0) {
      Items.BUCKET.setMaxStackSize(bucketCount);
      Items.MILK_BUCKET.setMaxStackSize(bucketCount);
    }

    int eggCount = VariegatedConfig.stackSizes.eggCount;
    if (eggCount <= 64 && eggCount > 0) {
      Items.EGG.setMaxStackSize(eggCount);
    }

    int writtenBookCount = VariegatedConfig.stackSizes.writtenBookCount;
    if (writtenBookCount <= 64 && writtenBookCount > 0) {
      Items.WRITTEN_BOOK.setMaxStackSize(writtenBookCount);
    }

    int armorStandCount = VariegatedConfig.stackSizes.armorStandCount;
    if (armorStandCount <= 64 && armorStandCount > 0) {
      Items.ARMOR_STAND.setMaxStackSize(armorStandCount);
    }

    int bannerCount = VariegatedConfig.stackSizes.bannerCount;
    if (bannerCount <= 64 && bannerCount > 0) {
      Items.BANNER.setMaxStackSize(bannerCount);
    }

    int minecartCount = VariegatedConfig.stackSizes.minecartCount;
    if (minecartCount <= 64 && minecartCount > 0) {
      Items.CHEST_MINECART.setMaxStackSize(minecartCount);
      Items.MINECART.setMaxStackSize(minecartCount);
      Items.COMMAND_BLOCK_MINECART.setMaxStackSize(minecartCount);
      Items.FURNACE_MINECART.setMaxStackSize(minecartCount);
      Items.TNT_MINECART.setMaxStackSize(minecartCount);
      Items.HOPPER_MINECART.setMaxStackSize(minecartCount);
    }

    int potionCount = VariegatedConfig.stackSizes.potionCount;
    if (potionCount <= 64 && potionCount > 0) {
      Items.POTIONITEM.setMaxStackSize(potionCount);
      Items.LINGERING_POTION.setMaxStackSize(potionCount);
      Items.SPLASH_POTION.setMaxStackSize(potionCount);
    }

    int boatCount = VariegatedConfig.stackSizes.boatCount;
    if (boatCount <= 64 && boatCount > 0) {
      Items.BOAT.setMaxStackSize(boatCount);
      Items.ACACIA_BOAT.setMaxStackSize(boatCount);
      Items.BIRCH_BOAT.setMaxStackSize(boatCount);
      Items.DARK_OAK_BOAT.setMaxStackSize(boatCount);
      Items.JUNGLE_BOAT.setMaxStackSize(boatCount);
      Items.SPRUCE_BOAT.setMaxStackSize(boatCount);
    }

    if (Loader.isModLoaded("evilcraft")) {
      Item tear = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "ender_tear"));
      if (tear != null) {
        int tearCount = VariegatedConfig.stackSizes.enderTearCount;
        if (tearCount <= 64 && tearCount > 0) {
          tear.setMaxStackSize(tearCount);
        }
      }

      Item werewolf = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "werewolf_flesh"));
      if (werewolf != null) {
        int werewolfCount = VariegatedConfig.stackSizes.werewolfCount;
        if (werewolfCount <= 64 && werewolfCount > 0) {
          werewolf.setMaxStackSize(werewolfCount);
        }
      }

      Item lightning = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "lightning_grenade"));
      if (lightning != null) {
        int lightningCount = VariegatedConfig.stackSizes.lightningCount;
        if (lightningCount <= 64 && lightningCount > 0) {
          lightning.setMaxStackSize(lightningCount);
        }
      }

      Item redstone = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "redstone_grenade"));
      if (redstone != null) {
        int redstoneCount = VariegatedConfig.stackSizes.redstoneCount;
        if (redstoneCount <= 64 && redstoneCount > 0) {
          redstone.setMaxStackSize(redstoneCount);
        }
      }

      Item darkPower = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "dark_power_gem"));
      if (darkPower != null) {
        int darkPowerCount = VariegatedConfig.stackSizes.darkPowerCount;
        if (darkPowerCount <= 64 && darkPowerCount > 0) {
          darkPower.setMaxStackSize(darkPowerCount);
        }
      }

      Item potentia = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "inverted_potentia"));
      if (potentia != null) {
        int potentiaCount = VariegatedConfig.stackSizes.potentiaCount;
        if (potentiaCount <= 64 && potentiaCount > 0) {
          potentia.setMaxStackSize(potentiaCount);
        }
      }
    }

    if (Loader.isModLoaded("bloodmagic")) {
      Item snare = Item.REGISTRY.getObject(new ResourceLocation("bloodmagic", "soul_snare"));
      if (snare != null) {
        int snareCount = VariegatedConfig.stackSizes.snareCount;
        if (snareCount <= 64 && snareCount > 0) {
          snare.setMaxStackSize(snareCount);
        }
      }
    }

    if (Loader.isModLoaded("thaumcraft")) {
      Item loot = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "loot_bag"));
      if (loot != null) {
        int lootCount = VariegatedConfig.stackSizes.lootBagCount;
        if (lootCount <= 64 && lootCount > 0) {
          loot.setMaxStackSize(lootCount);
        }
      }

      Item taint = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "bottle_taint"));
      if (taint != null) {
        int taintCount = VariegatedConfig.stackSizes.taintBottleCount;
        if (taintCount <= 64 && taintCount > 0) {
          taint.setMaxStackSize(taintCount);
        }
      }

      Item collapser = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "causality_collapser"));
      if (collapser != null) {
        int collapserCount = VariegatedConfig.stackSizes.causalityCount;
        if (collapserCount <= 64 && collapserCount > 0) {
          collapser.setMaxStackSize(collapserCount);
        }
      }
    }

    if (Loader.isModLoaded("treasure2")) {
      int coinCount = VariegatedConfig.stackSizes.coinCount;
      if (coinCount <= 64 && coinCount > 0) {
        Item silverCoin = Item.REGISTRY.getObject(new ResourceLocation("treasure2", "silver_coin"));
        Item goldCoin = Item.REGISTRY.getObject(new ResourceLocation("treasure2", "gold_coin"));

        if (silverCoin != null) {
          silverCoin.setMaxStackSize(coinCount);
        }
        if (goldCoin != null) {
          goldCoin.setMaxStackSize(coinCount);
        }
      }
    }

    if (Loader.isModLoaded("simplytea")) {
      int cupCount = VariegatedConfig.stackSizes.cupCount;
      if (cupCount <= 64 && cupCount > 0) {
        Item cup = Item.REGISTRY.getObject(new ResourceLocation("simplytea", "cup"));
        if (cup != null) {
          cup.setMaxStackSize(cupCount);
        }
      }
    }

    if (Loader.isModLoaded("enderio")) {
      int soulVialCount = VariegatedConfig.stackSizes.soulVialCount;
      if (soulVialCount <= 64 && soulVialCount > 0) {
        Item vial = Item.REGISTRY.getObject(new ResourceLocation("enderio", "soul_vial"));
        if (vial != null) {
          vial.setMaxStackSize(soulVialCount);
        }
      }
    }

    if (Loader.isModLoaded("combustfish")) {
      int codCount = VariegatedConfig.stackSizes.codCount;
      if (codCount <= 64 && codCount > 0) {
        Item cod = Item.REGISTRY.getObject(new ResourceLocation("combustfish", "combustive_cod"));
        if (cod != null) {
          cod.setMaxStackSize(codCount);
        }
      }
    }

    if (Loader.isModLoaded("astralsorcery")) {
      int lensCount = VariegatedConfig.stackSizes.lensCount;
      if (lensCount <= 64 && lensCount > 0) {
        Item lens = Item.REGISTRY.getObject(new ResourceLocation("astralsorcery", "itemcoloredlens"));
        if (lens != null) {
          lens.setMaxStackSize(lensCount);
        }
      }
    }

    Item.REGISTRY.forEach((item) -> {
      int size = item.getItemStackLimit();
      if (size > 1 && size < 64) {
        Variegated.LOG.info(item.getRegistryName().toString() + ": stack size " + size);
      }
    });
  }
}
