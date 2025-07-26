package net.withrage.item;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

public class StarchRecipeSerializer implements RecipeSerializer<GlassOfWaterRecipe> {
    public static final Identifier ID = new Identifier("cozyingredients", "starch");

    @Override
    public GlassOfWaterRecipe read(Identifier id, JsonObject json) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, json);
        return new GlassOfWaterRecipe(id, base.getGroup(), base.getOutput(null), base.getIngredients());
    }

    @Override
    public GlassOfWaterRecipe read(Identifier id, PacketByteBuf buf) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, buf);
        return new GlassOfWaterRecipe(id, base.getGroup(), base.getOutput(null), base.getIngredients());
    }

    @Override
    public void write(PacketByteBuf buf, GlassOfWaterRecipe recipe) {
        RecipeSerializer.SHAPELESS.write(buf, recipe);
    }
}
