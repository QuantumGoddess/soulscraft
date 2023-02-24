package net.quantumgoddess.soulscraft;

import net.fabricmc.api.ModInitializer;
import net.quantumgoddess.soulscraft.entity.attribute.SoulsCraftDefaultAttributeRegistry;

public class SoulsCraft implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		SoulsCraftDefaultAttributeRegistry.registerAll();
		// TODO modify attributes from screen

	}
}
