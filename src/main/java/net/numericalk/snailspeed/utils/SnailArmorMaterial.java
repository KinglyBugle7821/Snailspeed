package net.numericalk.snailspeed.utils;

import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.datagen.SnailItemTagsProvider;

import java.util.Map;

public class SnailArmorMaterial {
    public static final RegistryKey<EquipmentAsset> COPPER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Snailspeed.MOD_ID, "copper"));
    public static final RegistryKey<EquipmentAsset> BRONZE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Snailspeed.MOD_ID, "bronze"));
    public static final RegistryKey<EquipmentAsset> STEEL_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(Snailspeed.MOD_ID, "steel"));

    public static final int COPPER_DURABILITY = 11;
    public static final int BRONZE_DURABILITY = 13;
    public static final int STEEL_DURABILITY = 33;
    public static final ArmorMaterial COPPER_ARMOR = new ArmorMaterial(
            COPPER_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 3,
                    EquipmentType.LEGGINGS, 2,
                    EquipmentType.BOOTS, 1
            ),
            12,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            SnailItemTagsProvider.COPPER_TOOL_REPAIRABLE,
            COPPER_ARMOR_MATERIAL_KEY
    );
    public static final ArmorMaterial BRONZE_ARMOR = new ArmorMaterial(
            BRONZE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 2,
                    EquipmentType.CHESTPLATE, 5,
                    EquipmentType.LEGGINGS, 3,
                    EquipmentType.BOOTS, 2
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            SnailItemTagsProvider.BRONZE_TOOL_REPAIRABLE,
            BRONZE_ARMOR_MATERIAL_KEY
    );
    public static final ArmorMaterial STEEL_ARMOR = new ArmorMaterial(
            STEEL_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            10,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            2.0F,
            0.0F,
            SnailItemTagsProvider.STEEL_TOOL_REPAIRABLE,
            STEEL_ARMOR_MATERIAL_KEY
    );
}
