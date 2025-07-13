package net.withrage.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CozyIngredients.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CozyIngredients.LOGGER.info("Registering Mod Items for " + CozyIngredients.MOD_ID);
    }
}
