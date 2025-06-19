package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.items.SnailItems;

import java.util.concurrent.CompletableFuture;

public class SnailItemTagsProvider extends FabricTagProvider<Item> {
    public SnailItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    public static final TagKey<Item> FLINT_FLAKE_REPAIRABLE = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "flint_flake_repairable"));
    public static final TagKey<Item> CAMPFIRE_FUEL = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "campfire_fuel"));
    public static final TagKey<Item> LOG_BARKS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "log_barks"));
    public static final TagKey<Item> LOG_BARKS_THAT_BURN = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "log_barks_that_burn"));
    public static final TagKey<Item> STRING = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "string"));
    public static final TagKey<Item> OVEN_FUEL = TagKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, "oven_fuel"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(OVEN_FUEL)
                .add(Items.CHARCOAL)
                .add(Items.COAL)
                .add(Items.COAL_BLOCK)
                .add(SnailBlocks.DRIED_GRASS_SHEAF.asItem());
        getOrCreateTagBuilder(STRING)
                .add(Items.STRING)
                .add(SnailItems.GRASS_TWINE);
        getOrCreateTagBuilder(FLINT_FLAKE_REPAIRABLE)
                .add(Items.FLINT);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(SnailItems.FLINT_FLAKE)
                .add(SnailItems.FLINT_HATCHET);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(SnailItems.FLINT_PICKAXE);
        getOrCreateTagBuilder(ItemTags.WOODEN_TOOL_MATERIALS)
                .add(SnailItems.FLINT_FLAKE)
                .add(SnailItems.FLINT_HATCHET)
                .add(SnailItems.FLINT_PICKAXE)
                .add(Items.WOODEN_AXE)
                .add(Items.GOLDEN_AXE)
                .add(Items.WOODEN_PICKAXE)
                .add(Items.GOLDEN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(Items.STONE_PICKAXE)
                .add(Items.STONE_AXE);
        getOrCreateTagBuilder(ItemTags.IRON_TOOL_MATERIALS)
                .add(Items.IRON_PICKAXE)
                .add(Items.IRON_AXE);
        getOrCreateTagBuilder(ItemTags.DIAMOND_TOOL_MATERIALS)
                .add(Items.DIAMOND_PICKAXE)
                .add(Items.DIAMOND_AXE);
        getOrCreateTagBuilder(ItemTags.NETHERITE_TOOL_MATERIALS)
                .add(Items.NETHERITE_PICKAXE)
                .add(Items.NETHERITE_AXE);
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
                .add(SnailItems.WOOD_DUST);
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
