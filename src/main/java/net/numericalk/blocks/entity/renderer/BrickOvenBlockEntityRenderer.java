package net.numericalk.blocks.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.custom.BrickOvenBlockEntity;

import java.util.Random;

public class BrickOvenBlockEntityRenderer implements BlockEntityRenderer<BrickOvenBlockEntity> {
    public BrickOvenBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }
    Random random = new Random();
    @Override
    public void render(BrickOvenBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction facing = entity.getCachedState().get(CampfireBlock.FACING);
        ItemStack input_1 = entity.getStack(0);
        ItemStack input_2 = entity.getStack(1);
        ItemStack input_3 = entity.getStack(2);
        ItemStack input_4 = entity.getStack(3);
        ItemStack input_5 = entity.getStack(4);
        renderStackWith(input_1, 0.75f, 0.85f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input_2, 0.75f, 0.35f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input_3, 0.25f, 0.85f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input_4, 0.25f, 0.35f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input_5, 0.5f, 0.6f, entity, matrices, itemRenderer, vertexConsumers);
    }

    private void renderStackWith(ItemStack input, float x, float z, BrickOvenBlockEntity entity, MatrixStack matrices, ItemRenderer itemRenderer, VertexConsumerProvider vertexConsumers) {
        if (!input.isEmpty()){
            matrices.push();
            matrices.translate(x, 0.5f, z);
            matrices.scale(0.75f, 0.75f, 0.75f);
            matrices.multiply(RotationAxis.NEGATIVE_X.rotation((float) Math.PI / 2));

            itemRenderer.renderItem(input, ModelTransformationMode.GROUND,
                    getLightLevel(entity.getWorld(), entity.getPos()),
                    OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
            matrices.pop();
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
