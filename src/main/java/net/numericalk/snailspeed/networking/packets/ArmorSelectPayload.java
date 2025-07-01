package net.numericalk.snailspeed.networking.packets;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.networking.SnailNetworkingBrain;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;

public record ArmorSelectPayload(BlockPos pos, ArmorPiece armorPiece) implements CustomPayload {
    public static final CustomPayload.Id<ArmorSelectPayload> ARMOR_SELECT_PACKET_ID = new CustomPayload.Id<>(SnailNetworkingBrain.ARMOR_FORGE_ID);
    public static final PacketCodec<RegistryByteBuf, ArmorSelectPayload> CODEC = PacketCodec.tuple(
            BlockPos.PACKET_CODEC, ArmorSelectPayload::pos,
            ArmorPiece.PACKET_CODEC, ArmorSelectPayload::armorPiece,
            ArmorSelectPayload::new
    );
    @Override
    public Id<? extends CustomPayload> getId() {
        return ARMOR_SELECT_PACKET_ID;
    }
}

