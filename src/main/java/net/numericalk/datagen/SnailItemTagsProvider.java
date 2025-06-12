package net.numericalk.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
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

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(FLINT_FLAKE_REPAIRABLE)
                .add(Items.FLINT);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(SnailItems.FLINT_FLAKE);
        getOrCreateTagBuilder(ItemTags.WOODEN_TOOL_MATERIALS)
                .add(SnailItems.FLINT_FLAKE);
    }
}
