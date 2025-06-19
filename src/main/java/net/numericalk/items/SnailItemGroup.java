package net.numericalk.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.blocks.SnailBlocks;

public class SnailItemGroup {
    public static final ItemGroup SNAILSPEED_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Snailspeed.MOD_ID, "snailspeed_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(SnailItems.OAK_LOG_BARK))
                    .displayName(Text.translatable("itemgroup.snailspeed"))
                    .entries((displayContext, entries) -> {
                        entries.add(SnailItems.OAK_LOG_BARK);
                        entries.add(SnailItems.SPRUCE_LOG_BARK);
                        entries.add(SnailItems.BIRCH_LOG_BARK);
                        entries.add(SnailItems.JUNGLE_LOG_BARK);
                        entries.add(SnailItems.ACACIA_LOG_BARK);
                        entries.add(SnailItems.DARK_OAK_LOG_BARK);
                        entries.add(SnailItems.MANGROVE_LOG_BARK);
                        entries.add(SnailItems.CHERRY_LOG_BARK);
                        entries.add(SnailItems.PALE_OAK_LOG_BARK);
                        entries.add(SnailItems.CRIMSON_STEM_BARK);
                        entries.add(SnailItems.WARPED_STEM_BARK);

                        entries.add(SnailItems.WOOD_DUST);
                        entries.add(SnailItems.FLINT_HATCHET);
                        entries.add(SnailItems.FLINT_PICKAXE);

                        entries.add(SnailItems.FLINT_FLAKE);

                        entries.add(SnailBlocks.CAMPFIRE_BASE);
                        entries.add(SnailBlocks.BRICK_OVEN_BASE);
                        entries.add(SnailBlocks.BRICK_OVEN);

                        entries.add(SnailBlocks.GRASS_SHEAF);
                        entries.add(SnailBlocks.DRIED_GRASS_SHEAF);
                        entries.add(SnailBlocks.CLAY_BRICK);
                        entries.add(SnailBlocks.DRIED_CLAY_BRICK);

                        entries.add(SnailBlocks.FIRED_BRICK);

                        entries.add(SnailBlocks.UNTIED_STICK_BUNDLE);
                        entries.add(SnailBlocks.STICK_BUNDLE);
                        entries.add(SnailBlocks.UNTIED_THATCH_BLOCK);
                        entries.add(SnailBlocks.THATCH_BLOCK);

                        entries.add(SnailBlocks.UNSTEADY_DIRT);
                        entries.add(SnailBlocks.UNSTEADY_COARSE_DIRT);

                        entries.add(SnailBlocks.SCRATCHED_STONE);
                        entries.add(SnailBlocks.CRACKED_STONE);
                        entries.add(SnailBlocks.FRACTURED_STONE);
                        entries.add(SnailBlocks.CRUMBLED_STONE);
                        entries.add(SnailBlocks.SCRATCHED_DEEPSLATE);
                        entries.add(SnailBlocks.CRACKED_DEEPSLATE);
                        entries.add(SnailBlocks.FRACTURED_DEEPSLATE);
                        entries.add(SnailBlocks.CRUMBLED_DEEPSLATE);

                        entries.add(SnailItems.TINDER);
                        entries.add(SnailItems.BURNING_TINDER);
                        entries.add(SnailItems.BURNT_TINDER);

                        entries.add(SnailItems.BURNT_POTATO);
                        entries.add(SnailItems.BURNT_POPPED_CHORUS_FRUIT);
                        entries.add(SnailItems.BURNT_CHICKEN);
                        entries.add(SnailItems.BURNT_COD);
                        entries.add(SnailItems.BURNT_MUTTON);
                        entries.add(SnailItems.BURNT_PORKCHOP);
                        entries.add(SnailItems.BURNT_RABBIT);
                        entries.add(SnailItems.BURNT_SALMON);
                        entries.add(SnailItems.BURNT_KELP);
                        entries.add(SnailItems.BURNT_BEEF);

                        entries.add(SnailItems.GRASS_TWINE);
                        entries.add(SnailItems.PEBBLE);
                    }).build());
    public static void initialize() {}


}
