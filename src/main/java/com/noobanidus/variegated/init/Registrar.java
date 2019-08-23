package com.noobanidus.variegated.init;

import com.noobanidus.variegated.Variegated;
import com.noobanidus.variegated.VariegatedConfig;
import com.noobanidus.variegated.blocks.BlockDefiledGround;
import com.noobanidus.variegated.compat.bloodmagic.items.BloodApple;
import com.noobanidus.variegated.compat.botania.enchantment.EnchantmentManabound;
import com.noobanidus.variegated.compat.thaumcraft.blocks.BlockCompressedVisBattery;
import com.noobanidus.variegated.potions.PotionBoon;
import com.noobanidus.variegated.potions.PotionLove;
import com.noobanidus.variegated.tileentities.TileEntityDefiledGround;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Objects;

@SuppressWarnings("WeakerAccess")
@Mod.EventBusSubscriber(modid = Variegated.MODID)
public class Registrar {
  public static Block compressed = null;
  public static ItemBlock ib_compressed = null;

  public static Block defiled = null;
  public static ItemBlock ib_defiled = null;

  public static Item apple = null;

  public static Enchantment manabound = null;

  public static Item silveredApple;

  private static int duration = 4800;

  public static Potion boon = new PotionBoon();
  public static PotionType boonI = new PotionType("boon", new PotionEffect(boon, duration));
  public static PotionType boonII = new PotionType("boon", new PotionEffect(boon, duration, 1));
  public static PotionType boonIII = new PotionType("boon", new PotionEffect(boon, duration, 2));

  public static Potion attraction = new PotionLove();
  public static PotionType attractionI = new PotionType("attraction", new PotionEffect(attraction, 10 * 20));

  @SuppressWarnings("ConstantConditions")
  public static void preInit() {
    if (Loader.isModLoaded("botania")) {
      manabound = new EnchantmentManabound("variegated:manabound");
    }

    if (Loader.isModLoaded("bloodmagic")) {
      apple = new BloodApple();
    }

    if (Loader.isModLoaded("thaumcraft")) {
      compressed = new BlockCompressedVisBattery();
      ib_compressed = new ItemBlock(compressed);
      ib_compressed.setRegistryName(compressed.getRegistryName());
    }

    defiled = new BlockDefiledGround();
    ib_defiled = new ItemBlock(defiled);
    ib_defiled.setRegistryName(defiled.getRegistryName());

    silveredApple = new ItemAppleGold(4, 1.2f, false) {
      @Override
      public boolean hasEffect(ItemStack stack) {
        return false;
      }

      @Override
      public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (isInCreativeTab(tab)) {
          items.add(new ItemStack(this, 1));
        }
        return;
      }
    }.setAlwaysEdible().setTranslationKey("silvered_apple").setRegistryName("variegated", "silvered_apple").setCreativeTab(Variegated.TAB);
  }

  @SubscribeEvent
  public static void registerBlocks(RegistryEvent.Register<Block> event) {
    if (VariegatedConfig.Thaumcraft.enabled && Loader.isModLoaded("thaumcraft")) {
      event.getRegistry().register(compressed);
    }

    event.getRegistry().register(defiled);

    GameRegistry.registerTileEntity(TileEntityDefiledGround.class, new ResourceLocation(Variegated.MODID, "defiled_ground"));
  }

  @SubscribeEvent
  public static void registerItems(RegistryEvent.Register<Item> event) {
    if (VariegatedConfig.Thaumcraft.enabled && Loader.isModLoaded("thaumcraft")) {
      event.getRegistry().register(ib_compressed);
    }

    if (Loader.isModLoaded("bloodmagic")) {
      event.getRegistry().register(apple);
    }

    event.getRegistry().register(silveredApple);
    event.getRegistry().register(ib_defiled);
  }

  @SideOnly(Side.CLIENT)
  @SubscribeEvent
  public static void registerModels(ModelRegistryEvent event) {
    if (VariegatedConfig.Thaumcraft.enabled && Loader.isModLoaded("thaumcraft")) {
      ModelLoader.setCustomModelResourceLocation(ib_compressed, 0, new ModelResourceLocation(new ResourceLocation("variegated", "compressed_vis_battery"), "inventory"));
    }

    if (VariegatedConfig.DefiledGround.defiledGroundEnabled) {
      ModelLoader.setCustomModelResourceLocation(ib_defiled, 0, new ModelResourceLocation(Objects.requireNonNull(defiled.getRegistryName()), "inventory"));
    }

    if (Loader.isModLoaded("bloodmagic")) {
      ModelLoader.setCustomModelResourceLocation(apple, 0, new ModelResourceLocation(Objects.requireNonNull(apple.getRegistryName()), "inventory"));
    }

    ModelLoader.setCustomModelResourceLocation(silveredApple, 0, new ModelResourceLocation("variegated:food", "type=silveredApple"));
  }

  @SubscribeEvent
  public static void registerEnchantments(RegistryEvent.Register<Enchantment> event) {
    if (VariegatedConfig.Botania.enabled && Loader.isModLoaded("botania")) {
      event.getRegistry().register(manabound);
    }
  }

  @SubscribeEvent
  public static void registerPotions(RegistryEvent.Register<Potion> event) {
    event.getRegistry().register(boon);
    event.getRegistry().register(attraction);
  }

  @SubscribeEvent
  public static void registerPotionTypes(RegistryEvent.Register<PotionType> event) {
    boonI.setRegistryName(Variegated.MODID, "boon");
    boonII.setRegistryName(Variegated.MODID, "boon2");
    boonIII.setRegistryName(Variegated.MODID, "boon3");
    attractionI.setRegistryName(Variegated.MODID, "attraction");

    if (VariegatedConfig.fishermansBoon) {
      event.getRegistry().register(boonI);
      event.getRegistry().register(boonII);
      event.getRegistry().register(boonIII);
      PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromStacks(new ItemStack(Items.FISH, 1, ItemFishFood.FishType.COD.getMetadata())), boonI);
      PotionHelper.addMix(boonI, Ingredient.fromStacks(new ItemStack(Items.FISH, 1, ItemFishFood.FishType.CLOWNFISH.getMetadata())), boonII);
      PotionHelper.addMix(boonII, Items.EMERALD, boonIII);
    }

    if (VariegatedConfig.attraction) {
      event.getRegistry().register(attractionI);
      PotionHelper.addMix(PotionTypes.AWKWARD, Ingredient.fromItem(Items.EMERALD), attractionI);
    }
  }
}
