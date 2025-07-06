package net.numericalk.snailspeed.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.blocks.entity.custom.ArmorForgeBlockEntity;
import net.numericalk.snailspeed.blocks.entity.custom.FilteringTrayBlockEntity;
import net.numericalk.snailspeed.blocks.entity.custom.SawTableBlockEntity;
import net.numericalk.snailspeed.blocks.entity.custom.WeaponForgeBlockEntity;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.networking.packets.ArmorSelectPayload;
import net.numericalk.snailspeed.networking.packets.SawSelectRecipePayload;
import net.numericalk.snailspeed.networking.packets.WeaponSelectPayload;
import net.numericalk.snailspeed.recipe.custom.FilteringTrayRecipe;
import net.numericalk.snailspeed.utils.enums.ArmorPiece;
import net.numericalk.snailspeed.utils.enums.SawCraftable;
import net.numericalk.snailspeed.utils.enums.WeaponPiece;

import java.util.Optional;

public class SnailNetworkingBrain {
    public static final Identifier ARMOR_FORGE_ID = Identifier.of(Snailspeed.MOD_ID, "armor_forge_crafting");
    public static final Identifier SAW_RECIPE_ID = Identifier.of(Snailspeed.MOD_ID, "saw_table_crafting");
    public static final Identifier WEAPON_RECIPE_ID = Identifier.of(Snailspeed.MOD_ID, "weapon_forge_crafting");

    public static void registerC2SPackets() {
        ServerPlayNetworking.registerGlobalReceiver(
                ArmorSelectPayload.ARMOR_SELECT_PACKET_ID,
                (payload, context) -> {
                    ServerPlayerEntity player = context.player();
                    BlockPos pos = payload.pos();
                    ArmorPiece selected = payload.armorPiece();

                    player.server.execute(() -> {
                        if (player.getWorld().getBlockEntity(pos) instanceof ArmorForgeBlockEntity be) {
                            be.setSelectedPiece(selected);
                        }
                    });
                }
        );

        ServerPlayNetworking.registerGlobalReceiver(
                SawSelectRecipePayload.SAW_CRAFTABLE_RECIPE_PAYLOAD,
                ((sawSelectRecipePayload, context) -> {
                    ServerPlayerEntity player = context.player();
                    BlockPos pos = sawSelectRecipePayload.pos();
                    SawCraftable selected = sawSelectRecipePayload.sawCraftable();

                    player.server.execute(() -> {
                        if (player.getWorld().getBlockEntity(pos) instanceof SawTableBlockEntity be) {
                            be.setSelectedPiece(selected);
                        }
                    });
                })
        );
        ServerPlayNetworking.registerGlobalReceiver(
                WeaponSelectPayload.WEAPON_SELECT_PAYLOAD_ID,
                ((WeaponSelectPayload, context) -> {
                    ServerPlayerEntity player = context.player();
                    BlockPos pos = WeaponSelectPayload.pos();
                    WeaponPiece selected = WeaponSelectPayload.weaponPiece();

                    player.server.execute(() -> {
                        if (player.getWorld().getBlockEntity(pos) instanceof WeaponForgeBlockEntity be) {
                            be.setSelectedPiece(selected);
                        }
                    });
                })
        );
    }
    public static void registerS2CPacket() {

    }
}