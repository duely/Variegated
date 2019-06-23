package com.noobanidus.variegated.compat.bloodmagic.rituals.imperfect;

import WayofTime.bloodmagic.ritual.RitualRegister;
import WayofTime.bloodmagic.ritual.imperfect.IImperfectRitualStone;
import WayofTime.bloodmagic.ritual.imperfect.ImperfectRitual;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

import javax.annotation.Nonnull;

@RitualRegister.Imperfect("sun")
@SuppressWarnings("unused")
public class SunRitual extends ImperfectRitual {
  public SunRitual() {
    super("sun", s -> s.getBlock() == getBlock(), 5000, true, "ritual.variegated.imperfect.sun");
  }

  public static Block getBlock() {
    Block block = null;
    if (Loader.isModLoaded("botania")) {
      block = Block.REGISTRY.getObject(new ResourceLocation("botania", "quartztypesunny"));
    }

    if (block == null) {
      block = Blocks.QUARTZ_BLOCK;
    }

    return block;
  }

  @Override
  public boolean onActivate(@Nonnull IImperfectRitualStone imperfectRitualStone, @Nonnull EntityPlayer player) {
    if (!imperfectRitualStone.getRitualWorld().isRemote)
      imperfectRitualStone.getRitualWorld().getWorldInfo().setRaining(false);

    return true;
  }
}

