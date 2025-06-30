package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.blocks.SnailBlocksBrain;
import net.numericalk.snailspeed.items.SnailItems;

public class SnailModelProvider extends FabricModelProvider {

    public SnailModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_SPRUCE_LOG, Identifier.of("snailspeed", "block/trimmed_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_BIRCH_LOG, Identifier.of("snailspeed", "block/trimmed_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_JUNGLE_LOG, Identifier.of("snailspeed", "block/trimmed_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_ACACIA_LOG, Identifier.of("snailspeed", "block/trimmed_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_MANGROVE_LOG, Identifier.of("snailspeed", "block/trimmed_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_CHERRY_LOG, Identifier.of("snailspeed", "block/trimmed_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/trimmed_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_CRIMSON_STEM, Identifier.of("snailspeed", "block/trimmed_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TRIMMED_WARPED_STEM, Identifier.of("snailspeed", "block/trimmed_warped_stem"));

        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_OAK_LOG, Identifier.of("snailspeed", "block/cracked_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_SPRUCE_LOG, Identifier.of("snailspeed", "block/cracked_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_BIRCH_LOG, Identifier.of("snailspeed", "block/cracked_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_JUNGLE_LOG, Identifier.of("snailspeed", "block/cracked_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_ACACIA_LOG, Identifier.of("snailspeed", "block/cracked_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/cracked_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_MANGROVE_LOG, Identifier.of("snailspeed", "block/cracked_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_CHERRY_LOG, Identifier.of("snailspeed", "block/cracked_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/cracked_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_CRIMSON_STEM, Identifier.of("snailspeed", "block/cracked_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_WARPED_STEM, Identifier.of("snailspeed", "block/cracked_warped_stem"));

        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_OAK_LOG, Identifier.of("snailspeed", "block/damaged_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_SPRUCE_LOG, Identifier.of("snailspeed", "block/damaged_spruce_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_BIRCH_LOG, Identifier.of("snailspeed", "block/damaged_birch_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_JUNGLE_LOG, Identifier.of("snailspeed", "block/damaged_jungle_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_ACACIA_LOG, Identifier.of("snailspeed", "block/damaged_acacia_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_DARK_OAK_LOG, Identifier.of("snailspeed", "block/damaged_dark_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_MANGROVE_LOG, Identifier.of("snailspeed", "block/damaged_mangrove_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_CHERRY_LOG, Identifier.of("snailspeed", "block/damaged_cherry_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_PALE_OAK_LOG, Identifier.of("snailspeed", "block/damaged_pale_oak_log"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_CRIMSON_STEM, Identifier.of("snailspeed", "block/damaged_crimson_stem"));
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DAMAGED_WARPED_STEM, Identifier.of("snailspeed", "block/damaged_warped_stem"));

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_SPRUCE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_BIRCH_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_JUNGLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_ACACIA_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_DARK_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_MANGROVE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_CHERRY_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_PALE_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_BAMBOO_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_CRIMSON_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DAMAGED_WARPED_PLANKS);

        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TAPPED_SPRUCE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TAPPED_BIRCH_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.TAPPED_PALE_OAK_LOG, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DECAYED_SPRUCE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DECAYED_BIRCH_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.DECAYED_PALE_OAK_LOG, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.GRASS_SHEAF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.DRIED_GRASS_SHEAF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.CLAY_BRICK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.DRIED_CLAY_BRICK);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.FIRED_BRICK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.MORTAR);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.CLAY_CRUCIBLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.DRIED_CLAY_CRUCIBLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.CRUCIBLE);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.SCRATCHED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.CRACKED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.FRACTURED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.CRUMBLED_STONE);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.SCRATCHED_DEEPSLATE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.CRACKED_DEEPSLATE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.FRACTURED_DEEPSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.CRUMBLED_DEEPSLATE);

        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.UNTIED_STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.UNTIED_THATCH_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocksBrain.THATCH_BLOCK, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.UNSTEADY_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.UNSTEADY_ROOTED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.UNSTEADY_COARSE_DIRT);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DEEPSLATE_TIN_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.GRAPHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocksBrain.DEEPSLATE_GRAPHITE_ORE);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocksBrain.SAW_TABLE);
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
        itemModelGenerator.register(SnailItems.FLINT_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(SnailBlocksBrain.CAMPFIRE_BASE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailItems.TINDER, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BURNING_TINDER, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BURNT_TINDER, Models.HANDHELD);

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
        itemModelGenerator.register(SnailItems.PESTLE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BARK_SPUD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.CLAY_SAND, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PEBBLE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STONE_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.SOUL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_NUGGET, Models.GENERATED);

        itemModelGenerator.register(SnailItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLD_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.MOLTEN_COPPER, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_IRON, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_GOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_TIN, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_BRONZE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_STEEL, Models.GENERATED);

        itemModelGenerator.register(SnailItems.FURNACE_LID, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BLANK_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SWORD_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.AXE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PICKAXE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SHOVEL_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.HOE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.INGOT_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PLATE_CLAY_MOLD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BLANK_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SWORD_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.AXE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PICKAXE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SHOVEL_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.HOE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.INGOT_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PLATE_GRAPHITE_MOLD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.COPPER_SWORD_BLADE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_AXE_HEAD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_PICKAXE_HEAD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_SHOVEL_HEAD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_HOE_HEAD, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.IRON_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_HOE_HEAD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.GOLDEN_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLDEN_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLDEN_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLDEN_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLDEN_HOE_HEAD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BRONZE_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_HOE_HEAD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.STEEL_SWORD_BLADE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_AXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_PICKAXE_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_SHOVEL_HEAD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_HOE_HEAD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BRONZE_HOE, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.STEEL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.STEEL_AXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.STEEL_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.STEEL_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.STEEL_HOE, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.RESIN_BALL, Models.GENERATED);

        itemModelGenerator.register(SnailItems.RAW_TIN, Models.GENERATED);
        itemModelGenerator.register(SnailItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(SnailItems.TIN_NUGGET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.TIN_INGOT, Models.GENERATED);

        itemModelGenerator.register(SnailItems.RAW_GRAPHITE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GROUND_GRAPHITE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.REFINED_GRAPHITE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BRONZE_NUGGET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_PLATE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.STEEL_CHUNK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_INGOT, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_PLATE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.COPPER_PLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_PLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLDEN_PLATE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.FIBER_FILTER, Models.GENERATED);

        itemModelGenerator.register(SnailItems.COPPER_HELMET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_BOOTS, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BRONZE_HELMET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BRONZE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(SnailItems.STEEL_HELMET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STEEL_BOOTS, Models.GENERATED);

        itemModelGenerator.register(SnailItems.COPPER_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.STEEL_HAMMER, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.COPPER_RIVET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.LEATHER_STRIP, Models.GENERATED);

        itemModelGenerator.register(SnailItems.CHAIN_LINKS, Models.GENERATED);
        itemModelGenerator.register(SnailItems.IRON_BOLT, Models.GENERATED);

        itemModelGenerator.register(SnailItems.ARMOR_FORGE_PLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.LONG_STICK, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.AIR, Models.GENERATED);







        itemModelGenerator.register(SnailBlocksBrain.GRASS_SHEAF.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.DRIED_GRASS_SHEAF.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.CLAY_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.DRIED_CLAY_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.FIRED_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.CLAY_CRUCIBLE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.DRIED_CLAY_CRUCIBLE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.CRUCIBLE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocksBrain.MORTAR.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocksBrain.BRICK_OVEN_BASE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.BRICK_FURNACE_BASE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocksBrain.CLAY_MOLD.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.DRIED_CLAY_MOLD.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.FIRED_CLAY_MOLD.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocksBrain.RESIN_BOWL.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocksBrain.FILTERING_TRAY_BASE.asItem(), Models.GENERATED);
    }
    @Override
    public String getName() {
        return "snailspeed Model Provider";
    }
}
