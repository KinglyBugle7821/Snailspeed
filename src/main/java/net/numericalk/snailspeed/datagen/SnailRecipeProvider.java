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
import net.minecraft.registry.tag.ItemTags;
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
            final Item[] logBark = {
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

            final Item[][] graphiteMoldRecipe = {
                    {SnailItems.BLANK_CLAY_MOLD, SnailItems.BLANK_GRAPHITE_MOLD},
                    {SnailItems.SWORD_CLAY_MOLD, SnailItems.SWORD_GRAPHITE_MOLD},
                    {SnailItems.AXE_CLAY_MOLD, SnailItems.AXE_GRAPHITE_MOLD},
                    {SnailItems.PICKAXE_CLAY_MOLD, SnailItems.PICKAXE_GRAPHITE_MOLD},
                    {SnailItems.SHOVEL_CLAY_MOLD, SnailItems.SHOVEL_GRAPHITE_MOLD},
                    {SnailItems.HOE_CLAY_MOLD, SnailItems.HOE_GRAPHITE_MOLD},
                    {SnailItems.INGOT_CLAY_MOLD, SnailItems.INGOT_GRAPHITE_MOLD},
                    {SnailItems.PLATE_CLAY_MOLD, SnailItems.PLATE_GRAPHITE_MOLD},
                    {SnailItems.BLOCK_CLAY_MOLD, SnailItems.BLOCK_GRAPHITE_MOLD},
                    {SnailItems.BUCKET_CLAY_MOLD, SnailItems.BUCKET_GRAPHITE_MOLD}
            };

            final Item[][] woolProcessing = {
                    {SnailItems.ROUGH_WHITE_WOOL, Items.WHITE_WOOL},
                    {SnailItems.ROUGH_ORANGE_WOOL, Items.ORANGE_WOOL},
                    {SnailItems.ROUGH_MAGENTA_WOOL, Items.MAGENTA_WOOL},
                    {SnailItems.ROUGH_LIGHT_BLUE_WOOL, Items.LIGHT_BLUE_WOOL},
                    {SnailItems.ROUGH_YELLOW_WOOL, Items.YELLOW_WOOL},
                    {SnailItems.ROUGH_LIME_WOOL, Items.LIME_WOOL},
                    {SnailItems.ROUGH_PINK_WOOL, Items.PINK_WOOL},
                    {SnailItems.ROUGH_GRAY_WOOL, Items.GRAY_WOOL},
                    {SnailItems.ROUGH_LIGHT_GRAY_WOOL, Items.LIGHT_GRAY_WOOL},
                    {SnailItems.ROUGH_CYAN_WOOL, Items.CYAN_WOOL},
                    {SnailItems.ROUGH_PURPLE_WOOL, Items.PURPLE_WOOL},
                    {SnailItems.ROUGH_BLUE_WOOL, Items.BLUE_WOOL},
                    {SnailItems.ROUGH_BROWN_WOOL, Items.BROWN_WOOL},
                    {SnailItems.ROUGH_GREEN_WOOL, Items.GREEN_WOOL},
                    {SnailItems.ROUGH_RED_WOOL, Items.RED_WOOL},
                    {SnailItems.ROUGH_BLACK_WOOL, Items.BLACK_WOOL}
            };

            final Item[][] glassColoring = {
                    { Items.WHITE_DYE, Items.WHITE_STAINED_GLASS },
                    { Items.ORANGE_DYE, Items.ORANGE_STAINED_GLASS },
                    { Items.MAGENTA_DYE, Items.MAGENTA_STAINED_GLASS },
                    { Items.LIGHT_BLUE_DYE, Items.LIGHT_BLUE_STAINED_GLASS },
                    { Items.YELLOW_DYE, Items.YELLOW_STAINED_GLASS },
                    { Items.LIME_DYE, Items.LIME_STAINED_GLASS },
                    { Items.PINK_DYE, Items.PINK_STAINED_GLASS },
                    { Items.GRAY_DYE, Items.GRAY_STAINED_GLASS },
                    { Items.LIGHT_GRAY_DYE, Items.LIGHT_GRAY_STAINED_GLASS },
                    { Items.CYAN_DYE, Items.CYAN_STAINED_GLASS },
                    { Items.PURPLE_DYE, Items.PURPLE_STAINED_GLASS },
                    { Items.BLUE_DYE, Items.BLUE_STAINED_GLASS },
                    { Items.BROWN_DYE, Items.BROWN_STAINED_GLASS },
                    { Items.GREEN_DYE, Items.GREEN_STAINED_GLASS },
                    { Items.RED_DYE, Items.RED_STAINED_GLASS },
                    { Items.BLACK_DYE, Items.BLACK_STAINED_GLASS }
            };
            final Item[][] glassPaneColoring = {
                    { Items.WHITE_DYE, Items.WHITE_STAINED_GLASS_PANE },
                    { Items.ORANGE_DYE, Items.ORANGE_STAINED_GLASS_PANE },
                    { Items.MAGENTA_DYE, Items.MAGENTA_STAINED_GLASS_PANE },
                    { Items.LIGHT_BLUE_DYE, Items.LIGHT_BLUE_STAINED_GLASS_PANE },
                    { Items.YELLOW_DYE, Items.YELLOW_STAINED_GLASS_PANE },
                    { Items.LIME_DYE, Items.LIME_STAINED_GLASS_PANE },
                    { Items.PINK_DYE, Items.PINK_STAINED_GLASS_PANE },
                    { Items.GRAY_DYE, Items.GRAY_STAINED_GLASS_PANE },
                    { Items.LIGHT_GRAY_DYE, Items.LIGHT_GRAY_STAINED_GLASS_PANE },
                    { Items.CYAN_DYE, Items.CYAN_STAINED_GLASS_PANE },
                    { Items.PURPLE_DYE, Items.PURPLE_STAINED_GLASS_PANE },
                    { Items.BLUE_DYE, Items.BLUE_STAINED_GLASS_PANE },
                    { Items.BROWN_DYE, Items.BROWN_STAINED_GLASS_PANE },
                    { Items.GREEN_DYE, Items.GREEN_STAINED_GLASS_PANE },
                    { Items.RED_DYE, Items.RED_STAINED_GLASS_PANE },
                    { Items.BLACK_DYE, Items.BLACK_STAINED_GLASS_PANE }
            };
            final Item[][] glassToPane = {
                    { Items.GLASS, Items.GLASS_PANE },
                    { Items.WHITE_STAINED_GLASS, Items.WHITE_STAINED_GLASS_PANE },
                    { Items.ORANGE_STAINED_GLASS, Items.ORANGE_STAINED_GLASS_PANE },
                    { Items.MAGENTA_STAINED_GLASS, Items.MAGENTA_STAINED_GLASS_PANE },
                    { Items.LIGHT_BLUE_STAINED_GLASS, Items.LIGHT_BLUE_STAINED_GLASS_PANE },
                    { Items.YELLOW_STAINED_GLASS, Items.YELLOW_STAINED_GLASS_PANE },
                    { Items.LIME_STAINED_GLASS, Items.LIME_STAINED_GLASS_PANE },
                    { Items.PINK_STAINED_GLASS, Items.PINK_STAINED_GLASS_PANE },
                    { Items.GRAY_STAINED_GLASS, Items.GRAY_STAINED_GLASS_PANE },
                    { Items.LIGHT_GRAY_STAINED_GLASS, Items.LIGHT_GRAY_STAINED_GLASS_PANE },
                    { Items.CYAN_STAINED_GLASS, Items.CYAN_STAINED_GLASS_PANE },
                    { Items.PURPLE_STAINED_GLASS, Items.PURPLE_STAINED_GLASS_PANE },
                    { Items.BLUE_STAINED_GLASS, Items.BLUE_STAINED_GLASS_PANE },
                    { Items.BROWN_STAINED_GLASS, Items.BROWN_STAINED_GLASS_PANE },
                    { Items.GREEN_STAINED_GLASS, Items.GREEN_STAINED_GLASS_PANE },
                    { Items.RED_STAINED_GLASS, Items.RED_STAINED_GLASS_PANE },
                    { Items.BLACK_STAINED_GLASS, Items.BLACK_STAINED_GLASS_PANE }
            };
            final Item[][] concretePowderColoring = {
                    { Items.WHITE_DYE, Items.WHITE_CONCRETE_POWDER },
                    { Items.ORANGE_DYE, Items.ORANGE_CONCRETE_POWDER },
                    { Items.MAGENTA_DYE, Items.MAGENTA_CONCRETE_POWDER },
                    { Items.LIGHT_BLUE_DYE, Items.LIGHT_BLUE_CONCRETE_POWDER },
                    { Items.YELLOW_DYE, Items.YELLOW_CONCRETE_POWDER },
                    { Items.LIME_DYE, Items.LIME_CONCRETE_POWDER },
                    { Items.PINK_DYE, Items.PINK_CONCRETE_POWDER },
                    { Items.GRAY_DYE, Items.GRAY_CONCRETE_POWDER },
                    { Items.LIGHT_GRAY_DYE, Items.LIGHT_GRAY_CONCRETE_POWDER },
                    { Items.CYAN_DYE, Items.CYAN_CONCRETE_POWDER },
                    { Items.PURPLE_DYE, Items.PURPLE_CONCRETE_POWDER },
                    { Items.BLUE_DYE, Items.BLUE_CONCRETE_POWDER },
                    { Items.BROWN_DYE, Items.BROWN_CONCRETE_POWDER },
                    { Items.GREEN_DYE, Items.GREEN_CONCRETE_POWDER },
                    { Items.RED_DYE, Items.RED_CONCRETE_POWDER },
                    { Items.BLACK_DYE, Items.BLACK_CONCRETE_POWDER }
            };


            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                for (Item bark : logBark) {
                    String idPath = Registries.ITEM.getId(bark).getPath();

                    createShaped(RecipeCategory.MISC, SnailBlocks.CAMPFIRE_BASE, 1)
                            .pattern("bb")
                            .pattern("bb")
                            .input('b', SnailItemTagsProvider.LOG_BARKS_THAT_BURN)
                            .criterion(hasItem(bark), conditionsFromItem(bark))
                            .offerTo(exporter, String.valueOf(Identifier.of(Snailspeed.MOD_ID, "campfire_base_from_" + idPath)));
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
                        .criterion(hasItem(SnailBlocks.DRIED_GRASS_SHEAF), conditionsFromItem(SnailBlocks.DRIED_GRASS_SHEAF))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.FLINT_HATCHET, 1)
                        .pattern("gf")
                        .pattern("sf")
                        .input('g', SnailItemTagsProvider.STRING)
                        .input('s', Items.STICK)
                        .input('f', SnailItems.FLINT_FLAKE)
                        .criterion(hasItem(SnailItems.FLINT_FLAKE), conditionsFromItem(SnailItems.FLINT_FLAKE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.FLINT_PICKAXE, 1)
                        .pattern("ff")
                        .pattern("sg")
                        .input('g', SnailItemTagsProvider.STRING)
                        .input('s', Items.STICK)
                        .input('f', SnailItems.FLINT_FLAKE)
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
                        .criterion(hasItem(SnailBlocks.UNSTEADY_DIRT), conditionsFromItem(SnailBlocks.UNSTEADY_DIRT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailBlocks.BRICK_OVEN_BASE)
                        .pattern("##")
                        .input('#', Items.BRICK)
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailBlocks.BRICK_FURNACE_BASE)
                        .pattern("#O")
                        .pattern("O#")
                        .input('#', Items.BRICK)
                        .input('O', SnailBlocks.BRICK_OVEN_BASE.asItem())
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.FURNACE_LID)
                        .pattern("#O")
                        .input('#', Items.BRICK)
                        .input('O', SnailBlocks.BRICK_OVEN_BASE.asItem())
                        .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.MORTAR)
                        .pattern("##")
                        .input('#', SnailItems.ROCK)
                        .criterion(hasItem(SnailItems.ROCK), conditionsFromItem(SnailItems.ROCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.PESTLE)
                        .pattern("#")
                        .pattern("#")
                        .input('#', SnailItems.ROCK)
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
                        .criterion(hasItem(SnailItems.CLAY_SAND), conditionsFromItem(SnailItems.CLAY_SAND))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.CLAY_SAND, 3)
                        .pattern("S#")
                        .pattern("#S")
                        .input('#', Items.CLAY_BALL)
                        .input('S', Items.SAND)
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.CLAY_MOLD)
                        .pattern("##")
                        .input('#', Items.CLAY_BALL)
                        .criterion(hasItem(Items.CLAY_BALL), conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.RESIN_BOWL)
                        .pattern("SC")
                        .pattern("##")
                        .input('#', SnailItemTagsProvider.LOG_BARKS)
                        .input('S', Items.STICK)
                        .input('C', SnailItems.COPPER_NUGGET)
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

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.STEEL_CHUNK, 5)
                        .input(SnailItems.STEEL_INGOT)
                        .criterion(hasItem(SnailItems.STEEL_CHUNK), conditionsFromItem(SnailItems.STEEL_CHUNK))
                        .offerTo(exporter);


                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.FILTERING_TRAY_BASE)
                        .input(SnailItems.LONG_STICK, 4)
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
                        .criterion(hasItem(SnailItems.COPPER_SHOVEL_HEAD), conditionsFromItem(SnailItems.COPPER_SHOVEL_HEAD))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.BLANK_GRAPHITE_MOLD)
                        .pattern("##")
                        .input('#', SnailItems.REFINED_GRAPHITE)
                        .criterion(hasItem(SnailItems.REFINED_GRAPHITE), conditionsFromItem(SnailItems.REFINED_GRAPHITE))
                        .offerTo(exporter);

                for (Item[] entry : graphiteMoldRecipe) {
                    Item clay = entry[0];
                    Item graphite = entry[1];
                    String idPath = Registries.ITEM.getId(clay).getPath();

                    createShaped(RecipeCategory.MISC, graphite, 1)
                            .pattern("#C")
                            .input('#', SnailItemTagsProvider.GRAPHITE_MOLD)
                            .input('C', clay)
                            .group("graphite_mold")
                            .criterion(hasItem(clay), conditionsFromItem(clay))
                            .offerTo(exporter, String.valueOf(Identifier.of(Snailspeed.MOD_ID, "graphite_mold_from" + idPath)));
                }
                createShaped(RecipeCategory.MISC, SnailItems.FORGE_PLATE, 1)
                        .pattern("##")
                        .input('#', SnailItemTagsProvider.PLATES)
                        .criterion(hasItem(SnailItems.COPPER_PLATE), conditionsFromItem(SnailItems.COPPER_PLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.COPPER_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', Items.COPPER_INGOT)
                        .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.IRON_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', Items.IRON_INGOT)
                        .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.STEEL_HAMMER, 1)
                        .pattern("hg")
                        .pattern("s ")
                        .input('s', Items.STICK)
                        .input('g', SnailItemTagsProvider.GLUES)
                        .input('h', SnailItems.STEEL_INGOT)
                        .criterion(hasItem(SnailItems.STEEL_INGOT), conditionsFromItem(SnailItems.STEEL_INGOT))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.LEATHER_STRIP, 1)
                        .pattern("##")
                        .input('#', Items.LEATHER)
                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.COPPER_RIVET, 2)
                        .pattern("#")
                        .pattern("#")
                        .input('#', SnailItems.COPPER_NUGGET)
                        .criterion(hasItem(SnailItems.COPPER_NUGGET), conditionsFromItem(SnailItems.COPPER_NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.CHAIN, 2)
                        .pattern("$T")
                        .pattern("T$")
                        .input('$', Items.IRON_NUGGET)
                        .input('T', SnailItems.TIN_NUGGET)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailBlocks.LANTERN, 1)
                        .pattern("C#")
                        .pattern("NN")
                        .input('#', SnailItems.TORCH)
                        .input('C', Items.CHAIN)
                        .input('N', Items.IRON_NUGGET)
                        .criterion(hasItem(SnailBlocks.TORCH), conditionsFromItem(SnailBlocks.TORCH))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.IRON_BOLT, 2)
                        .pattern("#")
                        .pattern("#")
                        .input('#', Items.IRON_NUGGET)
                        .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.FLINT, 1)
                        .pattern("#")
                        .input('#', Blocks.GRAVEL)
                        .criterion(hasItem(Items.GRAVEL), conditionsFromItem(Items.GRAVEL))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.SMALL_BARREL)
                        .input(SnailBlocks.STICK_BUNDLE, 4)
                        .criterion(hasItem(SnailBlocks.STICK_BUNDLE), conditionsFromItem(SnailBlocks.STICK_BUNDLE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.LONG_STICK, 1)
                        .pattern("#")
                        .pattern("#")
                        .input('#', Items.STICK)
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.CIRCULAR_SAW)
                        .input(SnailItems.IRON_PLATE, 4)
                        .criterion(hasItem(SnailItems.IRON_PLATE), conditionsFromItem(SnailItems.IRON_PLATE))
                        .offerTo(exporter);

                for (Item[] wools : woolProcessing) {
                    Item roughWool = wools[0];
                    Item wool = wools[1];

                    createShapeless(RecipeCategory.BUILDING_BLOCKS, wool)
                            .input(roughWool, 4)
                            .criterion(hasItem(roughWool), conditionsFromItem(roughWool))
                            .group("rough_wools")
                            .offerTo(exporter);
                }

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.BRONZE_INGOT, 5)
                        .input(SnailBlocks.BRONZE_BLOCK, 1)
                        .criterion(hasItem(SnailBlocks.BRONZE_BLOCK), conditionsFromItem(SnailBlocks.BRONZE_BLOCK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.STEEL_INGOT, 5)
                        .input(SnailBlocks.STEEL_BLOCK, 1)
                        .criterion(hasItem(SnailBlocks.STEEL_BLOCK), conditionsFromItem(SnailBlocks.STEEL_BLOCK))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.TIN_INGOT, 5)
                        .input(SnailBlocks.TIN_BLOCK, 1)
                        .criterion(hasItem(SnailBlocks.TIN_BLOCK), conditionsFromItem(SnailBlocks.TIN_BLOCK))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.GLASS_BOTTLE, 1)
                        .input(SnailItemTagsProvider.LOG_BARKS)
                        .input(Items.GLASS)
                        .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.BREWING_STAND, 1)
                        .pattern("BP")
                        .pattern("##")
                        .input('#', Items.COBBLESTONE)
                        .input('B', Items.BLAZE_ROD)
                        .input('P', Items.BLAZE_POWDER)
                        .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.CONDUIT_SHELL, 1)
                        .input(Items.NAUTILUS_SHELL)
                        .input(Items.NAUTILUS_SHELL)
                        .criterion(hasItem(Items.NAUTILUS_SHELL), conditionsFromItem(Items.NAUTILUS_SHELL))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.CONDUIT, 1)
                        .input(SnailItems.CONDUIT_SHELL)
                        .input(SnailItems.CONDUIT_SHELL)
                        .input(Items.HEART_OF_THE_SEA)
                        .criterion(hasItem(SnailItems.CONDUIT_SHELL), conditionsFromItem(SnailItems.CONDUIT_SHELL))
                        .offerTo(exporter);

                for (Item[] items : glassColoring){
                    Item dye = items[0];
                    Item glass = items[1];
                    createShapeless(RecipeCategory.BUILDING_BLOCKS, glass, 3)
                            .input(dye)
                            .input(SnailItemTagsProvider.GLASS)
                            .input(SnailItemTagsProvider.GLASS)
                            .input(SnailItemTagsProvider.GLASS)
                            .criterion(hasItem(dye), conditionsFromItem(dye))
                            .offerTo(exporter);
                }
                for (Item[] items : glassPaneColoring){
                    Item dye = items[0];
                    Item glass = items[1];
                    createShapeless(RecipeCategory.BUILDING_BLOCKS, glass, 3)
                            .input(dye)
                            .input(SnailItemTagsProvider.GLASS_PANES)
                            .input(SnailItemTagsProvider.GLASS_PANES)
                            .input(SnailItemTagsProvider.GLASS_PANES)
                            .group("glass")
                            .criterion(hasItem(dye), conditionsFromItem(dye))
                            .offerTo(exporter);
                }
                for (Item[] items : glassToPane) {
                    Item glass = items[0];
                    Item glassPane = items[1];

                    String recipeId = Registries.ITEM.getId(glassPane).getPath() + "_from_" + Registries.ITEM.getId(glass).getPath();

                    createShaped(RecipeCategory.MISC, glassPane, 4)
                            .pattern("##")
                            .input('#', glass)
                            .group("glass_pane")
                            .criterion(hasItem(glass), conditionsFromItem(glass))
                            .offerTo(exporter, String.valueOf(Identifier.of(Snailspeed.MOD_ID, recipeId)));
                }
                createShaped(RecipeCategory.MISC, Items.WOODEN_SHOVEL, 1)
                        .pattern("#")
                        .pattern("S")
                        .input('#', ItemTags.PLANKS)
                        .input('S', SnailItems.LONG_STICK)
                        .criterion(hasItem(SnailItems.LONG_STICK), conditionsFromItem(SnailItems.LONG_STICK))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.FISHING_ROD, 1)
                        .pattern("S#")
                        .pattern(" #")
                        .input('#', SnailItems.FISHING_LINE)
                        .input('S', SnailItems.LONG_STICK)
                        .criterion(hasItem(SnailItems.FISHING_LINE), conditionsFromItem(SnailItems.FISHING_LINE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, SnailItems.FISHING_LINE, 1)
                        .pattern("##")
                        .pattern(" #")
                        .input('#', Items.STRING)
                        .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, SnailItems.STONE_PLATE, 1)
                        .pattern("##")
                        .input('#', Items.STONE)
                        .criterion(hasItem(Items.STONE), conditionsFromItem(Items.STONE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.REPEATER, 1)
                        .pattern("TT")
                        .pattern("# ")
                        .input('#', SnailItems.STONE_PLATE)
                        .input('T', Items.REDSTONE_TORCH)
                        .criterion(hasItem(SnailItems.STONE_PLATE), conditionsFromItem(SnailItems.STONE_PLATE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.COMPARATOR, 1)
                        .pattern("TQ")
                        .pattern("PQ")
                        .input('P', SnailItems.STONE_PLATE)
                        .input('T', Items.REDSTONE_TORCH)
                        .input('Q', Items.QUARTZ)
                        .criterion(hasItem(Items.QUARTZ), conditionsFromItem(Items.QUARTZ))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.PISTON, 1)
                        .pattern("TT")
                        .pattern("RI")
                        .input('T', ItemTags.WOODEN_TRAPDOORS)
                        .input('R', Items.REDSTONE)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.STICKY_PISTON, 1)
                        .input(Items.PISTON)
                        .input(SnailItemTagsProvider.GLUES)
                        .criterion(hasItem(Items.PISTON), conditionsFromItem(Items.PISTON))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.DROPPER, 1)
                        .pattern("PP")
                        .pattern("RP")
                        .input('P', SnailItems.STONE_PLATE)
                        .input('R', Items.REDSTONE)
                        .criterion(hasItem(SnailItems.STONE_PLATE), conditionsFromItem(SnailItems.STONE_PLATE))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DISPENSER, 1)
                        .input(Items.DROPPER)
                        .input(Items.BOW)
                        .criterion(hasItem(Items.DROPPER), conditionsFromItem(Items.DROPPER))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.REDSTONE_LAMP, 1)
                        .pattern("PG")
                        .pattern("RP")
                        .input('P', SnailItems.STONE_PLATE)
                        .input('R', Items.REDSTONE)
                        .input('G', Items.GLOWSTONE)
                        .criterion(hasItem(Items.GLOWSTONE), conditionsFromItem(Items.GLOWSTONE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.COMPASS, 1)
                        .pattern("PT")
                        .pattern("RI")
                        .input('P', SnailItems.STONE_PLATE)
                        .input('R', Items.REDSTONE)
                        .input('T', SnailItems.TIN_INGOT)
                        .input('I', Items.IRON_INGOT)
                        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.CLOCK, 1)
                        .pattern("PT")
                        .pattern("RG")
                        .input('P', SnailItems.STONE_PLATE)
                        .input('R', Items.REDSTONE)
                        .input('T', SnailItems.TIN_INGOT)
                        .input('G', Items.GOLD_INGOT)
                        .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.CARTOGRAPHY_TABLE, 1)
                        .pattern("PP")
                        .pattern("LL")
                        .input('P', Items.PAPER)
                        .input('L', ItemTags.LOGS)
                        .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.FLETCHING_TABLE, 1)
                        .pattern("FF")
                        .pattern("LL")
                        .input('F', Items.FLINT)
                        .input('L', ItemTags.LOGS)
                        .criterion(hasItem(Items.PAPER), conditionsFromItem(Items.PAPER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.CAULDRON, 1)
                        .pattern("TT")
                        .pattern("LL")
                        .input('T', SnailItems.TIN_INGOT)
                        .input('L', SnailItems.STONE_PLATE)
                        .criterion(hasItem(SnailItems.STONE_PLATE), conditionsFromItem(SnailItems.STONE_PLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.BAMBOO_BLOCK, 1)
                        .pattern("BB")
                        .pattern("BB")
                        .input('B', Items.BAMBOO)
                        .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.SCAFFOLDING, 1)
                        .pattern("FF")
                        .pattern("BB")
                        .input('F', SnailItems.FIBER_FILTER)
                        .input('B', Items.BAMBOO)
                        .criterion(hasItem(Items.BAMBOO), conditionsFromItem(Items.BAMBOO))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.PAINTING, 1)
                        .pattern("PW")
                        .pattern("WP")
                        .input('W', ItemTags.WOOL)
                        .input('P', ItemTags.PLANKS)
                        .criterion(hasItem(Items.WHITE_WOOL), conditionsFromItem(Items.WHITE_WOOL))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.ITEM_FRAME, 1)
                        .pattern("PL")
                        .pattern("LP")
                        .input('L', Items.LEATHER)
                        .input('P', ItemTags.PLANKS)
                        .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.ENDER_CHEST, 1)
                        .pattern("OO")
                        .pattern("EC")
                        .input('O', Items.OBSIDIAN)
                        .input('E', Items.ENDER_EYE)
                        .input('C', Items.CHEST)
                        .criterion(hasItem(Items.ENDER_EYE), conditionsFromItem(Items.ENDER_EYE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.COPPER_BULB, 2)
                        .pattern("RB")
                        .pattern("CC")
                        .input('R', Items.REDSTONE_BLOCK)
                        .input('B', Items.BLAZE_ROD)
                        .input('C', Items.COPPER_BLOCK)
                        .criterion(hasItem(Items.COPPER_BLOCK), conditionsFromItem(Items.COPPER_BLOCK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.EXPOSED_COPPER_BULB, 2)
                        .pattern("RB")
                        .pattern("CC")
                        .input('R', Items.REDSTONE_BLOCK)
                        .input('B', Items.BLAZE_ROD)
                        .input('C', Items.EXPOSED_COPPER)
                        .criterion(hasItem(Items.EXPOSED_COPPER), conditionsFromItem(Items.EXPOSED_COPPER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.WEATHERED_COPPER_BULB, 2)
                        .pattern("RB")
                        .pattern("CC")
                        .input('R', Items.REDSTONE_BLOCK)
                        .input('B', Items.BLAZE_ROD)
                        .input('C', Items.WEATHERED_COPPER)
                        .criterion(hasItem(Items.WEATHERED_COPPER), conditionsFromItem(Items.WEATHERED_COPPER))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.OXIDIZED_COPPER_BULB, 2)
                        .pattern("RB")
                        .pattern("CC")
                        .input('R', Items.REDSTONE_BLOCK)
                        .input('B', Items.BLAZE_ROD)
                        .input('C', Items.OXIDIZED_COPPER)
                        .criterion(hasItem(Items.OXIDIZED_COPPER), conditionsFromItem(Items.OXIDIZED_COPPER))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.RAIL, 4)
                        .pattern("RL")
                        .pattern("RL")
                        .input('R', SnailItems.RAIL_TRACK)
                        .input('L', SnailItems.LONG_STICK)
                        .criterion(hasItem(SnailItems.RAIL_TRACK), conditionsFromItem(SnailItems.RAIL_TRACK))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.POWERED_RAIL, 2)
                        .pattern("RG")
                        .pattern("##")
                        .input('R', Items.RAIL)
                        .input('G', Items.GOLD_INGOT)
                        .input('#', Items.REDSTONE)
                        .criterion(hasItem(Items.RAIL), conditionsFromItem(Items.RAIL))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.ACTIVATOR_RAIL, 2)
                        .pattern("RP")
                        .pattern("##")
                        .input('R', Items.RAIL)
                        .input('#', Items.REDSTONE_TORCH)
                        .input('P', Items.STONE_PRESSURE_PLATE)
                        .criterion(hasItem(Items.RAIL), conditionsFromItem(Items.RAIL))
                        .offerTo(exporter);
                createShaped(RecipeCategory.MISC, Items.DETECTOR_RAIL, 2)
                        .pattern("RP")
                        .input('R', Items.POWERED_RAIL)
                        .input('P', Items.STONE_PRESSURE_PLATE)
                        .criterion(hasItem(Items.RAIL), conditionsFromItem(Items.RAIL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.MISC, Items.MINECART)
                        .pattern("II")
                        .pattern("SS")
                        .input('I', SnailItems.IRON_PLATE)
                        .input('S', SnailItems.STONE_PLATE)
                        .criterion(hasItem(SnailItems.IRON_PLATE), conditionsFromItem(SnailItems.IRON_PLATE))
                        .offerTo(exporter);
                for (Item[] blocks : concretePowderColoring){
                    Item dye = blocks[0];
                    Item concrete_powder = blocks[1];

                    createShaped(RecipeCategory.MISC, concrete_powder, 2)
                            .pattern("GG")
                            .pattern("SD")
                            .input('G', Items.GRAVEL)
                            .input('S', Items.SAND)
                            .input('D', dye)
                            .criterion(hasItem(Items.SAND), conditionsFromItem(Items.SAND))
                            .offerTo(exporter);
                }

                createShaped(RecipeCategory.MISC, Items.LEAD, 1)
                        .pattern("SS")
                        .pattern("SG")
                        .input('G', SnailItemTagsProvider.GLUES)
                        .input('S', Items.STRING)
                        .criterion(hasItem(Items.STRING), conditionsFromItem(Items.STRING))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.LODESTONE, 3)
                        .input(Items.NETHERITE_INGOT)
                        .input(Items.CHISELED_STONE_BRICKS)
                        .input(Items.CHISELED_STONE_BRICKS)
                        .input(Items.CHISELED_STONE_BRICKS)
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.PRISMARINE_BRICKS, 3)
                        .input(Items.PRISMARINE)
                        .input(Items.PRISMARINE)
                        .input(Items.PRISMARINE)
                        .input(Items.PRISMARINE)
                        .criterion(hasItem(Items.PRISMARINE), conditionsFromItem(Items.PRISMARINE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DARK_PRISMARINE, 2)
                        .input(Items.PRISMARINE)
                        .input(Items.PRISMARINE)
                        .input(Items.PRISMARINE)
                        .input(Items.BLACK_DYE)
                        .criterion(hasItem(Items.PRISMARINE), conditionsFromItem(Items.PRISMARINE))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailItems.NETHERITE_NUGGET, 5)
                        .input(Items.NETHERITE_INGOT)
                        .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, SnailBlocks.ENCHANTING_TABLE_BASE, 1)
                        .input(SnailItems.OBSIDIAN_SHARD)
                        .input(SnailItems.OBSIDIAN_SHARD)
                        .input(Items.OBSIDIAN)
                        .input(Items.OBSIDIAN)
                        .criterion(hasItem(Items.OBSIDIAN), conditionsFromItem(Items.OBSIDIAN))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.TORCH, 1)
                        .input(SnailItems.TORCH)
                        .input(SnailItems.HELLSTONE_DUST)
                        .criterion(hasItem(SnailItems.HELLSTONE_DUST), conditionsFromItem(SnailItems.HELLSTONE_DUST))
                        .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.LANTERN, 1)
                        .input(SnailBlocks.LANTERN)
                        .input(SnailItems.HELLSTONE_DUST)
                        .criterion(hasItem(SnailItems.HELLSTONE_DUST), conditionsFromItem(SnailItems.HELLSTONE_DUST))
                        .offerTo(exporter, String.valueOf(Identifier.of(Snailspeed.MOD_ID, "lantern_hellstone")));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.SEA_LANTERN, 1)
                        .input(Items.PRISMARINE_CRYSTALS)
                        .input(Items.PRISMARINE_CRYSTALS)
                        .input(Items.PRISMARINE_CRYSTALS)
                        .input(SnailItems.HELLSTONE_DUST)
                        .criterion(hasItem(SnailItems.HELLSTONE_DUST), conditionsFromItem(SnailItems.HELLSTONE_DUST))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "SnailRecipeProvider";
    }
}
