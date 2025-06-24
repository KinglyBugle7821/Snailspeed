package net.numericalk;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.numericalk.blocks.SnailBlocks;
import net.numericalk.blocks.entity.SnailBlockEntities;
import net.numericalk.blocks.entity.renderer.BrickFurnaceBlockEntityRenderer;
import net.numericalk.blocks.entity.renderer.BrickOvenBlockEntityRenderer;
import net.numericalk.blocks.entity.renderer.CampfireBlockEntityRenderer;
import net.numericalk.blocks.entity.renderer.MortarBlockEntityRenderer;
import net.numericalk.items.SnailItemGroup;
import net.numericalk.items.SnailItems;
import net.numericalk.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Snailspeed implements ModInitializer {
	public static final String MOD_ID = "snailspeed";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		SnailItems.initialize();
		SnailBlocks.initialize();
		SnailItemGroup.initialize();
		SnailBlockEntities.initialize();

		SnailLootTableMod.modifyLootTables();
		SnailWoodReplace.replaceWood();
		SnailLogStripping.logStripping();
		SnailBreakEvents.playerBreak();
		SnailSetBlockOnFire.SetOnFire();

		BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CAMPFIRE_BASE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CLAY_MOLD, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.DRIED_CLAY_MOLD, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.FIRED_CLAY_MOLD, RenderLayer.getTranslucent());

		BlockEntityRendererFactories.register(SnailBlockEntities.CAMPFIRE_BLOCK_ENTITY, CampfireBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_OVEN_BLOCK_ENTITY, BrickOvenBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(SnailBlockEntities.MORTAR_BLOCK_ENTITY, MortarBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_FURNACE_BLOCK_ENTITY, BrickFurnaceBlockEntityRenderer::new);


	}
}