package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailBlockTagsProvider extends FabricTagProvider<Block> {

    public SnailBlockTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    public static final TagKey<Block> TRIMMED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "trimmed_logs"));
    public static final TagKey<Block> CRACKED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "cracked_logs"));
    public static final TagKey<Block> DAMAGED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "damaged_logs"));

    public static final TagKey<Block> STRIPPED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "stripped_logs"));
    public static final TagKey<Block> UNSTRIPPED_LOGS = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "unstripped_logs"));

    public static final TagKey<Block> STONE_BLOCK = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "stone_block"));
    public static final TagKey<Block> CRUMBLED_STONE_BLOCK = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Snailspeed.MOD_ID, "crumbled_stone_block"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(STONE_BLOCK)
                .add(Blocks.STONE)
                .add(SnailBlocks.SCRATCHED_STONE)
                .add(SnailBlocks.CRACKED_STONE)
                .add(Blocks.COBBLESTONE)
                .add(SnailBlocks.FRACTURED_STONE)
                .add(SnailBlocks.CRUMBLED_STONE)
                .add(Blocks.DEEPSLATE)
                .add(SnailBlocks.SCRATCHED_DEEPSLATE)
                .add(SnailBlocks.CRACKED_DEEPSLATE)
                .add(Blocks.COBBLED_DEEPSLATE)
                .add(SnailBlocks.FRACTURED_DEEPSLATE)
                .add(SnailBlocks.CRUMBLED_DEEPSLATE);
        getOrCreateTagBuilder(CRUMBLED_STONE_BLOCK)
                .add(SnailBlocks.CRUMBLED_STONE)
                .add(SnailBlocks.CRUMBLED_DEEPSLATE);

        getOrCreateTagBuilder(UNSTRIPPED_LOGS)
                .add(Blocks.OAK_LOG)
                .add(Blocks.OAK_WOOD)
                .add(Blocks.SPRUCE_LOG)
                .add(Blocks.SPRUCE_WOOD)
                .add(Blocks.BIRCH_LOG)
                .add(Blocks.BIRCH_WOOD)
                .add(Blocks.JUNGLE_LOG)
                .add(Blocks.JUNGLE_WOOD)
                .add(Blocks.ACACIA_LOG)
                .add(Blocks.ACACIA_WOOD)
                .add(Blocks.DARK_OAK_LOG)
                .add(Blocks.DARK_OAK_WOOD)
                .add(Blocks.MANGROVE_LOG)
                .add(Blocks.MANGROVE_WOOD)
                .add(Blocks.CHERRY_LOG)
                .add(Blocks.CHERRY_WOOD)
                .add(Blocks.PALE_OAK_LOG)
                .add(Blocks.PALE_OAK_WOOD)
                .add(Blocks.CRIMSON_STEM)
                .add(Blocks.CRIMSON_HYPHAE)
                .add(Blocks.WARPED_STEM)
                .add(Blocks.WARPED_HYPHAE);
        getOrCreateTagBuilder(STRIPPED_LOGS)
                .add(Blocks.STRIPPED_OAK_LOG)
                .add(Blocks.STRIPPED_OAK_WOOD)
                .add(Blocks.STRIPPED_SPRUCE_LOG)
                .add(Blocks.STRIPPED_SPRUCE_WOOD)
                .add(Blocks.STRIPPED_BIRCH_LOG)
                .add(Blocks.STRIPPED_BIRCH_WOOD)
                .add(Blocks.STRIPPED_JUNGLE_LOG)
                .add(Blocks.STRIPPED_JUNGLE_WOOD)
                .add(Blocks.STRIPPED_ACACIA_LOG)
                .add(Blocks.STRIPPED_ACACIA_WOOD)
                .add(Blocks.STRIPPED_DARK_OAK_LOG)
                .add(Blocks.STRIPPED_DARK_OAK_WOOD)
                .add(Blocks.STRIPPED_MANGROVE_LOG)
                .add(Blocks.STRIPPED_MANGROVE_WOOD)
                .add(Blocks.STRIPPED_CHERRY_LOG)
                .add(Blocks.STRIPPED_CHERRY_WOOD)
                .add(Blocks.STRIPPED_PALE_OAK_LOG)
                .add(Blocks.STRIPPED_PALE_OAK_WOOD)
                .add(Blocks.STRIPPED_CRIMSON_STEM)
                .add(Blocks.STRIPPED_CRIMSON_HYPHAE)
                .add(Blocks.STRIPPED_WARPED_STEM)
                .add(Blocks.STRIPPED_WARPED_HYPHAE);

        getOrCreateTagBuilder(TRIMMED_LOGS)
                .add(SnailBlocks.TRIMMED_OAK_LOG)
                .add(SnailBlocks.TRIMMED_SPRUCE_LOG)
                .add(SnailBlocks.TRIMMED_BIRCH_LOG)
                .add(SnailBlocks.TRIMMED_JUNGLE_LOG)
                .add(SnailBlocks.TRIMMED_ACACIA_LOG)
                .add(SnailBlocks.TRIMMED_DARK_OAK_LOG)
                .add(SnailBlocks.TRIMMED_MANGROVE_LOG)
                .add(SnailBlocks.TRIMMED_CHERRY_LOG)
                .add(SnailBlocks.TRIMMED_PALE_OAK_LOG)
                .add(SnailBlocks.TRIMMED_CRIMSON_STEM)
                .add(SnailBlocks.TRIMMED_WARPED_STEM);

        getOrCreateTagBuilder(CRACKED_LOGS)
                .add(SnailBlocks.CRACKED_OAK_LOG)
                .add(SnailBlocks.CRACKED_SPRUCE_LOG)
                .add(SnailBlocks.CRACKED_BIRCH_LOG)
                .add(SnailBlocks.CRACKED_JUNGLE_LOG)
                .add(SnailBlocks.CRACKED_ACACIA_LOG)
                .add(SnailBlocks.CRACKED_DARK_OAK_LOG)
                .add(SnailBlocks.CRACKED_MANGROVE_LOG)
                .add(SnailBlocks.CRACKED_CHERRY_LOG)
                .add(SnailBlocks.CRACKED_PALE_OAK_LOG)
                .add(SnailBlocks.CRACKED_CRIMSON_STEM)
                .add(SnailBlocks.CRACKED_WARPED_STEM);

        getOrCreateTagBuilder(DAMAGED_LOGS)
                .add(SnailBlocks.DAMAGED_OAK_LOG)
                .add(SnailBlocks.DAMAGED_SPRUCE_LOG)
                .add(SnailBlocks.DAMAGED_BIRCH_LOG)
                .add(SnailBlocks.DAMAGED_JUNGLE_LOG)
                .add(SnailBlocks.DAMAGED_ACACIA_LOG)
                .add(SnailBlocks.DAMAGED_DARK_OAK_LOG)
                .add(SnailBlocks.DAMAGED_MANGROVE_LOG)
                .add(SnailBlocks.DAMAGED_CHERRY_LOG)
                .add(SnailBlocks.DAMAGED_PALE_OAK_LOG)
                .add(SnailBlocks.DAMAGED_CRIMSON_STEM)
                .add(SnailBlocks.DAMAGED_WARPED_STEM);

        getOrCreateTagBuilder(BlockTags.LOGS)
                .add(SnailBlocks.TRIMMED_OAK_LOG)
                .add(SnailBlocks.TRIMMED_SPRUCE_LOG)
                .add(SnailBlocks.TRIMMED_BIRCH_LOG)
                .add(SnailBlocks.TRIMMED_JUNGLE_LOG)
                .add(SnailBlocks.TRIMMED_ACACIA_LOG)
                .add(SnailBlocks.TRIMMED_DARK_OAK_LOG)
                .add(SnailBlocks.TRIMMED_MANGROVE_LOG)
                .add(SnailBlocks.TRIMMED_CHERRY_LOG)
                .add(SnailBlocks.TRIMMED_PALE_OAK_LOG)
                .add(SnailBlocks.TRIMMED_CRIMSON_STEM)
                .add(SnailBlocks.TRIMMED_WARPED_STEM)

                .add(SnailBlocks.CRACKED_OAK_LOG)
                .add(SnailBlocks.CRACKED_SPRUCE_LOG)
                .add(SnailBlocks.CRACKED_BIRCH_LOG)
                .add(SnailBlocks.CRACKED_JUNGLE_LOG)
                .add(SnailBlocks.CRACKED_ACACIA_LOG)
                .add(SnailBlocks.CRACKED_DARK_OAK_LOG)
                .add(SnailBlocks.CRACKED_MANGROVE_LOG)
                .add(SnailBlocks.CRACKED_CHERRY_LOG)
                .add(SnailBlocks.CRACKED_PALE_OAK_LOG)
                .add(SnailBlocks.CRACKED_CRIMSON_STEM)
                .add(SnailBlocks.CRACKED_WARPED_STEM)

                .add(SnailBlocks.DAMAGED_OAK_LOG)
                .add(SnailBlocks.DAMAGED_SPRUCE_LOG)
                .add(SnailBlocks.DAMAGED_BIRCH_LOG)
                .add(SnailBlocks.DAMAGED_JUNGLE_LOG)
                .add(SnailBlocks.DAMAGED_ACACIA_LOG)
                .add(SnailBlocks.DAMAGED_DARK_OAK_LOG)
                .add(SnailBlocks.DAMAGED_MANGROVE_LOG)
                .add(SnailBlocks.DAMAGED_CHERRY_LOG)
                .add(SnailBlocks.DAMAGED_PALE_OAK_LOG)
                .add(SnailBlocks.DAMAGED_CRIMSON_STEM)
                .add(SnailBlocks.DAMAGED_WARPED_STEM);
        getOrCreateTagBuilder(BlockTags.SNAPS_GOAT_HORN)
                .add(SnailBlocks.TRIMMED_OAK_LOG)
                .add(SnailBlocks.TRIMMED_SPRUCE_LOG)
                .add(SnailBlocks.TRIMMED_BIRCH_LOG)
                .add(SnailBlocks.TRIMMED_JUNGLE_LOG)
                .add(SnailBlocks.TRIMMED_ACACIA_LOG)
                .add(SnailBlocks.TRIMMED_DARK_OAK_LOG)
                .add(SnailBlocks.TRIMMED_MANGROVE_LOG)
                .add(SnailBlocks.TRIMMED_CHERRY_LOG)
                .add(SnailBlocks.TRIMMED_PALE_OAK_LOG)
                .add(SnailBlocks.TRIMMED_CRIMSON_STEM)
                .add(SnailBlocks.TRIMMED_WARPED_STEM)

                .add(SnailBlocks.CRACKED_OAK_LOG)
                .add(SnailBlocks.CRACKED_SPRUCE_LOG)
                .add(SnailBlocks.CRACKED_BIRCH_LOG)
                .add(SnailBlocks.CRACKED_JUNGLE_LOG)
                .add(SnailBlocks.CRACKED_ACACIA_LOG)
                .add(SnailBlocks.CRACKED_DARK_OAK_LOG)
                .add(SnailBlocks.CRACKED_MANGROVE_LOG)
                .add(SnailBlocks.CRACKED_CHERRY_LOG)
                .add(SnailBlocks.CRACKED_PALE_OAK_LOG)
                .add(SnailBlocks.CRACKED_CRIMSON_STEM)
                .add(SnailBlocks.CRACKED_WARPED_STEM);
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(SnailBlocks.TRIMMED_OAK_LOG)
                .add(SnailBlocks.TRIMMED_SPRUCE_LOG)
                .add(SnailBlocks.TRIMMED_BIRCH_LOG)
                .add(SnailBlocks.TRIMMED_JUNGLE_LOG)
                .add(SnailBlocks.TRIMMED_ACACIA_LOG)
                .add(SnailBlocks.TRIMMED_DARK_OAK_LOG)
                .add(SnailBlocks.TRIMMED_MANGROVE_LOG)
                .add(SnailBlocks.TRIMMED_CHERRY_LOG)
                .add(SnailBlocks.TRIMMED_PALE_OAK_LOG)

                .add(SnailBlocks.CRACKED_OAK_LOG)
                .add(SnailBlocks.CRACKED_SPRUCE_LOG)
                .add(SnailBlocks.CRACKED_BIRCH_LOG)
                .add(SnailBlocks.CRACKED_JUNGLE_LOG)
                .add(SnailBlocks.CRACKED_ACACIA_LOG)
                .add(SnailBlocks.CRACKED_DARK_OAK_LOG)
                .add(SnailBlocks.CRACKED_MANGROVE_LOG)
                .add(SnailBlocks.CRACKED_CHERRY_LOG)
                .add(SnailBlocks.CRACKED_PALE_OAK_LOG)

                .add(SnailBlocks.DAMAGED_OAK_LOG)
                .add(SnailBlocks.DAMAGED_SPRUCE_LOG)
                .add(SnailBlocks.DAMAGED_BIRCH_LOG)
                .add(SnailBlocks.DAMAGED_JUNGLE_LOG)
                .add(SnailBlocks.DAMAGED_ACACIA_LOG)
                .add(SnailBlocks.DAMAGED_DARK_OAK_LOG)
                .add(SnailBlocks.DAMAGED_MANGROVE_LOG)
                .add(SnailBlocks.DAMAGED_CHERRY_LOG)
                .add(SnailBlocks.DAMAGED_PALE_OAK_LOG);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(SnailBlocks.CAMPFIRE_BASE)
                .add(SnailBlocks.UNTIED_STICK_BUNDLE)
                .add(SnailBlocks.STICK_BUNDLE);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(SnailBlocks.BRICK_OVEN_BASE)
                .add(SnailBlocks.BRICK_OVEN)

                .add(SnailBlocks.SCRATCHED_STONE)
                .add(SnailBlocks.CRACKED_STONE)
                .add(SnailBlocks.FRACTURED_STONE)
                .add(SnailBlocks.CRUMBLED_STONE)

                .add(SnailBlocks.SCRATCHED_DEEPSLATE)
                .add(SnailBlocks.CRACKED_DEEPSLATE)
                .add(SnailBlocks.FRACTURED_DEEPSLATE)
                .add(SnailBlocks.CRUMBLED_DEEPSLATE);
    }
    @Override
    protected FabricTagProvider<Block>.FabricTagBuilder getOrCreateTagBuilder(TagKey<Block> tag) {
        return super.getOrCreateTagBuilder(tag);
    }
}
