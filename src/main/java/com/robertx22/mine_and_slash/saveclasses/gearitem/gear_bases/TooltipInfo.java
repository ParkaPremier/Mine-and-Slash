package com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases;

import com.robertx22.mine_and_slash.database.data.MinMax;
import com.robertx22.mine_and_slash.database.data.stats.tooltips.StatTooltipType;
import com.robertx22.mine_and_slash.uncommon.capability.entity.EntityCap;
import com.robertx22.mine_and_slash.uncommon.datasaving.Load;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerEntity;

public class TooltipInfo implements Cloneable {

    public TooltipInfo(EntityCap.UnitData unitdata, MinMax minmax) {
        this.minmax = minmax;

        this.unitdata = unitdata;

        this.hasAltDown = Screen.hasAltDown();
        this.hasShiftDown = Screen.hasShiftDown();
    }

    public TooltipInfo(EntityCap.UnitData unitdata) {
        this.minmax = new MinMax(100, 100);

        this.unitdata = unitdata;

        this.hasAltDown = Screen.hasAltDown();
        this.hasShiftDown = Screen.hasShiftDown();

    }

    public TooltipInfo() {
        this.hasAltDown = Screen.hasAltDown();
        this.hasShiftDown = Screen.hasShiftDown();
    }

    public TooltipInfo(PlayerEntity player) {
        this.player = player;
        this.unitdata = Load.Unit(player);

        this.minmax = new MinMax(100, 100);

        this.hasAltDown = Screen.hasAltDown();
        this.hasShiftDown = Screen.hasShiftDown();
    }

    public TooltipInfo setIsSet() {
        this.isSet = true;
        return this;
    }

    public boolean showAbilityExtraInfo = true;

    public PlayerEntity player;
    public EntityCap.UnitData unitdata;
    public MinMax minmax = new MinMax(0, 100);
    public boolean isSet = false;
    public StatTooltipType statTooltipType = StatTooltipType.NORMAL;

    public boolean hasAltDown = false;
    public boolean hasShiftDown = false;

    public boolean shouldShowDescriptions() {
        return hasAltDown && !hasShiftDown && !isSet;
    }

    public boolean useInDepthStats() {
        return !hasAltDown && hasShiftDown && !isSet;
    }

}
