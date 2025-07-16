package net.withrage.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;

public class ModItems {
    public static final Item APPLE_JAM = registerItem("apple_jam", new Item(new FabricItemSettings()));
    public static final Item SWEETBERRY_JAM = registerItem("sweetberry_jam", new Item(new FabricItemSettings()));
    public static final Item GLOWBERRY_JAM = registerItem("glowberry_jam", new Item(new FabricItemSettings()));
    public static final Item CARAMEL = registerItem("caramel", new Item(new FabricItemSettings()));
    public static final Item NUHTELLA = registerItem("nuhtella", new Item(new FabricItemSettings()));
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()));
    public static final Item BUTTER = registerItem("butter", new Item(new FabricItemSettings()));
    public static final Item CHEESE = registerItem("cheese", new Item(new FabricItemSettings()));
    public static final Item FLOUR = registerItem("flour", new Item(new FabricItemSettings()));
    public static final Item ICE_CREAM_CONE = registerItem("ice_cream_cone", new Item(new FabricItemSettings()));
    public static final Item POWDERED_SUGAR = registerItem("powdered_sugar", new Item(new FabricItemSettings()));
    public static final Item WHIPPED_CREAM = registerItem("whipped_cream", new Item(new FabricItemSettings()));
    public static final Item JAR = registerItem("jar", new Item(new FabricItemSettings()));
    public static final Item MILK_BOX = registerItem("milk_box", new Item(new FabricItemSettings()));
    public static final Item GLASS_OF_WATER = registerItem("glass_of_water", new Item(new FabricItemSettings()));
    public static final Item WHISK = registerItem("whisk", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CozyIngredients.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CozyIngredients.LOGGER.info("Registering Mod Items for " + CozyIngredients.MOD_ID);
    }
}
