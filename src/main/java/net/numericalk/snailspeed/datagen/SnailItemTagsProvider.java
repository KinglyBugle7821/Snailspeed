package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailItemTagsProvider extends FabricTagProvider<Item> {
    public SnailItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> FLINT_FLAKE_REPAIRABLE = of("flint_flake_repairable");
    public static final TagKey<Item> COPPER_TOOL_REPAIRABLE = of("copper_tool_repairable");
    public static final TagKey<Item> BRONZE_TOOL_REPAIRABLE = of("copper_tool_repairable");
    public static final TagKey<Item> STEEL_TOOL_REPAIRABLE = of("steel_tool_repairable");
    public static final TagKey<Item> CAMPFIRE_FUEL = of("campfire_fuel");
    public static final TagKey<Item> LOG_BARKS = of("log_barks");
    public static final TagKey<Item> LOG_BARKS_THAT_BURN = of("log_barks_that_burn");
    public static final TagKey<Item> STRING = of("string");
    public static final TagKey<Item> OVEN_FUEL = of("oven_fuel");
    public static final TagKey<Item> MOLTEN_ITEMS = of("molten_items");
    public static final TagKey<Item> HIGH_MOLTEN_ITEMS = of("high_molten_items");
    public static final TagKey<Item> CLAY_MOLD = of("clay_mold");
    public static final TagKey<Item> GRAPHITE_MOLD = of("graphite_mold");
    public static final TagKey<Item> MOLD = of("mold");
    public static final TagKey<Item> GLUES = of("glues");

    public static final TagKey<Item> RAW_FOOD = of("raw_food");

    public static final TagKey<Item> PLATES = of("plates");
    public static final TagKey<Item> BINDERS = of("binders");
    public static final TagKey<Item> FASTENERS = of("fasteners");
    public static final TagKey<Item> HAMMERS = of("hammers");

    public static final TagKey<Item> TRIM_TEMPLATES = of("trim_templates");

    public static final TagKey<Item> FILTERS = of("filters");
    public static final TagKey<Item> GLASS = of("glass");
    public static final TagKey<Item> GLASS_PANES = of("glass_panes");

    public static final TagKey<Item> WOODEN_TOOLS = of("wooden_tools");
    public static final TagKey<Item> STONE_TOOLS = of("stone_tools");
    public static final TagKey<Item> IRON_TOOLS = of("iron_tools");
    public static final TagKey<Item> DIAMOND_TOOLS = of("diamond_tools");
    public static final TagKey<Item> NETHERITE_TOOLS = of("netherite_tools");

    private static TagKey<Item> of(String name) {
        return TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, name));
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(SnailItems.COPPER_HELMET)
                .add(SnailItems.COPPER_CHESTPLATE)
                .add(SnailItems.COPPER_LEGGINGS)
                .add(SnailItems.COPPER_BOOTS)
                .add(SnailItems.BRONZE_HELMET)
                .add(SnailItems.BRONZE_CHESTPLATE)
                .add(SnailItems.BRONZE_LEGGINGS)
                .add(SnailItems.BRONZE_BOOTS)
                .add(SnailItems.STEEL_HELMET)
                .add(SnailItems.STEEL_CHESTPLATE)
                .add(SnailItems.STEEL_LEGGINGS)
                .add(SnailItems.STEEL_BOOTS);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(SnailItems.COPPER_HELMET)
                .add(SnailItems.BRONZE_HELMET)
                .add(SnailItems.STEEL_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(SnailItems.COPPER_CHESTPLATE)
                .add(SnailItems.BRONZE_CHESTPLATE)
                .add(SnailItems.STEEL_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(SnailItems.COPPER_LEGGINGS)
                .add(SnailItems.BRONZE_LEGGINGS)
                .add(SnailItems.STEEL_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(SnailItems.COPPER_BOOTS)
                .add(SnailItems.BRONZE_BOOTS)
                .add(SnailItems.STEEL_BOOTS);
        getOrCreateTagBuilder(TRIM_TEMPLATES)
                .add(Items.BOLT_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.COAST_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.DUNE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.EYE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.FLOW_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.HOST_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.RAISER_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.RIB_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.SENTRY_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.SHAPER_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.SILENCE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.SNOUT_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.SPIRE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.TIDE_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.VEX_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.WARD_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.WAYFINDER_ARMOR_TRIM_SMITHING_TEMPLATE)
                .add(Items.WILD_ARMOR_TRIM_SMITHING_TEMPLATE);
        getOrCreateTagBuilder(RAW_FOOD)
                .add(Items.BEEF)
                .add(Items.CHICKEN)
                .add(Items.COD)
                .add(Items.KELP)
                .add(Items.MUTTON)
                .add(Items.PORKCHOP)
                .add(Items.POTATO)
                .add(Items.RABBIT)
                .add(Items.SALMON);
        getOrCreateTagBuilder(GLASS_PANES)
                .add(Items.GLASS_PANE)
                .add(Items.WHITE_STAINED_GLASS_PANE)
                .add(Items.ORANGE_STAINED_GLASS_PANE)
                .add(Items.MAGENTA_STAINED_GLASS_PANE)
                .add(Items.LIGHT_BLUE_STAINED_GLASS_PANE)
                .add(Items.YELLOW_STAINED_GLASS_PANE)
                .add(Items.LIME_STAINED_GLASS_PANE)
                .add(Items.PINK_STAINED_GLASS_PANE)
                .add(Items.GRAY_STAINED_GLASS_PANE)
                .add(Items.LIGHT_GRAY_STAINED_GLASS_PANE)
                .add(Items.CYAN_STAINED_GLASS_PANE)
                .add(Items.PURPLE_STAINED_GLASS_PANE)
                .add(Items.BLUE_STAINED_GLASS_PANE)
                .add(Items.BROWN_STAINED_GLASS_PANE)
                .add(Items.GREEN_STAINED_GLASS_PANE)
                .add(Items.RED_STAINED_GLASS_PANE)
                .add(Items.BLACK_STAINED_GLASS_PANE);
        getOrCreateTagBuilder(GLASS)
                .add(Items.GLASS)
                .add(Items.WHITE_STAINED_GLASS)
                .add(Items.ORANGE_STAINED_GLASS)
                .add(Items.MAGENTA_STAINED_GLASS)
                .add(Items.LIGHT_BLUE_STAINED_GLASS)
                .add(Items.YELLOW_STAINED_GLASS)
                .add(Items.LIME_STAINED_GLASS)
                .add(Items.PINK_STAINED_GLASS)
                .add(Items.GRAY_STAINED_GLASS)
                .add(Items.LIGHT_GRAY_STAINED_GLASS)
                .add(Items.CYAN_STAINED_GLASS)
                .add(Items.PURPLE_STAINED_GLASS)
                .add(Items.BLUE_STAINED_GLASS)
                .add(Items.BROWN_STAINED_GLASS)
                .add(Items.GREEN_STAINED_GLASS)
                .add(Items.RED_STAINED_GLASS)
                .add(Items.BLACK_STAINED_GLASS);
        getOrCreateTagBuilder(HAMMERS)
                .add(SnailItems.COPPER_HAMMER)
                .add(SnailItems.IRON_HAMMER)
                .add(SnailItems.STEEL_HAMMER);
        getOrCreateTagBuilder(FASTENERS)
                .add(SnailItems.COPPER_RIVET)
                .add(SnailItems.IRON_BOLT);
        getOrCreateTagBuilder(BINDERS)
                .add(SnailItems.LEATHER_STRIP)
                .add(Items.CHAIN);
        getOrCreateTagBuilder(PLATES)
                .add(SnailItems.BRONZE_PLATE)
                .add(SnailItems.GOLDEN_PLATE)
                .add(SnailItems.COPPER_PLATE)
                .add(SnailItems.IRON_PLATE)
                .add(SnailItems.STEEL_PLATE);
        getOrCreateTagBuilder(FILTERS)
                .add(SnailItems.FIBER_FILTER);
        getOrCreateTagBuilder(GLUES)
                .add(Items.SLIME_BALL)
                .add(SnailItems.RESIN_BALL);
        getOrCreateTagBuilder(CLAY_MOLD)
                .add(SnailItems.BLANK_CLAY_MOLD)
                .add(SnailItems.SWORD_CLAY_MOLD)
                .add(SnailItems.AXE_CLAY_MOLD)
                .add(SnailItems.PICKAXE_CLAY_MOLD)
                .add(SnailItems.SHOVEL_CLAY_MOLD)
                .add(SnailItems.HOE_CLAY_MOLD)
                .add(SnailItems.INGOT_CLAY_MOLD)
                .add(SnailItems.PLATE_CLAY_MOLD)
                .add(SnailItems.BLOCK_CLAY_MOLD)
                .add(SnailItems.BUCKET_CLAY_MOLD);
        getOrCreateTagBuilder(GRAPHITE_MOLD)
                .add(SnailItems.BLANK_GRAPHITE_MOLD)
                .add(SnailItems.SWORD_GRAPHITE_MOLD)
                .add(SnailItems.AXE_GRAPHITE_MOLD)
                .add(SnailItems.PICKAXE_GRAPHITE_MOLD)
                .add(SnailItems.SHOVEL_GRAPHITE_MOLD)
                .add(SnailItems.HOE_GRAPHITE_MOLD)
                .add(SnailItems.INGOT_GRAPHITE_MOLD)
                .add(SnailItems.PLATE_GRAPHITE_MOLD)
                .add(SnailItems.BLOCK_GRAPHITE_MOLD)
                .add(SnailItems.BUCKET_GRAPHITE_MOLD);
        getOrCreateTagBuilder(MOLD)
                .add(SnailItems.BLANK_CLAY_MOLD)
                .add(SnailItems.SWORD_CLAY_MOLD)
                .add(SnailItems.AXE_CLAY_MOLD)
                .add(SnailItems.PICKAXE_CLAY_MOLD)
                .add(SnailItems.SHOVEL_CLAY_MOLD)
                .add(SnailItems.HOE_CLAY_MOLD)
                .add(SnailItems.INGOT_CLAY_MOLD)
                .add(SnailItems.PLATE_CLAY_MOLD)
                .add(SnailItems.BLOCK_CLAY_MOLD)
                .add(SnailItems.BUCKET_CLAY_MOLD)
                .add(SnailItems.BLANK_GRAPHITE_MOLD)
                .add(SnailItems.SWORD_GRAPHITE_MOLD)
                .add(SnailItems.AXE_GRAPHITE_MOLD)
                .add(SnailItems.PICKAXE_GRAPHITE_MOLD)
                .add(SnailItems.SHOVEL_GRAPHITE_MOLD)
                .add(SnailItems.HOE_GRAPHITE_MOLD)
                .add(SnailItems.INGOT_GRAPHITE_MOLD)
                .add(SnailItems.PLATE_GRAPHITE_MOLD)
                .add(SnailItems.BLOCK_GRAPHITE_MOLD)
                .add(SnailItems.BUCKET_GRAPHITE_MOLD);
        getOrCreateTagBuilder(MOLTEN_ITEMS)
                .add(SnailItems.MOLTEN_COPPER)
                .add(SnailItems.MOLTEN_IRON)
                .add(SnailItems.MOLTEN_GOLD)
                .add(SnailItems.MOLTEN_TIN)
                .add(SnailItems.MOLTEN_BRONZE)
                .add(SnailItems.MOLTEN_STEEL)
                .add(SnailItems.MOLTEN_NETHERITE)
                .add(SnailItems.MOLTEN_COPPER_BLOCK)
                .add(SnailItems.MOLTEN_IRON_BLOCK)
                .add(SnailItems.MOLTEN_GOLD_BLOCK)
                .add(SnailItems.MOLTEN_TIN_BLOCK)
                .add(SnailItems.MOLTEN_BRONZE_BLOCK)
                .add(SnailItems.MOLTEN_STEEL_BLOCK)
                .add(SnailItems.MOLTEN_REDSTONE_BLOCK)
                .add(SnailItems.MOLTEN_LAPIS_BLOCK)
                .add(SnailItems.MOLTEN_GLASS)
                .add(SnailItems.MOLTEN_STONE)
                .add(SnailItems.MOLTEN_SMOOTH_STONE)
                .add(SnailItems.MOLTEN_DEEPSLATE)
                .add(SnailItems.MOLTEN_SMOOTH_QUARTZ_BLOCK)
                .add(SnailItems.MOLTEN_NETHERITE_BLOCK);
        getOrCreateTagBuilder(HIGH_MOLTEN_ITEMS)
                .add(SnailItems.MOLTEN_IRON)
                .add(SnailItems.MOLTEN_STEEL)
                .add(SnailItems.MOLTEN_IRON_BLOCK)
                .add(SnailItems.MOLTEN_STEEL_BLOCK);
        getOrCreateTagBuilder(OVEN_FUEL)
                .add(Items.CHARCOAL)
                .add(Items.COAL);
        getOrCreateTagBuilder(STRING)
                .add(Items.STRING)
                .add(SnailItems.GRASS_TWINE);
        getOrCreateTagBuilder(STEEL_TOOL_REPAIRABLE)
                .add(SnailItems.STEEL_INGOT);
        getOrCreateTagBuilder(COPPER_TOOL_REPAIRABLE)
                .add(Items.COPPER_INGOT);
        getOrCreateTagBuilder(FLINT_FLAKE_REPAIRABLE)
                .add(Items.FLINT);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(SnailItems.FLINT_FLAKE)
                .add(SnailItems.FLINT_HATCHET)

                .add(SnailItems.COPPER_AXE)
                .add(SnailItems.BRONZE_AXE)
                .add(SnailItems.STEEL_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(SnailItems.FLINT_PICKAXE)

                .add(SnailItems.COPPER_PICKAXE)
                .add(SnailItems.BRONZE_PICKAXE)
                .add(SnailItems.STEEL_PICKAXE);
        getOrCreateTagBuilder(WOODEN_TOOLS)
                .add(SnailItems.FLINT_FLAKE)
                .add(SnailItems.FLINT_HATCHET)
                .add(SnailItems.FLINT_PICKAXE)
                .add(Items.WOODEN_SWORD)
                .add(Items.GOLDEN_SWORD)
                .add(Items.WOODEN_AXE)
                .add(Items.GOLDEN_AXE)
                .add(Items.WOODEN_PICKAXE)
                .add(Items.GOLDEN_PICKAXE)
                .add(Items.WOODEN_SHOVEL)
                .add(Items.GOLDEN_SHOVEL)
                .add(Items.WOODEN_HOE)
                .add(Items.GOLDEN_HOE);
        getOrCreateTagBuilder(STONE_TOOLS)
                .add(SnailItems.BRONZE_SWORD)
                .add(SnailItems.BRONZE_AXE)
                .add(SnailItems.BRONZE_PICKAXE)
                .add(SnailItems.BRONZE_SHOVEL)
                .add(SnailItems.BRONZE_HOE)
                .add(SnailItems.COPPER_SWORD)
                .add(SnailItems.COPPER_AXE)
                .add(SnailItems.COPPER_PICKAXE)
                .add(SnailItems.COPPER_SHOVEL)
                .add(SnailItems.COPPER_HOE)
                .add(Items.STONE_SWORD)
                .add(Items.STONE_AXE)
                .add(Items.STONE_PICKAXE)
                .add(Items.STONE_SHOVEL)
                .add(Items.STONE_HOE);
        getOrCreateTagBuilder(IRON_TOOLS)
                .add(Items.IRON_SWORD)
                .add(Items.IRON_AXE)
                .add(Items.IRON_PICKAXE)
                .add(Items.IRON_SHOVEL)
                .add(Items.IRON_HOE);
        getOrCreateTagBuilder(DIAMOND_TOOLS)
                .add(Items.DIAMOND_SWORD)
                .add(Items.DIAMOND_AXE)
                .add(Items.DIAMOND_PICKAXE)
                .add(Items.DIAMOND_SHOVEL)
                .add(Items.DIAMOND_HOE)
                .add(SnailItems.STEEL_SWORD)
                .add(SnailItems.STEEL_AXE)
                .add(SnailItems.STEEL_PICKAXE)
                .add(SnailItems.STEEL_SHOVEL)
                .add(SnailItems.STEEL_HOE);
        getOrCreateTagBuilder(NETHERITE_TOOLS)
                .add(Items.NETHERITE_SWORD)
                .add(Items.NETHERITE_AXE)
                .add(Items.NETHERITE_PICKAXE)
                .add(Items.NETHERITE_SHOVEL)
                .add(Items.NETHERITE_HOE);
        getOrCreateTagBuilder(CAMPFIRE_FUEL)
                .add(Items.STICK)
                .add(SnailItems.OAK_LOG_BARK)
                .add(SnailItems.SPRUCE_LOG_BARK)
                .add(SnailItems.BIRCH_LOG_BARK)
                .add(SnailItems.JUNGLE_LOG_BARK)
                .add(SnailItems.ACACIA_LOG_BARK)
                .add(SnailItems.DARK_OAK_LOG_BARK)
                .add(SnailItems.MANGROVE_LOG_BARK)
                .add(SnailItems.CHERRY_LOG_BARK)
                .add(SnailItems.PALE_OAK_LOG_BARK)
                .add(SnailItems.CRIMSON_STEM_BARK)
                .add(SnailItems.WARPED_STEM_BARK)
                .add(SnailItems.WOOD_DUST)
                .add(SnailBlocks.DRIED_GRASS_SHEAF.asItem());
        getOrCreateTagBuilder(LOG_BARKS)
                .add(SnailItems.OAK_LOG_BARK)
                .add(SnailItems.SPRUCE_LOG_BARK)
                .add(SnailItems.BIRCH_LOG_BARK)
                .add(SnailItems.JUNGLE_LOG_BARK)
                .add(SnailItems.ACACIA_LOG_BARK)
                .add(SnailItems.DARK_OAK_LOG_BARK)
                .add(SnailItems.MANGROVE_LOG_BARK)
                .add(SnailItems.CHERRY_LOG_BARK)
                .add(SnailItems.PALE_OAK_LOG_BARK)
                .add(SnailItems.CRIMSON_STEM_BARK)
                .add(SnailItems.WARPED_STEM_BARK);
        getOrCreateTagBuilder(LOG_BARKS_THAT_BURN)
                .add(SnailItems.OAK_LOG_BARK)
                .add(SnailItems.SPRUCE_LOG_BARK)
                .add(SnailItems.BIRCH_LOG_BARK)
                .add(SnailItems.JUNGLE_LOG_BARK)
                .add(SnailItems.ACACIA_LOG_BARK)
                .add(SnailItems.DARK_OAK_LOG_BARK)
                .add(SnailItems.MANGROVE_LOG_BARK)
                .add(SnailItems.CHERRY_LOG_BARK)
                .add(SnailItems.PALE_OAK_LOG_BARK);
    }
}
