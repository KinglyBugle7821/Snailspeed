package net.numericalk.snailspeed;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.numericalk.snailspeed.advancement.SnailCriteria;
import net.numericalk.snailspeed.blocks.SnailBlocks;
import net.numericalk.snailspeed.blocks.entity.SnailBlockEntities;
import net.numericalk.snailspeed.items.SnailItemGroup;
import net.numericalk.snailspeed.items.SnailItems;
import net.numericalk.snailspeed.networking.SnailNetworkingBrain;
import net.numericalk.snailspeed.networking.packets.ArmorSelectPayload;
import net.numericalk.snailspeed.networking.packets.SawSelectRecipePayload;
import net.numericalk.snailspeed.networking.packets.WeaponSelectPayload;
import net.numericalk.snailspeed.recipe.SnailRecipe;
import net.numericalk.snailspeed.screen.SnailScreenHandlers;
import net.numericalk.snailspeed.utils.*;
import net.numericalk.snailspeed.world.gen.SnailWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Snailspeed implements ModInitializer {
    public static final String MOD_ID = "snailspeed";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {

        SnailItems.initialize();
        SnailBlocks.initialize();
        SnailRecipe.initialize();
        SnailCriteria.initialize();
        SnailItemGroup.initialize();
        SnailBlockEntities.initialize();
        SnailScreenHandlers.initialize();

        SnailWorldGen.generateModdedWorldGen();

        SnailLootTableMod.modifyLootTables();
        SnailLogStripping.logStripping();
        SnailSetBlockOnFire.SetOnFire();
        SnailWoodReplace.replaceWood();
        SnailBreakEvents.playerBreak();


        PayloadTypeRegistry.playC2S().register(ArmorSelectPayload.ARMOR_SELECT_PACKET_ID, ArmorSelectPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(ArmorSelectPayload.ARMOR_SELECT_PACKET_ID, ArmorSelectPayload.CODEC);

        PayloadTypeRegistry.playC2S().register(SawSelectRecipePayload.SAW_CRAFTABLE_RECIPE_PAYLOAD, SawSelectRecipePayload.CODEC);
        PayloadTypeRegistry.playS2C().register(SawSelectRecipePayload.SAW_CRAFTABLE_RECIPE_PAYLOAD, SawSelectRecipePayload.CODEC);

        PayloadTypeRegistry.playC2S().register(WeaponSelectPayload.WEAPON_SELECT_PAYLOAD_ID, WeaponSelectPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(WeaponSelectPayload.WEAPON_SELECT_PAYLOAD_ID, WeaponSelectPayload.CODEC);

        SnailNetworkingBrain.registerC2SPackets();
    }

    public static int getLightLevel(World world, BlockPos pos) {
        int blockLight = world.getLightLevel(LightType.BLOCK, pos);
        int skyLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(blockLight, skyLight);
    }
}