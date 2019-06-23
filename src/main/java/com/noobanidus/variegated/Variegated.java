package com.noobanidus.variegated;

import com.noobanidus.variegated.compat.top.ITOPHandler;
import com.noobanidus.variegated.init.Registrar;
import com.noobanidus.variegated.proxy.ISidedProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
@Mod(modid = Variegated.MODID, name = Variegated.MODNAME, version = Variegated.VERSION, dependencies = Variegated.DEPENDS)
@SuppressWarnings("WeakerAccess")
public class Variegated {
  public static final String MODID = "variegated";
  public static final String MODNAME = "Variegated";
  public static final String VERSION = "GRADLE:VERSION";
  public static final String DEPENDS = "after:thaumcraft;after:bloodmagic;after:extrautils2;after:botania;";

  @SuppressWarnings("unused")
  public static final String KEY = "ca23084fc26ce53879eea4b7afb0a8d9da9744d7";
  public final static Logger LOG = LogManager.getLogger(MODID);
  public final static Configuration CONFIG = new Configuration(new File("init", "variegated.cfg"), true);
  @SidedProxy(modId = MODID, clientSide = "com.noobanidus.variegated.proxy.ClientProxy", serverSide = "com.noobanidus.variegated.proxy.CommonProxy")
  public static ISidedProxy proxy;

  public static List<ITOPHandler> handlers = new ArrayList<>();

  public static CreativeTabs TAB = new CreativeTabs(MODID) {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(Registrar.silveredApple);
    }
  };

  @Mod.Instance(Variegated.MODID)
  public static Variegated instance;

  @Mod.EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    proxy.preInit(event);
  }

  @Mod.EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  @Mod.EventHandler
  public void postInit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
  }

  @Mod.EventHandler
  public void loadComplete(FMLLoadCompleteEvent event) {
    proxy.loadComplete(event);
  }

}
