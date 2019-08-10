package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public class StackSizeEtcHandler {
  public static void init() {
    Blocks.END_PORTAL_FRAME.setHardness(50.0F).setResistance(2000.0F).setHarvestLevel("pickaxe", 3);

    int cakeCount = VariegatedConfig.cakeCount;
    if (cakeCount <= 64 && cakeCount > 0) {
      Items.CAKE.setMaxStackSize(cakeCount);
    }

    int enderCount = VariegatedConfig.enderCount;
    if (enderCount <= 64 && enderCount > 0) {
      Items.ENDER_PEARL.setMaxStackSize(enderCount);
    }

    int snowballCount = VariegatedConfig.snowballCount;
    if (snowballCount <= 64 && snowballCount > 0) {
      Items.SNOWBALL.setMaxStackSize(snowballCount);
    }

    int signCount = VariegatedConfig.signCount;
    if (signCount <= 64 && signCount > 0) {
      Items.SIGN.setMaxStackSize(signCount);
    }

    int bookCount = VariegatedConfig.bookCount;
    if (bookCount <= 64 && bookCount > 0) {
      Items.ENCHANTED_BOOK.setMaxStackSize(bookCount);
    }

    int bucketCount = VariegatedConfig.bucketCount;
    if (bucketCount <= 64 && bucketCount > 0) {
      Items.BUCKET.setMaxStackSize(bucketCount);
    }

    int eggCount = VariegatedConfig.eggCount;
    if (eggCount <= 64 && eggCount > 0) {
      Items.EGG.setMaxStackSize(eggCount);
    }

    int writtenBookCount = VariegatedConfig.writtenBookCount;
    if (writtenBookCount <= 64 && writtenBookCount > 0) {
      Items.WRITTEN_BOOK.setMaxStackSize(writtenBookCount);
    }

    int armorStandCount = VariegatedConfig.armorStandCount;
    if (armorStandCount <= 64 && armorStandCount > 0) {
      Items.ARMOR_STAND.setMaxStackSize(armorStandCount);
    }

    int bannerCount = VariegatedConfig.bannerCount;
    if (bannerCount <= 64 && bannerCount > 0) {
      Items.BANNER.setMaxStackSize(bannerCount);
    }

    if (Loader.isModLoaded("evilcraft")) {
      Item tear = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "ender_tear"));
      if (tear != null) {
        int tearCount = VariegatedConfig.enderTearCount;
        if (tearCount <= 64 && tearCount > 0) {
          tear.setMaxStackSize(tearCount);
        }
      }

      Item werewolf = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "werewolf_flesh"));
      if (werewolf != null) {
        int werewolfCount = VariegatedConfig.werewolfCount;
        if (werewolfCount <= 64 && werewolfCount > 0) {
          werewolf.setMaxStackSize(werewolfCount);
        }
      }

      Item lightning = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "lightning_grenade"));
      if (lightning != null) {
        int lightningCount = VariegatedConfig.lightningCount;
        if (lightningCount <= 64 && lightningCount > 0) {
          lightning.setMaxStackSize(lightningCount);
        }
      }

      Item redstone = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "redstone_grenade"));
      if (redstone != null) {
        int redstoneCount = VariegatedConfig.redstoneCount;
        if (redstoneCount <= 64 && redstoneCount > 0) {
          redstone.setMaxStackSize(redstoneCount);
        }
      }

      Item darkPower = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "dark_power_gem"));
      if (darkPower != null) {
        int darkPowerCount = VariegatedConfig.darkPowerCount;
        if (darkPowerCount <= 64 && darkPowerCount > 0) {
          darkPower.setMaxStackSize(darkPowerCount);
        }
      }

      Item potentia = Item.REGISTRY.getObject(new ResourceLocation("evilcraft", "inverted_potentia"));
      if (potentia != null) {
        int potentiaCount = VariegatedConfig.potentiaCount;
        if (potentiaCount <= 64 && potentiaCount > 0) {
          potentia.setMaxStackSize(potentiaCount);
        }
      }
    }

    if (Loader.isModLoaded("bloodmagic")) {
      Item snare = Item.REGISTRY.getObject(new ResourceLocation("bloodmagic", "soul_snare"));
      if (snare != null) {
        int snareCount = VariegatedConfig.snareCount;
        if (snareCount <= 64 && snareCount > 0) {
          snare.setMaxStackSize(snareCount);
        }
      }
    }

    if (Loader.isModLoaded("thaumcraft")) {
      Item loot = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "loot_bag"));
      if (loot != null) {
        int lootCount = VariegatedConfig.lootBagCount;
        if (lootCount <= 64 && lootCount > 0) {
          loot.setMaxStackSize(lootCount);
        }
      }

      Item taint = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "bottle_taint"));
      if (taint != null) {
        int taintCount = VariegatedConfig.taintBottleCount;
        if (taintCount <= 64 && taintCount > 0) {
          taint.setMaxStackSize(taintCount);
        }
      }

      Item collapser = Item.REGISTRY.getObject(new ResourceLocation("thaumcraft", "causality_collapser"));
      if (collapser != null) {
        int collapserCount = VariegatedConfig.causalityCount;
        if (collapserCount <= 64 && collapserCount > 0) {
          collapser.setMaxStackSize(collapserCount);
        }
      }
    }

    Item.REGISTRY.forEach((item) -> {
      int size = item.getItemStackLimit();
      if (size > 1 && size < 64) {
        Variegated.LOG.debug(item.getRegistryName().toString() + ": stack size " + size);
      }
    });
  }
}
