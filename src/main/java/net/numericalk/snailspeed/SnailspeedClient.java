package net.numericalk.snailspeed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.renderer.*;

public class SnailspeedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CAMPFIRE_BASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.FILTERING_TRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CLAY_MOLD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.DRIED_CLAY_MOLD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.FIRED_CLAY_MOLD, RenderLayer.getTranslucent());

        BlockEntityRendererFactories.register(SnailBlockEntities.CAMPFIRE_BLOCK_ENTITY, CampfireBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_OVEN_BLOCK_ENTITY, BrickOvenBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.MORTAR_BLOCK_ENTITY, MortarBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_FURNACE_BLOCK_ENTITY, BrickFurnaceBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.FILTERING_TRAY_BLOCK_ENTITY, FilteringTrayBlockEntityRenderer::new);
    }
}
