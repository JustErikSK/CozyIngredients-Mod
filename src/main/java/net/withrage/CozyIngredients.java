package net.withrage;

import net.fabricmc.api.ModInitializer;
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
}