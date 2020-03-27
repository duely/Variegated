package com.noobanidus.variegated;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

import java.nio.file.Path;

public class ConfigManager {
  private static final ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

  public static ForgeConfigSpec COMMON_CONFIG;



  public static void loadConfig(ForgeConfigSpec spec, Path path) {
    CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave().writingMode(WritingMode.REPLACE).build();
    configData.load();
    spec.setConfig(configData);
  }

  public static void configLoaded(ModConfig.Loading event) {
    reset(event.getConfig());
  }

  public static void configReloaded(ModConfig.ConfigReloading event) {
    reset(event.getConfig());
  }

  public static void reset(ModConfig config) {
    COMMON_CONFIG.setConfig(config.getConfigData());
    // TODO: DO ANY CLEARS HERE
  }
}
