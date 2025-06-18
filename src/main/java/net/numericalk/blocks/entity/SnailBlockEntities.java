package net.numericalk.blocks.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.Snailspeed;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.custom.*;

public class SnailBlockEntities {
    public static final BlockEntityType<CampfireBlockEntity> CAMPFIRE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "campfire_block_entity"),
                    FabricBlockEntityTypeBuilder.create(CampfireBlockEntity::new, SnailBlocks.CAMPFIRE_BASE).build(null));
    public static final BlockEntityType<GrassSheafBlockEntity> GRASS_SHEAF_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "grass_sheaf_block_entity"),
                    FabricBlockEntityTypeBuilder.create(GrassSheafBlockEntity::new, SnailBlocks.GRASS_SHEAF).build(null));
    public static final BlockEntityType<DriedGrassSheafBlockEntity> DRIED_GRASS_SHEAF_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_grass_sheaf_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedGrassSheafBlockEntity::new, SnailBlocks.DRIED_GRASS_SHEAF).build(null));
    public static final BlockEntityType<BrickOvenBlockEntity> BRICK_OVEN_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "brick_oven_block_entity"),
                    FabricBlockEntityTypeBuilder.create(BrickOvenBlockEntity::new, SnailBlocks.BRICK_OVEN).build(null));
    public static final BlockEntityType<ClayBrickBlockEntity> CLAY_BRICK_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "clay_brick_block_entity"),
                    FabricBlockEntityTypeBuilder.create(ClayBrickBlockEntity::new, SnailBlocks.CLAY_BRICK).build(null));
    public static final BlockEntityType<DriedClayBrickBlockEntity> DRIED_CLAY_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Snailspeed.MOD_ID, "dried_clay_brick_block_entity"),
                    FabricBlockEntityTypeBuilder.create(DriedClayBrickBlockEntity::new, SnailBlocks.DRIED_CLAY_BRICK).build(null));

    public static void initialize() {

    }
}
