package net.numericalk.snailspeed.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;

public class SnailItemGroup {
    public static final ItemGroup SNAILSPEED_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Snailspeed.MOD_ID, "snailspeed_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(SnailItems.OAK_LOG_BARK))
                    .displayName(Text.translatable("itemgroup.snailspeed"))
                    .entries((displayContext, entries) -> {
                        entries.add(SnailItems.OAK_LOG_BARK);
                        entries.add(SnailItems.SPRUCE_LOG_BARK);
                        entries.add(SnailItems.BIRCH_LOG_BARK);
                        entries.add(SnailItems.JUNGLE_LOG_BARK);
                        entries.add(SnailItems.ACACIA_LOG_BARK);
                        entries.add(SnailItems.DARK_OAK_LOG_BARK);
                        entries.add(SnailItems.MANGROVE_LOG_BARK);
                        entries.add(SnailItems.CHERRY_LOG_BARK);
                        entries.add(SnailItems.PALE_OAK_LOG_BARK);
                        entries.add(SnailItems.CRIMSON_STEM_BARK);
                        entries.add(SnailItems.WARPED_STEM_BARK);

                        entries.add(SnailItems.WOOD_DUST);
                        entries.add(SnailItems.FLINT_HATCHET);
                        entries.add(SnailItems.FLINT_PICKAXE);

                        entries.add(SnailItems.FLINT_FLAKE);

                        entries.add(SnailItems.FIBER_FILTER);

                        entries.add(SnailBlocks.CAMPFIRE_BASE);
                        entries.add(SnailBlocks.BRICK_OVEN_BASE);
                        entries.add(SnailBlocks.BRICK_OVEN);

                        entries.add(SnailBlocks.BRICK_FURNACE_BASE);
                        entries.add(SnailBlocks.BRICK_FURNACE);
                        entries.add(SnailBlocks.CLAY_CRUCIBLE);
                        entries.add(SnailBlocks.DRIED_CLAY_CRUCIBLE);
                        entries.add(SnailBlocks.CRUCIBLE);

                        entries.add(SnailBlocks.GRASS_SHEAF);
                        entries.add(SnailBlocks.DRIED_GRASS_SHEAF);
                        entries.add(SnailBlocks.CLAY_BRICK);
                        entries.add(SnailBlocks.DRIED_CLAY_BRICK);

                        entries.add(SnailBlocks.FIRED_BRICK);
                        entries.add(SnailBlocks.MORTAR);

                        entries.add(SnailBlocks.UNTIED_STICK_BUNDLE);
                        entries.add(SnailBlocks.STICK_BUNDLE);
                        entries.add(SnailBlocks.UNTIED_THATCH_BLOCK);
                        entries.add(SnailBlocks.THATCH_BLOCK);

                        entries.add(SnailBlocks.UNSTEADY_DIRT);
                        entries.add(SnailBlocks.UNSTEADY_COARSE_DIRT);

                        entries.add(SnailBlocks.SCRATCHED_STONE);
                        entries.add(SnailBlocks.CRACKED_STONE);
                        entries.add(SnailBlocks.FRACTURED_STONE);
                        entries.add(SnailBlocks.CRUMBLED_STONE);
                        entries.add(SnailBlocks.SCRATCHED_DEEPSLATE);
                        entries.add(SnailBlocks.CRACKED_DEEPSLATE);
                        entries.add(SnailBlocks.FRACTURED_DEEPSLATE);
                        entries.add(SnailBlocks.CRUMBLED_DEEPSLATE);

                        entries.add(SnailBlocks.RESIN_BOWL);
                        entries.add(SnailBlocks.FILTERING_TRAY_BASE);
                        entries.add(SnailBlocks.FILTERING_TRAY);

                        entries.add(SnailBlocks.TAPPED_SPRUCE_LOG);
                        entries.add(SnailBlocks.TAPPED_BIRCH_LOG);
                        entries.add(SnailBlocks.TAPPED_PALE_OAK_LOG);

                        entries.add(SnailBlocks.DECAYED_SPRUCE_LOG);
                        entries.add(SnailBlocks.DECAYED_BIRCH_LOG);
                        entries.add(SnailBlocks.DECAYED_PALE_OAK_LOG);

                        entries.add(SnailItems.TINDER);
                        entries.add(SnailItems.BURNING_TINDER);
                        entries.add(SnailItems.BURNT_TINDER);

                        entries.add(SnailItems.BURNT_POTATO);
                        entries.add(SnailItems.BURNT_POPPED_CHORUS_FRUIT);
                        entries.add(SnailItems.BURNT_CHICKEN);
                        entries.add(SnailItems.BURNT_COD);
                        entries.add(SnailItems.BURNT_MUTTON);
                        entries.add(SnailItems.BURNT_PORKCHOP);
                        entries.add(SnailItems.BURNT_RABBIT);
                        entries.add(SnailItems.BURNT_SALMON);
                        entries.add(SnailItems.BURNT_KELP);
                        entries.add(SnailItems.BURNT_BEEF);

                        entries.add(SnailItems.GRASS_TWINE);
                        entries.add(SnailItems.PESTLE);
                        entries.add(SnailItems.BARK_SPUD);
                        entries.add(SnailItems.PEBBLE);
                        entries.add(SnailItems.STONE_ROCK);

                        entries.add(SnailItems.SOUL);

                        entries.add(SnailItems.CLAY_SAND);

                        entries.add(SnailItems.COPPER_DUST);
                        entries.add(SnailItems.COPPER_NUGGET);
                        entries.add(SnailItems.NETHERITE_NUGGET);

                        entries.add(SnailItems.IRON_DUST);
                        entries.add(SnailItems.GOLD_DUST);

                        entries.add(SnailItems.FURNACE_LID);

                        entries.add(SnailItems.RESIN_BALL);

                        entries.add(SnailBlocks.CLAY_MOLD);
                        entries.add(SnailBlocks.DRIED_CLAY_MOLD);
                        entries.add(SnailBlocks.FIRED_CLAY_MOLD);

                        entries.add(SnailItems.BLANK_CLAY_MOLD);
                        entries.add(SnailItems.SWORD_CLAY_MOLD);
                        entries.add(SnailItems.AXE_CLAY_MOLD);
                        entries.add(SnailItems.PICKAXE_CLAY_MOLD);
                        entries.add(SnailItems.SHOVEL_CLAY_MOLD);
                        entries.add(SnailItems.HOE_CLAY_MOLD);
                        entries.add(SnailItems.INGOT_CLAY_MOLD);
                        entries.add(SnailItems.PLATE_CLAY_MOLD);
                        entries.add(SnailItems.BLOCK_CLAY_MOLD);
                        entries.add(SnailItems.BUCKET_CLAY_MOLD);

                        entries.add(SnailItems.BLANK_GRAPHITE_MOLD);
                        entries.add(SnailItems.SWORD_GRAPHITE_MOLD);
                        entries.add(SnailItems.AXE_GRAPHITE_MOLD);
                        entries.add(SnailItems.PICKAXE_GRAPHITE_MOLD);
                        entries.add(SnailItems.SHOVEL_GRAPHITE_MOLD);
                        entries.add(SnailItems.HOE_GRAPHITE_MOLD);
                        entries.add(SnailItems.INGOT_GRAPHITE_MOLD);
                        entries.add(SnailItems.PLATE_GRAPHITE_MOLD);
                        entries.add(SnailItems.BUCKET_GRAPHITE_MOLD);

                        entries.add(SnailItems.COPPER_SWORD_BLADE);
                        entries.add(SnailItems.COPPER_AXE_HEAD);
                        entries.add(SnailItems.COPPER_PICKAXE_HEAD);
                        entries.add(SnailItems.COPPER_SHOVEL_HEAD);
                        entries.add(SnailItems.COPPER_HOE_HEAD);

                        entries.add(SnailItems.IRON_SWORD_BLADE);
                        entries.add(SnailItems.IRON_AXE_HEAD);
                        entries.add(SnailItems.IRON_PICKAXE_HEAD);
                        entries.add(SnailItems.IRON_SHOVEL_HEAD);
                        entries.add(SnailItems.IRON_HOE_HEAD);

                        entries.add(SnailItems.GOLDEN_SWORD_BLADE);
                        entries.add(SnailItems.GOLDEN_AXE_HEAD);
                        entries.add(SnailItems.GOLDEN_PICKAXE_HEAD);
                        entries.add(SnailItems.GOLDEN_SHOVEL_HEAD);
                        entries.add(SnailItems.GOLDEN_HOE_HEAD);

                        entries.add(SnailItems.BRONZE_SWORD_BLADE);
                        entries.add(SnailItems.BRONZE_AXE_HEAD);
                        entries.add(SnailItems.BRONZE_PICKAXE_HEAD);
                        entries.add(SnailItems.BRONZE_SHOVEL_HEAD);
                        entries.add(SnailItems.BRONZE_HOE_HEAD);

                        entries.add(SnailItems.STEEL_SWORD_BLADE);
                        entries.add(SnailItems.STEEL_AXE_HEAD);
                        entries.add(SnailItems.STEEL_PICKAXE_HEAD);
                        entries.add(SnailItems.STEEL_SHOVEL_HEAD);
                        entries.add(SnailItems.STEEL_HOE_HEAD);

                        entries.add(SnailItems.COPPER_SWORD);
                        entries.add(SnailItems.COPPER_AXE);
                        entries.add(SnailItems.COPPER_PICKAXE);
                        entries.add(SnailItems.COPPER_SHOVEL);
                        entries.add(SnailItems.COPPER_HOE);

                        entries.add(SnailItems.BRONZE_SWORD);
                        entries.add(SnailItems.BRONZE_AXE);
                        entries.add(SnailItems.BRONZE_PICKAXE);
                        entries.add(SnailItems.BRONZE_SHOVEL);
                        entries.add(SnailItems.BRONZE_HOE);

                        entries.add(SnailItems.STEEL_SWORD);
                        entries.add(SnailItems.STEEL_AXE);
                        entries.add(SnailItems.STEEL_PICKAXE);
                        entries.add(SnailItems.STEEL_SHOVEL);
                        entries.add(SnailItems.STEEL_HOE);

                        entries.add(SnailItems.OBSIDIAN_SHARD);
                        entries.add(SnailItems.OBSIDIAN_KNIFE);

                        entries.add(SnailBlocks.TIN_ORE);
                        entries.add(SnailBlocks.DEEPSLATE_TIN_ORE);
                        entries.add(SnailItems.RAW_TIN);
                        entries.add(SnailItems.TIN_DUST);
                        entries.add(SnailItems.TIN_NUGGET);
                        entries.add(SnailItems.TIN_INGOT);
                        entries.add(SnailItems.TIN_BLOCK);

                        entries.add(SnailBlocks.GRAPHITE_ORE);
                        entries.add(SnailBlocks.DEEPSLATE_GRAPHITE_ORE);
                        entries.add(SnailItems.RAW_GRAPHITE);
                        entries.add(SnailItems.GROUND_GRAPHITE);
                        entries.add(SnailItems.REFINED_GRAPHITE);

                        entries.add(SnailItems.BRONZE_NUGGET);
                        entries.add(SnailItems.BRONZE_INGOT);
                        entries.add(SnailItems.BRONZE_PLATE);
                        entries.add(SnailItems.BRONZE_BLOCK);

                        entries.add(SnailItems.STEEL_CHUNK);
                        entries.add(SnailItems.STEEL_INGOT);
                        entries.add(SnailItems.STEEL_PLATE);
                        entries.add(SnailItems.STEEL_BLOCK);

                        entries.add(SnailItems.COPPER_PLATE);
                        entries.add(SnailItems.IRON_PLATE);
                        entries.add(SnailItems.GOLDEN_PLATE);

                        entries.add(SnailItems.COPPER_HELMET);
                        entries.add(SnailItems.COPPER_CHESTPLATE);
                        entries.add(SnailItems.COPPER_LEGGINGS);
                        entries.add(SnailItems.COPPER_BOOTS);

                        entries.add(SnailItems.BRONZE_HELMET);
                        entries.add(SnailItems.BRONZE_CHESTPLATE);
                        entries.add(SnailItems.BRONZE_LEGGINGS);
                        entries.add(SnailItems.BRONZE_BOOTS);

                        entries.add(SnailItems.STEEL_HELMET);
                        entries.add(SnailItems.STEEL_CHESTPLATE);
                        entries.add(SnailItems.STEEL_LEGGINGS);
                        entries.add(SnailItems.STEEL_BOOTS);

                        entries.add(SnailItems.COPPER_HAMMER);
                        entries.add(SnailItems.IRON_HAMMER);
                        entries.add(SnailItems.STEEL_HAMMER);

                        entries.add(SnailItems.COPPER_RIVET);
                        entries.add(SnailItems.LEATHER_STRIP);

                        entries.add(SnailItems.IRON_BOLT);
                        entries.add(SnailItems.LONG_STICK);
                        entries.add(SnailItems.CIRCULAR_SAW);

                        entries.add(SnailItems.FORGE_PLATE);
                        entries.add(SnailBlocks.ARMOR_FORGE);
                        entries.add(SnailBlocks.WEAPON_FORGE);
                        entries.add(SnailBlocks.SMALL_BARREL);
                        entries.add(SnailBlocks.SAW_TABLE);

                        entries.add(SnailItems.ROUGH_WHITE_WOOL);
                        entries.add(SnailItems.ROUGH_ORANGE_WOOL);
                        entries.add(SnailItems.ROUGH_MAGENTA_WOOL);
                        entries.add(SnailItems.ROUGH_LIGHT_BLUE_WOOL);
                        entries.add(SnailItems.ROUGH_YELLOW_WOOL);
                        entries.add(SnailItems.ROUGH_LIME_WOOL);
                        entries.add(SnailItems.ROUGH_PINK_WOOL);
                        entries.add(SnailItems.ROUGH_GRAY_WOOL);
                        entries.add(SnailItems.ROUGH_LIGHT_GRAY_WOOL);
                        entries.add(SnailItems.ROUGH_CYAN_WOOL);
                        entries.add(SnailItems.ROUGH_PURPLE_WOOL);
                        entries.add(SnailItems.ROUGH_BLUE_WOOL);
                        entries.add(SnailItems.ROUGH_BROWN_WOOL);
                        entries.add(SnailItems.ROUGH_GREEN_WOOL);
                        entries.add(SnailItems.ROUGH_RED_WOOL);
                        entries.add(SnailItems.ROUGH_BLACK_WOOL);

                        entries.add(SnailItems.CONDUIT_SHELL);

                        entries.add(SnailItems.TORCH);
                        entries.add(SnailBlocks.LANTERN);

                        entries.add(SnailItems.STONE_PLATE);
                        entries.add(SnailBlocks.ENCHANTING_TABLE_BASE);

                        entries.add(SnailItems.GROUND_NETHERRACK);
                        entries.add(SnailItems.HELLSTONE_DUST);

                        entries.add(SnailItems.FLOUR);
                        entries.add(SnailItems.DOUGH);
                    }).build());

    public static void initialize() {
        
    }
}
