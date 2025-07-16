package net.withrage.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;

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
                        entries.add(ModItems.SALT);
                        entries.add(ModItems.BUTTER);
                        entries.add(ModItems.CHEESE);
                        entries.add(ModItems.FLOUR);
                        entries.add(ModItems.ICE_CREAM_CONE);
                        entries.add(ModItems.POWDERED_SUGAR);
                        entries.add(ModItems.WHIPPED_CREAM);
                        entries.add(ModItems.JAR);
                        entries.add(ModItems.MILK_BOX);
                        entries.add(ModItems.GLASS_OF_WATER);
                        entries.add(ModItems.WHISK);
                        entries.add(ModItems.COOKING_KNIFE);
                        entries.add(ModItems.COOKING_POT);
                        entries.add(ModItems.TOASTER);
                        entries.add(ModItems.SLICE_OF_BREAD);
                    }).build());

    public static void registerItemGroups() {
        CozyIngredients.LOGGER.info("Registering Item Groups for " + CozyIngredients.MOD_ID);
    }
}
