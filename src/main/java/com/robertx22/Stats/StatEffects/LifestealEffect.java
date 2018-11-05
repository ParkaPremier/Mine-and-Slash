package com.robertx22.stats.StatEffects;

import com.robertx22.effectdatas.DamageEffect;
import com.robertx22.effectdatas.EffectData;
import com.robertx22.effectdatas.EffectData.EffectTypes;
import com.robertx22.saveclasses.Unit;
import com.robertx22.stats.IStatEffect;
import com.robertx22.stats.Stat;

public class LifestealEffect implements IStatEffect {

	@Override
	public int GetPriority() {
		return 15;
	}

	@Override
	public EffectSides Side() {
		return EffectSides.Source;
	}

	@Override
	public EffectData TryModifyEffect(EffectData Effect, Unit source, Stat stat) {

		try {
			if (Effect instanceof DamageEffect && Effect.Type.equals(EffectTypes.BASIC_ATTACK)) {

				float healed = ((float) stat.Value * Effect.Number / 100);

				// System.out.println("Lifesteal stole " + healed);
				source.Heal(Effect.Source, (int) healed);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Effect;
	}

}
