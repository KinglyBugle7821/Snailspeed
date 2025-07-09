package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.advancement.SnailCriteria;
import net.numericalk.snailspeed.advancement.custom.*;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SnailAdvancementProvider extends FabricAdvancementProvider {
    public SnailAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry spawning = Advancement.Builder.create().display(Items.GRASS_BLOCK, Text.literal("Welcome"), Text.literal("Welcome To Snailspeed"), Identifier.ofVanilla("textures/block/smooth_stone.png"), AdvancementFrame.TASK, true, true, false).criterion("spawned", InventoryChangedCriterion.Conditions.items(Items.AIR)).build(consumer, Snailspeed.MOD_ID + ":spawning");
        AdvancementEntry breakLogWithoutTool = Advancement.Builder.create().parent(spawning).display(Items.BARRIER, Text.literal("Uh Oh!"), Text.literal("Break A Log With An Empty Hand"), null, AdvancementFrame.GOAL, true, true, false).criterion("broke_log_no_hand", SnailCriteria.BREAK_LOG.create(new BreakingLogCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":break_log_no_hand");
        AdvancementEntry getFlint = Advancement.Builder.create().parent(breakLogWithoutTool).display(Items.FLINT, Text.literal("Getting Started"), Text.literal("Craft Gravel Into Flint"), null, AdvancementFrame.TASK, true, true, false).criterion("got_flint", InventoryChangedCriterion.Conditions.items(Items.FLINT)).build(consumer, Snailspeed.MOD_ID + ":get_flint");
        AdvancementEntry getFlintFlake = Advancement.Builder.create().parent(getFlint).display(SnailItems.FLINT_FLAKE, Text.literal("Mason"), Text.literal("Break A Stone With A Flint To Turn It Into A Flint Flake"), null, AdvancementFrame.TASK, true, true, false).criterion("got_flint_flake", InventoryChangedCriterion.Conditions.items(SnailItems.FLINT_FLAKE)).build(consumer, Snailspeed.MOD_ID + ":get_flint_flake");
        AdvancementEntry gettingWood = Advancement.Builder.create().parent(getFlintFlake).display(SnailItems.FLINT_FLAKE, Text.literal("Getting Wood... Dust"), Text.literal("Break A Log With A Flint Flake"), null, AdvancementFrame.TASK, true, true, false).criterion("got_wood_dust", InventoryChangedCriterion.Conditions.items(SnailItems.WOOD_DUST)).build(consumer, Snailspeed.MOD_ID + ":get_wood_dust");
        AdvancementEntry campfireBuild = Advancement.Builder.create().parent(gettingWood).display(SnailBlocks.CAMPFIRE_BASE.asItem(), Text.literal("Campfire!"), Text.literal("Build A Campfire"), null, AdvancementFrame.TASK, true, true, false).criterion("built_campfire", SnailCriteria.BUILDING_CAMPFIRE.create(new BuildingCampfireCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":building_campfire");
        AdvancementEntry startingFire = Advancement.Builder.create().parent(campfireBuild).display(SnailItems.BURNING_TINDER, Text.literal("FIRE!"), Text.literal("Start A Fire With Tinder"), null, AdvancementFrame.TASK, true, true, false).criterion("got_fire", InventoryChangedCriterion.Conditions.items(SnailItems.BURNING_TINDER)).build(consumer, Snailspeed.MOD_ID + ":get_fire");
        AdvancementEntry campfireCooking = Advancement.Builder.create().parent(startingFire).display(SnailBlocks.CAMPFIRE_BASE.asItem(), Text.literal("Let Him Cook"), Text.literal("Cook On A Campfire"), null, AdvancementFrame.TASK, true, true, false).criterion("cooked_campfire", SnailCriteria.CAMPFIRE_COOKING.create(new CookingOnCampfireCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":cooking_campfire");
        AdvancementEntry overcooked =
                Advancement.Builder.create().parent(campfireCooking)
                        .display(SnailItems.BURNT_KELP.asItem(),
                                Text.literal("Gordon Hates This"),
                                Text.literal("Overcook A Food"),
                                null, AdvancementFrame.TASK,
                                true, true, false)
                        .criterion("burnt_beef",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_BEEF))
                        .criterion("burnt_chicken",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_CHICKEN))
                        .criterion("burnt_cod",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_COD))
                        .criterion("burnt_kelp",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_KELP))
                        .criterion("burnt_mutton",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_MUTTON))
                        .criterion("burnt_popped_chorus",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_POPPED_CHORUS_FRUIT))
                        .criterion("burnt_porkchop",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_PORKCHOP))
                        .criterion("burnt_potato",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_POTATO))
                        .criterion("burnt_rabbit",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_RABBIT))
                        .criterion("burnt_salmon",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_SALMON))
                        .criterion("burnt_bread",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BURNT_BREAD))
                        .requirements(AdvancementRequirements.anyOf(
                                List.of("burnt_beef",
                                        "burnt_chicken",
                                        "burnt_cod",
                                        "burnt_kelp",
                                        "burnt_mutton",
                                        "burnt_popped_chorus",
                                        "burnt_porkchop",
                                        "burnt_potato",
                                        "burnt_rabbit",
                                        "burnt_salmon",
                                        "burnt_bread")))
                        .build(consumer, Snailspeed.MOD_ID + ":overcooking");
        AdvancementEntry gettingAdvanced = Advancement.Builder.create().parent(campfireBuild).display(Items.BRICK, Text.literal("Advancing"), Text.literal("Get A Brick By Drying And Firing A Clay Brick"), null, AdvancementFrame.TASK, true, true, false).criterion("got_brick", InventoryChangedCriterion.Conditions.items(Items.BRICK)).build(consumer, Snailspeed.MOD_ID + ":get_brick");

        AdvancementEntry brickOvenBuild = Advancement.Builder.create().parent(gettingAdvanced).display(SnailBlocks.BRICK_OVEN.asItem(), Text.literal("LET HIM COOK NOW!"), Text.literal("Build A Brick Oven"), null, AdvancementFrame.TASK, true, true, false).criterion("got_brick_oven", SnailCriteria.BUILDING_BRICK_OVEN.create(new BuildingBrickOvenCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":building_brick_oven");
        AdvancementEntry soulTaker = Advancement.Builder.create().parent(brickOvenBuild).display(SnailItems.SOUL, Text.literal("Soul Taker"), Text.literal("Get A Soul By Killing Hostile Mobs"), null, AdvancementFrame.GOAL, true, true, false).criterion("got_soul", InventoryChangedCriterion.Conditions.items(SnailItems.SOUL)).build(consumer, Snailspeed.MOD_ID + ":get_soul");
        AdvancementEntry soulFire = Advancement.Builder.create().parent(soulTaker).display(SnailBlocks.BRICK_OVEN.asItem(), Text.literal("It's Getting Hot In Here"), Text.literal("Use A Soul On A Brick Oven"), null, AdvancementFrame.TASK, true, true, false).criterion("lit_soul_fire", SnailCriteria.SOUL_FIRE.create(new SoulFireCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":light_soul_fire");

        AdvancementEntry brickFurnaceBuild = Advancement.Builder.create().parent(gettingAdvanced).display(SnailBlocks.BRICK_FURNACE.asItem(), Text.literal("Industrial Evolution"), Text.literal("Build A Brick Furnace"), null, AdvancementFrame.TASK, true, true, false).criterion("got_brick_furnace", SnailCriteria.BUILDING_BRICK_FURNACE.create(new BuildingBrickFurnaceCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":building_brick_furnace");
        AdvancementEntry gettingCrucible = Advancement.Builder.create().parent(brickFurnaceBuild).display(SnailBlocks.CRUCIBLE.asItem(), Text.literal("Smelting Nuggets"), Text.literal("Dry And Fire A Clay Crucible"), null, AdvancementFrame.TASK, true, true, false).criterion("got_crucible", InventoryChangedCriterion.Conditions.items(SnailBlocks.CRUCIBLE.asItem())).build(consumer, Snailspeed.MOD_ID + ":get_crucible");
        AdvancementEntry gettingFurnaceLid = Advancement.Builder.create().parent(brickFurnaceBuild).display(SnailItems.FURNACE_LID, Text.literal("Sealed The Deal"), Text.literal("Create A Furnace Lid"), null, AdvancementFrame.TASK, true, true, false).criterion("got_furnace_lid", InventoryChangedCriterion.Conditions.items(SnailItems.FURNACE_LID)).build(consumer, Snailspeed.MOD_ID + ":get_furnace_lid");

        AdvancementEntry gettingClayMold =
                Advancement.Builder.create().parent(gettingAdvanced)
                        .display(SnailItems.INGOT_CLAY_MOLD,
                                Text.literal("Shaping Mold"),
                                Text.literal("Dry And Fire A Clay Mold"),
                                null, AdvancementFrame.TASK, true,
                                true, false)
                        .criterion("got_blank_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BLANK_CLAY_MOLD))
                        .criterion("got_sword_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.SWORD_CLAY_MOLD))
                        .criterion("got_axe_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.AXE_CLAY_MOLD))
                        .criterion("got_pickaxe_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.PICKAXE_CLAY_MOLD))
                        .criterion("got_shovel_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.SHOVEL_CLAY_MOLD))
                        .criterion("got_hoe_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.HOE_CLAY_MOLD))
                        .criterion("got_block_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.INGOT_CLAY_MOLD))
                        .criterion("got_ingot_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BLOCK_CLAY_MOLD))
                        .criterion("got_plate_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.PLATE_CLAY_MOLD))
                        .criterion("got_bucket_clay_mold",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BUCKET_CLAY_MOLD))
                        .requirements(AdvancementRequirements.anyOf(
                                List.of("got_blank_clay_mold",
                                        "got_sword_clay_mold",
                                        "got_axe_clay_mold",
                                        "got_pickaxe_clay_mold",
                                        "got_shovel_clay_mold",
                                        "got_hoe_clay_mold",
                                        "got_block_clay_mold",
                                        "got_ingot_clay_mold",
                                        "got_plate_clay_mold",
                                        "got_bucket_clay_mold")))
                        .build(consumer, Snailspeed.MOD_ID + ":getting_clay_mold");
        AdvancementEntry gettingCastTool =
                Advancement.Builder.create().parent(gettingClayMold)
                        .display(SnailItems.BRONZE_PICKAXE_HEAD,
                                Text.literal("Casting Ingots"),
                                Text.literal("Right-Click A Mold On A Molten Item"),
                                null, AdvancementFrame.TASK,
                                true, true, false)
                        .criterion("got_copper_sword_blade",
                                InventoryChangedCriterion.Conditions.items(SnailItems.COPPER_SWORD_BLADE))
                        .criterion("got_copper_axe_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.COPPER_AXE_HEAD))
                        .criterion("got_copper_shovel_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.COPPER_SHOVEL_HEAD))
                        .criterion("got_copper_hoe_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.COPPER_HOE_HEAD))
                        .criterion("got_copper_block",
                                InventoryChangedCriterion.Conditions.items(Blocks.COPPER_BLOCK))
                        .criterion("got_copper_ingot",
                                InventoryChangedCriterion.Conditions.items(Items.COPPER_INGOT))
                        .criterion("got_bronze_sword_blade",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_SWORD_BLADE))
                        .criterion("got_bronze_axe_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_AXE_HEAD))
                        .criterion("got_bronze_shovel_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_SHOVEL_HEAD))
                        .criterion("got_bronze_hoe_head",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_HOE_HEAD))
                        .criterion("got_bronze_block",
                                InventoryChangedCriterion.Conditions.items(SnailBlocks.BRONZE_BLOCK))
                        .criterion("got_bronze_ingot",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_INGOT))
                        .criterion("got_bronze_plate",
                                InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_PLATE))
                        .criterion("got_copper_plate",
                                InventoryChangedCriterion.Conditions.items(SnailItems.COPPER_PLATE))
                        .criterion("got_bucket",
                                InventoryChangedCriterion.Conditions.items(Items.BUCKET))
                        .requirements(AdvancementRequirements.anyOf(
                                List.of("got_copper_sword_blade",
                                        "got_copper_axe_head",
                                        "got_copper_shovel_head",
                                        "got_copper_hoe_head",
                                        "got_copper_block",
                                        "got_copper_ingot",
                                        "got_bronze_sword_blade",
                                        "got_bronze_axe_head",
                                        "got_bronze_shovel_head",
                                        "got_bronze_hoe_head",
                                        "got_bronze_block",
                                        "got_bronze_ingot",
                                        "got_bronze_plate",
                                        "got_copper_plate",
                                        "got_bucket")))
                        .build(consumer, Snailspeed.MOD_ID + ":casting_tool");
        AdvancementEntry gettingUpgrade = Advancement.Builder.create().parent(gettingCastTool).display(SnailItems.BRONZE_PICKAXE, Text.literal("Getting An Upgrade"), Text.literal("Craft A Bronze Pickaxe"), null, AdvancementFrame.TASK, true, true, false).criterion("got_upgrade", InventoryChangedCriterion.Conditions.items(SnailItems.BRONZE_PICKAXE)).build(consumer, Snailspeed.MOD_ID + ":getting_upgrade");

        AdvancementEntry gettingSaw = Advancement.Builder.create().parent(gettingUpgrade).display(SnailBlocks.SAW_TABLE, Text.literal("Cutting Wood"), Text.literal("Build A Saw Table By Using Circular Saw On A Wooden Slab"), null, AdvancementFrame.TASK, true, true, false).criterion("got_saw", SnailCriteria.GETTING_SAW.create(new GettingSawCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":getting_saw");
        AdvancementEntry gettingStonecutter = Advancement.Builder.create().parent(gettingUpgrade).display(Blocks.STONECUTTER, Text.literal("Cutting Stone"), Text.literal("Build A Stonecutter By Using Circular Saw On A Stone Slab"), null, AdvancementFrame.TASK, true, true, false).criterion("got_stonecutter", SnailCriteria.GETTING_STONECUTTER.create(new GettingStonecutterCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":getting_stonecutter");

        AdvancementEntry gettingArmorForge = Advancement.Builder.create().parent(gettingUpgrade).display(SnailBlocks.ARMOR_FORGE, Text.literal("Mom, I'm Going To War"), Text.literal("Build An Armor Forge By Using Forge Plate On A Stripped Log"), null, AdvancementFrame.TASK, true, true, false).criterion("got_armor_forge", SnailCriteria.GETTING_ARMOR_FORGE.create(new GettingArmorForgeCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":getting_armor_forge");
        AdvancementEntry gettingWeaponForge = Advancement.Builder.create().parent(gettingUpgrade).display(SnailBlocks.WEAPON_FORGE, Text.literal("Standing On Swords"), Text.literal("Build A Weapon Forge By Using Forge Plate On A Log"), null, AdvancementFrame.TASK, true, true, false).criterion("got_weapon_forge", SnailCriteria.GETTING_WEAPON_FORGE.create(new GettingWeaponForgeCriterion.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":getting_weapon_forge");

        AdvancementEntry gettingSteelArmor =
                Advancement.Builder.create().parent(gettingArmorForge)
                        .display(SnailItems.STEEL_CHESTPLATE,
                                Text.literal("Cover Me In Steel"),
                                Text.literal("Forge a piece of Steel Armor"),
                                null,AdvancementFrame.GOAL, true,
                                true, false)
                        .criterion("got_steel_helmet",
                                InventoryChangedCriterion.Conditions.items(SnailItems.STEEL_HELMET))
                        .criterion("got_steel_chestplate",
                                InventoryChangedCriterion.Conditions.items(SnailItems.STEEL_CHESTPLATE))
                        .criterion("got_steel_leggings",
                                InventoryChangedCriterion.Conditions.items(SnailItems.STEEL_LEGGINGS))
                        .criterion("got_steel_boots",
                                InventoryChangedCriterion.Conditions.items(SnailItems.STEEL_BOOTS))
                        .requirements(AdvancementRequirements.anyOf(
                                List.of("got_steel_helmet",
                                        "got_steel_chestplate",
                                        "got_steel_leggings",
                                        "got_steel_boots")))
                        .build(consumer, Snailspeed.MOD_ID + ":getting_steel_armor");

        AdvancementEntry gettingEnchantingTable = Advancement.Builder.create().parent(gettingArmorForge).display(Items.ENCHANTING_TABLE, Text.literal("Magic Is Real!"), Text.literal("Build An Enchanting Table By Using Enchanting Table Base, Diamond, Red Carpet, And Book"), null, AdvancementFrame.TASK, true, true, false).criterion("got_enchanting_table", SnailCriteria.BUILDING_ENCHANTING_TABLE.create(new EnchantingTableCriteria.Conditions(Optional.empty()))).build(consumer, Snailspeed.MOD_ID + ":getting_enchanting_table");
    }
}
