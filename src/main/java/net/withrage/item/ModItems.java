package net.withrage.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;
import net.withrage.item.custom.BurnedToastItem;
import net.withrage.item.custom.MilkBoxItem;
import net.withrage.item.custom.ToastItem;

public class ModItems {
    public static final Item APPLE_JAM = registerItem("apple_jam", new Item(new FabricItemSettings().food(ModFoodComponents.APPLE_JAM)));
    public static final Item SWEETBERRY_JAM = registerItem("sweetberry_jam", new Item(new FabricItemSettings().food(ModFoodComponents.SWEETBERRY_JAM)));
    public static final Item GLOWBERRY_JAM = registerItem("glowberry_jam", new Item(new FabricItemSettings().food(ModFoodComponents.GLOWBERRY_JAM)));
    public static final Item CARAMEL = registerItem("caramel", new Item(new FabricItemSettings().food(ModFoodComponents.CARAMEL)));
    public static final Item NUHTELLA = registerItem("nuhtella", new Item(new FabricItemSettings().food(ModFoodComponents.NUHTELLA)));
    public static final Item SALT = registerItem("salt", new Item(new FabricItemSettings()));
    public static final Item BUTTER = registerItem("butter", new Item(new FabricItemSettings().food(ModFoodComponents.BUTTER)));
    public static final Item CHEESE = registerItem("cheese", new Item(new FabricItemSettings().food(ModFoodComponents.CHEESE)));
    public static final Item FLOUR = registerItem("flour", new Item(new FabricItemSettings()));
    public static final Item ICE_CREAM_CONE = registerItem("ice_cream_cone", new Item(new FabricItemSettings().food(ModFoodComponents.ICE_CREAM_CONE)));
    public static final Item POWDERED_SUGAR = registerItem("powdered_sugar", new Item(new FabricItemSettings()));
    public static final Item WHIPPED_CREAM = registerItem("whipped_cream", new Item(new FabricItemSettings()));
    public static final Item JAR = registerItem("jar", new Item(new FabricItemSettings()));
    public static final Item MILK_BOX = registerItem("milk_box", new MilkBoxItem(new FabricItemSettings().food(ModFoodComponents.MILK_BOX)));
    public static final Item GLASS_OF_WATER = registerItem("glass_of_water", new DrinkItem(new FabricItemSettings().food(ModFoodComponents.GLASS_OF_WATER)));
    public static final Item WHISK = registerItem("whisk", new Item(new FabricItemSettings()));
    public static final Item COOKING_KNIFE = registerItem("cooking_knife", new Item(new FabricItemSettings()));
    public static final Item COOKING_POT = registerItem("cooking_pot", new Item(new FabricItemSettings()));
    public static final Item SLICE_OF_BREAD = registerItem("slice_of_bread", new Item(new FabricItemSettings().food(ModFoodComponents.SLICE_OF_BREAD)));
    public static final Item BOILED_EGG = registerItem("boiled_egg", new Item(new FabricItemSettings().food(ModFoodComponents.BOILED_EGG)));
    public static final Item BURGER_BUN = registerItem("burger_bun", new Item(new FabricItemSettings().food(ModFoodComponents.BURGER_BUN)));
    public static final Item BURNED_TOAST = registerItem("burned_toast", new BurnedToastItem(new FabricItemSettings().food(ModFoodComponents.BURNED_TOAST)));
    public static final Item NOODLES = registerItem("noodles", new Item(new FabricItemSettings().food(ModFoodComponents.NOODLES)));
    public static final Item PAN = registerItem("pan", new Item(new FabricItemSettings()));
    public static final Item RAW_CHIPS = registerItem("raw_chips", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_CHIPS)));
    public static final Item RAW_FRIES = registerItem("raw_fries", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_FRIES)));
    public static final Item STARCH = registerItem("starch", new Item(new FabricItemSettings()));
    public static final Item SUNNY_SIDE_UP_EGG = registerItem("sunny_side_up_egg", new Item(new FabricItemSettings().food(ModFoodComponents.SUNNY_SIDE_UP_EGG)));
    public static final Item TOAST = registerItem("toast", new ToastItem(new FabricItemSettings().food(ModFoodComponents.TOAST)));
    public static final Item FISHCAKE = registerItem("fishcake", new Item(new FabricItemSettings().food(ModFoodComponents.FISHCAKE)));
    public static final Item CLEAVER = registerItem("cleaver", new Item(new FabricItemSettings()));
    public static final Item MINCED_BEEF = registerItem("minced_beef", new Item(new FabricItemSettings().food(ModFoodComponents.MINCED_BEEF)));
    public static final Item MINCED_CHICKEN = registerItem("minced_chicken", new Item(new FabricItemSettings().food(ModFoodComponents.MINCED_CHICKEN)));
    public static final Item MINCED_LAMB = registerItem("minced_lamb", new Item(new FabricItemSettings().food(ModFoodComponents.MINCED_LAMB)));
    public static final Item MINCED_PORK = registerItem("minced_pork", new Item(new FabricItemSettings().food(ModFoodComponents.MINCED_PORK)));
    public static final Item COOKIE_CUTTER = registerItem("cookie_cutter", new Item(new FabricItemSettings()));
    public static final Item BAGEL = registerItem("bagel", new Item(new FabricItemSettings().food(ModFoodComponents.BAGEL)));
    public static final Item BAGUETTE = registerItem("baguette", new Item(new FabricItemSettings().food(ModFoodComponents.BAGUETTE)));
    public static final Item RAW_DINO_NUGGETS = registerItem("raw_dino_nuggets", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_DINO_NUGGETS)));
    public static final Item DOUGH = registerItem("dough", new Item(new FabricItemSettings()));
    public static final Item RAW_BACON = registerItem("raw_bacon", new Item(new FabricItemSettings().food(ModFoodComponents.RAW_BACON)));
    public static final Item BACON = registerItem("bacon", new Item(new FabricItemSettings().food(ModFoodComponents.BACON)));
    public static final Item CROISSANT = registerItem("croissant", new Item(new FabricItemSettings().food(ModFoodComponents.CROISSANT)));
    public static final Item BOLOGNA = registerItem("bologna", new Item(new FabricItemSettings().food(ModFoodComponents.BOLOGNA)));
    public static final Item CREAM_CHEESE = registerItem("cream_cheese", new Item(new FabricItemSettings().food(ModFoodComponents.CREAM_CHEESE)));
    public static final Item CHOCOLATE_SYRUP = registerItem("chocolate_syrup", new DrinkItem(new FabricItemSettings().food(ModFoodComponents.CHOCOLATE_SYRUP)));
    public static final Item FRUIT_SYRUP = registerItem("fruit_syrup", new DrinkItem(new FabricItemSettings().food(ModFoodComponents.FRUIT_SYRUP)));
    public static final Item WAFFLE = registerItem("waffle", new Item(new FabricItemSettings().food(ModFoodComponents.WAFFLE)));
    public static final Item CAKE_FORM = registerItem("cake_form", new Item(new FabricItemSettings()));
    public static final Item GELATIN = registerItem("gelatin", new Item(new FabricItemSettings().food(ModFoodComponents.GELATIN)));
    public static final Item COCOA_POWDER = registerItem("cocoa_powder", new Item(new FabricItemSettings()));
    public static final Item RAMEKIN = registerItem("ramekin", new Item(new FabricItemSettings()));
    public static final Item EGG_YOLKS = registerItem("egg_yolks", new Item(new FabricItemSettings()));
    public static final Item EGG_WHITES = registerItem("egg_whites", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CozyIngredients.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CozyIngredients.LOGGER.info("Registering Mod Items for " + CozyIngredients.MOD_ID);
    }
}
