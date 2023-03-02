package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.FoodComponent;

@Mixin(FoodComponent.class)
public interface FoodComponentAccessor {

    @Accessor
    @Mutable
    public abstract void setHunger(int hunger);

    @Accessor
    @Mutable
    public abstract void setSaturationModifier(float saturationModifier);

}
