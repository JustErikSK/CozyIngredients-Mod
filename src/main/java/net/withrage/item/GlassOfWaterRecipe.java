package net.withrage.item;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class GlassOfWaterRecipe extends ShapelessRecipe {
    public GlassOfWaterRecipe(Identifier id, String group, ItemStack output, DefaultedList<Ingredient> ingredients) {
        super(id, group, CraftingRecipeCategory.MISC, output, ingredients);
    }

    public DefaultedList<ItemStack> getRemainder(CraftingInventory inventory) {
        DefaultedList<ItemStack> remaining = DefaultedList.ofSize(inventory.size(), ItemStack.EMPTY);

        for (int i = 0; i < inventory.size(); ++i) {
            ItemStack item = inventory.getStack(i);
            if (item.isOf(Items.WATER_BUCKET)) {
                remaining.set(i, new ItemStack(Items.BUCKET));
            } else if (item.getItem().hasRecipeRemainder()) {
                Item remainderItem = item.getItem().getRecipeRemainder();
                if (remainderItem != null) {
                    remaining.set(i, new ItemStack(remainderItem));
                }
            }
        }
        return remaining;
    }
}
