package com.robertx22.mine_and_slash.database.base;

import com.robertx22.mine_and_slash.database.data.rarities.RarityTypeEnum;
import com.robertx22.mine_and_slash.database.data.rarities.containers.GearRarities;
import com.robertx22.mine_and_slash.database.data.rarities.containers.MobRarities;
import com.robertx22.mine_and_slash.database.data.rarities.containers.SkillGemRarities;
import com.robertx22.mine_and_slash.mmorpg.MMORPG;
import com.robertx22.mine_and_slash.vanilla_mc.packets.RarityPacket;
import net.minecraft.entity.player.ServerPlayerEntity;

public class Rarities {

    public static final GearRarities Gears = new GearRarities();
    public static final MobRarities Mobs = new MobRarities();
    public static final SkillGemRarities SkillGems = new SkillGemRarities();

    public static void sendAllPacketsToClientOnLogin(ServerPlayerEntity player) {

        MMORPG.sendToClient(new RarityPacket(RarityTypeEnum.GEAR), player);
        MMORPG.sendToClient(new RarityPacket(RarityTypeEnum.SKILL_GEM), player);

    }
}
