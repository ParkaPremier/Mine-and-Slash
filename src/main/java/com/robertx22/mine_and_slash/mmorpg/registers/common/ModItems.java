package com.robertx22.mine_and_slash.mmorpg.registers.common;

import com.robertx22.mine_and_slash.database.data.IGUID;
import com.robertx22.mine_and_slash.database.data.currency.*;
import com.robertx22.mine_and_slash.database.data.currency.base.CurrencyItem;
import com.robertx22.mine_and_slash.database.data.gearitemslots.bases.BaseGearType;
import com.robertx22.mine_and_slash.database.data.gearitemslots.cloth.ClothSlippers;
import com.robertx22.mine_and_slash.database.data.gearitemslots.cloth.OccultistRobes;
import com.robertx22.mine_and_slash.database.data.gearitemslots.cloth.SilkPants;
import com.robertx22.mine_and_slash.database.data.gearitemslots.cloth.SorcererCirclet;
import com.robertx22.mine_and_slash.database.data.gearitemslots.curios.LifeNecklace;
import com.robertx22.mine_and_slash.database.data.gearitemslots.curios.LifeRing;
import com.robertx22.mine_and_slash.database.data.gearitemslots.curios.OccultNecklace;
import com.robertx22.mine_and_slash.database.data.gearitemslots.curios.OccultRing;
import com.robertx22.mine_and_slash.database.data.gearitemslots.leather.HunterHood;
import com.robertx22.mine_and_slash.database.data.gearitemslots.leather.LeatherLeggings;
import com.robertx22.mine_and_slash.database.data.gearitemslots.leather.RawhideBoots;
import com.robertx22.mine_and_slash.database.data.gearitemslots.leather.WildTunic;
import com.robertx22.mine_and_slash.database.data.gearitemslots.offhand.Buckler;
import com.robertx22.mine_and_slash.database.data.gearitemslots.offhand.SpiritShield;
import com.robertx22.mine_and_slash.database.data.gearitemslots.offhand.TowerShield;
import com.robertx22.mine_and_slash.database.data.gearitemslots.plate.IronChestplate;
import com.robertx22.mine_and_slash.database.data.gearitemslots.plate.IronGreaves;
import com.robertx22.mine_and_slash.database.data.gearitemslots.plate.IronHelmet;
import com.robertx22.mine_and_slash.database.data.gearitemslots.plate.IronLegguards;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.Crossbow;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.HunterBow;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.melee.GemstoneSword;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.melee.PrimitiveAxe;
import com.robertx22.mine_and_slash.database.data.gearitemslots.weapons.melee.SageWand;
import com.robertx22.mine_and_slash.mmorpg.Ref;
import com.robertx22.mine_and_slash.uncommon.utilityclasses.ItemUtils;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.cloth.ClothBootsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.cloth.ClothChestItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.cloth.ClothHelmetItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.cloth.ClothPantsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.leather.LeatherBootsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.leather.LeatherChestItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.leather.LeatherHelmetItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.leather.LeatherPantsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.plate.PlateBootsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.plate.PlateChestItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.plate.PlateHelmetItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.armor.plate.PlatePantsItem;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.baubles.ItemNecklace;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.baubles.ItemRing;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.offhands.NormalShield;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.weapons.ItemAxe;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.weapons.ItemBow;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.weapons.ItemSword;
import com.robertx22.mine_and_slash.vanilla_mc.items.gearitems.weapons.ItemWand;
import com.robertx22.mine_and_slash.vanilla_mc.items.misc.*;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;

public class ModItems {

    public static DeferredRegister<Item> REG = new DeferredRegister<>(ForgeRegistries.ITEMS, Ref.MODID);
    public static List<RegistryObject<JewelItem>> ALL_JEWELS = new ArrayList<>();

    public static RegistryObject<Item> PLATE_BOOTS = of(() -> new PlateBootsItem(0), IronGreaves.INSTANCE);
    public static RegistryObject<Item> PLATE_HELMET = of(() -> new PlateHelmetItem(0), IronHelmet.INSTANCE);
    public static RegistryObject<Item> PLATE_CHEST = of(() -> new PlateChestItem(0), IronChestplate.INSTANCE);
    public static RegistryObject<Item> PLATE_PANTS = of(() -> new PlatePantsItem(0), IronLegguards.INSTANCE);

    public static RegistryObject<Item> CLOTH_SLIPPERS = of(() -> new ClothBootsItem(0), ClothSlippers.INSTANCE);
    public static RegistryObject<Item> SORCERER_CIRCLET = of(() -> new ClothHelmetItem(0), SorcererCirclet.INSTANCE);
    public static RegistryObject<Item> OCCULTIST_ROBES = of(() -> new ClothChestItem(0), OccultistRobes.INSTANCE);
    public static RegistryObject<Item> SILK_PANTS = of(() -> new ClothPantsItem(0), SilkPants.INSTANCE);

    public static RegistryObject<Item> HUNTER_HOOD = of(() -> new LeatherHelmetItem(0), HunterHood.INSTANCE);
    public static RegistryObject<Item> LEATHER_LEGGINGS = of(() -> new LeatherPantsItem(0), LeatherLeggings.INSTANCE);
    public static RegistryObject<Item> RAWHIDE_BOOTS = of(() -> new LeatherBootsItem(0), RawhideBoots.INSTANCE);
    public static RegistryObject<Item> WILD_TUNIC = of(() -> new LeatherChestItem(0), WildTunic.INSTANCE);

    public static RegistryObject<Item> GEMSTONE_SWORD = of(() -> new ItemSword(0), GemstoneSword.INSTANCE);
    public static RegistryObject<Item> PRIMITIVE_AXE = of(() -> new ItemAxe(0), PrimitiveAxe.INSTANCE);
    public static RegistryObject<Item> SAGE_WAND = of(() -> new ItemWand(0), SageWand.INSTANCE);
    public static RegistryObject<Item> BOW = of(() -> new ItemBow(0), HunterBow.INSTANCE);
    public static RegistryObject<Item> CROSSBOW = of(() -> new CrossbowItem(ItemUtils.getDefaultGearProperties()), Crossbow.INSTANCE);
    public static RegistryObject<Item> TOWER_SHIELD = of(() -> new NormalShield(TowerShield.INSTANCE), TowerShield.INSTANCE);
    public static RegistryObject<Item> SPIRIT_SHIELD = of(() -> new NormalShield(SpiritShield.INSTANCE), SpiritShield.INSTANCE);
    public static RegistryObject<Item> BUCKLER = of(() -> new NormalShield(Buckler.INSTANCE), Buckler.INSTANCE);

    public static RegistryObject<Item> HEALTH_NECKLACE = of(() -> new ItemNecklace(0), LifeNecklace.INSTANCE);
    public static RegistryObject<Item> MANA_REG_NECKLACE = of(() -> new ItemNecklace(0), OccultNecklace.INSTANCE);
    public static RegistryObject<Item> MANA_RING = of(() -> new ItemRing(0), OccultRing.INSTANCE);
    public static RegistryObject<Item> LIFE_RING = of(() -> new ItemRing(0), LifeRing.INSTANCE);

    // todo register all gears like this.

    public static List<RegistryObject<CurrencyItem>> currencies = new ArrayList<>();

    public static RegistryObject<CurrencyItem> ORB_OF_TRANSMUTATION = of(() -> new OrbOfTransmutationItem());
    public static RegistryObject<CurrencyItem> ORB_OF_DISORDER = of(() -> new OrbOfDisorder());
    public static RegistryObject<CurrencyItem> ORB_OF_TURBULENCE = of(() -> new OrbOfTurbulence());
    public static RegistryObject<CurrencyItem> STONE_OF_HOPE = of(() -> new StoneOfHopeItem());
    public static RegistryObject<CurrencyItem> LEAF_OF_CHANGE = of(() -> new LeafOfChangeItem());
    public static RegistryObject<CurrencyItem> ORB_OF_BLESSING = of(() -> new OrbOfBlessingItem());
    public static RegistryObject<CurrencyItem> ORB_OF_UNIQUE_BLESSING = of(() -> new OrbOfUniqueBlessingItem());

    public static RegistryObject<IdentifyTomeItem> IDENTIFY_TOME = item(() -> new IdentifyTomeItem(), "identify_tome");
    public static RegistryObject<Item> SKILL_GEM = item(() -> new Item(new Item.Properties().maxStackSize(1)
        .maxDamage(0)), "skill_gem");

    public static RegistryObject<MagicEssenceItem> MAGIC_ESSENCE = item(() -> new MagicEssenceItem());
    public static RegistryObject<RareMagicEssence> RARE_MAGIC_ESSENCE = item(() -> new RareMagicEssence());

    public static RegistryObject<JewelItem> BLUE_JEWEL = jewel(() -> new JewelItem(), "jewels/blue");
    public static RegistryObject<JewelItem> GREEN_JEWEL = jewel(() -> new JewelItem(), "jewels/green");

    public static RegistryObject<Item> INT_SKILL_GEM = item(() -> new SkillGemItem(), "skill_gems/int");
    public static RegistryObject<Item> DEX_SKILL_GEM = item(() -> new SkillGemItem(), "skill_gems/dex");
    public static RegistryObject<Item> STR_SKILL_GEM = item(() -> new SkillGemItem(), "skill_gems/str");
    public static RegistryObject<Item> NEWBIE_GEAR_BAG = item(() -> new ItemNewbieGearBag(), "newbie_gear_bag");
    public static RegistryObject<Item> INCRESE_MOB_RARITY = item(() -> new ItemIncreaseRarityNearestEntity(), "increase_rarity_nearest_entity");

    public static RegistryObject<ResetStatPointsItem> RESET_STATS_POTION = item(() -> new ResetStatPointsItem());

    static RegistryObject<JewelItem> jewel(Supplier<JewelItem> c, String id) {
        RegistryObject<JewelItem> wrap = REG.register(id, c);

        if (ALL_JEWELS == null) {
            ALL_JEWELS = new ArrayList<>();
        }

        ALL_JEWELS.add(wrap);
        return wrap;
    }

    static <T extends Item & IGUID> RegistryObject<T> item(Supplier<T> c) {

        RegistryObject<T> wrap = REG.register(c.get()
            .GUID(), c);

        return wrap;

    }

    static <T extends Item> RegistryObject<T> item(Supplier<T> c, String id) {
        RegistryObject<T> wrap = REG.register(id, c);
        return wrap;
    }

    static RegistryObject<Item> of(Supplier<Item> c, BaseGearType slot) {
        RegistryObject<Item> wrap = REG.register(slot.family()
            .name()
            .toLowerCase(Locale.ROOT) + "/" + slot.GUID(), c);
        return wrap;

    }

    static RegistryObject<CurrencyItem> of(Supplier<CurrencyItem> c) {

        RegistryObject<CurrencyItem> wrap = REG.register(c.get()
            .GUID(), c);

        currencies.add(wrap);

        return wrap;

    }

}
