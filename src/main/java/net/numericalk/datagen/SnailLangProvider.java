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

        translationBuilder.add(SnailItems.GRASS_TWINE, "Grass Twine");

        translationBuilder.add(SnailBlocks.GRASS_SHEAF, "Grass Sheaf");
        translationBuilder.add(SnailBlocks.DRIED_GRASS_SHEAF, "Dried Grass Sheaf");

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

        translationBuilder.add(SnailBlocks.CAMPFIRE_BASE, "Campfire Base");

        translationBuilder.add("itemgroup.snailspeed", "Snailspeed");
    }
}
