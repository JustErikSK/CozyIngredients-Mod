package net.withrage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;
import net.withrage.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup COZY_INGREDIENTS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CozyIngredients.MOD_ID, "apple_jam"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.cozyingredients"))
                    .icon(() -> new ItemStack(ModItems.APPLE_JAM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.APPLE_JAM);
                        entries.add(ModItems.SWEETBERRY_JAM);
                        entries.add(ModItems.GLOWBERRY_JAM);
                        entries.add(ModItems.CARAMEL);
                        entries.add(ModItems.NUHTELLA);
                        entries.add(ModItems.SLICE_OF_BREAD);
                        entries.add(ModItems.TOAST);
                        entries.add(ModItems.BURNED_TOAST);
                        entries.add(ModItems.BURGER_BUN);
                        entries.add(ModItems.BAGEL);
                        entries.add(ModItems.BAGUETTE);
                        entries.add(ModItems.ICE_CREAM_CONE);
                        entries.add(ModItems.BUTTER);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.MILK_BOX);
                        entries.add(ModItems.GLASS_OF_WATER);
                        entries.add(ModItems.BOILED_EGG);
                        entries.add(ModItems.SUNNY_SIDE_UP_EGG);
                        entries.add(ModItems.FISHCAKE);
                        entries.add(ModItems.NOODLES);
                        entries.add(ModItems.RAW_CHIPS);
                        entries.add(ModItems.RAW_FRIES);
                        entries.add(ModItems.RAW_DINO_NUGGETS);
                        entries.add(ModItems.RAW_BACON);
                        entries.add(ModItems.BACON);
                        entries.add(ModItems.MINCED_BEEF);
                        entries.add(ModItems.MINCED_CHICKEN);
                        entries.add(ModItems.MINCED_LAMB);
                        entries.add(ModItems.MINCED_PORK);
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.FLOUR);
                        entries.add(ModItems.STARCH);
                        entries.add(ModItems.POWDERED_SUGAR);
                        entries.add(ModItems.WHIPPED_CREAM);
                        entries.add(ModItems.DOUGH);
                        entries.add(ModItems.JAR);
                        entries.add(ModItems.WHISK);
                        entries.add(ModItems.COOKING_KNIFE);
                        entries.add(ModItems.CLEAVER);
                        entries.add(ModItems.COOKING_POT);
                        entries.add(ModItems.PAN);
                        entries.add(ModItems.COOKIE_CUTTER);
                        entries.add(ModBlocks.TOASTER);
                        entries.add(ModBlocks.CUTTING_BOARD);
                        entries.add(ModBlocks.CLOTH);
                    }).build());

    public static void registerItemGroups() {
        CozyIngredients.LOGGER.info("Registering Item Groups for " + CozyIngredients.MOD_ID);
    }
}
