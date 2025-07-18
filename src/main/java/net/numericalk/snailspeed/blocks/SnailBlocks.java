package net.numericalk.snailspeed.blocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.custom.*;
import net.numericalk.snailspeed.blocks.custom.CampfireBlock;

import java.util.function.Function;

public class SnailBlocks {
    public static final Block TRIMMED_OAK_LOG = registerBlock("trimmed_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_SPRUCE_LOG = registerBlock("trimmed_spruce_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_BIRCH_LOG = registerBlock("trimmed_birch_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_JUNGLE_LOG = registerBlock("trimmed_jungle_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_ACACIA_LOG = registerBlock("trimmed_acacia_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_DARK_OAK_LOG = registerBlock("trimmed_dark_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_MANGROVE_LOG = registerBlock("trimmed_mangrove_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CHERRY_LOG = registerBlock("trimmed_cherry_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_PALE_OAK_LOG = registerBlock("trimmed_pale_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CRIMSON_STEM = registerBlock("trimmed_crimson_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block TRIMMED_WARPED_STEM = registerBlock("trimmed_warped_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

    public static final Block CRACKED_OAK_LOG = registerBlock("cracked_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_SPRUCE_LOG = registerBlock("cracked_spruce_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_BIRCH_LOG = registerBlock("cracked_birch_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_JUNGLE_LOG = registerBlock("cracked_jungle_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_ACACIA_LOG = registerBlock("cracked_acacia_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_DARK_OAK_LOG = registerBlock("cracked_dark_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_MANGROVE_LOG = registerBlock("cracked_mangrove_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CHERRY_LOG = registerBlock("cracked_cherry_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_PALE_OAK_LOG = registerBlock("cracked_pale_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CRIMSON_STEM = registerBlock("cracked_crimson_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block CRACKED_WARPED_STEM = registerBlock("cracked_warped_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

    public static final Block DAMAGED_OAK_LOG = registerBlock("damaged_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_SPRUCE_LOG = registerBlock("damaged_spruce_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_BIRCH_LOG = registerBlock("damaged_birch_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_JUNGLE_LOG = registerBlock("damaged_jungle_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_ACACIA_LOG = registerBlock("damaged_acacia_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_DARK_OAK_LOG = registerBlock("damaged_dark_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_MANGROVE_LOG = registerBlock("damaged_mangrove_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CHERRY_LOG = registerBlock("damaged_cherry_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_PALE_OAK_LOG = registerBlock("damaged_pale_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CRIMSON_STEM = registerBlock("damaged_crimson_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block DAMAGED_WARPED_STEM = registerBlock("damaged_warped_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

    public static final Block DAMAGED_OAK_PLANKS = registerBlock("damaged_oak_planks",
            properties -> new Block(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_SPRUCE_PLANKS = registerBlock("damaged_spruce_planks",
            properties -> new Block(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_BIRCH_PLANKS = registerBlock("damaged_birch_planks",
            properties -> new Block(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_JUNGLE_PLANKS = registerBlock("damaged_jungle_planks",
            properties -> new Block(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_ACACIA_PLANKS = registerBlock("damaged_acacia_planks",
            properties -> new Block(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_DARK_OAK_PLANKS = registerBlock("damaged_dark_oak_planks",
            properties -> new Block(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_MANGROVE_PLANKS = registerBlock("damaged_mangrove_planks",
            properties -> new Block(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_CHERRY_PLANKS = registerBlock("damaged_cherry_planks",
            properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_PALE_OAK_PLANKS = registerBlock("damaged_pale_oak_planks",
            properties -> new Block(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_BAMBOO_PLANKS = registerBlock("damaged_bamboo_planks",
            properties -> new Block(properties.mapColor(MapColor.PALE_GREEN)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().requiresTool()));
    public static final Block DAMAGED_CRIMSON_PLANKS = registerBlock("damaged_crimson_planks",
            properties -> new Block(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).requiresTool()));
    public static final Block DAMAGED_WARPED_PLANKS = registerBlock("damaged_warped_planks",
            properties -> new Block(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(3.0F, 4.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).requiresTool()));

    public static final Block TAPPED_SPRUCE_LOG = registerBlock("tapped_spruce_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TAPPED_BIRCH_LOG = registerBlock("tapped_birch_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TAPPED_PALE_OAK_LOG = registerBlock("tapped_pale_oak_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));

    public static final Block DECAYED_SPRUCE_LOG = registerBlock("decayed_spruce_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DECAYED_BIRCH_LOG = registerBlock("decayed_birch_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DECAYED_PALE_OAK_LOG = registerBlock("decayed_pale_oak_log",
            properties -> new PillarBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(5.0F, 2.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));

    public static final Block CAMPFIRE_BASE = registerBlock("campfire_base",
            properties -> new CampfireBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque().luminance(CampfireBlock::getLuminance)));

    public static final Block BRICK_OVEN_BASE = registerBlock("brick_oven_base",
            properties -> new BrickOvenBaseBlock(properties.mapColor(MapColor.DULL_RED)
                    .strength(5.5F).sounds(BlockSoundGroup.STONE).nonOpaque().requiresTool()));
    public static final Block BRICK_OVEN = registerBlock("brick_oven",
            properties -> new BrickOvenBlock(properties.mapColor(MapColor.DULL_RED)
                    .strength(5.5F).sounds(BlockSoundGroup.STONE).nonOpaque()
                    .luminance(BrickOvenBlock::getLuminance).requiresTool()));

    public static final Block MORTAR = registerBlock("mortar",
            properties -> new MortarBlock(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(4.5F).sounds(BlockSoundGroup.STONE).nonOpaque().requiresTool()));

    public static final Block GRASS_SHEAF = registerBlock("grass_sheaf",
            properties -> new GrassSheafBlock(properties.mapColor(MapColor.EMERALD_GREEN)
                    .strength(0.5f).breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().noCollision().burnable()));
    public static final Block DRIED_GRASS_SHEAF = registerBlock("dried_grass_sheaf",
            properties -> new DriedGrassSheafBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(0.5f).breakInstantly().sounds(BlockSoundGroup.GRASS).nonOpaque().noCollision().burnable()));
    public static final Block CLAY_BRICK = registerBlock("clay_brick",
            properties -> new ClayBrickBlock(properties.mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.5f).breakInstantly().sounds(BlockSoundGroup.GRAVEL).nonOpaque()));
    public static final Block DRIED_CLAY_BRICK = registerBlock("dried_clay_brick",
            properties -> new DriedClayBrickBlock(properties.mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.5f).breakInstantly().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block FIRED_BRICK = registerBlock("fired_brick",
            properties -> new FiredBrickBlock(properties.mapColor(MapColor.DULL_RED)
                    .strength(0.5F).breakInstantly().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block SCRATCHED_STONE = registerBlock("scratched_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(7.0F, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CRACKED_STONE = registerBlock("cracked_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(7.0F, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block FRACTURED_STONE = registerBlock("fractured_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(7.0F, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CRUMBLED_STONE = registerBlock("crumbled_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(7.0F, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block SCRATCHED_DEEPSLATE = registerBlock("scratched_deepslate",
            properties -> new PillarBlock(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0F, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block CRACKED_DEEPSLATE = registerBlock("cracked_deepslate",
            properties -> new PillarBlock(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0F, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block FRACTURED_DEEPSLATE = registerBlock("fractured_deepslate",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0F, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block CRUMBLED_DEEPSLATE = registerBlock("crumbled_deepslate",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0F, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));


    public static final Block UNTIED_STICK_BUNDLE = registerBlock("untied_stick_bundle",
            properties -> new UntiedStickBundleBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(2.5f, 2f).sounds(BlockSoundGroup.BAMBOO).burnable()));
    public static final Block STICK_BUNDLE = registerBlock("stick_bundle",
            properties -> new TiedStickBundleBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(2.5f, 2f).sounds(BlockSoundGroup.BAMBOO).burnable()));

    public static final Block UNTIED_THATCH_BLOCK = registerBlock("untied_thatch_block",
            properties -> new UntiedThatchBlock(properties.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(1.5f).sounds(BlockSoundGroup.GRASS).burnable()));
    public static final Block THATCH_BLOCK = registerBlock("thatch_block",
            properties -> new TiedThatchBlock(properties.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(1.5f).sounds(BlockSoundGroup.GRASS).burnable()));

    public static final Block CLAY_CRUCIBLE = registerBlock("clay_crucible",
            properties -> new ClayCrucibleBlock(properties.mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.5f).breakInstantly().sounds(BlockSoundGroup.GRAVEL).nonOpaque()));
    public static final Block DRIED_CLAY_CRUCIBLE = registerBlock("dried_clay_crucible",
            properties -> new DriedClayCrucibleBlock(properties.mapColor(MapColor.WHITE_GRAY)
                    .strength(2.0f).breakInstantly().sounds(BlockSoundGroup.STONE).nonOpaque()));
    public static final Block CRUCIBLE = registerBlock("crucible",
            properties -> new CrucibleBlock(properties.mapColor(MapColor.WHITE_GRAY)
                    .strength(2.0f).breakInstantly().sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block BRICK_FURNACE = registerBlock("brick_furnace",
            properties -> new BrickFurnaceBlock(properties.mapColor(MapColor.WHITE_GRAY)
                    .strength(4.5f).sounds(BlockSoundGroup.STONE).nonOpaque().requiresTool().luminance(BrickFurnaceBlock::getLuminance)));
    public static final Block BRICK_FURNACE_BASE = registerBlock("brick_furnace_base",
            properties -> new BrickFurnaceBaseBlock(properties.mapColor(MapColor.WHITE_GRAY)
                    .strength(4.5f).sounds(BlockSoundGroup.STONE).nonOpaque().requiresTool()));

    public static final Block UNSTEADY_DIRT = registerBlock("unsteady_dirt",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block UNSTEADY_COARSE_DIRT = registerBlock("unsteady_coarse_dirt",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block UNSTEADY_ROOTED_DIRT = registerBlock("unsteady_rooted_dirt",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.ROOTED_DIRT)));
    public static final Block UNSTEADY_MUD = registerBlock("unsteady_mud",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.GRAVEL)));


    public static final Block CLAY_MOLD = registerBlock("clay_mold",
            properties -> new ClayMoldBlock(properties.mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.5F).breakInstantly().nonOpaque().sounds(BlockSoundGroup.GRAVEL)));
    public static final Block DRIED_CLAY_MOLD = registerBlock("dried_clay_mold",
            properties -> new DriedClayMoldBlock(properties.mapColor(MapColor.LIGHT_BLUE)
                    .strength(0.5F).breakInstantly().nonOpaque().sounds(BlockSoundGroup.STONE)));
    public static final Block FIRED_CLAY_MOLD = registerBlock("fired_clay_mold",
            properties -> new FiredClayMoldBlock(properties.mapColor(MapColor.DULL_RED)
                    .strength(1.0F).breakInstantly().nonOpaque().sounds(BlockSoundGroup.STONE)));

    public static final Block RESIN_BOWL = registerBlock("resin_bowl",
            properties -> new ResinBowlBlock(properties.mapColor(MapColor.DULL_RED)
                    .strength(1.0F).breakInstantly().nonOpaque().sounds(BlockSoundGroup.STONE)));

    public static final Block TIN_ORE = registerBlock("tin_ore",
            properties -> new Block(properties.mapColor(MapColor.STONE_GRAY)
                    .strength(7.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            properties -> new Block(properties.mapColor(MapColor.STONE_GRAY)
                    .strength(8.0F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block GRAPHITE_ORE = registerBlock("graphite_ore",
            properties -> new Block(properties.mapColor(MapColor.STONE_GRAY)
                    .strength(7.0F, 3.0F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block DEEPSLATE_GRAPHITE_ORE = registerBlock("deepslate_graphite_ore",
            properties -> new Block(properties.mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(8.0F, 3.0F).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));

    public static final Block FILTERING_TRAY_BASE = registerBlock("filtering_tray_base",
            properties -> new FilteringTrayBaseBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(3.0F).sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));
    public static final Block FILTERING_TRAY = registerBlock("filtering_tray",
            properties -> new FilteringTrayBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(3.0F).sounds(BlockSoundGroup.WOOD).burnable().nonOpaque()));

    public static final Block ARMOR_FORGE = registerBlock("armor_forge",
            properties -> new ArmorForgeBlock(properties.mapColor(MapColor.IRON_GRAY)
                    .strength(6.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block SMALL_BARREL = registerBlock("small_barrel",
            properties -> new SmallBarrelBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(5.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block SAW_TABLE = registerBlock("saw_table",
            properties -> new SawTableBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(5.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));
    public static final Block WEAPON_FORGE = registerBlock("weapon_forge",
            properties -> new WeaponForgeBlock(properties.mapColor(MapColor.OAK_TAN)
                    .strength(5.0F).sounds(BlockSoundGroup.WOOD).nonOpaque()));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block",
            properties -> new Block(properties.mapColor(MapColor.ORANGE)
                    .strength(4.0F, 6.0F).requiresTool().sounds(BlockSoundGroup.COPPER)));
    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            properties -> new Block(properties.mapColor(MapColor.BLACK)
                    .strength(6.0F, 6.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block TIN_BLOCK = registerBlock("tin_block",
            properties -> new Block(properties.mapColor(MapColor.TERRACOTTA_WHITE)
                    .strength(4.5F, 6.0F).requiresTool().sounds(BlockSoundGroup.METAL)));
    public static final Block LANTERN = registerBlock("lantern",
            properties -> new CustomLanternBlock(properties.mapColor(MapColor.IRON_GRAY).solid().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance(CustomLanternBlock::getLuminance).nonOpaque().pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ENCHANTING_TABLE_BASE = registerBlock("enchanting_table_base",
            properties -> new EnchantingTableBaseBlock(properties.mapColor(MapColor.BLACK).solid().strength(5.0F, 1200F).instrument(NoteBlockInstrument.BASEDRUM).sounds(BlockSoundGroup.STONE).nonOpaque()));

    public static final Block TORCH = registerTorch(
            "torch",
            settings -> new CustomTorchBlock(ParticleTypes.FLAME, settings.noCollision().breakInstantly().luminance(CustomTorchBlock::getLuminance).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)),
            AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(CustomTorchBlock::getLuminance).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block WALL_TORCH = registerTorch(
            "wall_torch",
            settings -> new CustomWallTorchBlock(ParticleTypes.FLAME, settings),
            copyLootTable(TORCH, true).noCollision().breakInstantly().luminance(CustomTorchBlock::getLuminance).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY)
    );

    private static AbstractBlock.Settings copyLootTable(Block block, boolean copyTranslationKey) {
        AbstractBlock.Settings settings = block.getSettings();
        AbstractBlock.Settings settings2 = AbstractBlock.Settings.create().lootTable(block.getLootTableKey());
        if (copyTranslationKey) {
            settings2 = settings2.overrideTranslationKey(block.getTranslationKey());
        }

        return settings2;
    }
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Snailspeed.MOD_ID, name), toRegister);
    }
    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, id));
    }
    private static Block registerTorch(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(keyOf(id), factory, settings);
    }
    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = (Block)factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }
    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Snailspeed.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Snailspeed.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, name)))));
    }


    public static void initialize() {}
}
