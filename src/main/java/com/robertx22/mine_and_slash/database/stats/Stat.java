package com.robertx22.mine_and_slash.database.stats;

import com.robertx22.mine_and_slash.database.IGUID;
import com.robertx22.mine_and_slash.db_lists.Rarities;
import com.robertx22.mine_and_slash.db_lists.registry.ISlashRegistryEntry;
import com.robertx22.mine_and_slash.db_lists.registry.SlashRegistryType;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.saveclasses.StatData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.StatModData;
import com.robertx22.mine_and_slash.saveclasses.gearitem.gear_bases.Rarity;
import com.robertx22.mine_and_slash.saveclasses.item_classes.tooltips.TooltipStatInfo;
import com.robertx22.mine_and_slash.uncommon.capability.EntityCap.UnitData;
import com.robertx22.mine_and_slash.uncommon.enumclasses.Elements;
import com.robertx22.mine_and_slash.uncommon.enumclasses.StatTypes;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocDesc;
import com.robertx22.mine_and_slash.uncommon.interfaces.IAutoLocName;
import com.robertx22.mine_and_slash.uncommon.interfaces.IWeighted;
import com.robertx22.mine_and_slash.uncommon.interfaces.data_items.IRarity;
import com.robertx22.mine_and_slash.uncommon.localization.Styles;
import com.robertx22.mine_and_slash.uncommon.localization.Words;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.text.DecimalFormat;
import java.util.List;

public abstract class Stat implements IGUID, IAutoLocName, IWeighted, IRarity, IAutoLocDesc, ISlashRegistryEntry {

    public Stat() {
    }

    // 14 per 14

    public TextFormatting getIconFormat() {
        if (this.Element() != null) {
            return this.Element().format;
        } else {
            return Elements.Physical.format;
        }
    }

    public String getIcon() {
        if (this.Element() != null) {
            return this.Element().icon;
        } else {
            return Elements.Physical.icon;
        }
    }

    public String getFormattedIcon() {
        return getIconFormat() + getIcon();
    }

    static final int rows = 13;
    static final int spriteSize = 18;

    @Override
    public int Tier() {
        return 0;
    }

    @Override
    public int getRarityRank() {
        return IRarity.Uncommon;
    }

    // this is used for alltraitmods, check if confused
    @Override
    public int Weight() {
        return this.getRarity().Weight();
    }

    @Override
    public Rarity getRarity() {
        return Rarities.Items.get(getRarityRank());
    }

    @Override
    public SlashRegistryType getSlashRegistryType() {
        return SlashRegistryType.STAT;
    }

    public int getSpriteX() {
        int placeX = this.iconSpriteNumber() % rows;
        return 1 + placeX * spriteSize;
    }

    public int getSpriteY() {
        int placeY = this.iconSpriteNumber() / rows;

        return 1 + placeY * spriteSize;
    }

    public int iconSpriteNumber() {
        return 0;
    }

    @Override
    public AutoLocGroup locDescGroup() {
        return AutoLocGroup.Stats;

    }

    @Override
    public String locNameLangFileGUID() {
        return Ref.MODID + ".stat." + formattedGUID();
    }

    @Override
    public String locDescLangFileGUID() {
        return Ref.MODID + ".stat_desc." + formattedGUID();
    }

    @Override
    public AutoLocGroup locNameGroup() {
        return AutoLocGroup.Stats;
    }

    public int maximumValue = Integer.MAX_VALUE;

    public int minimumValue = Integer.MIN_VALUE;

    public abstract boolean IsPercent();

    public abstract boolean ScalesToLevel();

    public abstract Elements Element();

    public int BaseFlat = 0;

    public String printValue(StatModData data, int level) {

        float val = data.GetActualVal(level);
        return printValue(val);

    }

    public String printValue(float val) {

        DecimalFormat format = new DecimalFormat();

        if (val < 10) {
            format.setMaximumFractionDigits(1);

            return format.format(val);

        } else {

            int intval = (int) val;
            return intval + "";

        }

    }

    @OnlyIn(Dist.CLIENT)
    public ITextComponent NameText(TooltipStatInfo info) {

        StatMod mod = info.mod;
        Stat basestat = mod.GetBaseStat();

        ITextComponent str = new StringTextComponent("");

        if (mod.Type().equals(StatTypes.Flat) && basestat.IsPercent()) {
            str.appendSibling(Words.Flat.locName()).appendText(" ");
        }

        str.appendSibling(basestat.locName());

        if (info.tooltipInfo.isSet == false) {
            return Styles.REDCOMP()
                    .appendSibling(new StringTextComponent(" * ").appendSibling(str)
                            .appendText(": "));
        } else {
            return Styles.GREENCOMP().appendSibling(str.appendText(": "));
        }
    }

    @OnlyIn(Dist.CLIENT)
    public ITextComponent NameAndValueText(TooltipStatInfo info) {

        float val = info.amount;

        String minusplus = val > 0 ? "+" : "";

        return NameText(info).appendText(minusplus + printValue(info.modData, info.tooltipInfo.level));
    }

    @OnlyIn(Dist.CLIENT)
    public List<ITextComponent> getTooltipList(TooltipStatInfo info) {

        if (info.tooltipInfo.usePrettyStatSymbols) {
            return PrimaryStatTooltipUtils.getTooltipList(info);
        } else {
            return NormalStatTooltipUtils.getTooltipList(info);
        }
    }

    public void CalcVal(StatData data, UnitData Source) {

        float finalValue = BaseFlat;

        if (ScalesToLevel()) {
            finalValue *= Source.getLevel();
        }

        finalValue += data.Flat;

        finalValue *= 1 + data.Percent / 100;

        finalValue *= 1 + data.Multi / 100;

        data.Value = MathHelper.clamp(finalValue, minimumValue, maximumValue);

    }

    public boolean IsShownOnTooltip() {
        return true;
    }

    public StatGroup statGroup() {
        return StatGroup.Misc;
    }

    public enum StatGroup {
        Main(Words.Main, 0),
        Misc(Words.Misc, 8),
        CoreStat(Words.Core_Stat, 5),
        SpellDamage(Words.Spell_Damage, 3),
        EleAttackDamage(Words.Elemental_Attack_Damage, 2),
        Defenses(Words.Defenses, 4),
        Penetration(Words.Penetration, 6),
        Damage(Words.Damage, 1),
        Regeneration(Words.Regeneration, 7);

        StatGroup(Words word, int place) {
            this.place = place;
            this.word = word;
        }

        public Words word;

        public final int width = 18;
        public final int height = 18;

        public int place = 0;

        public final int Y = 8;

        public int X() {
            return 25 + width * place;
        }
    }

}