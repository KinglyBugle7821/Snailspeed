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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(FLINT_FLAKE_REPAIRABLE)
                .add(Items.FLINT);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(SnailItems.FLINT_FLAKE);
        getOrCreateTagBuilder(ItemTags.WOODEN_TOOL_MATERIALS)
                .add(SnailItems.FLINT_FLAKE)
                .add(SnailItems.FLINT_HATCHET);
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
