package com.robertx22.mine_and_slash.items.gearitems.armor.leather;

import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.items.gearitems.bases.BaseDyableArmorItem;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;

import java.util.HashMap;

public class LeatherChestItem extends BaseDyableArmorItem {
    public static HashMap<Integer, Item> Items = new HashMap<Integer, Item>();

    public LeatherChestItem(int rarity) {
        super(Type.LEATHER, rarity, EquipmentSlotType.CHEST);

    }

    @Override
    public String locNameForLangFile() {
        Rarity rar = Rarities.Items.get(rarity);
        return rar.textFormatColor() + "Leather Breastplate";
    }
}

