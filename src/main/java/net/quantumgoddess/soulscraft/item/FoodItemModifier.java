package net.quantumgoddess.soulscraft.item;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.quantumgoddess.soulscraft.SoulsCraft;
import net.quantumgoddess.soulscraft.mixin.FoodComponentAccessor;

public class FoodItemModifier {

    private static final float DEFAULT_HUNGER_MODIFIER = 0.5f;
    private static final float DEFAULT_SATURATION_MODIFIER = 0.5f;

    public static boolean modifyAll() {
        boolean result = false;
        for (RegistryEntry<Item> entry : Registries.ITEM.getIndexedEntries()) {
            RegistryKey<Item> key = entry.getKey().get();
            Item item = entry.value();
            if (item.isFood()) {
                FoodComponent foodComponent = item.getFoodComponent();
                ((FoodComponentAccessor) foodComponent)
                        .setHunger(Math.round(foodComponent.getHunger() * DEFAULT_HUNGER_MODIFIER));
                ((FoodComponentAccessor) foodComponent)
                        .setSaturationModifier(foodComponent.getSaturationModifier() * DEFAULT_SATURATION_MODIFIER);
                result = true;
                SoulsCraft.LOGGER.info("Modified food item: " + key.getValue());
            }
        }
        return result;
    }
}
