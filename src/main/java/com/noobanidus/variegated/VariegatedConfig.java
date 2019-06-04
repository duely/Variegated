package com.noobanidus.variegated;

import net.minecraftforge.common.config.Config;

@Config(modid = Variegated.MODID)
@SuppressWarnings("unused")
public class VariegatedConfig {
    @Config.Comment("Settings related to Blood Magic")
    @Config.Name("Blood Magic")
    public static BloodMagic BloodMagic = new BloodMagic();
    @Config.Comment("Settings related to Botania")
    @Config.Name("Botania")
    public static Botania Botania = new Botania();
    @Config.Comment("Settings related to Thaumcraft")
    @Config.Name("Thaumcraft")
    public static Thaumcraft Thaumcraft = new Thaumcraft();
    @Config.Comment("Enable the Fisherman's Boon potion")
    @Config.Name("Enable Fisherman's Boon")
    public static boolean fishermansBoon = true;
    @Config.Comment("Break chance for Anvils (set to -1 to disable changing)")
    @Config.Name("Anvil Break Chance")
    public static double anvilBreakChance = 0.05d;
    @Config.Comment("Clear repair cost of items processed by the anvil")
    @Config.Name("Enable Cost Removal")
    public static boolean anvilCostRemoval = true;
    @Config.Comment("Enable breeding horses with silver apples")
    @Config.Name("Enable Silver Apple breeding")
    public static boolean silverAppleBreeding = true;
    @Config.Comment("Horses can traverse leaves without colliding")
    @Config.Name("Horses walk through leaves")
    public static boolean leafEnabled = true;
    @Config.Comment("Horses 'swim' upwards while in water, preventing dismounting")
    @Config.Name("Horses swim")
    public static boolean swimmingEnabled = true;
    @Config.Comment("Increase frequency of Woodland Mansion spawn by allowing it to spawn in additional biomes (Thaumcraft & Traverse forests and Vanilla forests)")
    @Config.Name("Extra Mansion Biomes")
    public static boolean extraMansions = true;
    @Config.Comment("Print oreDict entries in item tooltips")
    @Config.Name("OreDict Tooltips")
    public static boolean oredict = false;
    @Config.Comment("Increase size of cake stacks")
    @Config.Name("Cake Stack Size")
    @Config.RangeInt(min = 1, max = 64)
    public static int cakeCount = 64;
    @Config.Comment("Increase size of ender pearl stacks")
    @Config.Name("Ender Pearl Stack Size")
    @Config.RangeInt(min = 1, max = 64)
    public static int enderCount = 64;
    @Config.Comment("Increase size of snowball stacks")
    @Config.Name("Snowball Stack Size")
    @Config.RangeInt(min = 1, max = 64)
    public static int snowballCount = 64;
    @Config.Comment("Increase size of sign stacks")
    @Config.Name("Sign Stack Size")
    @Config.RangeInt(min = 1, max = 64)
    public static int signCount = 64;
    @Config.Comment("Increase size of enchanted book stacks")
    @Config.Name("Enchanted Book Stack Size")
    @Config.RangeInt(min = 1, max = 64)
    public static int bookCount = 64;
    @Config.Comment("Cancel trampling events for crops and farmland")
    @Config.Name("Cancel Trample")
    public static boolean cancelTrample = true;
    @Config.Comment("Age baby villagers with emeralds")
    @Config.Name("Baby Villager Aging")
    public static boolean ageVillagers = true;
    @Config.Comment("Value to age villagers by per emerald")
    @Config.Name("Baby Villager Age Value")
    public static int ageValue = 240;

    public static class BloodMagic {
        @Config.Comment("Automatically create a platform for the meteor to land on.")
        @Config.Name("Meteor platform")
        public boolean meteorEnabled = true;

        @Config.Comment("Y level to place the platform at (requires Meteor platform enabled)")
        @Config.Name("Platform Height")
        public int y = 24;
    }

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

    public static class Thaumcraft {
        @Config.Comment("Enable the Compressed Vis Battery, storing and restoring more to the aura.")
        @Config.Name("Enable Compressed Vis Battery")
        public boolean enabled = true;
    }
}
