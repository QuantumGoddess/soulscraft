package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.entity.mob.MobEntity;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin {

    @Inject(method = "isAffectedByDaylight()Z", at = @At("HEAD"), cancellable = true)
    private void isAffectedByDaylight(CallbackInfoReturnable<Boolean> info) {
        info.setReturnValue(false);
    }

}
