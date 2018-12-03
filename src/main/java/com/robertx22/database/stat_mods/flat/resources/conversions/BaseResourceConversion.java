package com.robertx22.database.stat_mods.flat.resources.conversions;

import com.robertx22.stats.StatMod;
import com.robertx22.uncommon.enumclasses.StatTypes;

public abstract class BaseResourceConversion extends StatMod {

    @Override
    public int Min() {
	return 10;
    }

    @Override
    public int Max() {
	return 30;
    }

    @Override
    public StatTypes Type() {
	return StatTypes.Flat;
    }

}