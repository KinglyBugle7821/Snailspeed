package net.numericalk.snailspeed.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.FallingBlock;

public class CustomSoilBlock extends FallingBlock {
    public static final MapCodec<CustomSoilBlock> CODEC = CustomSoilBlock.createCodec(CustomSoilBlock::new);

    public CustomSoilBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return CODEC;
    }
}
