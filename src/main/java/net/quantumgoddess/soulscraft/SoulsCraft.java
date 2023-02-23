package net.quantumgoddess.soulscraft;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.quantumgoddess.soulscraft.entities.attributes.SoulsCraftEntityAttributes;

public class SoulsCraft implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Hello Fabric world!");
		FabricDefaultAttributeRegistry.register(EntityType.ZOMBIE, SoulsCraftEntityAttributes.createZombieAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.CREEPER,
				SoulsCraftEntityAttributes.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.ENDERMAN,
				SoulsCraftEntityAttributes.createEndermanAttributes());

	}
}
