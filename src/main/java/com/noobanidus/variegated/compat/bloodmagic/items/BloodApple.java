package com.noobanidus.variegated.compat.bloodmagic.items;

import WayofTime.bloodmagic.core.data.SoulNetwork;
import WayofTime.bloodmagic.util.helper.NetworkHelper;
import com.noobanidus.variegated.Variegated;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class BloodApple extends ItemFood {
    public BloodApple() {
        super(4, 1.5f, false);

        setRegistryName(new ResourceLocation("variegated", "blood_apple"));
        setAlwaysEdible();
        setCreativeTab(Variegated.TAB);
        setTranslationKey("blood_apple");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(TextFormatting.DARK_RED + "" + TextFormatting.ITALIC + "\"When she breaks the tender peel,\nto taste the apple in my hand,\nher breath will still,\nher blood congeal\"");
        tooltip.add("");
        tooltip.add(TextFormatting.RED + "A very creative way to score some points towards being the fairest in the land.");

        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            SoulNetwork network = NetworkHelper.getSoulNetwork(player.getUniqueID());
            int essence = network.getCurrentEssence();
            network.setCurrentEssence(essence + 1000000);
        }
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
