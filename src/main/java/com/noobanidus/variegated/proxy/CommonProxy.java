package com.noobanidus.variegated.proxy;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.compat.bloodmagic.top.TOPHandler;
import com.noobanidus.variegated.compat.botania.brew.Brews;
import com.noobanidus.variegated.compat.top.TOPProvider;
import com.noobanidus.variegated.compat.vanilla.handlers.MansionBiomeTypesHandler;
import com.noobanidus.variegated.compat.vanilla.handlers.StackSizeEtcHandler;
import com.noobanidus.variegated.init.Registrar;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy implements ISidedProxy {
  public void preInit(FMLPreInitializationEvent event) {
    Registrar.preInit();
  }

  public void init(FMLInitializationEvent event) {
    if (Loader.isModLoaded("theoneprobe")) {
      TOPProvider.init();
    }

    Brews.registerBrews();
  }

  public void postInit(FMLPostInitializationEvent event) {
    if (Loader.isModLoaded("bloodmagic")) {
      Variegated.handlers.add(new TOPHandler());
    }
    if (Loader.isModLoaded("botania")) {
      Variegated.handlers.add(new com.noobanidus.variegated.compat.botania.top.TOPHandler());
    }
    if (Loader.isModLoaded("thaumcraft")) {
      Variegated.handlers.add(new com.noobanidus.variegated.compat.thaumcraft.top.TOPHandler());
    }
    if (Loader.isModLoaded("extrautils2")) {
      Variegated.handlers.add(new com.noobanidus.variegated.compat.xu2.top.TOPHandler());
    }
  }

  public void loadComplete(FMLLoadCompleteEvent event) {
    StackSizeEtcHandler.init();
    MansionBiomeTypesHandler.init();
    Variegated.LOG.info("Variegated: Load Complete.");
    Variegated.CONFIG.save();
  }

  public void serverStarting(FMLServerStartingEvent event) {
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }
}
