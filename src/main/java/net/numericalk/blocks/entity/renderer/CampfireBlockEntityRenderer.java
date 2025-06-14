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
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.blocks.custom.CampfireBlock;
import net.numericalk.blocks.entity.custom.CampfireBlockEntity;

public class CampfireBlockEntityRenderer implements BlockEntityRenderer<CampfireBlockEntity> {
    public CampfireBlockEntityRenderer(BlockEntityRendererFactory.Context context){

    }

    @Override
    public void render(CampfireBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        Direction facing = entity.getCachedState().get(CampfireBlock.FACING);

        if (facing == Direction.NORTH || facing == Direction.SOUTH) {
            matrices.push();
            matrices.translate(0.5f, 0.9f, 0.5f);
            matrices.scale(0.75f, 0.75f, 0.75f);

            for (int i = 0; i < entity.size(); i++) {
                ItemStack stack = entity.getStack(i);
                if (!stack.isEmpty()) {
                    matrices.push();

                    float xOffset = (i - (entity.size() - 1) / 2f) * 0.25f;
                    matrices.translate(xOffset, 0f, 0f);

                    matrices.multiply(RotationAxis.NEGATIVE_Y.rotation((float) Math.PI / 2));

                    itemRenderer.renderItem(stack, ModelTransformationMode.GROUND,
                            getLightLevel(entity.getWorld(), entity.getPos()),
                            OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

                    matrices.pop();
                }
            }

            matrices.pop();
        }
        if (facing == Direction.WEST || facing == Direction.EAST) {
            matrices.push();
            matrices.translate(0.5f, 0.9f, 0.5f);
            matrices.scale(0.75f, 0.75f, 0.75f);

            for (int i = 0; i < entity.size(); i++) {
                ItemStack stack = entity.getStack(i);
                if (!stack.isEmpty()) {
                    matrices.push();

                    float yOffset = (i - (entity.size() - 1) / 2f) * 0.25f;
                    matrices.translate(0f, 0f, yOffset);

                    matrices.multiply(RotationAxis.NEGATIVE_Y.rotation((float) Math.PI));

                    itemRenderer.renderItem(stack, ModelTransformationMode.GROUND,
                            getLightLevel(entity.getWorld(), entity.getPos()),
                            OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);

                    matrices.pop();
                }
            }

            matrices.pop();
        }
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
