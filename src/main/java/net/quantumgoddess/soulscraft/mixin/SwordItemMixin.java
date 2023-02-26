package net.quantumgoddess.soulscraft.mixin;

import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.quantumgoddess.soulscraft.item.SoulsCraftToolMaterials;

@Mixin(SwordItem.class)
public abstract class SwordItemMixin {

    @Accessor
    @Mutable
    public abstract void setAttackDamage(float attackDamage);

    @Accessor
    @Mutable
    public abstract float getAttackDamage();

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V", at = @At("HEAD"))
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

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/item/SwordItem;attackDamage:F", opcode = Opcodes.PUTFIELD))
    private float injected(float attackSpeed) {
        return ((SwordItem) (Object) this).getMaterial().getAttackDamage();
    }

    @Redirect(method = "<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V", at = @At(value = "FIELD", target = "Lnet/minecraft/item/SwordItem;attackDamage:F", opcode = Opcodes.PUTFIELD))
    private void injected(SwordItem item, float input) {
        ((SwordItemMixin) (Object) item).setAttackDamage(item.getMaterial().getAttackDamage());
    }

    // @Redirect(method =
    // "<init>(Lnet/minecraft/item/ToolMaterial;IFLnet/minecraft/item/Item$Settings;)V",
    // at = @At(value = "INVOKE", target =
    // "Lcom/google/common/collect/ImmutableMultimap$Builder;put(Lnet/minecraft/entity/attribute/EntityAttribute;Lnet/minecraft/entity/attribute/EntityAttributeModifier;)Lcom/google/common/collect/ImmutableMultimap$Builder;"))
    // private Builder<EntityAttribute, EntityAttributeModifier> injected(
    // Builder<EntityAttribute, EntityAttributeModifier> builder, EntityAttribute
    // attribute,
    // EntityAttributeModifier modifier) {
    // return builder.put(attribute,
    // new
    // EntityAttributeModifier(UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3"),
    // "Weapon modifier", (double) getAttackDamage(),
    // EntityAttributeModifier.Operation.ADDITION));
    // }
}
