package com.robertx22.mine_and_slash.onevent.entity;

import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.packets.BossPacket;
import com.robertx22.mine_and_slash.packets.EfficientMobUnitPacket;
import com.robertx22.mine_and_slash.packets.EntityUnitPacket;
import com.robertx22.mine_and_slash.uncommon.capability.entity.BossCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OnTrackEntity {

    @SubscribeEvent
    public static void onEntityTrack(PlayerEvent.StartTracking event) {

        Entity entity = event.getTarget();

        try {
            if (entity instanceof LivingEntity) {

                if (entity.isEntityEqual(event.getPlayer()) == false) {

                    if (entity instanceof PlayerEntity) {
                        MMORPG.sendToClient(
                            new EntityUnitPacket(entity, Load.Unit(entity)),
                            (ServerPlayerEntity) event.getPlayer()
                        );
                    } else {

                        MMORPG.sendToClient(
                            new EfficientMobUnitPacket(entity, Load.Unit(entity)),
                            (ServerPlayerEntity) event.getPlayer()
                        );

                        entity.getCapability(BossCap.Data)
                            .ifPresent(x -> {
                                if (x.isBoss()) {
                                    MMORPG.sendToClient(new BossPacket(entity), (ServerPlayerEntity) event.getPlayer());
                                }
                            });

                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
