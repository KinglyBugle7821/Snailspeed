package net.numericalk.snailspeed.misc;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.numericalk.snailspeed.Snailspeed;

public class SnailComponent {

    public static final ComponentType<Float> BURNING_ITEM = Registry.register(
            Registries.DATA_COMPONENT_TYPE,
            Identifier.of(Snailspeed.MOD_ID, "burning_time"),
            ComponentType.<Float>builder().codec(Codec.FLOAT).build()
    );
    public static void initialize() {}
}
