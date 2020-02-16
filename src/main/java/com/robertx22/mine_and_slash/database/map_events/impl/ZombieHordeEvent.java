package com.robertx22.mine_and_slash.database.map_events.impl;

import com.robertx22.mine_and_slash.database.map_events.base.MapEvent;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ZombieHordeEvent extends MapEvent {

    private ZombieHordeEvent() {
    }

    public static ZombieHordeEvent getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public void onActivate(World world) {

        if (!world.getPlayers().isEmpty()) {

            BlockPos p = randomPosNearPlayer(world);

            announceEvent(world, new StringTextComponent(TextFormatting.LIGHT_PURPLE + "A Zombie Horde has Appeared!"));
            summonBeacon(p, world);

            com.robertx22.mine_and_slash.database.bosses.base.Boss boss = SlashRegistry.Bosses().random();

            Entity bossMob = summonBoss(EntityType.ZOMBIE, world, p, boss);

            summonMinions(EntityType.ZOMBIE, 20, world, p);
        }

    }

    @Override
    public int minutesEventLasts() {
        return 0;
    }

    @Override
    public String GUID() {
        return "zombie_horde";
    }

    private static class SingletonHolder {
        private static final ZombieHordeEvent INSTANCE = new ZombieHordeEvent();
    }
}