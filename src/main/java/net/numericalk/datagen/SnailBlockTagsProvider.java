package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
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

    }
    @Override
    protected FabricTagProvider<Block>.FabricTagBuilder getOrCreateTagBuilder(TagKey<Block> tag) {
        return super.getOrCreateTagBuilder(tag);
    }

}
