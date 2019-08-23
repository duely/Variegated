package com.noobanidus.variegated.potions;

import com.noobanidus.variegated.Variegated;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionLove extends Potion {
  public static final ResourceLocation POTION_TEXTURE = new ResourceLocation(Variegated.MODID, "textures/gui/potions.png");

  public PotionLove() {
    super(false, 0xdb67ba);
    setRegistryName(Variegated.MODID, "attraction");
    setPotionName("variegated.potion.attraction");
    setBeneficial();
    setIconIndex(1, 0);
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

  @Override
  public void performEffect(EntityLivingBase target, int amplifier) {
    /*if (target instanceof EntityVillager) {
      EntityVillager villager = (EntityVillager) target;
      boolean doMate = !villager.isChild();
      if (doMate) {
        for (EntityAITasks.EntityAITaskEntry task : villager.tasks.taskEntries) {
          if (task.action instanceof EntityAIVillagerMate) {
            int timeout = ObfuscationReflectionHelper.getPrivateValue(EntityAIVillagerMate.class, (EntityAIVillagerMate) task.action, "field_75449_e");
            if (timeout == 0) {
              villager.setIsWillingToMate(true);
              villager.setMating(true);
              task.action.startExecuting();
            }
          }
        }
      }
      target.removePotionEffect(this);
    } else*/
    if (target instanceof EntityAnimal) {
      EntityAnimal animal = (EntityAnimal) target;
      if (animal.getGrowingAge() == 0 && !animal.isInLove()) {
        animal.setInLove(null);
      }
      target.removePotionEffect(this);
    }
  }
}

