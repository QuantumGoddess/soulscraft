package net.quantumgoddess.soulscraft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.quantumgoddess.soulscraft.entity.attribute.SoulsCraftDefaultAttributeRegistry;
import net.quantumgoddess.soulscraft.item.FoodItemModifier;

public class SoulsCraft implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger(SoulsCraft.class);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		LOGGER.info("Initializing SoulsCraft Mod");
		SoulsCraftDefaultAttributeRegistry.registerAll();
		LOGGER.info(
				FoodItemModifier.modifyAll() ? "Modified all registered food items" : "Could not modify food items");
	}
}
