package com.noobanidus.variegated.compat.botania.events;

import baubles.api.BaublesApi;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.items.IItemHandler;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
public class ManaboundHandler {
    @SubscribeEvent
    @Optional.Method(modid = "botania")
    public static void onLivingTick(LivingEvent.LivingUpdateEvent event) {
        if (VariegatedConfig.Botania.enabled && event.getEntity() instanceof EntityPlayer) {

            EntityPlayer player = (EntityPlayer) event.getEntity();

            List<ItemStack> equipment = new ArrayList<>();
            for (NonNullList<ItemStack> list : Arrays.asList(player.inventory.mainInventory, player.inventory.armorInventory, player.inventory.offHandInventory)) {
                equipment.addAll(list);
            }

            IItemHandler baubles = BaublesApi.getBaublesHandler(player);
            for (int i = 0; i < baubles.getSlots(); i++) {
                equipment.add(baubles.getStackInSlot(i));
            }

            for (ItemStack stack : equipment) {
                if (!(stack.getItem() instanceof IManaUsingItem) && stack.isItemDamaged() && stack.isItemEnchanted() && (EnchantmentHelper.getEnchantments(stack).get(Registrar.manabound) != null)) {
                    if (ManaItemHandler.requestManaExactForTool(stack, player, VariegatedConfig.Botania.manaCost, true)) {
                        stack.setItemDamage(stack.getItemDamage() - 1);
                    }
                }
            }
        }
    }
}
