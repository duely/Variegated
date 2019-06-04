package com.noobanidus.variegated.proxy;

import com.noobanidus.variegated.client.Keybinds;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@SuppressWarnings("unused")
public class ClientProxy extends CommonProxy {
    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);

        Keybinds.initKeybinds();
    }
}
