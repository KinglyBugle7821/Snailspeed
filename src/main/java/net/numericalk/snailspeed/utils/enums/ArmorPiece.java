package net.numericalk.snailspeed.utils.enums;


import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public enum ArmorPiece {
    HELMET(3, 2, 4),
    CHESTPLATE(5, 4, 7),
    LEGGINGS(4, 3, 5),
    BOOTS(2, 1, 3);

    public final int plateCount;
    public final int bindingCount;
    public final int fastenerCount;

    ArmorPiece(int plateCount, int bindingCount, int fastenerCount) {
        this.plateCount = plateCount;
        this.bindingCount = bindingCount;
        this.fastenerCount = fastenerCount;
    }

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

