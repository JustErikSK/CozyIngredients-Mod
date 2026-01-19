package net.withrage.compat.jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;
import net.withrage.block.ModBlocks;
import net.withrage.recipe.ToasterRecipe;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ToasterRecipeCategory implements IRecipeCategory<ToasterRecipe> {
    private static final Identifier GUI_TEX = new Identifier(CozyIngredients.MOD_ID, "textures/gui/toaster_gui.png");
    private final IDrawable background;
    private final IDrawable icon;
    private final IDrawableStatic arrowStatic;
    private final IDrawableAnimated arrowAnimated;

    public ToasterRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(GUI_TEX, 0, 0, 176, 80);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TOASTER));
        int arrowU = 176;
        int arrowV = 0;
        int arrowW = 6;
        int arrowH = 26;
        this.arrowStatic = guiHelper.createDrawable(new Identifier("cozyingredients", "textures/gui/toaster_gui.png"), arrowU, arrowV, arrowW, arrowH);
        int durationTicks = 72;
        this.arrowAnimated = guiHelper.createAnimatedDrawable(arrowStatic, durationTicks, IDrawableAnimated.StartDirection.BOTTOM, false);
    }

    @Override
    public mezz.jei.api.recipe.@NotNull RecipeType<ToasterRecipe> getRecipeType() {
        return ModJEIRecipeTypes.TOASTING;
    }

    @Override
    public @NotNull Text getTitle() {
        return Text.literal("Toasting");
    }

    @Override @SuppressWarnings("removal")
    public @NotNull IDrawable getBackground() {
        return background;
    }

    @Override
    public @NotNull IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ToasterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 80, 59)
                .addItemStacks(List.of(recipe.getInput().getMatchingStacks()));
        assert MinecraftClient.getInstance().world != null;
        ItemStack out = recipe.getOutput(MinecraftClient.getInstance().world.getRegistryManager());
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 11)
                .addItemStack(out);
    }

    @Override
    public void draw(ToasterRecipe recipe, IRecipeSlotsView recipeSlotsView, DrawContext context, double mouseX, double mouseY) {
        int arrowX = 84;
        int arrowY = 30;
        arrowAnimated.draw(context, arrowX, arrowY);
    }
}
