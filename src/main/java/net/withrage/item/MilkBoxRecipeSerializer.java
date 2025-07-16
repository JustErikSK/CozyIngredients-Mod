package net.withrage.item;

import com.google.gson.JsonObject;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.util.Identifier;

public class MilkBoxRecipeSerializer implements RecipeSerializer<MilkBoxRecipe> {
    public static final Identifier ID = new Identifier("cozyingredients", "milk_box");

    @Override
    public MilkBoxRecipe read(Identifier id, JsonObject json) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, json);
        return new MilkBoxRecipe(id, base.getGroup(), base.getOutput(null), base.getIngredients());
    }

    @Override
    public MilkBoxRecipe read(Identifier id, PacketByteBuf buf) {
        ShapelessRecipe base = RecipeSerializer.SHAPELESS.read(id, buf);
        return new MilkBoxRecipe(id, base.getGroup(), base.getOutput(null), base.getIngredients());
    }

    @Override
    public void write(PacketByteBuf buf, MilkBoxRecipe recipe) {
        RecipeSerializer.SHAPELESS.write(buf, recipe);
    }
}
