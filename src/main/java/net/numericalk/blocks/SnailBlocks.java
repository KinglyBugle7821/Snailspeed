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
import net.numericalk.blocks.custom.CrackedLogBlock;
import net.numericalk.blocks.custom.DamagedLogBlock;
import net.numericalk.blocks.custom.TrimmedLogBlock;

import java.util.function.Function;

public class SnailBlocks {

    public static final Block TRIMMED_OAK_LOG = registerBlock("trimmed_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_SPRUCE_LOG = registerBlock("trimmed_spruce_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_BIRCH_LOG = registerBlock("trimmed_birch_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_JUNGLE_LOG = registerBlock("trimmed_jungle_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_ACACIA_LOG = registerBlock("trimmed_acacia_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_DARK_OAK_LOG = registerBlock("trimmed_dark_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_MANGROVE_LOG = registerBlock("trimmed_mangrove_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CHERRY_LOG = registerBlock("trimmed_cherry_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_PALE_OAK_LOG = registerBlock("trimmed_pale_oak_log",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_CRIMSON_STEM = registerBlock("trimmed_crimson_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block TRIMMED_WARPED_STEM = registerBlock("trimmed_warped_stem",
            properties -> new TrimmedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));

    public static final Block CRACKED_OAK_LOG = registerBlock("cracked_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_SPRUCE_LOG = registerBlock("cracked_spruce_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_BIRCH_LOG = registerBlock("cracked_birch_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_JUNGLE_LOG = registerBlock("cracked_jungle_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_ACACIA_LOG = registerBlock("cracked_acacia_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_DARK_OAK_LOG = registerBlock("cracked_dark_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_MANGROVE_LOG = registerBlock("cracked_mangrove_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CHERRY_LOG = registerBlock("cracked_cherry_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_PALE_OAK_LOG = registerBlock("cracked_pale_oak_log",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_CRIMSON_STEM = registerBlock("cracked_crimson_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block CRACKED_WARPED_STEM = registerBlock("cracked_warped_stem",
            properties -> new CrackedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));

    public static final Block DAMAGED_OAK_LOG = registerBlock("damaged_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_SPRUCE_LOG = registerBlock("damaged_spruce_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.SPRUCE_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_BIRCH_LOG = registerBlock("damaged_birch_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.PALE_YELLOW)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_JUNGLE_LOG = registerBlock("damaged_jungle_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DIRT_BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_ACACIA_LOG = registerBlock("damaged_acacia_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_DARK_OAK_LOG = registerBlock("damaged_dark_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.BROWN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_MANGROVE_LOG = registerBlock("damaged_mangrove_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.RED)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CHERRY_LOG = registerBlock("damaged_cherry_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_PALE_OAK_LOG = registerBlock("damaged_pale_oak_log",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_CRIMSON_STEM = registerBlock("damaged_crimson_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DULL_PINK)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));
    public static final Block DAMAGED_WARPED_STEM = registerBlock("damaged_warped_stem",
            properties -> new DamagedLogBlock(properties.mapColor(MapColor.DARK_AQUA)
                    .instrument(NoteBlockInstrument.BASS).strength(4.0F).hardness(6.5F)
                    .sounds(BlockSoundGroup.NETHER_WOOD).burnable().nonOpaque().requiresTool()));

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
