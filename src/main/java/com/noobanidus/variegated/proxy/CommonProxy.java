package com.noobanidus.variegated.proxy;

import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.commands.CommandInfo;
import com.noobanidus.variegated.commands.CommandSimulate;
import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.compat.bloodmagic.handlers.HellfireSpeed;
import com.noobanidus.variegated.compat.bloodmagic.top.TOPHandler;
import com.noobanidus.variegated.compat.botania.brew.Brews;
import com.noobanidus.variegated.compat.botania.enchantment.EnchantmentManabound;
import com.noobanidus.variegated.compat.exotic_birds.ReducePackSize;
import com.noobanidus.variegated.compat.top.TOPProvider;
import com.noobanidus.variegated.compat.vanilla.handlers.MansionBiomeTypesHandler;
import com.noobanidus.variegated.compat.StackSizeEtcHandler;
import com.noobanidus.variegated.init.Registrar;
import com.noobanidus.variegated.network.Networking;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.*;

public class CommonProxy implements ISidedProxy {
  public void preInit(FMLPreInitializationEvent event) {
    Registrar.preInit();
    Networking.register();
  }

  public void init(FMLInitializationEvent event) {
    if (Loader.isModLoaded("theoneprobe")) {
      TOPProvider.init();
    }

    Brews.registerBrews();
    EnchantmentManabound.registerEnchantment();
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
    if (Loader.isModLoaded("exoticbirds") && VariegatedConfig.ExoticBirds.enable) {
      ReducePackSize.init();
    }
    if (Loader.isModLoaded("bloodmagic")) {
      HellfireSpeed.init();
    }
    Variegated.LOG.info("Variegated: Load Complete.");
  }

  public void serverStarting(FMLServerStartingEvent event) {
    event.registerServerCommand(new CommandSimulate());
    event.registerServerCommand(new CommandInfo());
  }

  public void serverStarted(FMLServerStartedEvent event) {
  }
}
