package com.robertx22.mine_and_slash.database.gearitemslots.offhand;

import com.robertx22.mine_and_slash.database.StatModifier;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.BaseOffHand;
import com.robertx22.mine_and_slash.database.gearitemslots.bases.GearItemSlot;
import com.robertx22.mine_and_slash.database.stats.types.defense.Armor;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ModItems;
import com.robertx22.mine_and_slash.uncommon.enumclasses.ModType;
import net.minecraft.item.Item;

import java.util.Arrays;
import java.util.List;

public class ArmorShield extends BaseOffHand {
    public static GearItemSlot INSTANCE = new ArmorShield();

    private ArmorShield() {

    }

    @Override
    public List<StatModifier> BaseStats() {
        return Arrays.asList(new StatModifier(20, 80, Armor.getInstance(), ModType.FLAT));
    }

    @Override
    public List<StatModifier> ImplicitStats() {
        return Arrays.asList();
    }

    @Override
    public PlayStyle getPlayStyle() {
        return PlayStyle.WARRIOR;
    }

    @Override
    public List<SlotTag> getTags() {
        return Arrays.asList(SlotTag.Shield, SlotTag.Plate);
    }

    @Override
    public Item getItem() {
        return ModItems.ARMOR_SHIELD.get();
    }

    @Override
    public String GUID() {
        return "armor_shield";
    }

    @Override
    public String locNameForLangFile() {
        return "Plate Shield";
    }
}
