package net.numericalk.snailspeed.networking.packets;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.networking.SnailNetworkingBrain;
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import net.numericalk.snailspeed.utils.enums.WeaponPiece;

public record WeaponSelectPayload(BlockPos pos, WeaponPiece weaponPiece) implements CustomPayload {

    public static final CustomPayload.Id<WeaponSelectPayload> WEAPON_SELECT_PAYLOAD_ID = new CustomPayload.Id<>(SnailNetworkingBrain.WEAPON_RECIPE_ID);
    public static final PacketCodec<RegistryByteBuf, WeaponSelectPayload> CODEC = PacketCodec.tuple(
            BlockPos.PACKET_CODEC, WeaponSelectPayload::pos,
            WeaponPiece.PACKET_CODEC, WeaponSelectPayload::weaponPiece,
            WeaponSelectPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return WEAPON_SELECT_PAYLOAD_ID;
    }
}
