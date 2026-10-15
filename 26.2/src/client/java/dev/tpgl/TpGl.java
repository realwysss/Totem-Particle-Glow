package dev.tpgl;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;

public class TpGl implements ClientModInitializer {
	public void onInitializeClient() {
		Cfg.ld();
		KeyMapping k = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.totemparticleglow.open", InputConstants.KEY_Y, KeyMapping.Category.register(Identifier.fromNamespaceAndPath("totemparticleglow", "main"))));
		ClientTickEvents.END_CLIENT_TICK.register(m -> {
			while (k.consumeClick()) if (m.gui.screen() == null) m.gui.setScreen(CfgScr.mk(null));
		});
	}
}
