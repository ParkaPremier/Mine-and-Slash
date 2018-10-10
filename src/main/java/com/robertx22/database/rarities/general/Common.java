package com.robertx22.database.rarities.general;

import com.robertx22.constants.Rarity;

import net.minecraft.util.text.TextFormatting;

public class Common  extends Rarity {

	@Override
	public String Name() {
		
		return "Common";
	}

	@Override
	public int Rank() {
	
		return 0;
	}

	@Override
	public String Color() {
		// TODO Auto-generated method stub
		return TextFormatting.GRAY.toString();
	}

}
