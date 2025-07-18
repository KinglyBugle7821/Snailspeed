package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailLangProvider extends FabricLanguageProvider {
    public SnailLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
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
        translationBuilder.add(SnailItems.BURNT_BREAD, "Burnt Bread");

        translationBuilder.add(SnailItems.FLINT_FLAKE, "Flint Flake");
        translationBuilder.add(SnailItems.FLINT_HATCHET, "Flint Hatchet");
        translationBuilder.add(SnailItems.FLINT_PICKAXE, "Flint Pickaxe");

        translationBuilder.add(SnailItems.GRASS_TWINE, "Grass Twine");
        translationBuilder.add(SnailItems.PESTLE, "Pestle");
        translationBuilder.add(SnailItems.BARK_SPUD, "Bark Spud");
        translationBuilder.add(SnailItems.CLAY_SAND, "Clay Sand");
        translationBuilder.add(SnailItems.PEBBLE, "Pebble");

        translationBuilder.add(SnailItems.STONE_ROCK, "Rock");

        translationBuilder.add(SnailItems.STONE_DUST, "Stone Dust");

        translationBuilder.add(SnailItems.SOUL, "Soul");

        translationBuilder.add(SnailItems.COPPER_DUST, "Copper Dust");
        translationBuilder.add(SnailItems.COPPER_NUGGET, "Copper Nugget");
        translationBuilder.add(SnailItems.NETHERITE_NUGGET, "Netherite Nugget");

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
        translationBuilder.add(SnailItems.BLOCK_CLAY_MOLD, "Block Clay Mold");
        translationBuilder.add(SnailItems.BUCKET_CLAY_MOLD, "Bucket Clay Mold");

        translationBuilder.add(SnailItems.BLANK_GRAPHITE_MOLD, "Blank Graphite Mold");
        translationBuilder.add(SnailItems.SWORD_GRAPHITE_MOLD, "Sword Graphite Mold");
        translationBuilder.add(SnailItems.AXE_GRAPHITE_MOLD, "Axe Graphite Mold");
        translationBuilder.add(SnailItems.PICKAXE_GRAPHITE_MOLD, "Pickaxe Graphite Mold");
        translationBuilder.add(SnailItems.SHOVEL_GRAPHITE_MOLD, "Shovel Graphite Mold");
        translationBuilder.add(SnailItems.HOE_GRAPHITE_MOLD, "Hoe Graphite Mold");
        translationBuilder.add(SnailItems.INGOT_GRAPHITE_MOLD, "Ingot Graphite Mold");
        translationBuilder.add(SnailItems.PLATE_GRAPHITE_MOLD, "Plate Graphite Mold");
        translationBuilder.add(SnailItems.BLOCK_GRAPHITE_MOLD, "Block Graphite Mold");
        translationBuilder.add(SnailItems.BUCKET_GRAPHITE_MOLD, "Bucket Graphite Mold");

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

        translationBuilder.add(SnailItems.OBSIDIAN_SHARD, "Obsidian Shard");
        translationBuilder.add(SnailItems.OBSIDIAN_KNIFE, "Obsidian Knife");

        translationBuilder.add(SnailItems.STONE_KNIFE, "Stone Knife");

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

        translationBuilder.add(SnailItems.IRON_BOLT, "Iron Bolt");

        translationBuilder.add(SnailItems.FORGE_PLATE, "Forge Plate");
        translationBuilder.add(SnailItems.CIRCULAR_SAW, "Circular Saw");
        translationBuilder.add(SnailItems.LONG_STICK, "Long Stick");

        translationBuilder.add(SnailItems.MOLTEN_COPPER, "Molten Copper");
        translationBuilder.add(SnailItems.MOLTEN_IRON, "Molten Iron");
        translationBuilder.add(SnailItems.MOLTEN_GOLD, "Molten Gold");
        translationBuilder.add(SnailItems.MOLTEN_TIN, "Molten Tin");
        translationBuilder.add(SnailItems.MOLTEN_BRONZE, "Molten Bronze");
        translationBuilder.add(SnailItems.MOLTEN_STEEL, "Molten Steel");
        translationBuilder.add(SnailItems.MOLTEN_NETHERITE, "Molten Netherite");
        translationBuilder.add(SnailItems.MOLTEN_COPPER_BLOCK, "Molten Copper Block");
        translationBuilder.add(SnailItems.MOLTEN_IRON_BLOCK, "Molten Iron Block");
        translationBuilder.add(SnailItems.MOLTEN_GOLD_BLOCK, "Molten Gold Block");
        translationBuilder.add(SnailItems.MOLTEN_TIN_BLOCK, "Molten Tin Block");
        translationBuilder.add(SnailItems.MOLTEN_BRONZE_BLOCK, "Molten Bronze Block");
        translationBuilder.add(SnailItems.MOLTEN_STEEL_BLOCK, "Molten Steel Block");
        translationBuilder.add(SnailItems.MOLTEN_REDSTONE_BLOCK, "Molten Redstone Block");
        translationBuilder.add(SnailItems.MOLTEN_LAPIS_BLOCK, "Molten Lapis Block");
        translationBuilder.add(SnailItems.MOLTEN_GLASS, "Molten Glass");
        translationBuilder.add(SnailItems.MOLTEN_STONE, "Molten Stone");
        translationBuilder.add(SnailItems.MOLTEN_SMOOTH_STONE, "Molten Smooth Stone");
        translationBuilder.add(SnailItems.MOLTEN_DEEPSLATE, "Molten Deepslate");
        translationBuilder.add(SnailItems.MOLTEN_SMOOTH_QUARTZ_BLOCK, "Molten Smooth Quartz Block");
        translationBuilder.add(SnailItems.MOLTEN_NETHERITE_BLOCK, "Molten Netherite Block");
        translationBuilder.add(SnailItems.MOLTEN_TERRACOTTA, "Molten Terracotta");
        translationBuilder.add(SnailItems.MOLTEN_SANDSTONE, "Molten Sandstone");

        translationBuilder.add(SnailItems.ROUGH_WHITE_WOOL, "Rough White Wool");
        translationBuilder.add(SnailItems.ROUGH_ORANGE_WOOL, "Rough Orange Wool");
        translationBuilder.add(SnailItems.ROUGH_MAGENTA_WOOL, "Rough Magenta Wool");
        translationBuilder.add(SnailItems.ROUGH_LIGHT_BLUE_WOOL, "Rough Light Blue Wool");
        translationBuilder.add(SnailItems.ROUGH_YELLOW_WOOL, "Rough Yellow Wool");
        translationBuilder.add(SnailItems.ROUGH_LIME_WOOL, "Rough Lime Wool");
        translationBuilder.add(SnailItems.ROUGH_PINK_WOOL, "Rough Pink Wool");
        translationBuilder.add(SnailItems.ROUGH_GRAY_WOOL, "Rough Gray Wool");
        translationBuilder.add(SnailItems.ROUGH_LIGHT_GRAY_WOOL, "Rough Light Gray Wool");
        translationBuilder.add(SnailItems.ROUGH_CYAN_WOOL, "Rough Cyan Wool");
        translationBuilder.add(SnailItems.ROUGH_PURPLE_WOOL, "Rough Purple Wool");
        translationBuilder.add(SnailItems.ROUGH_BLUE_WOOL, "Rough Blue Wool");
        translationBuilder.add(SnailItems.ROUGH_BROWN_WOOL, "Rough Brown Wool");
        translationBuilder.add(SnailItems.ROUGH_GREEN_WOOL, "Rough Green Wool");
        translationBuilder.add(SnailItems.ROUGH_RED_WOOL, "Rough Red Wool");
        translationBuilder.add(SnailItems.ROUGH_BLACK_WOOL, "Rough Black Wool");

        translationBuilder.add(SnailItems.CONDUIT_SHELL, "Conduit Shell");
        translationBuilder.add(SnailItems.FISHING_LINE, "Fishing Line");

        translationBuilder.add(SnailItems.TORCH, "Torch");
        translationBuilder.add(SnailItems.STONE_PLATE, "Stone Plate");
        translationBuilder.add(SnailItems.RAIL_TRACK, "Rail Track");

        translationBuilder.add(SnailItems.GROUND_NETHERRACK, "Ground Netherrack");
        translationBuilder.add(SnailItems.HELLSTONE_DUST, "Hellstone Dust");
        translationBuilder.add(SnailItems.FLOUR, "Flour");
        translationBuilder.add(SnailItems.DOUGH, "Dough");






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
        translationBuilder.add(SnailBlocks.UNSTEADY_MUD, "Unsteady Mud");

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
        translationBuilder.add(SnailBlocks.SMALL_BARREL, "Small Barrel");
        translationBuilder.add(SnailBlocks.SAW_TABLE, "Saw Table");
        translationBuilder.add(SnailBlocks.WEAPON_FORGE, "Weapon Forge");

        translationBuilder.add(SnailBlocks.BRONZE_BLOCK, "Bronze Block");
        translationBuilder.add(SnailBlocks.STEEL_BLOCK, "Steel Block");
        translationBuilder.add(SnailBlocks.TIN_BLOCK, "Tin Block");

        translationBuilder.add(SnailBlocks.LANTERN, "Lantern");
        translationBuilder.add(SnailBlocks.ENCHANTING_TABLE_BASE, "Enchanting Table Base");

        translationBuilder.add("tooltip.snailspeed.item.air", "Please Don't Ask about this (#IHateNetworking)");
        translationBuilder.add("tooltip.snailspeed.item.bark_spud", "Right Click On A Log To Create Tapped Log");
        translationBuilder.add("tooltip.snailspeed.item.burning_tinder", "Used To Light Campfires And Coals On Fire");
        translationBuilder.add("tooltip.snailspeed.item.circular_saw", "Used To Break Wooden Planks/Stone Into Wooden/Stone Slabs");
        translationBuilder.add("tooltip.snailspeed.item.tinder", "Hold Stick On The Offhand And Hold Right Click To Create Burning Tinder");
        translationBuilder.add("tooltip.snailspeed.item.furnace_lid", "A Lid To Cover A Brick Furnace");
        translationBuilder.add("tooltip.snailspeed.item.molten", "Use A Mold To Cast");

        translationBuilder.add("tooltip.snailspeed.block.armor_forge", "Used To Craft Armors");
        translationBuilder.add("tooltip.snailspeed.block.brick_furnace_base", "Right-Click With A Brick To Build A Brick Furnace, Finish It With A Clay Ball");
        translationBuilder.add("tooltip.snailspeed.block.brick_oven_base", "Right-Click With A Brick To Build A Brick Oven, Finish It With A Clay Ball");
        translationBuilder.add("tooltip.snailspeed.block.campfire", "Right-Click With A Stick To Build A Campfire");
        translationBuilder.add("tooltip.snailspeed.block.crucible", "A Crucible To Be Used On A Furnace To Start Smelting");
        translationBuilder.add("tooltip.snailspeed.block.grass_sheaf", "Drying It Might Create A Useful Item...");
        translationBuilder.add("tooltip.snailspeed.block.dried_grass_sheaf", "Leave It Too Long In The Sun Might Start A Fire...");
        translationBuilder.add("tooltip.snailspeed.block.filtering_tray", "Right-Click With A Stick To Build A Filtering Tray");
        translationBuilder.add("tooltip.snailspeed.block.mortar", "Right-Click With A Pestle To Grind Things");
        translationBuilder.add("tooltip.snailspeed.block.resin_bowl", "Place It Behind A Tapped Log To Collect Resin");
        translationBuilder.add("tooltip.snailspeed.block.saw_table", "Used To Craft Wooden Blocks");
        translationBuilder.add("tooltip.snailspeed.block.floating_block", "This Block Can Float");
        translationBuilder.add("tooltip.snailspeed.block.weapon_forge", "Used To Craft Weapons");
        translationBuilder.add("tooltip.snailspeed.block.clay_mold", "Right-Click To Switch Between Different Patterns");

        translationBuilder.add("tooltip.snailspeed.guide.forge_plate_1", "§7Right Click On A Stripped Log To Build An Armor Forge");
        translationBuilder.add("tooltip.snailspeed.guide.forge_plate_2", "§7Right Click On A Log To Build An Weapon Forge");
        translationBuilder.add("tooltip.snailspeed.guide.circular_saw_1", "§7Used To Create Stonecutter by Right Clicking Stone Slab");
        translationBuilder.add("tooltip.snailspeed.guide.circular_saw_2", "§7Used To Create Saw Table by Right Clicking Wooden Slab");
        translationBuilder.add("tooltip.snailspeed.guide.armor_forge_1", "§7Obtained By Right-Clicking A Forge Plate On A Stripped Log");
        translationBuilder.add("tooltip.snailspeed.guide.armor_forge_2", "§7Can Also Be Used To Trim Armors");
        translationBuilder.add("tooltip.snailspeed.guide.dried_grass_sheaf", "§7Obtained By Drying Grass Sheaf In The Sun");
        translationBuilder.add("tooltip.snailspeed.guide.grass_sheaf", "§7Obtained By Breaking Grass With A Flint Flake");
        translationBuilder.add("tooltip.snailspeed.guide.saw_table", "§7Obtained By Right-Clicking Circular Saw On A Wooden Slab");
        translationBuilder.add("tooltip.snailspeed.guide.weapon_forge", "§7Obtained By Right-Clicking A Forge Plate On A Log");
        translationBuilder.add("tooltip.snailspeed.guide.clay_mold_1", "§7Cannot Cast Iron and Steel Material");
        translationBuilder.add("tooltip.snailspeed.guide.clay_mold_2", "§7Will Destroy on Cast");
        translationBuilder.add("tooltip.snailspeed.guide.clay_mold_3", "§7Can Cast With %s");

        translationBuilder.add("tooltip.snailspeed.guide.graphite_mold_1", "§7Can Cast Iron and Steel Material");
        translationBuilder.add("tooltip.snailspeed.guide.graphite_mold_2", "§7Will Not Destroy on Cast");
        translationBuilder.add("tooltip.snailspeed.guide.graphite_mold_3", "§7Can Cast With %s");


        translationBuilder.add("tooltip.snailspeed.guide.clay_blocks", "§7Can Be Dried Under The Sun");
        translationBuilder.add("tooltip.snailspeed.guide.dried_clay_blocks", "§7Can Be Fired Near A Campfire");

        translationBuilder.add("itemgroup.snailspeed", "Snailspeed");
        translationBuilder.add("tooltip.snailspeed.has_shift_down", "§7[SHIFT] For More Info");
    }
}
