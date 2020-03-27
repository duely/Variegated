/*  @Config.Comment("Enable the Fisherman's Boon potion")
  @Config.Name("Enable Fisherman's Boon")
  public static boolean fishermansBoon = true;

  @Config.Comment("Enable the Attraction potion")
  @Config.Name("Enable Attraction")
  public static boolean attraction = true;

  @Config.Comment("Enable the Wings potion")
  @Config.Name("Enable Wings")
  public static boolean wings = true;

  @Config.Comment("Enable breeding horses with silver apples")
  @Config.Name("Enable Silver Apple breeding")
  public static boolean silverAppleBreeding = true;

  @Config.Comment("Allow ender portal frames to be broken in survival")
  @Config.Name("Breakable Ender Portal Frames")
  public static boolean breakableFrames = true;

  @Config.Comment("Allow the create of a featherweight block")
  @Config.Name("Enable featherweight")
  public static boolean enableFeatherweight = true;

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
    public int tickVarianceAmount = 30;
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
  }*/
