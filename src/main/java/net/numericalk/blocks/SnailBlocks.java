package net.numericalk.blocks;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.blocks.custom.*;
import net.numericalk.blocks.custom.CampfireBlock;

import java.util.function.Function;

public class SnailBlocks {

    public static final Block TRIMMED_OAK_LOG = registerBlock("trimmed_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_SPRUCE_LOG = registerBlock("trimmed_spruce_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_BIRCH_LOG = registerBlock("trimmed_birch_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_JUNGLE_LOG = registerBlock("trimmed_jungle_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_ACACIA_LOG = registerBlock("trimmed_acacia_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_DARK_OAK_LOG = registerBlock("trimmed_dark_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_MANGROVE_LOG = registerBlock("trimmed_mangrove_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CHERRY_LOG = registerBlock("trimmed_cherry_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_PALE_OAK_LOG = registerBlock("trimmed_pale_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CRIMSON_STEM = registerBlock("trimmed_crimson_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block TRIMMED_WARPED_STEM = registerBlock("trimmed_warped_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

    public static final Block CRACKED_OAK_LOG = registerBlock("cracked_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_SPRUCE_LOG = registerBlock("cracked_spruce_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_BIRCH_LOG = registerBlock("cracked_birch_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_JUNGLE_LOG = registerBlock("cracked_jungle_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_ACACIA_LOG = registerBlock("cracked_acacia_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_DARK_OAK_LOG = registerBlock("cracked_dark_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_MANGROVE_LOG = registerBlock("cracked_mangrove_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CHERRY_LOG = registerBlock("cracked_cherry_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_PALE_OAK_LOG = registerBlock("cracked_pale_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CRIMSON_STEM = registerBlock("cracked_crimson_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block CRACKED_WARPED_STEM = registerBlock("cracked_warped_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

    public static final Block DAMAGED_OAK_LOG = registerBlock("damaged_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_SPRUCE_LOG = registerBlock("damaged_spruce_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_BIRCH_LOG = registerBlock("damaged_birch_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_JUNGLE_LOG = registerBlock("damaged_jungle_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_ACACIA_LOG = registerBlock("damaged_acacia_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_DARK_OAK_LOG = registerBlock("damaged_dark_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_MANGROVE_LOG = registerBlock("damaged_mangrove_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CHERRY_LOG = registerBlock("damaged_cherry_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_PALE_OAK_LOG = registerBlock("damaged_pale_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CRIMSON_STEM = registerBlock("damaged_crimson_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));
    public static final Block DAMAGED_WARPED_STEM = registerBlock("damaged_warped_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(6.0F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).nonOpaque().requiresTool()));

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
                    .strength(8.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CRACKED_STONE = registerBlock("cracked_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block FRACTURED_STONE = registerBlock("fractured_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block CRUMBLED_STONE = registerBlock("crumbled_stone",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(8.0f, 6.0f).sounds(BlockSoundGroup.STONE).requiresTool()));

    public static final Block SCRATCHED_DEEPSLATE = registerBlock("scratched_deepslate",
            properties -> new PillarBlock(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(9.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block CRACKED_DEEPSLATE = registerBlock("cracked_deepslate",
            properties -> new PillarBlock(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(9.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block FRACTURED_DEEPSLATE = registerBlock("fractured_deepslate",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(9.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));
    public static final Block CRUMBLED_DEEPSLATE = registerBlock("crumbled_deepslate",
            properties -> new Block(properties.mapColor(MapColor.LIGHT_GRAY)
                    .strength(9.0f, 6.0f).sounds(BlockSoundGroup.DEEPSLATE).requiresTool()));


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

    public static final Block UNSTEADY_DIRT = registerBlock("unsteady_dirt",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.GRAVEL)));
    public static final Block UNSTEADY_COARSE_DIRT = registerBlock("unsteady_coarse_dirt",
            properties -> new CustomSoilBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .strength(0.4F).sounds(BlockSoundGroup.GRAVEL)));
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Snailspeed.MOD_ID, name), toRegister);
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
