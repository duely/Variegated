package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;

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
  }
}
