package net.withrage;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.withrage.block.screen.ModScreenHandlers;
import net.withrage.block.screen.ToasterScreen;

public class CozyIngredientsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.TOASTER_SCREEN_HANDLER, ToasterScreen::new);
    }
}
