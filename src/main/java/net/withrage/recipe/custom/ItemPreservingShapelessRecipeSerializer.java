package net.withrage.recipe.custom;

import com.google.gson.JsonObject;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.network.PacketByteBuf;

public class ItemPreservingShapelessRecipeSerializer implements RecipeSerializer<ItemPreservingShapelessRecipe> {
    @Override
    public ItemPreservingShapelessRecipe read(Identifier id, JsonObject json) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, json);
        return new ItemPreservingShapelessRecipe(
                base.getId(),
                base.getGroup(),
                base.getCategory(),
                base.getOutput(null),
                base.getIngredients()
        );
    }

    @Override
    public ItemPreservingShapelessRecipe read(Identifier id, PacketByteBuf buf) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, buf);
        return new ItemPreservingShapelessRecipe(
                base.getId(),
                base.getGroup(),
                base.getCategory(),
                base.getOutput(null),
                base.getIngredients()
        );
    }

    @Override
    public void write(PacketByteBuf buf, ItemPreservingShapelessRecipe recipe) {
        RecipeSerializer.SHAPELESS.write(buf, recipe);
    }
}
