package net.numericalk.snailspeed.utils.enums;


import com.mojang.serialization.MapCodec;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.math.BlockPos;

public enum ArmorPiece {
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS;

    public static final PacketCodec<RegistryByteBuf, ArmorPiece> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public ArmorPiece decode(RegistryByteBuf buf) {
            return buf.readEnumConstant(ArmorPiece.class);
        }

        @Override
        public void encode(RegistryByteBuf buf, ArmorPiece value) {
            buf.writeEnumConstant(value);
        }
    };
}

