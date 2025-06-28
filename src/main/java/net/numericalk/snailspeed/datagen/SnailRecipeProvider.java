package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
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
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

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

            final Item[][] toolRecipe = {
                    {SnailItems.COPPER_SWORD_BLADE, SnailItems.COPPER_SWORD},
                    {SnailItems.COPPER_AXE_HEAD, SnailItems.COPPER_AXE},
                    {SnailItems.COPPER_PICKAXE_HEAD, SnailItems.COPPER_PICKAXE},
                    {SnailItems.COPPER_SHOVEL_HEAD, SnailItems.COPPER_SHOVEL},
                    {SnailItems.COPPER_HOE_HEAD, SnailItems.COPPER_HOE},

                    {SnailItems.BRONZE_SWORD_BLADE, SnailItems.BRONZE_SWORD},
                    {SnailItems.BRONZE_AXE_HEAD, SnailItems.BRONZE_AXE},
                    {SnailItems.BRONZE_PICKAXE_HEAD, SnailItems.BRONZE_PICKAXE},
                    {SnailItems.BRONZE_SHOVEL_HEAD, SnailItems.BRONZE_SHOVEL},
                    {SnailItems.BRONZE_HOE_HEAD, SnailItems.BRONZE_HOE},

                    {SnailItems.IRON_SWORD_BLADE, Items.IRON_SWORD},
                    {SnailItems.IRON_AXE_HEAD, Items.IRON_AXE},
                    {SnailItems.IRON_PICKAXE_HEAD, Items.IRON_PICKAXE},
                    {SnailItems.IRON_SHOVEL_HEAD, Items.IRON_SHOVEL},
                    {SnailItems.IRON_HOE_HEAD, Items.IRON_HOE},

                    {SnailItems.STEEL_SWORD_BLADE, SnailItems.STEEL_SWORD},
                    {SnailItems.STEEL_AXE_HEAD, SnailItems.STEEL_AXE},
                    {SnailItems.STEEL_PICKAXE_HEAD, SnailItems.STEEL_PICKAXE},
                    {SnailItems.STEEL_SHOVEL_HEAD, SnailItems.STEEL_SHOVEL},
                    {SnailItems.STEEL_HOE_HEAD, SnailItems.STEEL_HOE},

                    {SnailItems.GOLDEN_SWORD_BLADE, Items.GOLDEN_SWORD},
                    {SnailItems.GOLDEN_AXE_HEAD, Items.GOLDEN_AXE},
                    {SnailItems.GOLDEN_PICKAXE_HEAD, Items.GOLDEN_PICKAXE},
                    {SnailItems.GOLDEN_SHOVEL_HEAD, Items.GOLDEN_SHOVEL},
                    {SnailItems.GOLDEN_HOE_HEAD, Items.GOLDEN_HOE}
            };

            final Item[][] graphiteMoldRecipe = {
                    {SnailItems.BLANK_CLAY_MOLD, SnailItems.BLANK_GRAPHITE_MOLD},
                    {SnailItems.SWORD_CLAY_MOLD, SnailItems.SWORD_GRAPHITE_MOLD},
                    {SnailItems.AXE_CLAY_MOLD, SnailItems.AXE_GRAPHITE_MOLD},
                    {SnailItems.PICKAXE_CLAY_MOLD, SnailItems.PICKAXE_GRAPHITE_MOLD},
                    {SnailItems.SHOVEL_CLAY_MOLD, SnailItems.SHOVEL_GRAPHITE_MOLD},
                    {SnailItems.HOE_CLAY_MOLD, SnailItems.HOE_GRAPHITE_MOLD},
                    {SnailItems.INGOT_CLAY_MOLD, SnailItems.INGOT_GRAPHITE_MOLD},
                    {SnailItems.PLATE_CLAY_MOLD, SnailItems.PLATE_GRAPHITE_MOLD}
            };

            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                for (Item[] entry : toolRecipe){
                    Item head = entry[0];
                    Item tool = entry[1];

                    createShaped(RecipeCategory.MISC, tool, 1)
                            .pattern("hg")
                            .pattern("s ")
                            .input('s', Items.STICK)
                            .input('g', SnailItemTagsProvider.GLUES)
                            .input('h', head)
                            .group("multi_bench")
                            .criterion(hasItem(head), conditionsFromItem(head))
                            .offerTo(exporter);
                }

                for (Object entry : logBark) {
                    Item bark = (Item) entry;
                    String idPath = Registries.ITEM.getId(bark).getPath();

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
                        .input('g', SnailItemTagsProvider.STRING)
                        .input('s', Items.STICK)
                        .input('f', SnailItems.FLINT_FLAKE)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.FLINT_FLAKE), conditionsFromItem(SnailItems.FLINT_FLAKE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.FLINT_PICKAXE, 1)
                        .pattern("ff")
                        .pattern("sg")
                        .input('g', SnailItemTagsProvider.STRING)
                        .input('s', Items.STICK)
                        .input('f', SnailItems.FLINT_FLAKE)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.FLINT_FLAKE), conditionsFromItem(SnailItems.FLINT_FLAKE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.UNTIED_STICK_BUNDLE)
                        .input(Items.STICK, 4)
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.STICK_BUNDLE)
                        .input(SnailBlocks.UNTIED_STICK_BUNDLE)
                        .input(SnailItems.GRASS_TWINE)
                        .criterion(hasItem(SnailBlocks.UNTIED_STICK_BUNDLE), conditionsFromItem(SnailBlocks.UNTIED_STICK_BUNDLE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.UNTIED_THATCH_BLOCK)
                        .input(SnailBlocks.DRIED_GRASS_SHEAF, 4)
                        .criterion(hasItem(SnailBlocks.UNTIED_THATCH_BLOCK), conditionsFromItem(SnailBlocks.UNTIED_THATCH_BLOCK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.THATCH_BLOCK)
                        .input(SnailBlocks.UNTIED_THATCH_BLOCK)
                        .input(SnailItems.GRASS_TWINE)
                        .criterion(hasItem(SnailBlocks.UNTIED_THATCH_BLOCK), conditionsFromItem(SnailBlocks.UNTIED_THATCH_BLOCK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.UNSTEADY_COARSE_DIRT, 4)
                        .pattern("dg")
                        .pattern("gd")
                        .input('d', SnailBlocks.UNSTEADY_DIRT)
                        .input('g', Blocks.GRAVEL)
                        .group("multi_bench")
                        .criterion(hasItem(SnailBlocks.UNSTEADY_DIRT), conditionsFromItem(SnailBlocks.UNSTEADY_DIRT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailBlocks.BRICK_OVEN_BASE)
                        .pattern("##")
                        .input('#', Items.BRICK)
                        .group("multi_bench")
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailBlocks.BRICK_FURNACE_BASE)
                        .pattern("#O")
                        .pattern("O#")
                        .input('#', Items.BRICK)
                        .input('O', SnailBlocks.BRICK_OVEN_BASE.asItem())
                        .group("multi_bench")
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.FURNACE_LID)
                        .pattern("#O")
                        .input('#', Items.BRICK)
                        .input('O', SnailBlocks.BRICK_OVEN_BASE.asItem())
                        .group("multi_bench")
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.MORTAR)
                        .pattern("##")
                        .input('#', SnailItems.ROCK)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.ROCK), conditionsFromItem(SnailItems.ROCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.PESTLE)
                        .pattern("#")
                        .pattern("#")
                        .input('#', SnailItems.ROCK)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.ROCK), conditionsFromItem(SnailItems.ROCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.CLAY_BRICK, 4)
                        .input(Items.CLAY_BALL, 4)
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);


                createShaped(RecipeCategory.MISC, SnailBlocks.CLAY_CRUCIBLE)
                        .pattern("##")
                        .pattern("##")
                        .input('#', SnailItems.CLAY_SAND)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.CLAY_SAND), conditionsFromItem(SnailItems.CLAY_SAND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.CLAY_SAND, 3)
                        .pattern("S#")
                        .pattern("#S")
                        .input('#', Items.CLAY_BALL)
                        .input('S', Items.SAND)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.CLAY_MOLD)
                        .pattern("##")
                        .input('#', Items.CLAY_BALL)
                        .group("multi_bench")
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.RESIN_BOWL)
                        .pattern("SC")
                        .pattern("##")
                        .input('#', SnailItemTagsProvider.LOG_BARKS)
                        .input('S', Items.STICK)
                        .input('C', SnailItems.COPPER_NUGGET)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.COPPER_NUGGET), conditionsFromItem(SnailItems.COPPER_NUGGET))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.COPPER_NUGGET, 5)
                        .input(Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.BRONZE_NUGGET, 5)
                        .input(SnailItems.BRONZE_INGOT)
                        .criterion(hasItem(SnailItems.BRONZE_INGOT), conditionsFromItem(SnailItems.BRONZE_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.STEEL_CHUNK, 3)
                        .input(SnailItems.STEEL_INGOT)
                        .criterion(hasItem(SnailItems.STEEL_CHUNK), conditionsFromItem(SnailItems.STEEL_CHUNK))
                        .offerTo(exporter);


                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.FILTERING_TRAY_BASE)
                        .input(SnailBlocks.UNTIED_STICK_BUNDLE, 4)
                        .criterion(hasItem(SnailBlocks.UNTIED_STICK_BUNDLE), conditionsFromItem(SnailBlocks.UNTIED_STICK_BUNDLE))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.FIBER_FILTER)
                        .input(SnailItems.GRASS_TWINE, 4)
                        .criterion(hasItem(SnailItems.GRASS_TWINE), conditionsFromItem(SnailItems.GRASS_TWINE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.BARK_SPUD)
                        .pattern("SN")
                        .pattern("# ")
                        .input('#', Items.STICK)
                        .input('S', SnailItems.COPPER_SHOVEL_HEAD)
                        .input('N', SnailItems.TIN_NUGGET)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.COPPER_SHOVEL_HEAD), conditionsFromItem(SnailItems.COPPER_SHOVEL_HEAD))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.BLANK_GRAPHITE_MOLD)
                        .pattern("##")
                        .input('#', SnailItems.REFINED_GRAPHITE)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.REFINED_GRAPHITE), conditionsFromItem(SnailItems.REFINED_GRAPHITE))
                        .offerTo(exporter);

                for (Item[] entry : graphiteMoldRecipe){
                    Item clay = entry[0];
                    Item graphite = entry[1];
                    String idPath = Registries.ITEM.getId(clay).getPath();

                    createShaped(RecipeCategory.MISC, graphite, 1)
                            .pattern("#C")
                            .input('#', graphite)
                            .input('C', clay)
                            .group("multi_bench")
                            .criterion(hasItem(clay), conditionsFromItem(clay))
                            .offerTo(exporter, String.valueOf(Identifier.of(Snailspeed.MOD_ID, "graphite_mold_from" + idPath)));
                }
                createShaped(RecipeCategory.MISC, SnailItems.ARMOR_FORGE_PLATE, 1)
                        .pattern("##")
                        .input('#', SnailItemTagsProvider.PLATES)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.COPPER_PLATE), conditionsFromItem(SnailItems.COPPER_PLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.COPPER_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', Items.COPPER_INGOT)
                        .group("multi_bench")
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.IRON_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', Items.IRON_INGOT)
                        .group("multi_bench")
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.STEEL_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', SnailItems.STEEL_INGOT)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.STEEL_INGOT), conditionsFromItem(SnailItems.STEEL_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.LEATHER_STRIP, 1)
                        .pattern("##")
                        .input('#', Items.LEATHER)
                        .group("multi_bench")
                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.COPPER_RIVET, 2)
                        .pattern("#")
                        .pattern("#")
                        .input('#', SnailItems.COPPER_NUGGET)
                        .group("multi_bench")
                        .criterion(hasItem(SnailItems.COPPER_NUGGET), conditionsFromItem(SnailItems.COPPER_NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.CHAIN_LINKS, 2)
                        .pattern("$#")
                        .pattern("#$")
                        .input('#', Items.IRON_INGOT)
                        .input('$', Items.IRON_NUGGET)
                        .group("multi_bench")
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.IRON_BOLT, 2)
                        .pattern("#")
                        .pattern("#")
                        .input('#', Items.IRON_NUGGET)
                        .group("multi_bench")
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "SnailRecipeProvider";
    }
}
