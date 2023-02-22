package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.HostileEntity;

@Mixin(CreeperEntity.class)
public class CreeperEntityMixin {

	private static double movementSpeed = 0.0;
	private static double attackDamage = 0.0;
	private static double armor = 4.0;
	private static double health = 40.0;
	private static double followRange = 70.0;

	@Inject(at = @At("HEAD"), method = "createCreeperAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", cancellable = true)
	private static void createCreeperAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.setReturnValue(
				HostileEntity.createHostileAttributes().add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movementSpeed));
	}
}
