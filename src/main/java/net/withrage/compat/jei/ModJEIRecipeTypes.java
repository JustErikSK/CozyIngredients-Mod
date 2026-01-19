package net.withrage.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import net.withrage.recipe.ToasterRecipe;

public class ModJEIRecipeTypes {
    public static final RecipeType<ToasterRecipe> TOASTING =
            RecipeType.create("cozyingredients", "toasting", ToasterRecipe.class);
}
