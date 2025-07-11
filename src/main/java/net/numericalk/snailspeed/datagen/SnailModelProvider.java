package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

public class SnailModelProvider extends FabricModelProvider {

    public SnailModelProvider(FabricDataOutput output) {
        super(output);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block[] axisRotatedBlocks = {
                SnailBlocks.TRIMMED_OAK_LOG,
                SnailBlocks.TRIMMED_SPRUCE_LOG,
                SnailBlocks.TRIMMED_BIRCH_LOG,
                SnailBlocks.TRIMMED_JUNGLE_LOG,
                SnailBlocks.TRIMMED_ACACIA_LOG,
                SnailBlocks.TRIMMED_DARK_OAK_LOG,
                SnailBlocks.TRIMMED_MANGROVE_LOG,
                SnailBlocks.TRIMMED_CHERRY_LOG,
                SnailBlocks.TRIMMED_PALE_OAK_LOG,
                SnailBlocks.TRIMMED_CRIMSON_STEM,
                SnailBlocks.TRIMMED_WARPED_STEM,

                SnailBlocks.CRACKED_OAK_LOG,
                SnailBlocks.CRACKED_SPRUCE_LOG,
                SnailBlocks.CRACKED_BIRCH_LOG,
                SnailBlocks.CRACKED_JUNGLE_LOG,
                SnailBlocks.CRACKED_ACACIA_LOG,
                SnailBlocks.CRACKED_DARK_OAK_LOG,
                SnailBlocks.CRACKED_MANGROVE_LOG,
                SnailBlocks.CRACKED_CHERRY_LOG,
                SnailBlocks.CRACKED_PALE_OAK_LOG,
                SnailBlocks.CRACKED_CRIMSON_STEM,
                SnailBlocks.CRACKED_WARPED_STEM,

                SnailBlocks.DAMAGED_OAK_LOG,
                SnailBlocks.DAMAGED_SPRUCE_LOG,
                SnailBlocks.DAMAGED_BIRCH_LOG,
                SnailBlocks.DAMAGED_JUNGLE_LOG,
                SnailBlocks.DAMAGED_ACACIA_LOG,
                SnailBlocks.DAMAGED_DARK_OAK_LOG,
                SnailBlocks.DAMAGED_MANGROVE_LOG,
                SnailBlocks.DAMAGED_CHERRY_LOG,
                SnailBlocks.DAMAGED_PALE_OAK_LOG,
                SnailBlocks.DAMAGED_CRIMSON_STEM,
                SnailBlocks.DAMAGED_WARPED_STEM
        };
        for (Block axisRotatedBlock : axisRotatedBlocks) {
            blockStateModelGenerator.registerAxisRotated(axisRotatedBlock, ModelIds.getBlockModelId(axisRotatedBlock));
        }

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_SPRUCE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_BIRCH_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_JUNGLE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_ACACIA_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_DARK_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_MANGROVE_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_CHERRY_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_PALE_OAK_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_BAMBOO_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_CRIMSON_PLANKS);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DAMAGED_WARPED_PLANKS);

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TAPPED_SPRUCE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TAPPED_BIRCH_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.TAPPED_PALE_OAK_LOG, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DECAYED_SPRUCE_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DECAYED_BIRCH_LOG, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.DECAYED_PALE_OAK_LOG, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.GRASS_SHEAF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.DRIED_GRASS_SHEAF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.CLAY_BRICK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.DRIED_CLAY_BRICK);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.FIRED_BRICK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.MORTAR);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.CLAY_CRUCIBLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.DRIED_CLAY_CRUCIBLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.CRUCIBLE);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.SCRATCHED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.CRACKED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.FRACTURED_STONE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.CRUMBLED_STONE);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.SCRATCHED_DEEPSLATE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.CRACKED_DEEPSLATE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.FRACTURED_DEEPSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.CRUMBLED_DEEPSLATE);

        blockStateModelGenerator.registerAxisRotated(SnailBlocks.UNTIED_STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.STICK_BUNDLE, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.UNTIED_THATCH_BLOCK, TexturedModel.CUBE_COLUMN);
        blockStateModelGenerator.registerAxisRotated(SnailBlocks.THATCH_BLOCK, TexturedModel.CUBE_COLUMN);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.UNSTEADY_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.UNSTEADY_ROOTED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.UNSTEADY_COARSE_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.UNSTEADY_MUD);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.TIN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DEEPSLATE_TIN_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.GRAPHITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.DEEPSLATE_GRAPHITE_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.STEEL_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(SnailBlocks.TIN_BLOCK);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(SnailBlocks.SAW_TABLE);
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

        itemModelGenerator.register(SnailBlocks.CAMPFIRE_BASE.asItem(), Models.GENERATED);

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
        itemModelGenerator.register(SnailItems.BURNT_BREAD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.GRASS_TWINE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PESTLE, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.BARK_SPUD, Models.HANDHELD);
        itemModelGenerator.register(SnailItems.CLAY_SAND, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PEBBLE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STONE_ROCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STONE_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.SOUL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_DUST, Models.GENERATED);
        itemModelGenerator.register(SnailItems.COPPER_NUGGET, Models.GENERATED);
        itemModelGenerator.register(SnailItems.NETHERITE_NUGGET, Models.GENERATED);

        itemModelGenerator.register(SnailItems.IRON_DUST, Models.GENERATED);
        itemModelGenerator.register(SnailItems.GOLD_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.MOLTEN_COPPER, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_IRON, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_GOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_TIN, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_BRONZE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_STEEL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_NETHERITE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.MOLTEN_COPPER_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_IRON_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_GOLD_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_TIN_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_BRONZE_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_STEEL_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_REDSTONE_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_LAPIS_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_NETHERITE_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_SANDSTONE, Models.GENERATED);

        itemModelGenerator.register(SnailItems.MOLTEN_GLASS, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_STONE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_SMOOTH_STONE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_DEEPSLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_SMOOTH_QUARTZ_BLOCK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.MOLTEN_TERRACOTTA, Models.GENERATED);


        itemModelGenerator.register(SnailItems.FURNACE_LID, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BLANK_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SWORD_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.AXE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PICKAXE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SHOVEL_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.HOE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.INGOT_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PLATE_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BLOCK_CLAY_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BUCKET_CLAY_MOLD, Models.GENERATED);

        itemModelGenerator.register(SnailItems.BLANK_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SWORD_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.AXE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PICKAXE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.SHOVEL_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.HOE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.INGOT_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.PLATE_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BLOCK_GRAPHITE_MOLD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.BUCKET_GRAPHITE_MOLD, Models.GENERATED);

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

        itemModelGenerator.register(SnailItems.OBSIDIAN_SHARD, Models.GENERATED);
        itemModelGenerator.register(SnailItems.OBSIDIAN_KNIFE, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.STONE_KNIFE, Models.HANDHELD);

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

        itemModelGenerator.register(SnailItems.IRON_BOLT, Models.GENERATED);

        itemModelGenerator.register(SnailItems.FORGE_PLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.CIRCULAR_SAW, Models.GENERATED);
        itemModelGenerator.register(SnailItems.LONG_STICK, Models.HANDHELD);

        itemModelGenerator.register(SnailItems.ROUGH_WHITE_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_ORANGE_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_MAGENTA_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_LIGHT_BLUE_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_YELLOW_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_LIME_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_PINK_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_GRAY_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_LIGHT_GRAY_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_CYAN_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_PURPLE_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_BLUE_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_BROWN_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_GREEN_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_RED_WOOL, Models.GENERATED);
        itemModelGenerator.register(SnailItems.ROUGH_BLACK_WOOL, Models.GENERATED);

        itemModelGenerator.register(SnailItems.CONDUIT_SHELL, Models.GENERATED);

        itemModelGenerator.register(SnailItems.TORCH, Models.GENERATED);
        itemModelGenerator.register(SnailItems.FISHING_LINE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.STONE_PLATE, Models.GENERATED);
        itemModelGenerator.register(SnailItems.RAIL_TRACK, Models.GENERATED);

        itemModelGenerator.register(SnailItems.GROUND_NETHERRACK, Models.GENERATED);
        itemModelGenerator.register(SnailItems.HELLSTONE_DUST, Models.GENERATED);

        itemModelGenerator.register(SnailItems.FLOUR, Models.GENERATED);
        itemModelGenerator.register(SnailItems.DOUGH, Models.GENERATED);

        itemModelGenerator.register(SnailItems.AIR, Models.GENERATED);







        itemModelGenerator.register(SnailBlocks.GRASS_SHEAF.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.DRIED_GRASS_SHEAF.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.CLAY_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.DRIED_CLAY_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.FIRED_BRICK.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.CLAY_CRUCIBLE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.DRIED_CLAY_CRUCIBLE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.CRUCIBLE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocks.MORTAR.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocks.BRICK_OVEN_BASE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.BRICK_FURNACE_BASE.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocks.CLAY_MOLD.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.DRIED_CLAY_MOLD.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.FIRED_CLAY_MOLD.asItem(), Models.GENERATED);

        itemModelGenerator.register(SnailBlocks.RESIN_BOWL.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.FILTERING_TRAY_BASE.asItem(), Models.GENERATED);
        itemModelGenerator.register(SnailBlocks.LANTERN.asItem(), Models.GENERATED);
    }
}
