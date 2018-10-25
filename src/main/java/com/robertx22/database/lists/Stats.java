package com.robertx22.database.lists;

import java.util.HashMap;

import com.robertx22.database.stats.types.defense.Armor;
import com.robertx22.database.stats.types.defense.Dodge;
import com.robertx22.database.stats.types.defense.SpellDodge;
import com.robertx22.database.stats.types.elementals.damage.FireDamage;
import com.robertx22.database.stats.types.elementals.damage.NatureDamage;
import com.robertx22.database.stats.types.elementals.damage.ThunderDamage;
import com.robertx22.database.stats.types.elementals.damage.WaterDamage;
import com.robertx22.database.stats.types.elementals.pene.FirePene;
import com.robertx22.database.stats.types.elementals.pene.NaturePene;
import com.robertx22.database.stats.types.elementals.pene.ThunderPene;
import com.robertx22.database.stats.types.elementals.pene.WaterPene;
import com.robertx22.database.stats.types.elementals.resist.FireResist;
import com.robertx22.database.stats.types.elementals.resist.NatureResist;
import com.robertx22.database.stats.types.elementals.resist.ThunderResist;
import com.robertx22.database.stats.types.elementals.resist.WaterResist;
import com.robertx22.database.stats.types.offense.CriticalDamage;
import com.robertx22.database.stats.types.offense.CriticalHit;
import com.robertx22.database.stats.types.offense.PhysicalDamage;
import com.robertx22.database.stats.types.offense.LifeOnHit;
import com.robertx22.database.stats.types.offense.Lifesteal;
import com.robertx22.database.stats.types.resources.Energy;
import com.robertx22.database.stats.types.resources.EnergyRegen;
import com.robertx22.database.stats.types.resources.Health;
import com.robertx22.database.stats.types.resources.HealthRegen;
import com.robertx22.database.stats.types.resources.Mana;
import com.robertx22.database.stats.types.resources.ManaRegen;
import com.robertx22.database.stats.types.traits.Golem;
import com.robertx22.stats.Stat;

public class Stats {
	public static HashMap<String, Stat> All = new HashMap<String, Stat>() {
		{
			{

				// Resources
				put(new Health().Name(), new Health());
				put(new HealthRegen().Name(), new HealthRegen());

				put(new Mana().Name(), new Mana());
				put(new ManaRegen().Name(), new ManaRegen());

				put(new Energy().Name(), new Energy());
				put(new EnergyRegen().Name(), new EnergyRegen());
				// Resources

				put(new Armor().Name(), new Armor());
				put(new CriticalDamage().Name(), new CriticalDamage());
				put(new CriticalHit().Name(), new CriticalHit());
				put(new PhysicalDamage().Name(), new PhysicalDamage());

				// Elemental
				put(new FireDamage().Name(), new FireDamage());
				put(new WaterDamage().Name(), new WaterDamage());
				put(new ThunderDamage().Name(), new ThunderDamage());
				put(new NatureDamage().Name(), new NatureDamage());

				put(new FireResist().Name(), new FireResist());
				put(new NatureResist().Name(), new NatureResist());
				put(new WaterResist().Name(), new WaterResist());
				put(new ThunderResist().Name(), new ThunderResist());

				put(new FirePene().Name(), new FirePene());
				put(new NaturePene().Name(), new NaturePene());
				put(new WaterPene().Name(), new WaterPene());
				put(new ThunderPene().Name(), new ThunderPene());
				// Elemental

				put(new Lifesteal().Name(), new Lifesteal());
				put(new LifeOnHit().Name(), new LifeOnHit());

				put(new Dodge().Name(), new Dodge());
				put(new SpellDodge().Name(), new SpellDodge());

				// traits
				put(new Golem().Name(), new Golem());
				// traits

			}
		}
	};
}
