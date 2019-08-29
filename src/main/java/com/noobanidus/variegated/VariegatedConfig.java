package com.noobanidus.variegated;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class VariegatedConfig {
  @SubscribeEvent
  public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
    if (event.getModID().equals(Variegated.MODID)) {
      ConfigManager.sync(Variegated.MODID, Config.Type.INSTANCE);
    }
  }

  @Config.Comment("Enable the Fisherman's Boon potion")
  @Config.Name("Enable Fisherman's Boon")
  public static boolean fishermansBoon = true;

  @Config.Comment("Enable the Attraction potion")
  @Config.Name("Enable Attraction")
  public static boolean attraction = true;

  @Config.Comment("Enable breeding horses with silver apples")
  @Config.Name("Enable Silver Apple breeding")
  public static boolean silverAppleBreeding = true;

  @Config.Comment("Allow ender portal frames to be broken in survival")
  @Config.Name("Breakable Ender Portal Frames")
  public static boolean breakableFrames = true;

  @Config.Comment("Options relating to the stack sizes of various items")
  @Config.Name("Stack Size")
  public static StackSizes stackSizes = new StackSizes();

  public static class StackSizes {
    @Config.Comment("Increase size of cake stacks [-1 to keep default]")
    @Config.Name("Cake Stack Size")
    @Config.RangeInt(min = -1, max = 64)
    public int cakeCount = 64;
    @Config.Comment("Increase size of ender pearl stacks [-1 to keep default]")
    @Config.Name("Ender Pearl Stack Size")
    @Config.RangeInt(min = -1, max = 64)
    public int enderCount = 64;
    @Config.Comment("Increase size of snowball stacks [-1 to keep default]")
    @Config.Name("Snowball Stack Size")
    @Config.RangeInt(min = -1, max = 64)
    public int snowballCount = 64;
    @Config.Comment("Increase size of sign stacks [-1 to keep default]")
    @Config.Name("Sign Stack Size")
    @Config.RangeInt(min = -1, max = 64)
    public int signCount = 64;
    @Config.Comment("Increase size of enchanted book stacks [-1 to keep default]")
    @Config.Name("Enchanted Book Stack Size")
    @Config.RangeInt(min = -1, max = 64)
    public int bookCount = 64;
    @Config.Comment("Increase size of bucket stacks [-1 to keep default]")
    @Config.Name("Bucket stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int bucketCount = 64;
    @Config.Comment("Increase size of egg stacks [-1 to keep default]")
    @Config.Name("Egg stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int eggCount = 64;
    @Config.Comment("Increase size of written book stacks [-1 to keep default]")
    @Config.Name("Written book stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int writtenBookCount = 64;
    @Config.Comment("Increase size of armor stand stacks [-1 to keep default]")
    @Config.Name("Armor stand stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int armorStandCount = 64;
    @Config.Comment("Increase size of banner stacks [-1 to keep default]")
    @Config.Name("Banner stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int bannerCount = 64;
    @Config.Comment("Increase size of minecart stacks [-1 to keep default]")
    @Config.Name("Minecart stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int minecartCount = 64;
    @Config.Comment("Increase size of potion stacks [-1 to keep default]")
    @Config.Name("Potion stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int potionCount = 64;
    @Config.Comment("Increase size of boat stacks [-1 to keep default]")
    @Config.Name("Boat stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int boatCount = 64;
    @Config.Comment("Increase size of loot bag stacks [Thaumcraft only] [-1 to keep default]")
    @Config.Name("Loot bag stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int lootBagCount = 64;
    @Config.Comment("Increase size of taint bottle stacks [Thaumcraft only] [-1 to keep default]")
    @Config.Name("Taint bottle stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int taintBottleCount = 64;
    @Config.Comment("Increase size of causality collapser stacks [Thaumcraft only] [-1 to keep default]")
    @Config.Name("Causality collapser stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int causalityCount = 64;
    @Config.Comment("Increase size of snare stacks [Blood Magic only] [-1 to keep default]")
    @Config.Name("Snare stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int snareCount = 64;
    @Config.Comment("Increase the stack size of ender tears [EvilCraft only] [-1 to keep default]")
    @Config.Name("Ender Tear stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int enderTearCount = 64;
    @Config.Comment("Increase the stack size of werewolf flesh [EvilCraft only] [-1 to keep default]")
    @Config.Name("Werewolf flesh stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int werewolfCount = 64;
    @Config.Comment("Increase the stack size of lightning grenades [EvilCraft only] [-1 to keep default]")
    @Config.Name("Lightning grenade stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int lightningCount = 64;
    @Config.Comment("Increase the stack size of redstone grenades [EvilCraft only] [-1 to keep default]")
    @Config.Name("Redstone grenade stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int redstoneCount = 64;
    @Config.Comment("Increase the stack size of dark power gems [EvilCraft only] [-1 to keep default]")
    @Config.Name("Dark power gem stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int darkPowerCount = 64;
    @Config.Comment("Increase the stack size of inverted potentia [EvilCraft only] [-1 to keep default]")
    @Config.Name("Inverted potentia stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int potentiaCount = 64;
    @Config.Comment("Increase the stack size of coins [Treasure2! only] [-1 to keep default]")
    @Config.Name("Coin stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int coinCount = 64;
    @Config.Comment("Increase the stack size of tea cups [SimplyTea only] [-1 to keep default]")
    @Config.Name("Tea cup stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int cupCount = 64;
    @Config.Comment("Increase the stack size of soul vials [EnderIO only] [-1 to keep default]")
    @Config.Name("Soul vial stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int soulVialCount = 64;
    @Config.Comment("Increase the stack size of combustive cod [Combustive Fishing only] [-1 to keep default]")
    @Config.Name("Combustive cod stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int codCount = 64;
    @Config.Comment("Increase the stack size of lenses [Astral Sorcery only] [-1 to keep default]")
    @Config.Name("Lens stack size")
    @Config.RangeInt(min = -1, max = 64)
    public int lensCount = 64;
    @Config.Comment("Print out to the log a list of items with a max stack size more than 1 but less than 64")
    @Config.Name("Log Stack Sizes")
    public boolean logStackSizes = false;
  }

  @Config.Comment("Settings related to Vanilla")
  @Config.Name("Vanilla Settings")
  public static VanillaSettings vanillaSettings = new VanillaSettings();

  public static class VanillaSettings {
    @Config.Comment("Break chance for Anvils (set to -1 to disable changing)")
    @Config.Name("Anvil Break Chance")
    public double anvilBreakChance = 0.05d;

    @Config.Comment("Clear repair cost of items processed by the anvil")
    @Config.Name("Enable Cost Removal")
    public boolean anvilCostRemoval = true;

    @Config.Comment("Horses can traverse leaves without colliding")
    @Config.Name("Horses walk through leaves")
    public boolean leafEnabled = true;

    @Config.Comment("Horses 'swim' upwards while in water, preventing dismounting")
    @Config.Name("Horses swim")
    public boolean swimmingEnabled = true;

    @Config.Comment("Increase frequency of Woodland Mansion spawn by allowing it to spawn in additional biomes (Thaumcraft & Traverse forests and Vanilla forests)")
    @Config.Name("Extra Mansion Biomes")
    public boolean extraMansions = true;

    @Config.Comment("Print oreDict entries in item tooltips")
    @Config.Name("OreDict Tooltips")
    public boolean oredict = false;

    @Config.Comment("Cancel trampling events for crops and farmland")
    @Config.Name("Cancel Trample")
    public boolean cancelTrample = true;

    @Config.Comment("Age baby villagers with emeralds")
    @Config.Name("Baby Villager Aging")
    public boolean ageVillagers = true;

    @Config.Comment("Value to age villagers by per emerald")
    @Config.Name("Baby Villager Age Value")
    public int ageValue = 240;
  }

  @Config.Comment("Settings related to Defiled Ground")
  @Config.Name("Defiled Ground")
  public static DefiledGround DefiledGround = new DefiledGround();

  public static class DefiledGround {
    @Config.Comment("Enabled defiled ground's functionality; if disabled, it is still craftable, but does nothing.")
    @Config.Name("Enable Defiled Ground")
    public boolean defiledGroundEnabled = true;

    @Config.Comment("Radius in which to test for mobs for total number of mobs spawned")
    @Config.Name("Check horizontal radius")
    public int horizontalRadius = 5;

    @Config.Comment("Vertical radius in which to test for mobs for total number of mobs spawned")
    @Config.Name("Check vertical radius")
    public int verticalRadius = 4;

    @Config.Comment("Set to false to disable numerical checks for nearby mobs before spawning")
    @Config.Name("Enable mob check")
    public boolean mobCheck = true;

    @Config.Comment("Maximum number of mobs within range at which point to stop spawning")
    @Config.Name("Maximum mobs")
    public int maximumMobs = 10;

    @Config.Comment("Minimum light level for spawning mobs (set to -1 to disable)")
    @Config.Name("Minimum light")
    @Config.RangeInt(min = -1, max = 15)
    public int minimumLight = 7;

    @Config.Comment("Requires silk-touch in order to harvest")
    @Config.Name("Require silk touch")
    public boolean requireSilkTouch = false;

    @Config.Comment("Set the chance per tick of spawning mobs (higher value = rarer, this value is ignored if Spawn on tick is enabled)")
    @Config.Name("Spawn chance")
    @Config.RangeInt(min = 1)
    public int spawnChance = 3200;

    @Config.Comment("Set to true to enable configuration to happen on a regular basis with potential randomisation")
    @Config.Name("Spawn on tick")
    public boolean spawnOnTick = true;

    @Config.Comment("How often spawns should happen in ticks (multiply by 20 to convert to seconds)")
    @Config.Name("Spawn every tick")
    public int spawnTickRate = 680; // 34 seconds

    @Config.Comment("Set to true to enable variance by a random number of the tick rate")
    @Config.Name("Enable tick variance")
    public boolean tickVariance = true;

    @Config.Comment("Set to the number of ticks to randomly add (or subtract) from the next spawn")
    @Config.Name("Tick variance")
    public int tickVarianceAmount = 100;
  }

  @Config.Comment("Settings related to Blood Magic")
  @Config.Name("Blood Magic")
  public static BloodMagic BloodMagic = new BloodMagic();

  public static class BloodMagic {
    @Config.Comment("Automatically create a platform for the meteor to land on.")
    @Config.Name("Meteor platform")
    public boolean meteorEnabled = true;

    @Config.Comment("Y level to place the platform at (requires Meteor platform enabled)")
    @Config.Name("Platform Height")
    public int y = 24;
  }

  @Config.Comment("Settings related to Botania")
  @Config.Name("Botania")
  public static Botania Botania = new Botania();

  public static class Botania {
    @Config.Comment("Mana cost of the 'Wings' flight brew.")
    @Config.Name("Wings Brew Cost")
    public int WingsCost = 50000;

    @Config.Comment("Enable the Manabound enchantment, which causes items to be repaired with mana from the player's inventory")
    @Config.Name("Manabound Enchantment")
    public boolean enabled = true;

    @Config.Comment("Cost of mana to repair a point of damage")
    @Config.Name("Mana Cost per Damage Point")
    public int manaCost = 370;
  }

  @Config.Comment("Settings related to Thaumcraft")
  @Config.Name("Thaumcraft")
  public static Thaumcraft Thaumcraft = new Thaumcraft();

  public static class Thaumcraft {
    @Config.Comment("Enable the Compressed Vis Battery, storing and restoring more to the aura.")
    @Config.Name("Enable Compressed Vis Battery")
    public boolean enabled = true;
  }
}

