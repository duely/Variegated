package com.noobanidus.variegated.compat.vanilla.handlers;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.util.RecipeItemHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Variegated.MODID, value = Side.CLIENT)
@SuppressWarnings("unused")
public class OreHandler {
  private static Map<Integer, List<String>> ORE_MAP = new Int2ObjectOpenHashMap<>();

  @SubscribeEvent
  @SideOnly(Side.CLIENT)
  public static void onTooltip(ItemTooltipEvent event) {
    if (VariegatedConfig.oredict) {
      if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
        ItemStack item = event.getItemStack();
        if (item.isEmpty()) return;

        int itemId = RecipeItemHelper.pack(item);

        if (!ORE_MAP.containsKey(itemId)) {
          List<String> ores = new ArrayList<>();
          int[] ids = OreDictionary.getOreIDs(item);
          for (int id : ids) {
            ores.add("  - " + OreDictionary.getOreName(id));
          }
          ORE_MAP.put(itemId, ores);
        }

        List<String> names = ORE_MAP.get(itemId);
        if (names.size() != 0) {
          event.getToolTip().add("");
          event.getToolTip().add("Ore names:");
          event.getToolTip().addAll(names);
        }
      }
    }
  }
}

