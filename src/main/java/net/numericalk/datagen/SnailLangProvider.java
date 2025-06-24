package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

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
        translationBuilder.add(SnailBlocks.UNSTEADY_COARSE_DIRT, "Unsteady Coarse Dirt");

        translationBuilder.add(SnailBlocks.CLAY_MOLD, "Clay Mold");
        translationBuilder.add(SnailBlocks.DRIED_CLAY_MOLD, "Dried Clay Mold");
        translationBuilder.add(SnailBlocks.FIRED_CLAY_MOLD, "Fired Clay Mold");

        translationBuilder.add("itemgroup.snailspeed", "Snailspeed");
    }
}
