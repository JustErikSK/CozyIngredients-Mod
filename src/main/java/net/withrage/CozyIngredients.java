package net.withrage;

import net.fabricmc.api.ModInitializer;

import net.withrage.item.ModItemGroups;
import net.withrage.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CozyIngredients implements ModInitializer {
	public static final String MOD_ID = "cozyingredients";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}