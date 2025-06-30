package net.numericalk.snailspeed.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocksBrain;
import net.numericalk.snailspeed.blocks.entity.custom.*;

public class SnailBlockEntities {
    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "campfire_block_entity"),
                    FabricBlockEntityTypeBuilder.create(CampfireBlockEntity::new, SnailBlocksBrain.CAMPFIRE_BASE).build(null));
    public static final BlockEntityType<GrassSheafBlockEntity> GRASS_SHEAF_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "grass_sheaf_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GrassSheafBlockEntity::new, SnailBlocksBrain.GRASS_SHEAF).build(null));
    public static final BlockEntityType<DriedGrassSheafBlockEntity> DRIED_GRASS_SHEAF_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_grass_sheaf_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedGrassSheafBlockEntity::new, SnailBlocksBrain.DRIED_GRASS_SHEAF).build(null));
    public static final BlockEntityType<BrickOvenBlockEntity> BRICK_OVEN_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_oven_block_entity"),
                    FabricBlockEntityTypeBuilder.create(BrickOvenBlockEntity::new, SnailBlocksBrain.BRICK_OVEN).build(null));
    public static final BlockEntityType<ClayBrickBlockEntity> CLAY_BRICK_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "clay_brick_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ClayBrickBlockEntity::new, SnailBlocksBrain.CLAY_BRICK).build(null));
    public static final BlockEntityType<DriedClayBrickBlockEntity> DRIED_CLAY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_clay_brick_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedClayBrickBlockEntity::new, SnailBlocksBrain.DRIED_CLAY_BRICK).build(null));
    public static final BlockEntityType<MortarBlockEntity> MORTAR_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "mortar_block_entity"),
                    FabricBlockEntityTypeBuilder.create(MortarBlockEntity::new, SnailBlocksBrain.MORTAR).build(null));
    public static final BlockEntityType<ClayCrucibleBlockEntity> CLAY_CRUCIBLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "clay_crucible_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ClayCrucibleBlockEntity::new, SnailBlocksBrain.CLAY_CRUCIBLE).build(null));
    public static final BlockEntityType<DriedClayCrucibleBlockEntity> DRIED_CLAY_CRUCIBLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_clay_crucible_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedClayCrucibleBlockEntity::new, SnailBlocksBrain.DRIED_CLAY_CRUCIBLE).build(null));
    public static final BlockEntityType<BrickFurnaceBlockEntity> BRICK_FURNACE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_furnace_block_entity"),
                    FabricBlockEntityTypeBuilder.create(BrickFurnaceBlockEntity::new, SnailBlocksBrain.BRICK_FURNACE).build(null));
    public static final BlockEntityType<ClayMoldBlockEntity> CLAY_MOLD_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "clay_mold_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ClayMoldBlockEntity::new, SnailBlocksBrain.CLAY_MOLD).build(null));
    public static final BlockEntityType<DriedClayMoldBlockEntity> DRIED_CLAY_MOLD_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_clay_mold_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedClayMoldBlockEntity::new, SnailBlocksBrain.DRIED_CLAY_MOLD).build(null));
    public static final BlockEntityType<ResinBowlBlockEntity> RESIN_BOWL_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "resin_bowl_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ResinBowlBlockEntity::new, SnailBlocksBrain.RESIN_BOWL).build(null));
    public static final BlockEntityType<FilteringTrayBlockEntity>  FILTERING_TRAY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "filtering_tray_block_entity"),
                    FabricBlockEntityTypeBuilder.create(FilteringTrayBlockEntity::new, SnailBlocksBrain.FILTERING_TRAY).build(null));
    public static final BlockEntityType<ArmorForgeBlockEntity>  ARMOR_FORGE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "armor_forge_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ArmorForgeBlockEntity::new, SnailBlocksBrain.ARMOR_FORGE).build(null));
    public static final BlockEntityType<SmallBarrelBlockEntity> SMALL_BARREL_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "small_barrel_block_entity"),
                    FabricBlockEntityTypeBuilder.create(SmallBarrelBlockEntity::new, SnailBlocksBrain.SMALL_BARREL).build(null));
    public static final BlockEntityType<SawTableBlockEntity> SAW_TABLE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "saw_table_block_entity"),
                    FabricBlockEntityTypeBuilder.create(SawTableBlockEntity::new, SnailBlocksBrain.SAW_TABLE).build(null));

    public static void initialize() {}
}
