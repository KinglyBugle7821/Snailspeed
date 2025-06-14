package net.numericalk.items;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterial;
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

    public static final Item TINDER = register("tinder", settings -> new TinderItem(settings.maxCount(1)));
    public static final Item BURNING_TINDER = register("burning_tinder", settings -> new TinderItem(settings.maxCount(1)));
    public static final Item BURNT_TINDER = register("burnt_tinder", settings -> new TinderItem(settings.maxCount(1)));

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
