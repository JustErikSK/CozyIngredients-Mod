package net.withrage.block;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.withrage.CozyIngredients;
import net.withrage.block.entity.ToasterBlockEntity;

public class ModBlockEntities {
    public static BlockEntityType<ToasterBlockEntity> TOASTER;

    public static void registerAll() {
        TOASTER = Registry.register(
                Registries.BLOCK_ENTITY_TYPE,
                new Identifier("cozyingredients", "toaster"),
                FabricBlockEntityTypeBuilder.create(ToasterBlockEntity::new, ModBlocks.TOASTER).build(null)
        );
    }

    public static void registerBlockEntities() {
        CozyIngredients.LOGGER.info("Registering Block Entities for " + CozyIngredients.MOD_ID);
    }
}
