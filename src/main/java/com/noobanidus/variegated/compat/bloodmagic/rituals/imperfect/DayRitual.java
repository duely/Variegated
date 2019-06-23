package com.noobanidus.variegated.compat.bloodmagic.rituals.imperfect;

import WayofTime.bloodmagic.ritual.RitualRegister;
import WayofTime.bloodmagic.ritual.imperfect.IImperfectRitualStone;
import WayofTime.bloodmagic.ritual.imperfect.ImperfectRitual;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

import javax.annotation.Nonnull;

@RitualRegister.Imperfect("day")
@SuppressWarnings("unused")
public class DayRitual extends ImperfectRitual {
  public DayRitual() {
    super("day", s -> s.getBlock() == Blocks.GOLD_BLOCK, 500, true, "ritual.variegated.imperfect.day");
  }

  @Override
  public boolean onActivate(@Nonnull IImperfectRitualStone imperfectRitualStone, @Nonnull EntityPlayer player) {
    if (!imperfectRitualStone.getRitualWorld().isRemote)
      imperfectRitualStone.getRitualWorld().setWorldTime((imperfectRitualStone.getRitualWorld().getWorldTime() / 24000) * 24000);

    return true;
  }
}
