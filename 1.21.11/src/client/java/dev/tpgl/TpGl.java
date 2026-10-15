package dev.tpgl;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class TpGl implements ClientModInitializer {
	public void onInitializeClient() {
		Cfg.ld();
		KeyMapping k = KeyBindingHelper.registerKeyBinding(new KeyMapping("key.totemparticleglow.open", InputConstants.KEY_Y, KeyMapping.Category.register(Identifier.fromNamespaceAndPath("totemparticleglow", "main"))));
		ClientTickEvents.END_CLIENT_TICK.register(m -> {
			while (k.consumeClick()) if (m.screen == null) m.setScreen(CfgScr.mk(null));
		});
	}
}
