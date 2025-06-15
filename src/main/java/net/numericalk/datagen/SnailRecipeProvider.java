package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailRecipeProvider extends FabricRecipeProvider {
    public SnailRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            final Object[] logBark = {
                    SnailItems.OAK_LOG_BARK,
                    SnailItems.SPRUCE_LOG_BARK,
                    SnailItems.BIRCH_LOG_BARK,
                    SnailItems.JUNGLE_LOG_BARK,
                    SnailItems.ACACIA_LOG_BARK,
                    SnailItems.DARK_OAK_LOG_BARK,
                    SnailItems.MANGROVE_LOG_BARK,
                    SnailItems.CHERRY_LOG_BARK,
                    SnailItems.PALE_OAK_LOG_BARK,
                    SnailItems.CRIMSON_STEM_BARK,
                    SnailItems.WARPED_STEM_BARK
            };

            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                for (Object entry : logBark) {
                    Item bark = (Item) entry;
                    String idPath = Registries.ITEM.getId(bark).getPath(); // e.g., "oak_log_bark"

                    createShaped(RecipeCategory.MISC, SnailBlocks.CAMPFIRE_BASE, 1)
                            .pattern("bb")
                            .pattern("bb")
                            .input('b', SnailItemTagsProvider.LOG_BARKS_THAT_BURN)
                            .group("multi_bench")
                            .criterion(hasItem(bark), conditionsFromItem(bark))
                            .offerTo(exporter, String.valueOf(Identifier.of("snailspeed", "campfire_base_from_" + idPath)));
                }
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.TINDER)
                        .input(SnailItemTagsProvider.LOG_BARKS_THAT_BURN)
                        .input(SnailItems.WOOD_DUST)
                        .criterion(hasItem(SnailItems.WOOD_DUST), conditionsFromItem(SnailItems.WOOD_DUST))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.GRASS_TWINE, 1)
                        .pattern(" g")
                        .pattern("g ")
                        .input('g', SnailBlocks.DRIED_GRASS_SHEAF)
                        .group("multi_bench")
                        .criterion(hasItem(SnailBlocks.DRIED_GRASS_SHEAF), conditionsFromItem(SnailBlocks.DRIED_GRASS_SHEAF))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.FLINT_HATCHET, 1)
                        .pattern("gf")
                        .pattern("sf")
                        .input('g', SnailItems.GRASS_TWINE)
                        .input('s', Items.STICK)
                        .input('f', SnailItems.FLINT_FLAKE)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.GRASS_TWINE), conditionsFromItem(SnailItems.GRASS_TWINE))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "SnailRecipeProvider";
    }
}
