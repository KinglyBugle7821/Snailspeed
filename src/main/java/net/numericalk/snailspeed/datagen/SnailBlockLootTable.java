package net.numericalk.snailspeed.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailBlockLootTable extends FabricBlockLootTableProvider {
    private final CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup;

    public SnailBlockLootTable(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
        this.registryLookup = registryLookup;
    }

    @Override
    public void generate() {
        RegistryWrapper.WrapperLookup registryLookup = this.registryLookup.join();
        RegistryEntryLookup<Item> itemLookup = registryLookup.getOrThrow(RegistryKeys.ITEM);


        Block[] trimmedLogs = {
                SnailBlocks.TRIMMED_OAK_LOG,
                SnailBlocks.TRIMMED_SPRUCE_LOG,
                SnailBlocks.TRIMMED_BIRCH_LOG,
                SnailBlocks.TRIMMED_JUNGLE_LOG,
                SnailBlocks.TRIMMED_ACACIA_LOG,
                SnailBlocks.TRIMMED_DARK_OAK_LOG,
                SnailBlocks.TRIMMED_MANGROVE_LOG,
                SnailBlocks.TRIMMED_CHERRY_LOG,
                SnailBlocks.TRIMMED_PALE_OAK_LOG,
                SnailBlocks.TRIMMED_CRIMSON_STEM,
                SnailBlocks.TRIMMED_WARPED_STEM
        };
        Block[] crackedLogs = {
                SnailBlocks.CRACKED_OAK_LOG,
                SnailBlocks.CRACKED_SPRUCE_LOG,
                SnailBlocks.CRACKED_BIRCH_LOG,
                SnailBlocks.CRACKED_JUNGLE_LOG,
                SnailBlocks.CRACKED_ACACIA_LOG,
                SnailBlocks.CRACKED_DARK_OAK_LOG,
                SnailBlocks.CRACKED_MANGROVE_LOG,
                SnailBlocks.CRACKED_CHERRY_LOG,
                SnailBlocks.CRACKED_PALE_OAK_LOG,
                SnailBlocks.CRACKED_CRIMSON_STEM,
                SnailBlocks.CRACKED_WARPED_STEM
        };
        Block[] damagedLogs = {
                SnailBlocks.DAMAGED_OAK_LOG,
                SnailBlocks.DAMAGED_SPRUCE_LOG,
                SnailBlocks.DAMAGED_BIRCH_LOG,
                SnailBlocks.DAMAGED_JUNGLE_LOG,
                SnailBlocks.DAMAGED_ACACIA_LOG,
                SnailBlocks.DAMAGED_DARK_OAK_LOG,
                SnailBlocks.DAMAGED_MANGROVE_LOG,
                SnailBlocks.DAMAGED_CHERRY_LOG,
                SnailBlocks.DAMAGED_PALE_OAK_LOG,
                SnailBlocks.DAMAGED_CRIMSON_STEM,
                SnailBlocks.DAMAGED_WARPED_STEM
        };
        Block[] damagedPlanks = {
                SnailBlocks.DAMAGED_OAK_PLANKS,
                SnailBlocks.DAMAGED_SPRUCE_PLANKS,
                SnailBlocks.DAMAGED_BIRCH_PLANKS,
                SnailBlocks.DAMAGED_JUNGLE_PLANKS,
                SnailBlocks.DAMAGED_ACACIA_PLANKS,
                SnailBlocks.DAMAGED_DARK_OAK_PLANKS,
                SnailBlocks.DAMAGED_MANGROVE_PLANKS,
                SnailBlocks.DAMAGED_CHERRY_PLANKS,
                SnailBlocks.DAMAGED_PALE_OAK_PLANKS,
                SnailBlocks.DAMAGED_BAMBOO_PLANKS,
                SnailBlocks.DAMAGED_CRIMSON_PLANKS,
                SnailBlocks.DAMAGED_WARPED_PLANKS
        };

        Block[] woodBlocks = {
                Blocks.OAK_LOG, Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_WOOD, Blocks.OAK_PLANKS,
                Blocks.OAK_FENCE, Blocks.OAK_FENCE_GATE, Blocks.OAK_DOOR, Blocks.OAK_TRAPDOOR,
                Blocks.OAK_SLAB, Blocks.OAK_STAIRS, Blocks.OAK_SIGN, Blocks.OAK_WALL_SIGN,

                Blocks.SPRUCE_LOG, Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_WOOD, Blocks.SPRUCE_PLANKS,
                Blocks.SPRUCE_FENCE, Blocks.SPRUCE_FENCE_GATE, Blocks.SPRUCE_DOOR, Blocks.SPRUCE_TRAPDOOR,
                Blocks.SPRUCE_SLAB, Blocks.SPRUCE_STAIRS, Blocks.SPRUCE_SIGN, Blocks.SPRUCE_WALL_SIGN,

                Blocks.BIRCH_LOG, Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_WOOD, Blocks.BIRCH_PLANKS,
                Blocks.BIRCH_FENCE, Blocks.BIRCH_FENCE_GATE, Blocks.BIRCH_DOOR, Blocks.BIRCH_TRAPDOOR,
                Blocks.BIRCH_SLAB, Blocks.BIRCH_STAIRS, Blocks.BIRCH_SIGN, Blocks.BIRCH_WALL_SIGN,

                Blocks.JUNGLE_LOG, Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_WOOD, Blocks.JUNGLE_PLANKS,
                Blocks.JUNGLE_FENCE, Blocks.JUNGLE_FENCE_GATE, Blocks.JUNGLE_DOOR, Blocks.JUNGLE_TRAPDOOR,
                Blocks.JUNGLE_SLAB, Blocks.JUNGLE_STAIRS, Blocks.JUNGLE_SIGN, Blocks.JUNGLE_WALL_SIGN,

                Blocks.ACACIA_LOG, Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_WOOD, Blocks.ACACIA_PLANKS,
                Blocks.ACACIA_FENCE, Blocks.ACACIA_FENCE_GATE, Blocks.ACACIA_DOOR, Blocks.ACACIA_TRAPDOOR,
                Blocks.ACACIA_SLAB, Blocks.ACACIA_STAIRS, Blocks.ACACIA_SIGN, Blocks.ACACIA_WALL_SIGN,

                Blocks.DARK_OAK_LOG, Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_WOOD, Blocks.DARK_OAK_PLANKS,
                Blocks.DARK_OAK_FENCE, Blocks.DARK_OAK_FENCE_GATE, Blocks.DARK_OAK_DOOR, Blocks.DARK_OAK_TRAPDOOR,
                Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_STAIRS, Blocks.DARK_OAK_SIGN, Blocks.DARK_OAK_WALL_SIGN,

                Blocks.MANGROVE_LOG, Blocks.MANGROVE_WOOD, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_WOOD, Blocks.MANGROVE_PLANKS,
                Blocks.MANGROVE_FENCE, Blocks.MANGROVE_FENCE_GATE, Blocks.MANGROVE_DOOR, Blocks.MANGROVE_TRAPDOOR,
                Blocks.MANGROVE_SLAB, Blocks.MANGROVE_STAIRS, Blocks.MANGROVE_SIGN, Blocks.MANGROVE_WALL_SIGN,
                Blocks.MANGROVE_ROOTS, Blocks.MUDDY_MANGROVE_ROOTS,

                Blocks.CHERRY_LOG, Blocks.CHERRY_WOOD, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_WOOD, Blocks.CHERRY_PLANKS,
                Blocks.CHERRY_FENCE, Blocks.CHERRY_FENCE_GATE, Blocks.CHERRY_DOOR, Blocks.CHERRY_TRAPDOOR,
                Blocks.CHERRY_SLAB, Blocks.CHERRY_STAIRS, Blocks.CHERRY_SIGN, Blocks.CHERRY_WALL_SIGN,
                Blocks.CHERRY_LEAVES, Blocks.CHERRY_SAPLING,

                Blocks.PALE_OAK_LOG, Blocks.PALE_OAK_WOOD, Blocks.STRIPPED_PALE_OAK_LOG, Blocks.STRIPPED_PALE_OAK_WOOD, Blocks.PALE_OAK_PLANKS,
                Blocks.PALE_OAK_FENCE, Blocks.PALE_OAK_FENCE_GATE, Blocks.PALE_OAK_DOOR, Blocks.PALE_OAK_TRAPDOOR,
                Blocks.PALE_OAK_SLAB, Blocks.PALE_OAK_STAIRS, Blocks.PALE_OAK_SIGN, Blocks.PALE_OAK_WALL_SIGN,

                Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.BAMBOO_PLANKS,
                Blocks.BAMBOO_FENCE, Blocks.BAMBOO_FENCE_GATE, Blocks.BAMBOO_DOOR, Blocks.BAMBOO_TRAPDOOR,
                Blocks.BAMBOO_SLAB, Blocks.BAMBOO_STAIRS, Blocks.BAMBOO_SIGN, Blocks.BAMBOO_WALL_SIGN,
                Blocks.BAMBOO_MOSAIC, Blocks.BAMBOO_MOSAIC_SLAB, Blocks.BAMBOO_MOSAIC_STAIRS,

                Blocks.CRIMSON_STEM, Blocks.CRIMSON_HYPHAE, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_HYPHAE, Blocks.CRIMSON_PLANKS,
                Blocks.CRIMSON_FENCE, Blocks.CRIMSON_FENCE_GATE, Blocks.CRIMSON_DOOR, Blocks.CRIMSON_TRAPDOOR,
                Blocks.CRIMSON_SLAB, Blocks.CRIMSON_STAIRS, Blocks.CRIMSON_SIGN, Blocks.CRIMSON_WALL_SIGN,

                Blocks.WARPED_STEM, Blocks.WARPED_HYPHAE, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_WARPED_HYPHAE, Blocks.WARPED_PLANKS,
                Blocks.WARPED_FENCE, Blocks.WARPED_FENCE_GATE, Blocks.WARPED_DOOR, Blocks.WARPED_TRAPDOOR,
                Blocks.WARPED_SLAB, Blocks.WARPED_STAIRS, Blocks.WARPED_SIGN, Blocks.WARPED_WALL_SIGN
        };

        Block[] jsDropRockBro = {
                Blocks.SMOOTH_STONE,
                Blocks.STONE_SLAB,
                Blocks.SMOOTH_STONE_SLAB,
                Blocks.STONE_STAIRS,
                Blocks.STONE_BRICKS,
                Blocks.CRACKED_STONE_BRICKS,
                Blocks.CHISELED_STONE_BRICKS,
                Blocks.STONE_BRICK_SLAB,
                Blocks.STONE_BRICK_STAIRS,
                Blocks.STONE_BRICK_WALL,

                Blocks.COBBLESTONE_SLAB,
                Blocks.COBBLESTONE_STAIRS,
                Blocks.COBBLESTONE_WALL,
                Blocks.MOSSY_COBBLESTONE_SLAB,
                Blocks.MOSSY_COBBLESTONE_STAIRS,
                Blocks.MOSSY_COBBLESTONE_WALL,

                Blocks.ANDESITE,
                Blocks.POLISHED_ANDESITE,
                Blocks.ANDESITE_SLAB,
                Blocks.POLISHED_ANDESITE_SLAB,
                Blocks.ANDESITE_STAIRS,
                Blocks.POLISHED_ANDESITE_STAIRS,
                Blocks.ANDESITE_WALL,

                Blocks.GRANITE,
                Blocks.POLISHED_GRANITE,
                Blocks.GRANITE_SLAB,
                Blocks.POLISHED_GRANITE_SLAB,
                Blocks.GRANITE_STAIRS,
                Blocks.POLISHED_GRANITE_STAIRS,
                Blocks.GRANITE_WALL,

                Blocks.DIORITE,
                Blocks.POLISHED_DIORITE,
                Blocks.DIORITE_SLAB,
                Blocks.POLISHED_DIORITE_SLAB,
                Blocks.DIORITE_STAIRS,
                Blocks.POLISHED_DIORITE_STAIRS,
                Blocks.DIORITE_WALL,

                Blocks.TUFF,
                Blocks.POLISHED_TUFF,
                Blocks.TUFF_SLAB,
                Blocks.POLISHED_TUFF_SLAB,
                Blocks.TUFF_STAIRS,
                Blocks.POLISHED_TUFF_STAIRS,
                Blocks.TUFF_WALL,
                Blocks.TUFF_BRICKS,
                Blocks.TUFF_BRICK_SLAB,
                Blocks.TUFF_BRICK_STAIRS,
                Blocks.TUFF_BRICK_WALL,
                Blocks.CHISELED_TUFF,
                Blocks.CHISELED_TUFF_BRICKS,

                Blocks.POLISHED_DEEPSLATE,
                Blocks.DEEPSLATE_BRICKS,
                Blocks.DEEPSLATE_TILES,
                Blocks.CRACKED_DEEPSLATE_BRICKS,
                Blocks.CRACKED_DEEPSLATE_TILES,
                Blocks.CHISELED_DEEPSLATE,
                Blocks.COBBLED_DEEPSLATE_SLAB,
                Blocks.POLISHED_DEEPSLATE_SLAB,
                Blocks.DEEPSLATE_BRICK_SLAB,
                Blocks.DEEPSLATE_TILE_SLAB,
                Blocks.COBBLED_DEEPSLATE_STAIRS,
                Blocks.POLISHED_DEEPSLATE_STAIRS,
                Blocks.DEEPSLATE_BRICK_STAIRS,
                Blocks.DEEPSLATE_TILE_STAIRS,
                Blocks.COBBLED_DEEPSLATE_WALL,
                Blocks.POLISHED_DEEPSLATE_WALL,
                Blocks.DEEPSLATE_BRICK_WALL,
                Blocks.DEEPSLATE_TILE_WALL,

                Blocks.SANDSTONE,
                Blocks.CHISELED_SANDSTONE,
                Blocks.SMOOTH_SANDSTONE,
                Blocks.SANDSTONE_SLAB,
                Blocks.SMOOTH_SANDSTONE_SLAB,
                Blocks.SANDSTONE_STAIRS,
                Blocks.SMOOTH_SANDSTONE_STAIRS,
                Blocks.SANDSTONE_WALL,
                Blocks.RED_SANDSTONE,
                Blocks.CHISELED_RED_SANDSTONE,
                Blocks.SMOOTH_RED_SANDSTONE,
                Blocks.RED_SANDSTONE_SLAB,
                Blocks.SMOOTH_RED_SANDSTONE_SLAB,
                Blocks.RED_SANDSTONE_STAIRS,
                Blocks.SMOOTH_RED_SANDSTONE_STAIRS,
                Blocks.RED_SANDSTONE_WALL
        };
        for (Block woodDustDrop : woodBlocks) {
            addDrop(woodDustDrop, onlyDropWhenHolding(ItemTags.AXES, woodDustDrop, SnailItems.STONE_ROCK, 1f, 3f, itemLookup));
        }
        for (Block rockDrop : jsDropRockBro) {
            addDrop(rockDrop, onlyDropWhenHolding(SnailItemTagsProvider.DIAMOND_PICKAXE_MINEABLE, rockDrop, SnailItems.STONE_ROCK, 1f, 3f, itemLookup));
        }
        for (Block trimmedLog : trimmedLogs) {

            addDrop(trimmedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Block crackedLog : crackedLogs) {

            addDrop(crackedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(1)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        for (Block damagedLog : damagedLogs) {

            addDrop(damagedLog, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(1), new ConstantLootNumberProvider(3)))
                    .with(ItemEntry.builder(Items.STICK))))
            );
        }
        for (Block damagedPlank : damagedPlanks) {

            addDrop(damagedPlank, LootTable.builder().pool(addSurvivesExplosionCondition(SnailItems.WOOD_DUST, LootPool.builder()
                    .rolls(new UniformLootNumberProvider(new ConstantLootNumberProvider(2), new ConstantLootNumberProvider(2)))
                    .with(ItemEntry.builder(SnailItems.WOOD_DUST))))
            );
        }
        addDrop(SnailBlocks.CAMPFIRE_BASE);
        addDrop(SnailBlocks.BRICK_OVEN_BASE);
        addDrop(SnailBlocks.BRICK_FURNACE_BASE);
        addDrop(SnailBlocks.FILTERING_TRAY_BASE);
        addDrop(SnailBlocks.BRICK_OVEN, bundledBlockDrop(SnailBlocks.BRICK_OVEN_BASE, Items.BRICK, 6));
        addDrop(SnailBlocks.BRICK_FURNACE, bundledBlockDrop(SnailBlocks.BRICK_FURNACE_BASE, Items.BRICK, 4));

        addDrop(SnailBlocks.GRASS_SHEAF);
        addDrop(SnailBlocks.DRIED_GRASS_SHEAF);
        addDrop(SnailBlocks.CLAY_BRICK);
        addDrop(SnailBlocks.DRIED_CLAY_BRICK);

        addDrop(SnailBlocks.FIRED_BRICK, bundledBlockDrop(SnailBlocks.FIRED_BRICK, Items.BRICK, 1));

        addDrop(SnailBlocks.UNTIED_STICK_BUNDLE, bundledBlockDrop(SnailBlocks.UNTIED_STICK_BUNDLE, Items.STICK, 4));
        addDrop(SnailBlocks.STICK_BUNDLE);
        addDrop(SnailBlocks.UNTIED_THATCH_BLOCK, bundledBlockDrop(SnailBlocks.UNTIED_THATCH_BLOCK, SnailBlocks.DRIED_GRASS_SHEAF.asItem(), 4));
        addDrop(SnailBlocks.THATCH_BLOCK);

        addDrop(SnailBlocks.MORTAR);

        addDrop(SnailBlocks.UNSTEADY_DIRT);
        addDrop(SnailBlocks.UNSTEADY_ROOTED_DIRT);
        addDrop(SnailBlocks.UNSTEADY_COARSE_DIRT);
        addDrop(SnailBlocks.UNSTEADY_MUD);

        addDrop(SnailBlocks.CLAY_CRUCIBLE);
        addDrop(SnailBlocks.DRIED_CLAY_CRUCIBLE);
        addDrop(SnailBlocks.CRUCIBLE);

        addDrop(SnailBlocks.CLAY_MOLD);
        addDrop(SnailBlocks.DRIED_CLAY_BRICK);
        addDrop(SnailBlocks.RESIN_BOWL);
        addDrop(SnailBlocks.FILTERING_TRAY);

        addDrop(SnailBlocks.TIN_ORE, multipleOreDrops(SnailBlocks.TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));
        addDrop(SnailBlocks.DEEPSLATE_TIN_ORE, multipleOreDrops(SnailBlocks.DEEPSLATE_TIN_ORE, SnailItems.RAW_TIN, 1f, 2f));

        addDrop(SnailBlocks.GRAPHITE_ORE, multipleOreDrops(SnailBlocks.GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));
        addDrop(SnailBlocks.DEEPSLATE_GRAPHITE_ORE, multipleOreDrops(SnailBlocks.DEEPSLATE_GRAPHITE_ORE, SnailItems.RAW_GRAPHITE, 1f, 1f));

        addDrop(SnailBlocks.ARMOR_FORGE);
        addDrop(SnailBlocks.SMALL_BARREL);
        addDrop(SnailBlocks.SAW_TABLE);
        addDrop(SnailBlocks.WEAPON_FORGE);

        addDrop(SnailBlocks.BRONZE_BLOCK);
        addDrop(SnailBlocks.TIN_BLOCK);
        addDrop(SnailBlocks.STEEL_BLOCK);

        addDrop(Blocks.DIRT, bundledBlockDrop(Blocks.DIRT, SnailBlocks.UNSTEADY_DIRT.asItem(), 1f));
        addDrop(Blocks.GRASS_BLOCK, bundledBlockDrop(Blocks.GRASS_BLOCK, SnailBlocks.UNSTEADY_DIRT.asItem(), 1f));
        addDrop(Blocks.PODZOL, bundledBlockDrop(Blocks.PODZOL, SnailBlocks.UNSTEADY_DIRT.asItem(), 1f));
        addDrop(Blocks.FARMLAND, bundledBlockDrop(Blocks.FARMLAND, SnailBlocks.UNSTEADY_DIRT.asItem(), 1f));
        addDrop(Blocks.ROOTED_DIRT, bundledBlockDrop(Blocks.ROOTED_DIRT, SnailBlocks.UNSTEADY_ROOTED_DIRT.asItem(), 1f));
        addDrop(Blocks.COARSE_DIRT, bundledBlockDrop(Blocks.COARSE_DIRT, SnailBlocks.UNSTEADY_COARSE_DIRT.asItem(), 1f));
        addDrop(Blocks.MUD, bundledBlockDrop(Blocks.MUD, SnailBlocks.UNSTEADY_MUD.asItem(), 1f));
        addDrop(Blocks.MOSS_BLOCK, bundledBlockDrop(Blocks.MOSS_BLOCK, Blocks.VINE.asItem(), 1f, 2f));
        addDrop(Blocks.PALE_MOSS_BLOCK, bundledBlockDrop(Blocks.PALE_MOSS_BLOCK, Blocks.VINE.asItem(), 1f, 2f));

        addDrop(Blocks.OBSIDIAN, bundledBlockDrop(Blocks.OBSIDIAN, SnailItems.OBSIDIAN_SHARD, 2f, 5f));
        addDrop(Blocks.CHEST, bundledBlockDrop(Blocks.CHEST, Items.STICK, 2f, 5f));
        addDrop(Blocks.BARREL, bundledBlockDrop(Blocks.BARREL, Items.STICK, 2f, 5f));


        addDrop(SnailBlocks.ENCHANTING_TABLE_BASE);

    }

    public LootTable.Builder onlyDropWhenHolding(TagKey<Item> itemTag, Block block, Item drop, float min, float max, RegistryEntryLookup<Item> itemLookup){

        return LootTable.builder()
                .pool(
                        LootPool.builder()
                                .rolls(UniformLootNumberProvider.create(min, max))
                                .conditionally(InvertedLootCondition.builder(
                                        MatchToolLootCondition.builder(
                                                ItemPredicate.Builder.create()
                                                        .tag(itemLookup, itemTag)
                                        )
                                )).with(ItemEntry.builder(drop))
                ).pool(
                        LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(
                                        MatchToolLootCondition.builder(
                                                ItemPredicate.Builder.create()
                                                        .tag(itemLookup, itemTag)
                                        )
                                )
                                .with(ItemEntry.builder(block.asItem()))
                );
    }

    public LootTable.Builder bundledBlockDrop(Block drop, Item drop2, float count) {
        return this.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop, ItemEntry.builder(drop2)
                        .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(count)))));
    }
    public LootTable.Builder bundledBlockDrop(Block drop, Item drop2, float countMin, float countMax) {
        return this.dropsWithSilkTouch(drop,
                this.applyExplosionDecay(drop, ItemEntry.builder(drop2)
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(countMin, countMax)))));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops)))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
