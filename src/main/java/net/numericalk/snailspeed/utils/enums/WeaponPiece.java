package net.numericalk.snailspeed.utils.enums;

import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;

public enum WeaponPiece {
    SWORD,
    AXE,
    PICKAXE,
    SHOVEL,
    HOE,
    BOW,
    CROSSBOW,
    ARROW;

    public static final Codec<SawCraftable> CODEC = Codec.STRING.xmap(
            SawCraftable::valueOf,
            SawCraftable::name
    );


    public static final PacketCodec<RegistryByteBuf, WeaponPiece> PACKET_CODEC = new PacketCodec<>() {
        @Override
        public WeaponPiece decode(RegistryByteBuf buf) {
            return buf.readEnumConstant(WeaponPiece.class);
        }

        @Override
        public void encode(RegistryByteBuf buf, WeaponPiece value) {
            buf.writeEnumConstant(value);
        }
    };
}
