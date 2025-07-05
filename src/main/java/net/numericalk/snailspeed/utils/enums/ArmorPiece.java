package net.numericalk.snailspeed.utils.enums;


import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public enum ArmorPiece {
    HELMET(),
    CHESTPLATE(),
    LEGGINGS(),
    BOOTS();

    public final int plateCount;
    public final int bindingCount;
    public final int fastenerCount;

    ArmorPiece() {
        this.plateCount = 1;
        this.bindingCount = 1;
        this.fastenerCount = 1;
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

