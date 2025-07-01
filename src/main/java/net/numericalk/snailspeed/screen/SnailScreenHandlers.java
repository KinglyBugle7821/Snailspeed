package net.numericalk.snailspeed.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.numericalk.snailspeed.Snailspeed;
import net.numericalk.snailspeed.screen.custom.ArmorForgeScreenHandler;
import net.numericalk.snailspeed.screen.custom.SawTableScreenHandler;
import net.numericalk.snailspeed.screen.custom.SmallBarrelScreenHandler;

public class SnailScreenHandlers {
    public static final ScreenHandlerType<ArmorForgeScreenHandler> ARMOR_FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Snailspeed.MOD_ID, "armor_forge_screen_handler"),
                    new ExtendedScreenHandlerType<>(ArmorForgeScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<SmallBarrelScreenHandler> SMALL_BARREL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Snailspeed.MOD_ID, "small_barrel_screen_handler"),
                    new ExtendedScreenHandlerType<>(SmallBarrelScreenHandler::new, BlockPos.PACKET_CODEC));
    public static final ScreenHandlerType<SawTableScreenHandler> SAW_TABLE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Snailspeed.MOD_ID, "saw_table_screen_handler"),
                    new ExtendedScreenHandlerType<>(SawTableScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void initialize() {}
}
