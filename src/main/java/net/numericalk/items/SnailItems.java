package net.numericalk.items;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.items.custom.TinderItem;
import net.numericalk.utils.SnailToolMaterial;

import java.util.function.Function;

public class SnailItems {

    public static final Item OAK_LOG_BARK = register("oak_log_bark", Item::new);
    public static final Item SPRUCE_LOG_BARK = register("spruce_log_bark", Item::new);
    public static final Item BIRCH_LOG_BARK = register("birch_log_bark", Item::new);
    public static final Item JUNGLE_LOG_BARK = register("jungle_log_bark", Item::new);
    public static final Item ACACIA_LOG_BARK = register("acacia_log_bark", Item::new);
    public static final Item DARK_OAK_LOG_BARK = register("dark_oak_log_bark", Item::new);
    public static final Item MANGROVE_LOG_BARK = register("mangrove_log_bark", Item::new);
    public static final Item CHERRY_LOG_BARK = register("cherry_log_bark", Item::new);
    public static final Item PALE_OAK_LOG_BARK = register("pale_oak_log_bark", Item::new);

    public static final Item CRIMSON_STEM_BARK = register("crimson_stem_bark", Item::new);
    public static final Item WARPED_STEM_BARK = register("warped_stem_bark", Item::new);

    public static final Item WOOD_DUST = register("wood_dust", Item::new);

    public static final Item FLINT_FLAKE = register("flint_flake", settings -> new AxeItem(SnailToolMaterial.FLINT_MATERIAL, 0f, -2.4f, settings), new Item.Settings());
    public static final Item FLINT_HATCHET = register("flint_hatchet", settings -> new AxeItem(SnailToolMaterial.FLINT_TOOL_MATERIAL, 1f, -2.4f, settings), new Item.Settings());
    public static final Item FLINT_PICKAXE = register("flint_pickaxe", settings -> new PickaxeItem(SnailToolMaterial.FLINT_TOOL_MATERIAL, 1f, -2.0f, settings), new Item.Settings());

    public static final Item TINDER = register("tinder", settings -> new TinderItem(settings.maxCount(1)));
    public static final Item BURNING_TINDER = register("burning_tinder", settings -> new TinderItem(settings.maxCount(1)));
    public static final Item BURNT_TINDER = register("burnt_tinder", Item::new);

    public static final Item BURNT_POTATO = register("burnt_potato", Item::new);
    public static final Item BURNT_POPPED_CHORUS_FRUIT = register("burnt_popped_chorus_fruit", Item::new);
    public static final Item BURNT_CHICKEN = register("burnt_chicken", Item::new);
    public static final Item BURNT_COD = register("burnt_cod", Item::new);
    public static final Item BURNT_MUTTON = register("burnt_mutton", Item::new);
    public static final Item BURNT_PORKCHOP = register("burnt_porkchop", Item::new);
    public static final Item BURNT_RABBIT = register("burnt_rabbit", Item::new);
    public static final Item BURNT_SALMON = register("burnt_salmon", Item::new);
    public static final Item BURNT_KELP = register("burnt_kelp", Item::new);
    public static final Item BURNT_BEEF = register("burnt_beef", Item::new);

    public static final Item GRASS_TWINE = register("grass_twine", Item::new);

    public static final Item PEBBLE = register("pebble", Item::new);
    public static final Item STONE_DUST = register("stone_dust", Item::new);

    private static Item register(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Snailspeed.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, name)))));
    }
    private static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Snailspeed.MOD_ID, name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static void initialize() {
    }
}
