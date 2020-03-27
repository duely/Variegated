package com.noobanidus.variegated;

import com.noobanidus.variegated.registrate.CustomRegistrate;
import com.noobanidus.variegated.setup.ClientSetup;
import com.noobanidus.variegated.setup.CommonSetup;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("variegated")
@SuppressWarnings("WeakerAccess")
public class Variegated {
  public static final String MODID = "variegated";

  @SuppressWarnings("unused")
  public final static Logger LOG = LogManager.getLogger(MODID);

  public static CustomRegistrate REGISTRATE;

  public static ItemGroup ITEM_GROUP = new ItemGroup(MODID) {
    @Override
    public ItemStack createIcon() {
      return null;
    }
  };

  public Variegated() {
    ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigManager.COMMON_CONFIG);
    ConfigManager.loadConfig(ConfigManager.COMMON_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MODID + "-common.toml"));
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    modBus.addListener(CommonSetup::init);

    REGISTRATE = CustomRegistrate.create(MODID);
    REGISTRATE.itemGroup(NonNullSupplier.of(() -> ITEM_GROUP));

    DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
      modBus.addListener(ClientSetup::init);
    });
  }
}
