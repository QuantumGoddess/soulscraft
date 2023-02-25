package net.quantumgoddess.soulscraft.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.quantumgoddess.soulscraft.item.SoulsCraftArmorMaterials;

@Mixin(ArmorItem.class)
public class ArmorItemMixin {

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ArmorMaterial;Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/Item$Settings;)V", at = @At("HEAD"))
    private static ArmorMaterial injected(ArmorMaterial material) {
        switch (material.getName()) {
            case "chainmail":
                return SoulsCraftArmorMaterials.CHAIN;
            case "diamond":
                return SoulsCraftArmorMaterials.DIAMOND;
            case "gold":
                return SoulsCraftArmorMaterials.GOLD;
            case "iron":
                return SoulsCraftArmorMaterials.IRON;
            case "leather":
                return SoulsCraftArmorMaterials.LEATHER;
            case "netherite":
                return SoulsCraftArmorMaterials.NETHERITE;
            case "turtle":
                return SoulsCraftArmorMaterials.TURTLE;
            default:
                return material;
        }
    }
}
