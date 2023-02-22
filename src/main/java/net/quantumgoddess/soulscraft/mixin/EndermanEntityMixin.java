package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

	private static double movementSpeed = 0.6f;
	private static double attackDamage = 14.0;
	private static double armor = 4.0;
	private static double health = 80.0;
	private static double followRange = 128.0;

	@Inject(at = @At("HEAD"), method = "createEndermanAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", cancellable = true)
	private static void createZombieAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.setReturnValue(
				HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, health)
						.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movementSpeed)
						.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, attackDamage)
						.add(EntityAttributes.GENERIC_FOLLOW_RANGE, followRange));
	}
}
