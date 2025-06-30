package net.numericalk.snailspeed.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocksBrain;

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

                        entries.add(SnailBlocksBrain.CAMPFIRE_BASE);
                        entries.add(SnailBlocksBrain.BRICK_OVEN_BASE);
                        entries.add(SnailBlocksBrain.BRICK_OVEN);

                        entries.add(SnailBlocksBrain.BRICK_FURNACE_BASE);
                        entries.add(SnailBlocksBrain.BRICK_FURNACE);
                        entries.add(SnailBlocksBrain.CLAY_CRUCIBLE);
                        entries.add(SnailBlocksBrain.DRIED_CLAY_CRUCIBLE);
                        entries.add(SnailBlocksBrain.CRUCIBLE);

                        entries.add(SnailBlocksBrain.GRASS_SHEAF);
                        entries.add(SnailBlocksBrain.DRIED_GRASS_SHEAF);
                        entries.add(SnailBlocksBrain.CLAY_BRICK);
                        entries.add(SnailBlocksBrain.DRIED_CLAY_BRICK);

                        entries.add(SnailBlocksBrain.FIRED_BRICK);
                        entries.add(SnailBlocksBrain.MORTAR);

                        entries.add(SnailBlocksBrain.UNTIED_STICK_BUNDLE);
                        entries.add(SnailBlocksBrain.STICK_BUNDLE);
                        entries.add(SnailBlocksBrain.UNTIED_THATCH_BLOCK);
                        entries.add(SnailBlocksBrain.THATCH_BLOCK);

                        entries.add(SnailBlocksBrain.UNSTEADY_DIRT);
                        entries.add(SnailBlocksBrain.UNSTEADY_COARSE_DIRT);

                        entries.add(SnailBlocksBrain.SCRATCHED_STONE);
                        entries.add(SnailBlocksBrain.CRACKED_STONE);
                        entries.add(SnailBlocksBrain.FRACTURED_STONE);
                        entries.add(SnailBlocksBrain.CRUMBLED_STONE);
                        entries.add(SnailBlocksBrain.SCRATCHED_DEEPSLATE);
                        entries.add(SnailBlocksBrain.CRACKED_DEEPSLATE);
                        entries.add(SnailBlocksBrain.FRACTURED_DEEPSLATE);
                        entries.add(SnailBlocksBrain.CRUMBLED_DEEPSLATE);

                        entries.add(SnailBlocksBrain.RESIN_BOWL);
                        entries.add(SnailBlocksBrain.FILTERING_TRAY_BASE);
                        entries.add(SnailBlocksBrain.FILTERING_TRAY);

                        entries.add(SnailBlocksBrain.TAPPED_SPRUCE_LOG);
                        entries.add(SnailBlocksBrain.TAPPED_BIRCH_LOG);
                        entries.add(SnailBlocksBrain.TAPPED_PALE_OAK_LOG);

                        entries.add(SnailBlocksBrain.DECAYED_SPRUCE_LOG);
                        entries.add(SnailBlocksBrain.DECAYED_BIRCH_LOG);
                        entries.add(SnailBlocksBrain.DECAYED_PALE_OAK_LOG);

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
                        entries.add(SnailItems.ROCK);

                        entries.add(SnailItems.SOUL);

                        entries.add(SnailItems.CLAY_SAND);

                        entries.add(SnailItems.COPPER_DUST);
                        entries.add(SnailItems.COPPER_NUGGET);

                        entries.add(SnailItems.IRON_DUST);
                        entries.add(SnailItems.GOLD_DUST);

                        entries.add(SnailItems.FURNACE_LID);

                        entries.add(SnailItems.RESIN_BALL);

                        entries.add(SnailBlocksBrain.CLAY_MOLD);
                        entries.add(SnailBlocksBrain.DRIED_CLAY_MOLD);
                        entries.add(SnailBlocksBrain.FIRED_CLAY_MOLD);

                        entries.add(SnailItems.BLANK_CLAY_MOLD);
                        entries.add(SnailItems.SWORD_CLAY_MOLD);
                        entries.add(SnailItems.AXE_CLAY_MOLD);
                        entries.add(SnailItems.PICKAXE_CLAY_MOLD);
                        entries.add(SnailItems.SHOVEL_CLAY_MOLD);
                        entries.add(SnailItems.HOE_CLAY_MOLD);
                        entries.add(SnailItems.INGOT_CLAY_MOLD);
                        entries.add(SnailItems.PLATE_CLAY_MOLD);

                        entries.add(SnailItems.BLANK_GRAPHITE_MOLD);
                        entries.add(SnailItems.SWORD_GRAPHITE_MOLD);
                        entries.add(SnailItems.AXE_GRAPHITE_MOLD);
                        entries.add(SnailItems.PICKAXE_GRAPHITE_MOLD);
                        entries.add(SnailItems.SHOVEL_GRAPHITE_MOLD);
                        entries.add(SnailItems.HOE_GRAPHITE_MOLD);
                        entries.add(SnailItems.INGOT_GRAPHITE_MOLD);
                        entries.add(SnailItems.PLATE_GRAPHITE_MOLD);

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

                        entries.add(SnailBlocksBrain.TIN_ORE);
                        entries.add(SnailBlocksBrain.DEEPSLATE_TIN_ORE);
                        entries.add(SnailItems.RAW_TIN);
                        entries.add(SnailItems.TIN_DUST);
                        entries.add(SnailItems.TIN_NUGGET);
                        entries.add(SnailItems.TIN_INGOT);

                        entries.add(SnailBlocksBrain.GRAPHITE_ORE);
                        entries.add(SnailBlocksBrain.DEEPSLATE_GRAPHITE_ORE);
                        entries.add(SnailItems.RAW_GRAPHITE);
                        entries.add(SnailItems.GROUND_GRAPHITE);
                        entries.add(SnailItems.REFINED_GRAPHITE);

                        entries.add(SnailItems.BRONZE_NUGGET);
                        entries.add(SnailItems.BRONZE_INGOT);
                        entries.add(SnailItems.BRONZE_PLATE);

                        entries.add(SnailItems.STEEL_CHUNK);
                        entries.add(SnailItems.STEEL_INGOT);
                        entries.add(SnailItems.STEEL_PLATE);

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

                        entries.add(SnailItems.CHAIN_LINKS);
                        entries.add(SnailItems.IRON_BOLT);

                        entries.add(SnailItems.ARMOR_FORGE_PLATE);
                        entries.add(SnailBlocksBrain.ARMOR_FORGE);
                        entries.add(SnailBlocksBrain.SMALL_BARREL);
                        entries.add(SnailBlocksBrain.SAW_TABLE);

                    }).build());
    public static void initialize() {}


}
