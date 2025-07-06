package net.numericalk.snailspeed.items;

import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.custom.*;
import net.numericalk.snailspeed.utils.SnailArmorMaterial;
import net.numericalk.snailspeed.utils.SnailToolMaterial;

import java.util.function.BiFunction;
import java.util.function.Function;

public class SnailItems {

    public static final Item OAK_LOG_BARK = register("oak_log_bark", Item::new);
    public static final Item SPRUCE_LOG_BARK = register("spruce_log_bark", Item::new);
    public static final Item BIRCH_LOG_BARK = register("birch_log_bark", Item::new);
    public static final Item JUNGLE_LOG_BARK = register("jungle_log_bark", Item::new);
    public static final Item ACACIA_LOG_BARK = register("acacia_log_bark", Item::new);
    public static final Item DARK_OAK_LOG_BARK = register("dark_oak_log_bark", Item::new);
    public static final Item MANGROVE_LOG_BARK = register("mangrove_log_bark", Item::new);
    public static final Item CHERRY_LOG_BARK = register("cherry_log_bark", Item::new);
    public static final Item PALE_OAK_LOG_BARK = register("pale_oak_log_bark", Item::new);

    public static final Item CRIMSON_STEM_BARK = register("crimson_stem_bark", Item::new);
    public static final Item WARPED_STEM_BARK = register("warped_stem_bark", Item::new);

    public static final Item WOOD_DUST = register("wood_dust", Item::new);

    public static final Item FLINT_FLAKE = register("flint_flake", settings -> new AxeItem(SnailToolMaterial.FLINT_MATERIAL, -1f, -2.0f, settings));
    public static final Item FLINT_HATCHET = register("flint_hatchet", settings -> new AxeItem(SnailToolMaterial.FLINT_TOOL_MATERIAL, 1f, -3.2f, settings));
    public static final Item FLINT_PICKAXE = register("flint_pickaxe", settings -> new PickaxeItem(SnailToolMaterial.FLINT_TOOL_MATERIAL, 0f, -2.8f, settings));

    public static final Item TINDER = register("tinder", settings -> new TinderItem(settings.maxCount(1)));
    public static final Item BURNING_TINDER = register("burning_tinder", settings -> new BurningTinderItem(settings.maxCount(1)));
    public static final Item BURNT_TINDER = register("burnt_tinder", Item::new);

    public static final Item BURNT_POTATO = register("burnt_potato", Item::new);
    public static final Item BURNT_POPPED_CHORUS_FRUIT = register("burnt_popped_chorus_fruit", Item::new);
    public static final Item BURNT_CHICKEN = register("burnt_chicken", Item::new);
    public static final Item BURNT_COD = register("burnt_cod", Item::new);
    public static final Item BURNT_MUTTON = register("burnt_mutton", Item::new);
    public static final Item BURNT_PORKCHOP = register("burnt_porkchop", Item::new);
    public static final Item BURNT_RABBIT = register("burnt_rabbit", Item::new);
    public static final Item BURNT_SALMON = register("burnt_salmon", Item::new);
    public static final Item BURNT_KELP = register("burnt_kelp", Item::new);
    public static final Item BURNT_BEEF = register("burnt_beef", Item::new);

    public static final Item GRASS_TWINE = register("grass_twine", Item::new);
    public static final Item PESTLE = register("pestle", settings -> new Item(settings.maxCount(1)));

    public static final Item CLAY_SAND = register("clay_sand", Item::new);

    public static final Item PEBBLE = register("pebble", Item::new);
    public static final Item ROCK = register("rock", Item::new);
    public static final Item STONE_DUST = register("stone_dust", Item::new);

    public static final Item SOUL = register("soul", Item::new);

    public static final Item COPPER_DUST = register("copper_dust", Item::new);
    public static final Item COPPER_NUGGET = register("copper_nugget", Item::new);
    public static final Item IRON_DUST = register("iron_dust", Item::new);
    public static final Item GOLD_DUST = register("gold_dust", Item::new);

    public static final Item MOLTEN_COPPER = register("molten_copper", MoltenItem::new);
    public static final Item MOLTEN_IRON = register("molten_iron", MoltenItem::new);
    public static final Item MOLTEN_GOLD = register("molten_gold", MoltenItem::new);
    public static final Item MOLTEN_TIN = register("molten_tin", MoltenItem::new);
    public static final Item MOLTEN_BRONZE = register("molten_bronze", MoltenItem::new);
    public static final Item MOLTEN_STEEL = register("molten_steel", MoltenItem::new);

    public static final Item MOLTEN_COPPER_BLOCK = register("molten_copper_block", MoltenItem::new);
    public static final Item MOLTEN_IRON_BLOCK = register("molten_iron_block", MoltenItem::new);
    public static final Item MOLTEN_GOLD_BLOCK = register("molten_gold_block", MoltenItem::new);
    public static final Item MOLTEN_TIN_BLOCK = register("molten_tin_block", MoltenItem::new);
    public static final Item MOLTEN_BRONZE_BLOCK = register("molten_bronze_block", MoltenItem::new);
    public static final Item MOLTEN_STEEL_BLOCK = register("molten_steel_block", MoltenItem::new);

    public static final Item MOLTEN_GLASS = register("molten_glass", MoltenItem::new);
    public static final Item MOLTEN_STONE = register("molten_stone", MoltenItem::new);
    public static final Item MOLTEN_SMOOTH_STONE = register("molten_smooth_stone", MoltenItem::new);
    public static final Item MOLTEN_DEEPSLATE = register("molten_deepslate", MoltenItem::new);

    public static final Item FURNACE_LID = register("furnace_lid", FurnaceLidItem::new);



    public static final Item BLANK_CLAY_MOLD = register("blank_clay_mold", Item::new);
    public static final Item SWORD_CLAY_MOLD = register("sword_clay_mold", Item::new);
    public static final Item AXE_CLAY_MOLD = register("axe_clay_mold", Item::new);
    public static final Item PICKAXE_CLAY_MOLD = register("pickaxe_clay_mold", Item::new);
    public static final Item SHOVEL_CLAY_MOLD = register("shovel_clay_mold", Item::new);
    public static final Item HOE_CLAY_MOLD = register("hoe_clay_mold", Item::new);
    public static final Item INGOT_CLAY_MOLD = register("ingot_clay_mold", Item::new);
    public static final Item PLATE_CLAY_MOLD = register("plate_clay_mold", Item::new);
    public static final Item BLOCK_CLAY_MOLD = register("block_clay_mold", Item::new);
    public static final Item BUCKET_CLAY_MOLD = register("bucket_clay_mold", Item::new);

    public static final Item BLANK_GRAPHITE_MOLD = register("blank_graphite_mold", Item::new);
    public static final Item SWORD_GRAPHITE_MOLD = register("sword_graphite_mold", Item::new);
    public static final Item AXE_GRAPHITE_MOLD = register("axe_graphite_mold", Item::new);
    public static final Item PICKAXE_GRAPHITE_MOLD = register("pickaxe_graphite_mold", Item::new);
    public static final Item SHOVEL_GRAPHITE_MOLD = register("shovel_graphite_mold", Item::new);
    public static final Item HOE_GRAPHITE_MOLD = register("hoe_graphite_mold", Item::new);
    public static final Item INGOT_GRAPHITE_MOLD = register("ingot_graphite_mold", Item::new);
    public static final Item PLATE_GRAPHITE_MOLD = register("plate_graphite_mold", Item::new);
    public static final Item BLOCK_GRAPHITE_MOLD = register("block_graphite_mold", Item::new);
    public static final Item BUCKET_GRAPHITE_MOLD = register("bucket_graphite_mold", Item::new);

    public static final Item COPPER_SWORD_BLADE = register("copper_sword_blade", Item::new);
    public static final Item COPPER_AXE_HEAD = register("copper_axe_head", Item::new);
    public static final Item COPPER_PICKAXE_HEAD = register("copper_pickaxe_head", Item::new);
    public static final Item COPPER_SHOVEL_HEAD = register("copper_shovel_head", Item::new);
    public static final Item COPPER_HOE_HEAD = register("copper_hoe_head", Item::new);

    public static final Item IRON_SWORD_BLADE = register("iron_sword_blade", Item::new);
    public static final Item IRON_AXE_HEAD = register("iron_axe_head", Item::new);
    public static final Item IRON_PICKAXE_HEAD = register("iron_pickaxe_head", Item::new);
    public static final Item IRON_SHOVEL_HEAD = register("iron_shovel_head", Item::new);
    public static final Item IRON_HOE_HEAD = register("iron_hoe_head", Item::new);

    public static final Item GOLDEN_SWORD_BLADE = register("golden_sword_blade", Item::new);
    public static final Item GOLDEN_AXE_HEAD = register("golden_axe_head", Item::new);
    public static final Item GOLDEN_PICKAXE_HEAD = register("golden_pickaxe_head", Item::new);
    public static final Item GOLDEN_SHOVEL_HEAD = register("golden_shovel_head", Item::new);
    public static final Item GOLDEN_HOE_HEAD = register("golden_hoe_head", Item::new);

    public static final Item BRONZE_SWORD_BLADE = register("bronze_sword_blade", Item::new);
    public static final Item BRONZE_AXE_HEAD = register("bronze_axe_head", Item::new);
    public static final Item BRONZE_PICKAXE_HEAD = register("bronze_pickaxe_head", Item::new);
    public static final Item BRONZE_SHOVEL_HEAD = register("bronze_shovel_head", Item::new);
    public static final Item BRONZE_HOE_HEAD = register("bronze_hoe_head", Item::new);

    public static final Item STEEL_SWORD_BLADE = register("steel_sword_blade", Item::new);
    public static final Item STEEL_AXE_HEAD = register("steel_axe_head", Item::new);
    public static final Item STEEL_PICKAXE_HEAD = register("steel_pickaxe_head", Item::new);
    public static final Item STEEL_SHOVEL_HEAD = register("steel_shovel_head", Item::new);
    public static final Item STEEL_HOE_HEAD = register("steel_hoe_head", Item::new);

    public static final Item COPPER_SWORD = register("copper_sword", settings -> new SwordItem(SnailToolMaterial.COPPER_TOOL_MATERIAL, 1f, -2.4f, settings));
    public static final Item COPPER_AXE = register("copper_axe", settings -> new AxeItem(SnailToolMaterial.COPPER_TOOL_MATERIAL, 2.5f, -3.3f, settings));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", settings -> new PickaxeItem(SnailToolMaterial.COPPER_TOOL_MATERIAL, -1f, -2.8f, settings));
    public static final Item COPPER_SHOVEL = register("copper_shovel", settings -> new ShovelItem(SnailToolMaterial.COPPER_TOOL_MATERIAL, 0f, -3f, settings));
    public static final Item COPPER_HOE = register("copper_hoe", settings -> new HoeItem(SnailToolMaterial.COPPER_TOOL_MATERIAL, -2f, -2.5f, settings));

    public static final Item BRONZE_SWORD = register("bronze_sword", settings -> new SwordItem(SnailToolMaterial.BRONZE_TOOL_MATERIAL, 1f, -2.4f, settings));
    public static final Item BRONZE_AXE = register("bronze_axe", settings -> new AxeItem(SnailToolMaterial.BRONZE_TOOL_MATERIAL, 2.5f, -3.3f, settings));
    public static final Item BRONZE_PICKAXE = register("bronze_pickaxe", settings -> new PickaxeItem(SnailToolMaterial.BRONZE_TOOL_MATERIAL, -1f, -2.8f, settings));
    public static final Item BRONZE_SHOVEL = register("bronze_shovel", settings -> new ShovelItem(SnailToolMaterial.BRONZE_TOOL_MATERIAL, 0f, -3f, settings));
    public static final Item BRONZE_HOE = register("bronze_hoe", settings -> new HoeItem(SnailToolMaterial.BRONZE_TOOL_MATERIAL, -2f, -2.5f, settings));

    public static final Item STEEL_SWORD = register("steel_sword", settings -> new SwordItem(SnailToolMaterial.STEEL_TOOL_MATERIAL, 3f, -2.4f, settings));
    public static final Item STEEL_AXE = register("steel_axe", settings -> new AxeItem(SnailToolMaterial.STEEL_TOOL_MATERIAL, 5f, -3.0f, settings));
    public static final Item STEEL_PICKAXE = register("steel_pickaxe", settings -> new PickaxeItem(SnailToolMaterial.STEEL_TOOL_MATERIAL, 1f, -2.8f, settings));
    public static final Item STEEL_SHOVEL = register("steel_shovel", settings -> new ShovelItem(SnailToolMaterial.STEEL_TOOL_MATERIAL, 1.5f, -3f, settings));
    public static final Item STEEL_HOE = register("steel_hoe", settings -> new HoeItem(SnailToolMaterial.STEEL_TOOL_MATERIAL, -3f, 0f, settings));

    public static final Item RESIN_BALL = register("resin_ball", Item::new);

    public static final Item RAW_TIN = register("raw_tin", Item::new);
    public static final Item TIN_DUST = register("tin_dust", Item::new);
    public static final Item TIN_NUGGET = register("tin_nugget", Item::new);
    public static final Item TIN_INGOT = register("tin_ingot", Item::new);

    public static final Item RAW_GRAPHITE = register("raw_graphite", Item::new);
    public static final Item GROUND_GRAPHITE = register("ground_graphite", Item::new);
    public static final Item REFINED_GRAPHITE = register("refined_graphite", Item::new);

    public static final Item BRONZE_NUGGET = register("bronze_nugget", Item::new);
    public static final Item BRONZE_INGOT = register("bronze_ingot", Item::new);
    public static final Item BRONZE_PLATE = register("bronze_plate", Item::new);

    public static final Item STEEL_CHUNK = register("steel_chunk", Item::new);
    public static final Item STEEL_INGOT = register("steel_ingot", Item::new);
    public static final Item STEEL_PLATE = register("steel_plate", Item::new);

    public static final Item FIBER_FILTER = register("fiber_filter", Item::new);

    public static final Item COPPER_PLATE = register("copper_plate", Item::new);
    public static final Item IRON_PLATE = register("iron_plate", Item::new);
    public static final Item GOLDEN_PLATE = register("golden_plate", Item::new);

    public static final Item BARK_SPUD = register("bark_spud", settings -> new BarkSpudItem(settings.maxCount(1).maxDamage(24)));

    public static final Item COPPER_HELMET = register("copper_helmet", settings -> new ArmorItem(SnailArmorMaterial.COPPER_ARMOR, EquipmentType.HELMET, settings));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", settings -> new ArmorItem(SnailArmorMaterial.COPPER_ARMOR, EquipmentType.CHESTPLATE, settings));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", settings -> new ArmorItem(SnailArmorMaterial.COPPER_ARMOR, EquipmentType.LEGGINGS, settings));
    public static final Item COPPER_BOOTS = register("copper_boots", settings -> new ArmorItem(SnailArmorMaterial.COPPER_ARMOR, EquipmentType.BOOTS, settings));

    public static final Item BRONZE_HELMET = register("bronze_helmet", settings -> new ArmorItem(SnailArmorMaterial.BRONZE_ARMOR, EquipmentType.HELMET, settings));
    public static final Item BRONZE_CHESTPLATE = register("bronze_chestplate", settings -> new ArmorItem(SnailArmorMaterial.BRONZE_ARMOR, EquipmentType.CHESTPLATE, settings));
    public static final Item BRONZE_LEGGINGS = register("bronze_leggings", settings -> new ArmorItem(SnailArmorMaterial.BRONZE_ARMOR, EquipmentType.LEGGINGS, settings));
    public static final Item BRONZE_BOOTS = register("bronze_boots", settings -> new ArmorItem(SnailArmorMaterial.BRONZE_ARMOR, EquipmentType.BOOTS, settings));

    public static final Item STEEL_HELMET = register("steel_helmet", settings -> new ArmorItem(SnailArmorMaterial.STEEL_ARMOR, EquipmentType.HELMET, settings));
    public static final Item STEEL_CHESTPLATE = register("steel_chestplate", settings -> new ArmorItem(SnailArmorMaterial.STEEL_ARMOR, EquipmentType.CHESTPLATE, settings));
    public static final Item STEEL_LEGGINGS = register("steel_leggings", settings -> new ArmorItem(SnailArmorMaterial.STEEL_ARMOR, EquipmentType.LEGGINGS, settings));
    public static final Item STEEL_BOOTS = register("steel_boots", settings -> new ArmorItem(SnailArmorMaterial.STEEL_ARMOR, EquipmentType.BOOTS, settings));

    public static final Item COPPER_HAMMER = register("copper_hammer", settings -> new Item(settings.maxCount(1).maxDamage(67)));
    public static final Item IRON_HAMMER = register("iron_hammer", settings -> new Item(settings.maxCount(1).maxDamage(250)));
    public static final Item STEEL_HAMMER = register("steel_hammer", settings -> new Item(settings.maxCount(1).maxDamage(1561)));

    public static final Item COPPER_RIVET = register("copper_rivet", Item::new);
    public static final Item LEATHER_STRIP = register("leather_strip", Item::new);

    public static final Item CHAIN_LINKS = register("chain_links", Item::new);
    public static final Item IRON_BOLT = register("iron_bolt", Item::new);

    public static final Item FORGE_PLATE = register("forge_plate", ForgePlateBaseItem::new);
    public static final Item CIRCULAR_SAW = register("circular_saw", settings -> new CircularSawItem(settings.maxCount(1).maxDamage(250)));
    public static final Item LONG_STICK = register("long_stick", Item::new);

    public static final Item ROUGH_WHITE_WOOL = register("rough_white_wool", Item::new);
    public static final Item ROUGH_ORANGE_WOOL = register("rough_orange_wool", Item::new);
    public static final Item ROUGH_MAGENTA_WOOL = register("rough_magenta_wool", Item::new);
    public static final Item ROUGH_LIGHT_BLUE_WOOL = register("rough_light_blue_wool", Item::new);
    public static final Item ROUGH_YELLOW_WOOL = register("rough_yellow_wool", Item::new);
    public static final Item ROUGH_LIME_WOOL = register("rough_lime_wool", Item::new);
    public static final Item ROUGH_PINK_WOOL = register("rough_pink_wool", Item::new);
    public static final Item ROUGH_GRAY_WOOL = register("rough_gray_wool", Item::new);
    public static final Item ROUGH_LIGHT_GRAY_WOOL = register("rough_light_gray_wool", Item::new);
    public static final Item ROUGH_CYAN_WOOL = register("rough_cyan_wool", Item::new);
    public static final Item ROUGH_PURPLE_WOOL = register("rough_purple_wool", Item::new);
    public static final Item ROUGH_BLUE_WOOL = register("rough_blue_wool", Item::new);
    public static final Item ROUGH_BROWN_WOOL = register("rough_brown_wool", Item::new);
    public static final Item ROUGH_GREEN_WOOL = register("rough_green_wool", Item::new);
    public static final Item ROUGH_RED_WOOL = register("rough_red_wool", Item::new);
    public static final Item ROUGH_BLACK_WOOL = register("rough_black_wool", Item::new);

    public static final Item FISHING_LINE = register("fishing_ling", Item::new);

    public static final Item BRONZE_BLOCK = SnailBlocks.BRONZE_BLOCK.asItem();
    public static final Item STEEL_BLOCK = SnailBlocks.STEEL_BLOCK.asItem();
    public static final Item TIN_BLOCK = SnailBlocks.TIN_BLOCK.asItem();

    public static final Item TORCH = register(
            SnailBlocks.TORCH,
            ((block, settings) -> new VerticallyAttachableBlockItem(block, SnailBlocks.WALL_TORCH, Direction.DOWN, settings))
    );

    public static final Item CONDUIT_SHELL = register("conduit_shell", Item::new);

    public static final Item AIR = register("air", AirItem::new);

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return register(block, factory, new Item.Settings());
    }
    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register1(
                keyOf(block.getRegistryEntry().registryKey()), itemSettings -> factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey()
        );
    }
    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }
    private static Item register(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Snailspeed.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, name)))));
    }
    public static Item register1(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }
    public static void initialize() {
    }
}
