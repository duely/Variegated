package com.noobanidus.variegated.client;

import com.noobanidus.variegated.Variegated;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Variegated.MODID)
public class Keybinds {
  public static final String ArcTweaks_GROUP = "variegated.keybinds.group";
  public static final String ArcTweaks_BINDS = "variegated.keybinds.";
  public static KeyBinding offhandActivate = null;

  public static void initKeybinds() {
    KeyBinding kb = new KeyBinding(ArcTweaks_BINDS + "offhand", 0, ArcTweaks_GROUP);
    ClientRegistry.registerKeyBinding(kb);
    offhandActivate = kb;
  }

  @SubscribeEvent
  @OnlyIn(Dist.CLIENT)
  public static void onKeybind(InputEvent.KeyInputEvent event) {
    Minecraft mc = Minecraft.getInstance();
    if (mc.isGameFocused() && offhandActivate.isKeyDown()) {
      mc.playerController.processRightClick(mc.player, mc.player.world, Hand.OFF_HAND);
    }
  }
}

