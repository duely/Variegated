package com.noobanidus.variegated.potions;

import com.noobanidus.variegated.Variegated;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionWings extends Potion {
  public static final ResourceLocation POTION_TEXTURE = new ResourceLocation(Variegated.MODID, "textures/gui/potions.png");

  public PotionWings() {
    super(false, 0x49d1c6);
    setRegistryName(Variegated.MODID, "wings");
    setPotionName("variegated.potion.wings");
    setBeneficial();
    setIconIndex(2, 0);
  }

  @Override
  public boolean isReady(int duration, int amplifier) {
    return true;
  }

  @Override
  @SideOnly(Side.CLIENT)
  public int getStatusIconIndex() {
    Minecraft.getMinecraft().renderEngine.bindTexture(POTION_TEXTURE);
    return super.getStatusIconIndex();
  }
}


