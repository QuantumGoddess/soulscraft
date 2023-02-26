package net.quantumgoddess.soulscraft.entity.attribute;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombieEntity;

public class SoulsCraftDefaultAttributeRegistry {

	public static void registerAll() {
		// overworld mobs
		FabricDefaultAttributeRegistry.register(EntityType.ZOMBIE, createZombieAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.CREEPER, createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.ENDERMAN, createEndermanAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.PLAYER, createPlayerAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.WITCH, createWitchAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.SPIDER, createSpiderAttributes());

		// nether mobs
		FabricDefaultAttributeRegistry.register(EntityType.BLAZE, createBlazeAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.PIGLIN, createPiglinAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.PIGLIN_BRUTE, createPiglinBruteAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.GHAST, createGhastAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.HOGLIN, createHoglinAttributes());
		FabricDefaultAttributeRegistry.register(EntityType.ZOMBIFIED_PIGLIN, createZombifiedPiglinAttributes());
	}

	public static DefaultAttributeContainer.Builder createZombifiedPiglinAttributes() {
		return ZombieEntity.createZombieAttributes().add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS, 0.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0);
	}

	public static DefaultAttributeContainer.Builder createHoglinAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
				.add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.6f)
				.add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK, 2.0).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0);
	}

	public static DefaultAttributeContainer.Builder createGhastAttributes() {
		return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 20.0)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 100.0);
	}

	public static DefaultAttributeContainer.Builder createPiglinBruteAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0);
	}

	public static DefaultAttributeContainer.Builder createPiglinAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 32.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.35f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10.0);
	}

	public static DefaultAttributeContainer.Builder createBlazeAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 12.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f).add(EntityAttributes.GENERIC_FOLLOW_RANGE, 48.0);
	}

	public static DefaultAttributeContainer.Builder createSpiderAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 32.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f);
	}

	private static DefaultAttributeContainer.Builder createWitchAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 52.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
	}

	private static DefaultAttributeContainer.Builder createZombieAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
				.add(EntityAttributes.GENERIC_ARMOR, 4.0)
				.add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
	}

	private static DefaultAttributeContainer.Builder createCreeperAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
	}

	private static DefaultAttributeContainer.Builder createEndermanAttributes() {
		return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
	}

	private static DefaultAttributeContainer.Builder createPlayerAttributes() {
		return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f)
				.add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0)
				.add(EntityAttributes.GENERIC_LUCK)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0);
	}
}
