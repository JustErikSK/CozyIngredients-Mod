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
    public static final Item COOKING_KNIFE = registerItem("cooking_knife", new Item(new FabricItemSettings()));
    public static final Item COOKING_POT = registerItem("cooking_pot", new Item(new FabricItemSettings()));
    public static final Item SLICE_OF_BREAD = registerItem("slice_of_bread", new Item(new FabricItemSettings()));
    public static final Item BOILED_EGG = registerItem("boiled_egg", new Item(new FabricItemSettings()));
    public static final Item BURGER_BUN = registerItem("burger_bun", new Item(new FabricItemSettings()));
    public static final Item BURNED_TOAST = registerItem("burned_toast", new Item(new FabricItemSettings()));
    public static final Item NOODLES = registerItem("noodles", new Item(new FabricItemSettings()));
    public static final Item PAN = registerItem("pan", new Item(new FabricItemSettings()));
    public static final Item RAW_CHIPS = registerItem("raw_chips", new Item(new FabricItemSettings()));
    public static final Item RAW_FRIES = registerItem("raw_fries", new Item(new FabricItemSettings()));
    public static final Item STARCH = registerItem("starch", new Item(new FabricItemSettings()));
    public static final Item SUNNY_SIDE_EGG = registerItem("sunny_side_egg", new Item(new FabricItemSettings()));
    public static final Item TOAST = registerItem("toast", new Item(new FabricItemSettings()));
    public static final Item FISHCAKE = registerItem("fishcake", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CozyIngredients.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CozyIngredients.LOGGER.info("Registering Mod Items for " + CozyIngredients.MOD_ID);
    }
}
