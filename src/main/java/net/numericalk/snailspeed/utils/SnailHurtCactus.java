package net.numericalk.snailspeed.utils;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.Blocks;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;

public class SnailHurtCactus {
    public static void cactusHurtAw(){

        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (state.isOf(Blocks.CACTUS)){
                if (world instanceof ServerWorld serverWorld){
                    RegistryEntry<DamageType> cactusDamage = serverWorld.getRegistryManager()
                            .getOrThrow(RegistryKeys.DAMAGE_TYPE)
                            .getEntry(Identifier.ofVanilla("cactus"))
                            .orElseThrow();
                    DamageSource cactusSource = new DamageSource(cactusDamage);

                    player.damage(serverWorld, cactusSource, 1);
                }
            }
            return true;
        });
    }
}
