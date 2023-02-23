package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.mob.CreeperEntity;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {
    @Accessor
    public abstract void setExplosionRadius(int explosionRadius);

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V")
    private void CreeperEntity(CallbackInfo info) {
        ((CreeperEntityMixin) (Object) this).setExplosionRadius(5);
    }

}