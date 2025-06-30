package net.numericalk.snailspeed.networking.packets;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.networking.SnailNetworkingBrain;
import net.numericalk.snailspeed.utils.enums.SawCraftable;

public record SawSelectRecipePayload(BlockPos pos, SawCraftable sawCraftable) implements CustomPayload {
    public static final CustomPayload.Id<SawSelectRecipePayload> SAW_CRAFTABLE_RECIPE_PAYLOAD = new CustomPayload.Id<>(SnailNetworkingBrain.SAW_RECIPE_ID);
    public static final PacketCodec<RegistryByteBuf, SawSelectRecipePayload> CODEC = PacketCodec.tuple(
            BlockPos.PACKET_CODEC, SawSelectRecipePayload::pos,
            SawCraftable.PACKET_CODEC, SawSelectRecipePayload::sawCraftable,
            SawSelectRecipePayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return SAW_CRAFTABLE_RECIPE_PAYLOAD;
    }
}
