package net.quantumgoddess.soulscraft.entity.attribute;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;

public class SoulsCraftDefaultAttributeRegistry {

    public static void registerAll() {
        FabricDefaultAttributeRegistry.register(EntityType.ZOMBIE,
                SoulsCraftDefaultAttributeRegistry.createZombieAttributes());
        FabricDefaultAttributeRegistry.register(EntityType.CREEPER,
                SoulsCraftDefaultAttributeRegistry.createCreeperAttributes());
        FabricDefaultAttributeRegistry.register(EntityType.ENDERMAN,
                SoulsCraftDefaultAttributeRegistry.createEndermanAttributes());
        FabricDefaultAttributeRegistry.register(EntityType.PLAYER,
                SoulsCraftDefaultAttributeRegistry.createPlayerAttributes());
    }

    private static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, 35.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.23f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 6.0)
                .add(EntityAttributes.GENERIC_ARMOR, 4.0).add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS);
    }

    private static DefaultAttributeContainer.Builder createCreeperAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25);
    }

    private static DefaultAttributeContainer.Builder createEndermanAttributes() {
        return HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 80.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3f).add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 14.0)
                .add(EntityAttributes.GENERIC_FOLLOW_RANGE, 64.0);
    }

    private static DefaultAttributeContainer.Builder createPlayerAttributes() {
        return LivingEntity.createLivingAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 1.0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.1f).add(EntityAttributes.GENERIC_ATTACK_SPEED, 1.0)
                .add(EntityAttributes.GENERIC_LUCK)
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10.0);
    }
}
