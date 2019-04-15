package com.robertx22.database.rarities.runes;

import com.robertx22.database.rarities.RuneRarity;
import com.robertx22.database.rarities.items.LegendaryItem;

public class LegendaryRune extends LegendaryItem implements RuneRarity {

    @Override
    public int minimumRunewordPower() {
	return 2;
    }

    @Override
    public int maximumRunewordPower() {
	return 3;
    }

}
