package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class AnvilHandler {
    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent event) {
        clear(event.getLeft(), event.getRight());
    }

    @SubscribeEvent
    public static void onAnvil(AnvilRepairEvent event) {
        clear(event.getItemResult());
        if (VariegatedConfig.anvilBreakChance != -1) {
            event.setBreakChance((float) VariegatedConfig.anvilBreakChance);
        }
    }

    private static void clear(ItemStack... stacks) {
        if (VariegatedConfig.anvilCostRemoval) {
            for (ItemStack stack : stacks) {
                if (stack.isEmpty()) return;

                NBTTagCompound compound = stack.getTagCompound();

                if (compound == null || !compound.hasKey("RepairCost")) return;

                compound.removeTag("RepairCost");
            }
        }
    }
}
