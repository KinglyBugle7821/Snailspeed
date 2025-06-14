package net.numericalk.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

public class SnailModelProvider extends FabricModelProvider {

    public SnailModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_SPRUCE_LOG, Identifier.of("snailspeed", "block/trimmed_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_BIRCH_LOG, Identifier.of("snailspeed", "block/trimmed_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_JUNGLE_LOG, Identifier.of("snailspeed", "block/trimmed_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_ACACIA_LOG, Identifier.of("snailspeed", "block/trimmed_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_MANGROVE_LOG, Identifier.of("snailspeed", "block/trimmed_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_CHERRY_LOG, Identifier.of("snailspeed", "block/trimmed_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_CRIMSON_STEM, Identifier.of("snailspeed", "block/trimmed_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TRIMMED_WARPED_STEM, Identifier.of("snailspeed", "block/trimmed_warped_stem"));

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_OAK_LOG, Identifier.of("snailspeed", "block/cracked_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_SPRUCE_LOG, Identifier.of("snailspeed", "block/cracked_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_BIRCH_LOG, Identifier.of("snailspeed", "block/cracked_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_JUNGLE_LOG, Identifier.of("snailspeed", "block/cracked_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_ACACIA_LOG, Identifier.of("snailspeed", "block/cracked_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/cracked_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_MANGROVE_LOG, Identifier.of("snailspeed", "block/cracked_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_CHERRY_LOG, Identifier.of("snailspeed", "block/cracked_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/cracked_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_CRIMSON_STEM, Identifier.of("snailspeed", "block/cracked_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_WARPED_STEM, Identifier.of("snailspeed", "block/cracked_warped_stem"));

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_OAK_LOG, Identifier.of("snailspeed", "block/damaged_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_SPRUCE_LOG, Identifier.of("snailspeed", "block/damaged_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_BIRCH_LOG, Identifier.of("snailspeed", "block/damaged_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_JUNGLE_LOG, Identifier.of("snailspeed", "block/damaged_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_ACACIA_LOG, Identifier.of("snailspeed", "block/damaged_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/damaged_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_MANGROVE_LOG, Identifier.of("snailspeed", "block/damaged_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_CHERRY_LOG, Identifier.of("snailspeed", "block/damaged_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/damaged_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_CRIMSON_STEM, Identifier.of("snailspeed", "block/damaged_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DAMAGED_WARPED_STEM, Identifier.of("snailspeed", "block/damaged_warped_stem"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.GRASS_SHEAF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.DRIED_GRASS_SHEAF);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.SCRATCHED_STONE);

//        blockStateModelGenerator.registerAxisRotated(SnailBlocks.UNTIED_STICK_BUNDLE, Identifier.of("snailspeed", "block/untied_stick_bundle"));
//        blockStateModelGenerator.registerAxisRotated(SnailBlocks.STICK_BUNDLE, Identifier.of("snailspeed", "block/stick_bundle"));

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.UNTIED_STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
//        blockStateModelGenerator.registerAxisRotated(SnailBlocks.UNTIED_STICK_BUNDLE, Identifier.of("snailspeed", "block/untied_stick_bundle"));
//        blockStateModelGenerator.registerAxisRotated(SnailBlocks.STICK_BUNDLE, Identifier.of("snailspeed", "block/stick_bundle"));
    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(SnailItems.OAK_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SPRUCE_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BIRCH_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.JUNGLE_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ACACIA_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.DARK_OAK_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MANGROVE_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.CHERRY_LOG_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PALE_OAK_LOG_BARK, Models.GENERATED);

        itemModelGenerator.register(SnailItems.WARPED_STEM_BARK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.CRIMSON_STEM_BARK, Models.GENERATED);

        itemModelGenerator.register(SnailItems.WOOD_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.FLINT_FLAKE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.FLINT_HATCHET, Models.HANDHELD);

        itemModelGenerator.register(SnailBlocks.CAMPFIRE_BASE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailItems.TINDER, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNING_TINDER, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_TINDER, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BURNT_POTATO, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_POPPED_CHORUS_FRUIT, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_CHICKEN, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_COD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_MUTTON, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_PORKCHOP, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_RABBIT, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_SALMON, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_KELP, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BURNT_BEEF, Models.GENERATED);

        itemModelGenerator.register(SnailItems.GRASS_TWINE, Models.GENERATED);

        itemModelGenerator.register(SnailBlocks.GRASS_SHEAF.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.DRIED_GRASS_SHEAF.asItem(), Models.GENERATED);
    }
    @Override
    public String getName() {
        return "Snailspeed Model Provider";
    }
}
