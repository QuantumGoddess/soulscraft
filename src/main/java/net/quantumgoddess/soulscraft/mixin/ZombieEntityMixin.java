package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;

@Mixin(ZombieEntity.class)
public class ZombieEntityMixin {

	private static double movementSpeed = 0.23f;
	private static double attackDamage = 6.0;
	private static double armor = 4.0;
	private static double health = 40.0;
	private static double followRange = 70.0;

	@Inject(at = @At("HEAD"), method = "createZombieAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", cancellable = true)
	private static void createZombieAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.setReturnValue(
				HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_FOLLOW_RANGE, followRange)
						.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movementSpeed)
						.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, attackDamage)
						.add(EntityAttributes.GENERIC_ARMOR, armor).add(EntityAttributes.ZOMBIE_SPAWN_REINFORCEMENTS));
	}
}
