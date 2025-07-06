package net.numericalk.snailspeed.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.custom.*;

public class SnailBlockEntities {
    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE = registerBlockEntityType("campfire",
            FabricBlockEntityTypeBuilder.create(CampfireBlockEntity::new, SnailBlocks.CAMPFIRE_BASE).build());
    public static final BlockEntityType<GrassSheafBlockEntity> GRASS_SHEAF = registerBlockEntityType("grass_sheaf",
            FabricBlockEntityTypeBuilder.create(GrassSheafBlockEntity::new, SnailBlocks.GRASS_SHEAF).build());
    public static final BlockEntityType<DriedGrassSheafBlockEntity> DRIED_GRASS_SHEAF = registerBlockEntityType("dried_grass_sheaf",
            FabricBlockEntityTypeBuilder.create(DriedGrassSheafBlockEntity::new, SnailBlocks.DRIED_GRASS_SHEAF).build());
    public static final BlockEntityType<BrickOvenBlockEntity> BRICK_OVEN = registerBlockEntityType("brick_oven",
            FabricBlockEntityTypeBuilder.create(BrickOvenBlockEntity::new, SnailBlocks.BRICK_OVEN).build());
    public static final BlockEntityType<ClayBrickBlockEntity> CLAY_BRICK = registerBlockEntityType("clay_brick",
            FabricBlockEntityTypeBuilder.create(ClayBrickBlockEntity::new, SnailBlocks.CLAY_BRICK).build());
    public static final BlockEntityType<DriedClayBrickBlockEntity> DRIED_CLAY = registerBlockEntityType("dried_clay_brick",
            FabricBlockEntityTypeBuilder.create(DriedClayBrickBlockEntity::new, SnailBlocks.DRIED_CLAY_BRICK).build());
    public static final BlockEntityType<MortarBlockEntity> MORTAR = registerBlockEntityType("mortar",
            FabricBlockEntityTypeBuilder.create(MortarBlockEntity::new, SnailBlocks.MORTAR).build());
    public static final BlockEntityType<ClayCrucibleBlockEntity> CLAY_CRUCIBLE = registerBlockEntityType("clay_crucible",
            FabricBlockEntityTypeBuilder.create(ClayCrucibleBlockEntity::new, SnailBlocks.CLAY_CRUCIBLE).build());
    public static final BlockEntityType<DriedClayCrucibleBlockEntity> DRIED_CLAY_CRUCIBLE = registerBlockEntityType("dried_clay_crucible",
            FabricBlockEntityTypeBuilder.create(DriedClayCrucibleBlockEntity::new, SnailBlocks.DRIED_CLAY_CRUCIBLE).build());
    public static final BlockEntityType<BrickFurnaceBlockEntity> BRICK_FURNACE = registerBlockEntityType("brick_furnace",
            FabricBlockEntityTypeBuilder.create(BrickFurnaceBlockEntity::new, SnailBlocks.BRICK_FURNACE).build());
    public static final BlockEntityType<ClayMoldBlockEntity> CLAY_MOLD = registerBlockEntityType("clay_mold",
            FabricBlockEntityTypeBuilder.create(ClayMoldBlockEntity::new, SnailBlocks.CLAY_MOLD).build());
    public static final BlockEntityType<DriedClayMoldBlockEntity> DRIED_CLAY_MOLD = registerBlockEntityType("dried_clay_mold",
            FabricBlockEntityTypeBuilder.create(DriedClayMoldBlockEntity::new, SnailBlocks.DRIED_CLAY_MOLD).build());
    public static final BlockEntityType<ResinBowlBlockEntity> RESIN_BOWL = registerBlockEntityType("resin_bowl",
            FabricBlockEntityTypeBuilder.create(ResinBowlBlockEntity::new, SnailBlocks.RESIN_BOWL).build());
    public static final BlockEntityType<FilteringTrayBlockEntity> FILTERING_TRAY = registerBlockEntityType("filtering_tray",
            FabricBlockEntityTypeBuilder.create(FilteringTrayBlockEntity::new, SnailBlocks.FILTERING_TRAY).build());
    public static final BlockEntityType<ArmorForgeBlockEntity> ARMOR_FORGE = registerBlockEntityType("armor_forge",
            FabricBlockEntityTypeBuilder.create(ArmorForgeBlockEntity::new, SnailBlocks.ARMOR_FORGE).build());
    public static final BlockEntityType<SmallBarrelBlockEntity> SMALL_BARREL = registerBlockEntityType("small_barrel",
            FabricBlockEntityTypeBuilder.create(SmallBarrelBlockEntity::new, SnailBlocks.SMALL_BARREL).build());
    public static final BlockEntityType<SawTableBlockEntity> SAW_TABLE = registerBlockEntityType("saw_table",
            FabricBlockEntityTypeBuilder.create(SawTableBlockEntity::new, SnailBlocks.SAW_TABLE).build());
    public static final BlockEntityType<CustomTorchBlockEntity> TORCH = registerBlockEntityType("torch",
            FabricBlockEntityTypeBuilder.create(CustomTorchBlockEntity::new, SnailBlocks.TORCH).build());
    public static final BlockEntityType<CustomWallTorchBlockEntity> WALL_TORCH = registerBlockEntityType("wall_torch",
            FabricBlockEntityTypeBuilder.create(CustomWallTorchBlockEntity::new, SnailBlocks.WALL_TORCH).build());
    public static final BlockEntityType<WeaponForgeBlockEntity> WEAPON_FORGE = registerBlockEntityType("weapon_forge",
            FabricBlockEntityTypeBuilder.create(WeaponForgeBlockEntity::new, SnailBlocks.WEAPON_FORGE).build());

    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntityType(String id, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, id), type);
    }

    public static void initialize() {}
}