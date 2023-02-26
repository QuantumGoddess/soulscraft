package net.quantumgoddess.soulscraft.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.quantumgoddess.soulscraft.item.SoulsCraftToolMaterials;

@Mixin(MiningToolItem.class)
public abstract class MiningToolItemMixin {

    @Accessor
    @Mutable
    public abstract void setAttackDamage(float attackDamage);

    @ModifyVariable(method = "<init>(FFLnet/minecraft/item/ToolMaterial;Lnet/minecraft/registry/tag/TagKey;Lnet/minecraft/item/Item$Settings;)V", at = @At("HEAD"))
    private static ToolMaterial injected(ToolMaterial material) {
        switch ((ToolMaterials) material) {
            case WOOD:
                return SoulsCraftToolMaterials.WOOD;
            case DIAMOND:
                return SoulsCraftToolMaterials.DIAMOND;
            case GOLD:
                return SoulsCraftToolMaterials.GOLD;
            case IRON:
                return SoulsCraftToolMaterials.IRON;
            case STONE:
                return SoulsCraftToolMaterials.STONE;
            case NETHERITE:
                return SoulsCraftToolMaterials.NETHERITE;
            default:
                return material;
        }
    }

    @Redirect(method = "<init>(FFLnet/minecraft/item/ToolMaterial;Lnet/minecraft/registry/tag/TagKey;Lnet/minecraft/item/Item$Settings;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/item/MiningToolItem;attackDamage:F", opcode = Opcodes.PUTFIELD))
    private void injected(MiningToolItem item, float input) {
        ((MiningToolItemMixin) (Object) item).setAttackDamage(0.0f);
    }

    @ModifyVariable(method = "<init>(FFLnet/minecraft/item/ToolMaterial;Lnet/minecraft/registry/tag/TagKey;Lnet/minecraft/item/Item$Settings;)V", at = @At("HEAD"), ordinal = 1)
    private static float injected(float attackSpeed) {
        return 0;
    }
}
