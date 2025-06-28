package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailLangProvider extends FabricLanguageProvider {
    public SnailLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(SnailItems.OAK_LOG_BARK, "Oak Log Bark");
        translationBuilder.add(SnailItems.SPRUCE_LOG_BARK, "Spruce Log Bark");
        translationBuilder.add(SnailItems.BIRCH_LOG_BARK, "Birch Log Bark");
        translationBuilder.add(SnailItems.JUNGLE_LOG_BARK, "Jungle Log Bark");
        translationBuilder.add(SnailItems.ACACIA_LOG_BARK, "Acacia Log Bark");
        translationBuilder.add(SnailItems.DARK_OAK_LOG_BARK, "Dark Oak Log Bark");
        translationBuilder.add(SnailItems.MANGROVE_LOG_BARK, "Mangrove Log Bark");
        translationBuilder.add(SnailItems.CHERRY_LOG_BARK, "Cherry Log Bark");
        translationBuilder.add(SnailItems.PALE_OAK_LOG_BARK, "Pale Oak Log Bark");

        translationBuilder.add(SnailItems.CRIMSON_STEM_BARK, "Crimson Stem Bark");
        translationBuilder.add(SnailItems.WARPED_STEM_BARK, "Warped Stem Bark");

        translationBuilder.add(SnailItems.WOOD_DUST, "Wood Dust");

        translationBuilder.add(SnailItems.TINDER, "Tinder");
        translationBuilder.add(SnailItems.BURNING_TINDER, "Burning Tinder");
        translationBuilder.add(SnailItems.BURNT_TINDER, "Burnt Tinder");

        translationBuilder.add(SnailItems.BURNT_POTATO, "Burnt Potato");
        translationBuilder.add(SnailItems.BURNT_POPPED_CHORUS_FRUIT, "Burnt Chorus Fruit");
        translationBuilder.add(SnailItems.BURNT_CHICKEN, "Burnt Chicken");
        translationBuilder.add(SnailItems.BURNT_COD, "Burnt Cod");
        translationBuilder.add(SnailItems.BURNT_MUTTON, "Burnt Mutton");
        translationBuilder.add(SnailItems.BURNT_PORKCHOP, "Burnt Porkchop");
        translationBuilder.add(SnailItems.BURNT_RABBIT, "Burnt Rabbit");
        translationBuilder.add(SnailItems.BURNT_SALMON, "Burnt Salmon");
        translationBuilder.add(SnailItems.BURNT_KELP, "Burnt Kelp");
        translationBuilder.add(SnailItems.BURNT_BEEF, "Burnt Beef");

        translationBuilder.add(SnailItems.FLINT_FLAKE, "Flint Flake");
        translationBuilder.add(SnailItems.FLINT_HATCHET, "Flint Hatchet");
        translationBuilder.add(SnailItems.FLINT_PICKAXE, "Flint Pickaxe");

        translationBuilder.add(SnailItems.GRASS_TWINE, "Grass Twine");
        translationBuilder.add(SnailItems.PESTLE, "Pestle");
        translationBuilder.add(SnailItems.BARK_SPUD, "Bark Spud");
        translationBuilder.add(SnailItems.CLAY_SAND, "Clay Sand");
        translationBuilder.add(SnailItems.PEBBLE, "Pebble");
        translationBuilder.add(SnailItems.ROCK, "Rock");
        translationBuilder.add(SnailItems.STONE_DUST, "Stone Dust");

        translationBuilder.add(SnailItems.SOUL, "Soul");

        translationBuilder.add(SnailItems.COPPER_DUST, "Copper Dust");
        translationBuilder.add(SnailItems.COPPER_NUGGET, "Copper Nugget");

        translationBuilder.add(SnailItems.IRON_DUST, "Iron Dust");
        translationBuilder.add(SnailItems.GOLD_DUST, "Gold Dust");

        translationBuilder.add(SnailItems.FURNACE_LID, "Furnace Lid");

        translationBuilder.add(SnailItems.BLANK_CLAY_MOLD, "Blank Clay Mold");
        translationBuilder.add(SnailItems.SWORD_CLAY_MOLD, "Sword Clay Mold");
        translationBuilder.add(SnailItems.AXE_CLAY_MOLD, "Axe Clay Mold");
        translationBuilder.add(SnailItems.PICKAXE_CLAY_MOLD, "Pickaxe Clay Mold");
        translationBuilder.add(SnailItems.SHOVEL_CLAY_MOLD, "Shovel Clay Mold");
        translationBuilder.add(SnailItems.HOE_CLAY_MOLD, "Hoe Clay Mold");
        translationBuilder.add(SnailItems.INGOT_CLAY_MOLD, "Ingot Clay Mold");
        translationBuilder.add(SnailItems.PLATE_CLAY_MOLD, "Plate Clay Mold");

        translationBuilder.add(SnailItems.BLANK_GRAPHITE_MOLD, "Blank Graphite Mold");
        translationBuilder.add(SnailItems.SWORD_GRAPHITE_MOLD, "Sword Graphite Mold");
        translationBuilder.add(SnailItems.AXE_GRAPHITE_MOLD, "Axe Graphite Mold");
        translationBuilder.add(SnailItems.PICKAXE_GRAPHITE_MOLD, "Pickaxe Graphite Mold");
        translationBuilder.add(SnailItems.SHOVEL_GRAPHITE_MOLD, "Shovel Graphite Mold");
        translationBuilder.add(SnailItems.HOE_GRAPHITE_MOLD, "Hoe Graphite Mold");
        translationBuilder.add(SnailItems.INGOT_GRAPHITE_MOLD, "Ingot Graphite Mold");
        translationBuilder.add(SnailItems.PLATE_GRAPHITE_MOLD, "Plate Graphite Mold");

        translationBuilder.add(SnailItems.COPPER_SWORD_BLADE, "Copper Sword Blade");
        translationBuilder.add(SnailItems.COPPER_AXE_HEAD, "Copper Axe Head");
        translationBuilder.add(SnailItems.COPPER_PICKAXE_HEAD, "Copper Pickaxe Head");
        translationBuilder.add(SnailItems.COPPER_SHOVEL_HEAD, "Copper Shovel Head");
        translationBuilder.add(SnailItems.COPPER_HOE_HEAD, "Copper Hoe Head");

        translationBuilder.add(SnailItems.IRON_SWORD_BLADE, "Iron Sword Blade");
        translationBuilder.add(SnailItems.IRON_AXE_HEAD, "Iron Axe Head");
        translationBuilder.add(SnailItems.IRON_PICKAXE_HEAD, "Iron Pickaxe Head");
        translationBuilder.add(SnailItems.IRON_SHOVEL_HEAD, "Iron Shovel Head");
        translationBuilder.add(SnailItems.IRON_HOE_HEAD, "Iron Hoe Head");

        translationBuilder.add(SnailItems.GOLDEN_SWORD_BLADE, "Golden Sword Blade");
        translationBuilder.add(SnailItems.GOLDEN_AXE_HEAD, "Golden Axe Head");
        translationBuilder.add(SnailItems.GOLDEN_PICKAXE_HEAD, "Golden Pickaxe Head");
        translationBuilder.add(SnailItems.GOLDEN_SHOVEL_HEAD, "Golden Shovel Head");
        translationBuilder.add(SnailItems.GOLDEN_HOE_HEAD, "Golden Hoe Head");

        translationBuilder.add(SnailItems.BRONZE_SWORD_BLADE, "Bronze Sword Blade");
        translationBuilder.add(SnailItems.BRONZE_AXE_HEAD, "Bronze Axe Head");
        translationBuilder.add(SnailItems.BRONZE_PICKAXE_HEAD, "Bronze Pickaxe Head");
        translationBuilder.add(SnailItems.BRONZE_SHOVEL_HEAD, "Bronze Shovel Head");
        translationBuilder.add(SnailItems.BRONZE_HOE_HEAD, "Bronze Hoe Head");

        translationBuilder.add(SnailItems.STEEL_SWORD_BLADE, "Steel Sword Blade");
        translationBuilder.add(SnailItems.STEEL_AXE_HEAD, "Steel Axe Head");
        translationBuilder.add(SnailItems.STEEL_PICKAXE_HEAD, "Steel Pickaxe Head");
        translationBuilder.add(SnailItems.STEEL_SHOVEL_HEAD, "Steel Shovel Head");
        translationBuilder.add(SnailItems.STEEL_HOE_HEAD, "Steel Hoe Head");

        translationBuilder.add(SnailItems.STEEL_SWORD, "Steel Sword");
        translationBuilder.add(SnailItems.STEEL_AXE, "Steel Axe");
        translationBuilder.add(SnailItems.STEEL_PICKAXE, "Steel Pickaxe");
        translationBuilder.add(SnailItems.STEEL_SHOVEL, "Steel Shovel");
        translationBuilder.add(SnailItems.STEEL_HOE, "Steel Hoe");

        translationBuilder.add(SnailItems.BRONZE_SWORD, "Bronze Sword");
        translationBuilder.add(SnailItems.BRONZE_AXE, "Bronze Axe");
        translationBuilder.add(SnailItems.BRONZE_PICKAXE, "Bronze Pickaxe");
        translationBuilder.add(SnailItems.BRONZE_SHOVEL, "Bronze Shovel");
        translationBuilder.add(SnailItems.BRONZE_HOE, "Bronze Hoe");

        translationBuilder.add(SnailItems.COPPER_SWORD, "Copper Sword");
        translationBuilder.add(SnailItems.COPPER_AXE, "Copper Axe");
        translationBuilder.add(SnailItems.COPPER_PICKAXE, "Copper Pickaxe");
        translationBuilder.add(SnailItems.COPPER_SHOVEL, "Copper Shovel");
        translationBuilder.add(SnailItems.COPPER_HOE, "Copper Hoe");

        translationBuilder.add(SnailItems.RESIN_BALL, "Resin Ball");

        translationBuilder.add(SnailItems.RAW_TIN, "Raw Tin");
        translationBuilder.add(SnailItems.TIN_DUST, "Tin Dust");
        translationBuilder.add(SnailItems.TIN_NUGGET, "Tin Nugget");
        translationBuilder.add(SnailItems.TIN_INGOT, "Tin Ingot");

        translationBuilder.add(SnailItems.RAW_GRAPHITE, "Raw Graphite");
        translationBuilder.add(SnailItems.GROUND_GRAPHITE, "Ground Graphite");
        translationBuilder.add(SnailItems.REFINED_GRAPHITE, "Refined Graphite");

        translationBuilder.add(SnailItems.BRONZE_NUGGET, "Bronze Nugget");
        translationBuilder.add(SnailItems.BRONZE_INGOT, "Bronze Ingot");
        translationBuilder.add(SnailItems.BRONZE_PLATE, "Bronze Plate");

        translationBuilder.add(SnailItems.STEEL_CHUNK, "Steel Chunk");
        translationBuilder.add(SnailItems.STEEL_INGOT, "Steel Ingot");
        translationBuilder.add(SnailItems.STEEL_PLATE, "Steel Plate");

        translationBuilder.add(SnailItems.COPPER_PLATE, "Copper Plate");
        translationBuilder.add(SnailItems.IRON_PLATE, "Iron Plate");
        translationBuilder.add(SnailItems.GOLDEN_PLATE, "Golden Plate");

        translationBuilder.add(SnailItems.FIBER_FILTER, "Fiber Filter");

        translationBuilder.add(SnailItems.COPPER_HELMET, "Copper Helmet");
        translationBuilder.add(SnailItems.COPPER_CHESTPLATE, "Copper Chestplate");
        translationBuilder.add(SnailItems.COPPER_LEGGINGS, "Copper Leggings");
        translationBuilder.add(SnailItems.COPPER_BOOTS, "Copper Boots");

        translationBuilder.add(SnailItems.BRONZE_HELMET, "Bronze Helmet");
        translationBuilder.add(SnailItems.BRONZE_CHESTPLATE, "Bronze Chestplate");
        translationBuilder.add(SnailItems.BRONZE_LEGGINGS, "Bronze Leggings");
        translationBuilder.add(SnailItems.BRONZE_BOOTS, "Bronze Boots");

        translationBuilder.add(SnailItems.STEEL_HELMET, "Steel Helmet");
        translationBuilder.add(SnailItems.STEEL_CHESTPLATE, "Steel Chestplate");
        translationBuilder.add(SnailItems.STEEL_LEGGINGS, "Steel Leggings");
        translationBuilder.add(SnailItems.STEEL_BOOTS, "Steel Boots");

        translationBuilder.add(SnailItems.COPPER_HAMMER, "Copper Hammer");
        translationBuilder.add(SnailItems.IRON_HAMMER, "Iron Hammer");
        translationBuilder.add(SnailItems.STEEL_HAMMER, "Steel Hammer");

        translationBuilder.add(SnailItems.COPPER_RIVET, "Copper Rivet");
        translationBuilder.add(SnailItems.LEATHER_STRIP, "Leather Strip");

        translationBuilder.add(SnailItems.CHAIN_LINKS, "Chain Links");
        translationBuilder.add(SnailItems.IRON_BOLT, "Iron Bolt");

        translationBuilder.add(SnailItems.ARMOR_FORGE_PLATE, "Armor Forge Plate");




        translationBuilder.add(SnailBlocks.GRASS_SHEAF, "Grass Sheaf");
        translationBuilder.add(SnailBlocks.DRIED_GRASS_SHEAF, "Dried Grass Sheaf");
        translationBuilder.add(SnailBlocks.CLAY_BRICK, "Clay Brick");
        translationBuilder.add(SnailBlocks.DRIED_CLAY_BRICK, "Dried Clay Brick");

        translationBuilder.add(SnailBlocks.FIRED_BRICK, "Fired Brick");

        translationBuilder.add(SnailBlocks.MORTAR, "Mortar");

        translationBuilder.add(SnailBlocks.TRIMMED_OAK_LOG, "Trimmed Oak Log");
        translationBuilder.add(SnailBlocks.TRIMMED_SPRUCE_LOG, "Trimmed Spruce Log");
        translationBuilder.add(SnailBlocks.TRIMMED_BIRCH_LOG, "Trimmed Birch Log");
        translationBuilder.add(SnailBlocks.TRIMMED_JUNGLE_LOG, "Trimmed Jungle Log");
        translationBuilder.add(SnailBlocks.TRIMMED_ACACIA_LOG, "Trimmed Acacia Log");
        translationBuilder.add(SnailBlocks.TRIMMED_DARK_OAK_LOG, "Trimmed Dark Oak Log");
        translationBuilder.add(SnailBlocks.TRIMMED_MANGROVE_LOG, "Trimmed Mangrove Log");
        translationBuilder.add(SnailBlocks.TRIMMED_CHERRY_LOG, "Trimmed Cherry Log");
        translationBuilder.add(SnailBlocks.TRIMMED_PALE_OAK_LOG, "Trimmed Pale Oak Log");
        translationBuilder.add(SnailBlocks.TRIMMED_CRIMSON_STEM, "Trimmed Crimson Stem");
        translationBuilder.add(SnailBlocks.TRIMMED_WARPED_STEM, "Trimmed Warped Stem");

        translationBuilder.add(SnailBlocks.CRACKED_OAK_LOG, "Cracked Oak Log");
        translationBuilder.add(SnailBlocks.CRACKED_SPRUCE_LOG, "Cracked Spruce Log");
        translationBuilder.add(SnailBlocks.CRACKED_BIRCH_LOG, "Cracked Birch Log");
        translationBuilder.add(SnailBlocks.CRACKED_JUNGLE_LOG, "Cracked Jungle Log");
        translationBuilder.add(SnailBlocks.CRACKED_ACACIA_LOG, "Cracked Acacia Log");
        translationBuilder.add(SnailBlocks.CRACKED_DARK_OAK_LOG, "Cracked Dark Oak Log");
        translationBuilder.add(SnailBlocks.CRACKED_MANGROVE_LOG, "Cracked Mangrove Log");
        translationBuilder.add(SnailBlocks.CRACKED_CHERRY_LOG, "Cracked Cherry Log");
        translationBuilder.add(SnailBlocks.CRACKED_PALE_OAK_LOG, "Cracked Pale Oak Log");
        translationBuilder.add(SnailBlocks.CRACKED_CRIMSON_STEM, "Cracked Crimson Stem");
        translationBuilder.add(SnailBlocks.CRACKED_WARPED_STEM, "Cracked Warped Stem");

        translationBuilder.add(SnailBlocks.DAMAGED_OAK_LOG, "Damaged Oak Log");
        translationBuilder.add(SnailBlocks.DAMAGED_SPRUCE_LOG, "Damaged Spruce Log");
        translationBuilder.add(SnailBlocks.DAMAGED_BIRCH_LOG, "Damaged Birch Log");
        translationBuilder.add(SnailBlocks.DAMAGED_JUNGLE_LOG, "Damaged Jungle Log");
        translationBuilder.add(SnailBlocks.DAMAGED_ACACIA_LOG, "Damaged Acacia Log");
        translationBuilder.add(SnailBlocks.DAMAGED_DARK_OAK_LOG, "Damaged Dark Oak Log");
        translationBuilder.add(SnailBlocks.DAMAGED_MANGROVE_LOG, "Damaged Mangrove Log");
        translationBuilder.add(SnailBlocks.DAMAGED_CHERRY_LOG, "Damaged Cherry Log");
        translationBuilder.add(SnailBlocks.DAMAGED_PALE_OAK_LOG, "Damaged Pale Oak Log");
        translationBuilder.add(SnailBlocks.DAMAGED_CRIMSON_STEM, "Damaged Crimson Stem");
        translationBuilder.add(SnailBlocks.DAMAGED_WARPED_STEM, "Damaged Warped Stem");

        translationBuilder.add(SnailBlocks.DAMAGED_OAK_PLANKS, "Damaged Oak Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_SPRUCE_PLANKS, "Damaged Spruce Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_BIRCH_PLANKS, "Damaged Birch Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_JUNGLE_PLANKS, "Damaged Jungle Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_ACACIA_PLANKS, "Damaged Acacia Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_DARK_OAK_PLANKS, "Damaged Dark Oak Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_MANGROVE_PLANKS, "Damaged Mangrove Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_CHERRY_PLANKS, "Damaged Cherry Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_PALE_OAK_PLANKS, "Damaged Pale Oak Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_BAMBOO_PLANKS, "Damaged Bamboo Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_CRIMSON_PLANKS, "Damaged Crimson Planks");
        translationBuilder.add(SnailBlocks.DAMAGED_WARPED_PLANKS, "Damaged Warped Planks");

        translationBuilder.add(SnailBlocks.TAPPED_SPRUCE_LOG, "Tapped Spruce Log");
        translationBuilder.add(SnailBlocks.TAPPED_BIRCH_LOG, "Tapped Birch Log");
        translationBuilder.add(SnailBlocks.TAPPED_PALE_OAK_LOG, "Tapped Pale Oak Log");

        translationBuilder.add(SnailBlocks.DECAYED_SPRUCE_LOG, "Decayed Spruce Log");
        translationBuilder.add(SnailBlocks.DECAYED_BIRCH_LOG, "Decayed Birch Log");
        translationBuilder.add(SnailBlocks.DECAYED_PALE_OAK_LOG, "Decayed Pale Oak Log");

        translationBuilder.add(SnailBlocks.CAMPFIRE_BASE, "Campfire Base");
        translationBuilder.add(SnailBlocks.BRICK_OVEN_BASE, "Brick Oven Base");
        translationBuilder.add(SnailBlocks.BRICK_OVEN, "Brick Oven");

        translationBuilder.add(SnailBlocks.BRICK_FURNACE_BASE, "Brick Furnace Base");
        translationBuilder.add(SnailBlocks.BRICK_FURNACE, "Brick Furnace");
        translationBuilder.add(SnailBlocks.CLAY_CRUCIBLE, "Clay Crucible");
        translationBuilder.add(SnailBlocks.DRIED_CLAY_CRUCIBLE, "Dried Clay Crucible");
        translationBuilder.add(SnailBlocks.CRUCIBLE, "Crucible");

        translationBuilder.add(SnailBlocks.SCRATCHED_STONE, "Scratched Stone");
        translationBuilder.add(SnailBlocks.CRACKED_STONE, "Cracked Stone");
        translationBuilder.add(SnailBlocks.FRACTURED_STONE, "Fractured Stone");
        translationBuilder.add(SnailBlocks.CRUMBLED_STONE, "Crumbled Stone");
        translationBuilder.add(SnailBlocks.SCRATCHED_DEEPSLATE, "Scratched Deepslate");
        translationBuilder.add(SnailBlocks.CRACKED_DEEPSLATE, "Cracked Deepslate");
        translationBuilder.add(SnailBlocks.FRACTURED_DEEPSLATE, "Fractured Deepslate");
        translationBuilder.add(SnailBlocks.CRUMBLED_DEEPSLATE, "Crumbled Deepslate");

        translationBuilder.add(SnailBlocks.UNTIED_STICK_BUNDLE, "Untied Stick Bundle");
        translationBuilder.add(SnailBlocks.STICK_BUNDLE, "Stick Bundle");
        translationBuilder.add(SnailBlocks.UNTIED_THATCH_BLOCK, "Untied Thatch Block");
        translationBuilder.add(SnailBlocks.THATCH_BLOCK, "Thatch Block");

        translationBuilder.add(SnailBlocks.UNSTEADY_DIRT, "Unsteady Dirt");
        translationBuilder.add(SnailBlocks.UNSTEADY_ROOTED_DIRT, "Unsteady Rooted Dirt");
        translationBuilder.add(SnailBlocks.UNSTEADY_COARSE_DIRT, "Unsteady Coarse Dirt");

        translationBuilder.add(SnailBlocks.CLAY_MOLD, "Clay Mold");
        translationBuilder.add(SnailBlocks.DRIED_CLAY_MOLD, "Dried Clay Mold");
        translationBuilder.add(SnailBlocks.FIRED_CLAY_MOLD, "Fired Clay Mold");

        translationBuilder.add(SnailBlocks.RESIN_BOWL, "Resin Bowl");
        translationBuilder.add(SnailBlocks.FILTERING_TRAY, "Filtering Tray");
        translationBuilder.add(SnailBlocks.FILTERING_TRAY_BASE, "Filtering Tray Base");

        translationBuilder.add(SnailBlocks.TIN_ORE, "Tin Ore");
        translationBuilder.add(SnailBlocks.DEEPSLATE_TIN_ORE, "Deepslate Tin Ore");
        translationBuilder.add(SnailBlocks.GRAPHITE_ORE, "Graphite Ore");
        translationBuilder.add(SnailBlocks.DEEPSLATE_GRAPHITE_ORE, "Deepslate Graphite Ore");

        translationBuilder.add(SnailBlocks.ARMOR_FORGE, "Armor Forge");

        translationBuilder.add("itemgroup.snailspeed", "snailspeed");
    }
}
