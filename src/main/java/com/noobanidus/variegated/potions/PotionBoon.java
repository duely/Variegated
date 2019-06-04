package com.noobanidus.variegated.potions;

import com.noobanidus.variegated.Variegated;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentMending;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.ItemFishingRod;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PotionBoon extends Potion {
    public static final ResourceLocation POTION_TEXTURE = new ResourceLocation(Variegated.MODID, "textures/gui/potions.png");

    public PotionBoon() {
        super(false, 0xecbb10);
        setRegistryName(Variegated.MODID, "fishermans_friend");
        setPotionName("variegated.potion.fishermans_friend");
        setBeneficial();
        setIconIndex(0, 0);
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
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        if (entityLivingBaseIn instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLivingBaseIn;

            ItemStack stack = player.getHeldItemMainhand();
            if (!(stack.getItem() instanceof ItemFishingRod)) return;

            if (player.fishEntity != null) {
                EntityFishHook hook = player.fishEntity;
                int l = EnchantmentHelper.getFishingLuckBonus(stack) + amplifier + 1;

                player.fishEntity.setLuck(l);

                switch (amplifier) {
                    case 0:
                        if (entityLivingBaseIn.ticksExisted % 3 == 0)
                            hook.onUpdate();
                        break;
                    case 1:
                        if (entityLivingBaseIn.ticksExisted % 2 == 0)
                            hook.onUpdate();
                        break;
                    case 2:
                        hook.onUpdate();
                        break;
                }
            }
        }
    }
}

