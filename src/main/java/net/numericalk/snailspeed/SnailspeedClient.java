package net.numericalk.snailspeed;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.blocks.entity.renderer.*;
import net.numericalk.snailspeed.networking.SnailNetworkingBrain;
import net.numericalk.snailspeed.networking.packets.ArmorSelectPayload;
import net.numericalk.snailspeed.networking.packets.SawSelectRecipePayload;
import net.numericalk.snailspeed.screen.SnailScreenHandlers;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreen;
import net.numericalk.snailspeed.screen.custom.SawTableScreen;
import net.numericalk.snailspeed.screen.custom.SmallBarrelScreen;

public class SnailspeedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CAMPFIRE_BASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.FILTERING_TRAY, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.CLAY_MOLD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.DRIED_CLAY_MOLD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.FIRED_CLAY_MOLD, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(SnailBlocks.SAW_TABLE, RenderLayer.getCutout());

        BlockEntityRendererFactories.register(SnailBlockEntities.CAMPFIRE, CampfireBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_OVEN, BrickOvenBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.MORTAR, MortarBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.BRICK_FURNACE, BrickFurnaceBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(SnailBlockEntities.FILTERING_TRAY, FilteringTrayBlockEntityRenderer::new);

        HandledScreens.register(SnailScreenHandlers.ARMOR_FORGE_SCREEN_HANDLER, ArmorForgeScreen::new);
        HandledScreens.register(SnailScreenHandlers.SMALL_BARREL_SCREEN_HANDLER, SmallBarrelScreen::new);
        HandledScreens.register(SnailScreenHandlers.SAW_TABLE_SCREEN_HANDLER, SawTableScreen::new);


        SnailNetworkingBrain.registerS2CPacket();

        ClientPlayNetworking.registerGlobalReceiver(
                ArmorSelectPayload.ARMOR_SELECT_PACKET_ID,
                (payload, context) -> {

                }
        );

        ClientPlayNetworking.registerGlobalReceiver(SawSelectRecipePayload.SAW_CRAFTABLE_RECIPE_PAYLOAD,
                (payload, context) -> {

                }
        );
    }
}