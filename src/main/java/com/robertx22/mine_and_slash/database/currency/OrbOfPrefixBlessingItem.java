package com.robertx22.mine_and_slash.database.currency;

import com.robertx22.mine_and_slash.advacements.PlayerLevelTrigger;
import com.robertx22.mine_and_slash.database.currency.base.CurrencyItem;
import com.robertx22.mine_and_slash.database.currency.base.ICurrencyItemEffect;
import com.robertx22.mine_and_slash.database.currency.base.IShapedRecipe;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.BaseLocRequirement;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.GearEnumLocReq;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.SimpleGearLocReq;
import com.robertx22.mine_and_slash.database.currency.loc_reqs.item_types.GearReq;
import com.robertx22.mine_and_slash.items.SimpleMatItem;
import com.robertx22.mine_and_slash.items.ores.ItemOre;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.mmorpg.registers.common.ModItems;
import com.robertx22.mine_and_slash.saveclasses.item_classes.GearItemData;
import com.robertx22.mine_and_slash.uncommon.datasaving.Gear;
import com.robertx22.mine_and_slash.uncommon.interfaces.IRenamed;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

import java.util.Arrays;
import java.util.List;

public class OrbOfPrefixBlessingItem extends CurrencyItem implements ICurrencyItemEffect, IRenamed, IShapedRecipe {
    @Override
    public String GUID() {
        return "currency/reroll_prefix_numbers";
    }

    private static final String name = Ref.MODID + ":currency/reroll_prefix_numbers";

    @Override
    public List<String> oldNames() {
        return Arrays.asList(Ref.MODID + ":reroll_prefix_numbers");
    }

    public OrbOfPrefixBlessingItem() {

        super(name);

    }

    @Override
    public ItemStack ModifyItem(ItemStack stack, ItemStack Currency) {

        GearItemData gear = Gear.Load(stack);

        gear.prefix.RerollNumbers(gear);

        Gear.Save(stack, gear);

        return stack;
    }

    @Override
    public List<BaseLocRequirement> requirements() {
        return Arrays.asList(GearReq.INSTANCE, GearEnumLocReq.AFFIXES, SimpleGearLocReq.HAS_PREFIX);
    }

    @Override
    public int getTier() {
        return 4;
    }

    @Override
    public int getRarityRank() {
        return IRarity.Epic;
    }

    @Override
    public List<String> loreLines() {
        return Arrays.asList("I command you to change!");
    }

    @Override
    public String locNameForLangFile() {
        return nameColor + "Orb Of Prefix Blessing";
    }

    @Override
    public String locDescForLangFile() {
        return "Re-rolls numbers of a prefix";
    }

    @Override
    public int instabilityAddAmount() {
        return 10;
    }

    @Override
    public ShapedRecipeBuilder getRecipe() {
        return shaped(ModItems.ORB_OF_PREFIX_BLESSING.get())
            .key('#', SimpleMatItem.CRYSTALLIZED_ESSENCE)
            .key('t', ModItems.ORB_OF_EVER_CHANGING_PREFIX.get())
            .key('v', Items.GLISTERING_MELON_SLICE)
            .key('o', ItemOre.ItemOres.get(IRarity.Rare))
            .patternLine("v#v")
            .patternLine("vtv")
            .patternLine("ooo")
            .addCriterion("player_level", new PlayerLevelTrigger.Instance(10));
    }

}