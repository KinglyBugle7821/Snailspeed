package net.numericalk.snailspeed.utils.enums;

import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public enum SawCraftable {
    STAIRS,
    SLAB,
    DOOR,
    BED,
    FENCE,
    FENCE_GATE,
    CHEST,
    BARREL,
    PLANKS,
    HANGING_SIGN,
    SIGN,
    TRAPDOOR;

    public static final Codec<SawCraftable> CODEC = Codec.STRING.xmap(
            SawCraftable::valueOf,
            SawCraftable::name
    );


    public static final PacketCodec<RegistryByteBuf, SawCraftable> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public SawCraftable decode(RegistryByteBuf buf) {
            return buf.readEnumConstant(SawCraftable.class);
        }

        @Override
        public void encode(RegistryByteBuf buf, SawCraftable value) {
            buf.writeEnumConstant(value);
        }
    };
}
