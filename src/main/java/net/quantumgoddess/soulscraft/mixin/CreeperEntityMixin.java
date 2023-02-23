package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import net.minecraft.entity.mob.CreeperEntity;

@Mixin(CreeperEntity.class)
public abstract class CreeperEntityMixin {

    @Shadow
    private int explosionRadius = 5;

}