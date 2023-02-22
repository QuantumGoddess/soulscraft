package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;

@Mixin(HostileEntity.class)
public class HostileEntityMixin {
	@Inject(at = @At("HEAD"), method = "createHostileAttributes()Lnet/minecraft/entity/attribute/DefaultAttributeContainer$Builder;", cancellable = true)
	private static void createHostileAttributes(CallbackInfoReturnable<DefaultAttributeContainer.Builder> info) {
		info.setReturnValue(MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0));
	}
}
