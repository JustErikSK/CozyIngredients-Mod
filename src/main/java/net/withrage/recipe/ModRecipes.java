package net.withrage.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.withrage.CozyIngredients;

public class ModRecipes {
    public static final RecipeType<ToasterRecipe> TOASTER_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return CozyIngredients.MOD_ID + ":toasting";
        }
    };

    public static final RecipeSerializer<ToasterRecipe> TOASTER_SERIALIZER =
            new ToasterRecipeSerializer();

    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_TYPE, new Identifier(CozyIngredients.MOD_ID, "toasting"), TOASTER_TYPE);
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(CozyIngredients.MOD_ID, "toasting"), TOASTER_SERIALIZER);
    }
}
