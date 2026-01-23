package net.withrage.compat.jei;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;
import net.withrage.block.ModBlocks;
import net.withrage.recipe.ModRecipes;
import net.withrage.recipe.ToasterRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@JeiPlugin
public class CozyIngredientsJEIPlugin implements IModPlugin {
    private static final Identifier ID = new Identifier(CozyIngredients.MOD_ID, "jei_plugin");

    static {
        CozyIngredients.LOGGER.info("JEI PLUGIN CLASS LOADED");
    }

    public CozyIngredientsJEIPlugin() {
        CozyIngredients.LOGGER.info("JEI PLUGIN INSTANCE CREATED");
    }

    @Override
    public @NotNull Identifier getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();
        registration.addRecipeCategories(new ToasterRecipeCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        var client = MinecraftClient.getInstance();
        if (client.getNetworkHandler() == null) return;
        RecipeManager manager = client.getNetworkHandler().getRecipeManager();
        List<ToasterRecipe> recipes =
                manager.listAllOfType(ModRecipes.TOASTER_TYPE);
        CozyIngredients.LOGGER.info("Registering {} toaster recipes into JEI", recipes.size());
        registration.addRecipes(ModJEIRecipeTypes.TOASTING, recipes);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.TOASTER), ModJEIRecipeTypes.TOASTING);
    }
}
