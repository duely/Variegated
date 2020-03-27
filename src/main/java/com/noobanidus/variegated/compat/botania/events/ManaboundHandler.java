package com.noobanidus.variegated.compat.botania.events;

import baubles.api.BaublesApi;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.ConfigManager;
import com.noobanidus.variegated.init.Registrar;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import vazkii.botania.api.mana.IManaUsingItem;
import vazkii.botania.api.mana.ManaItemHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
public class ManaboundHandler {
  @SubscribeEvent
  public static void onLivingTick(LivingEvent.LivingUpdateEvent event) {
    if (ConfigManager.Botania.enabled && event.getEntity() instanceof PlayerEntity) {

      PlayerEntity player = (PlayerEntity) event.getEntity();

      List<ItemStack> equipment = new ArrayList<>();
      for (NonNullList<ItemStack> list : Arrays.asList(player.inventory.mainInventory, player.inventory.armorInventory, player.inventory.offHandInventory)) {
        equipment.addAll(list);
      }

      // TODO: Convert to curios
/*      IItemHandler baubles = BaublesApi.getBaublesHandler(player);
      for (int i = 0; i < baubles.getSlots(); i++) {
        equipment.add(baubles.getStackInSlot(i));
      }*/

      for (ItemStack stack : equipment) {
        if (!(stack.getItem() instanceof IManaUsingItem) && stack.isDamaged() && stack.isEnchanted() && (EnchantmentHelper.getEnchantments(stack).get(Registrar.manabound) != null)) {
          if (ManaItemHandler.requestManaExactForTool(stack, player, ConfigManager.Botania.manaCost, true)) {
            stack.setDamage(stack.getDamage() - 1);
          }
        }
      }
    }
  }
}
