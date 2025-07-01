package net.numericalk.snailspeed.blocks.entity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.RotationAxis;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.entity.custom.FilteringTrayBlockEntity;

public class FilteringTrayBlockEntityRenderer implements BlockEntityRenderer<FilteringTrayBlockEntity> {
    public FilteringTrayBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {

    }
    @Override
    public void render(FilteringTrayBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack input1 = entity.getStack(0);
        ItemStack input2 = entity.getStack(1);
        ItemStack input3 = entity.getStack(2);
        ItemStack input4 = entity.getStack(3);
        renderStackWith(input1, 0.9f,  entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input2, 0.95f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input3, 1.0f, entity, matrices, itemRenderer, vertexConsumers);
        renderStackWith(input4, 1.05f, entity, matrices, itemRenderer, vertexConsumers);
    }

    private void renderStackWith(ItemStack input, float y, FilteringTrayBlockEntity entity, MatrixStack matrices, ItemRenderer itemRenderer, VertexConsumerProvider vertexConsumers) {
        if (!input.isEmpty()) {
            matrices.push();
            matrices.translate(0.5f, y, 0.6f);
            matrices.scale(1f, 1f, 1f);
            matrices.multiply(RotationAxis.NEGATIVE_X.rotation((float) Math.PI / 2));

            itemRenderer.renderItem(input, ModelTransformationMode.GROUND,
                    Snailspeed.getLightLevel(entity.getWorld(), entity.getPos()),
                    OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
            matrices.pop();
        }
    }
}
