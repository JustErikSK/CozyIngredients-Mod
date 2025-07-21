package net.withrage.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipes {
    public static RecipeType<ToasterRecipe> TOASTER_TYPE;
    public static RecipeSerializer<ToasterRecipe> TOASTER_SERIALIZER;

    public static void registerRecipes() {
        TOASTER_TYPE = Registry.register(Registries.RECIPE_TYPE, new Identifier("cozyingredients", "toasting"), new RecipeType<>() {
            public String toString() {
                return "cozyingredients:toasting";
            }
        });
        TOASTER_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, new Identifier("cozyingredients", "toasting"), new ToasterRecipeSerializer());
    }
}
