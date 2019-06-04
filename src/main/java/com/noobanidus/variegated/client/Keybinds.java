package com.noobanidus.variegated.client;

import com.noobanidus.variegated.Variegated;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    @SideOnly(Side.CLIENT)
    public static void onKeybind(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getMinecraft();
        if (mc.inGameHasFocus && offhandActivate.isKeyDown()) {
            mc.playerController.processRightClick(mc.player, mc.player.world, EnumHand.OFF_HAND);
        }
    }
}

