package net.withrage;

import net.fabricmc.api.ModInitializer;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.block.entity.ModBlockEntities;
import net.withrage.block.ModBlocks;
import net.withrage.block.screen.ModScreenHandlers;
import net.withrage.item.*;
import net.withrage.recipe.ModRecipes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CozyIngredients implements ModInitializer {
	public static final String MOD_ID = "cozyingredients";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerScreenHandlers();
		ModBlockEntities.registerBlockEntities();
		ModRecipes.registerRecipes();
	}

	public static final RecipeSerializer<GlassOfWaterRecipe> GLASS_OF_WATER_RECIPE_RECIPE_SERIALIZER =
			Registry.register(Registries.RECIPE_SERIALIZER,
					new Identifier("cozyingredients", "glass_of_water"),
					new GlassOfWaterRecipeSerializer());

	public static final RecipeType<GlassOfWaterRecipe> GLASS_OF_WATER_RECIPE_RECIPE_TYPE =
			Registry.register(Registries.RECIPE_TYPE,
					new Identifier("cozyingredients", "glass_of_water"),
					new RecipeType<>() {
						public String toString() {
							return "cozyingredients:glass_of_water";
						}
					});

	public static final RecipeSerializer<MilkBoxRecipe> MILK_BOX_RECIPE_RECIPE_SERIALIZER =
			Registry.register(Registries.RECIPE_SERIALIZER,
					new Identifier("cozyingredients", "milk_box"),
					new MilkBoxRecipeSerializer());

	public static final RecipeType<MilkBoxRecipe> MILK_BOX_RECIPE_RECIPE_TYPE =
			Registry.register(Registries.RECIPE_TYPE,
					new Identifier("cozyingredients", "milk_box"),
					new RecipeType<>() {
						public String toString() {
							return "cozyingredients:milk_box";
						}
					});

	public static final StarchRecipeSerializer STARCH_RECIPE_RECIPE_SERIALIZER =
			Registry.register(Registries.RECIPE_SERIALIZER,
					new Identifier("cozyingredients", "starch"),
					new StarchRecipeSerializer());

	public static final RecipeType<StarchRecipe> STARCH_RECIPE_RECIPE_TYPE =
			Registry.register(Registries.RECIPE_TYPE,
					new Identifier("cozyingredients", "starch"),
					new RecipeType<>() {
						public String toString() {
							return "cozyingredients:starch";
						}
					});
}