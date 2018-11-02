package com.robertx22.mmorpg;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = Ref.MODID)
@Config.LangKey("mmorpg.config.title")
@EventBusSubscriber
public class ModConfig {

	public static GUIContainer GUI = new GUIContainer();

	public static class GUIContainer {

		@Config.Name("Render Chat Combat Log")
		@Config.Comment("Show/Disable Chat Damage Numbers")
		public boolean RENDER_CHAT_COMBAT_LOG = false;

		@Config.Name("Render Floating Damage Numbers")
		@Config.Comment("Show/Disable Floating Damage Numbers when you attack mobs")
		public boolean RENDER_FLOATING_DAMAGE = true;

		@Config.Name("Render Mob Health Bar")
		@Config.Comment("Show/Disable mob health barsd")
		public boolean RENDER_MOB_HEALTH_GUI = true;

	}

	@Mod.EventBusSubscriber
	private static class EventHandler {

		@SubscribeEvent
		public static void onConfigChanged(ConfigChangedEvent event) {
			if (event.getModID().equals(Ref.MODID)) {
				ConfigManager.sync(Ref.MODID, Config.Type.INSTANCE);
				System.out.println("config works");
			}
		}

	}

}
