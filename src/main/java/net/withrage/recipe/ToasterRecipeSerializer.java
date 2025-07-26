package net.withrage.recipe;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.util.Identifier;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemStack;
import com.google.gson.JsonObject;
import net.minecraft.util.JsonHelper;

public class ToasterRecipeSerializer implements RecipeSerializer<ToasterRecipe> {
    @Override
    public ToasterRecipe read(Identifier id, JsonObject json) {
        Ingredient input = Ingredient.fromJson(JsonHelper.getObject(json, "input"));
        ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json, "output"));
        return new ToasterRecipe(id, input, output);
    }

    @Override
    public ToasterRecipe read(Identifier id, PacketByteBuf buf) {
        Ingredient input = Ingredient.fromPacket(buf);
        ItemStack output = buf.readItemStack();
        return new ToasterRecipe(id, input, output);
    }

    @Override
    public void write(PacketByteBuf buf, ToasterRecipe recipe) {
        recipe.getInput().write(buf);
        buf.writeItemStack(recipe.getOutput(null));
    }
}
