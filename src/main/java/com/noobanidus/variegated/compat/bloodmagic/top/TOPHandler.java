package com.noobanidus.variegated.compat.bloodmagic.top;

import WayofTime.bloodmagic.BloodMagic;
import WayofTime.bloodmagic.block.BlockRitualController;
import WayofTime.bloodmagic.block.enums.EnumRitualController;
import WayofTime.bloodmagic.ritual.Ritual;
import WayofTime.bloodmagic.ritual.imperfect.ImperfectRitual;
import WayofTime.bloodmagic.tile.TileMasterRitualStone;
import WayofTime.bloodmagic.util.helper.RitualHelper;
import com.noobanidus.variegated.compat.top.ITOPHandler;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.apache.commons.lang3.StringUtils;

import static mcjty.theoneprobe.api.TextStyleClass.OK;
import static mcjty.theoneprobe.api.TextStyleClass.WARNING;

public class TOPHandler implements ITOPHandler {
  @Override
  public void handle(ProbeMode mode, IProbeInfo probeInfo, EntityPlayer player, World world, IBlockState blockState, IProbeHitData data) {
    if (blockState.getBlock() instanceof BlockRitualController) {
      BlockRitualController block = (BlockRitualController) blockState.getBlock();
      EnumRitualController type = blockState.getValue(block.getProperty());

      if (type == EnumRitualController.IMPERFECT) {
        ImperfectRitual ritual = BloodMagic.RITUAL_MANAGER.getImperfectRitual(world.getBlockState(data.getPos().up()));
        if (ritual != null) {
          String ritualName = StringUtils.capitalize(ritual.getName());
          probeInfo.text(OK + String.format("Imperfect Ritual of %s", ritualName));
          probeInfo.text(WARNING + String.format("Cost: %dLP", ritual.getActivationCost()));
        } else {
          probeInfo.text(WARNING + "Invalid ritual.");
        }
      } else {
        TileMasterRitualStone tile = (TileMasterRitualStone) world.getTileEntity(data.getPos());

        String key = RitualHelper.getValidRitual(world, data.getPos());
        if (!key.isEmpty()) {
          Ritual ritual = BloodMagic.RITUAL_MANAGER.getRitual(key);
          String ritualName = I18n.format(ritual.getTranslationKey());
          probeInfo.text(OK + ritualName);
          if (tile != null && tile.isPowered()) {
            probeInfo.text(WARNING + "(Disabled via redstone)");
          } else if (tile != null && tile.isActive()) {
            probeInfo.text(OK + "Active");
          } else {
            probeInfo.text(WARNING + String.format("Activation cost: %,dLP", ritual.getActivationCost()));
          }
        } else {
          probeInfo.text(WARNING + "Invalid ritual.");
        }
      }
    }
  }
}
