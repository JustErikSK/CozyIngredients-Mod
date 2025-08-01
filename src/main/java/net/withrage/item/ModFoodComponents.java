package net.withrage.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent APPLE_JAM = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent BACON = new FoodComponent.Builder()
            .hunger(5)
            .saturationModifier(0.5f)
            .snack()
            .meat()
            .build();

    public static final FoodComponent BAGEL = new FoodComponent.Builder()
            .hunger(6)
            .saturationModifier(0.4f)
            .build();

    public static final FoodComponent BAGUETTE = new FoodComponent.Builder()
            .hunger(7)
            .saturationModifier(0.5f)
            .build();

    public static final FoodComponent BOILED_EGG = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.45f)
            .snack()
            .build();

    public static final FoodComponent BURGER_BUN = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .snack()
            .build();

    public static final FoodComponent BURNED_TOAST = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 40, 1), 100)
            .build();

    public static final FoodComponent BUTTER = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.15f)
            .snack()
            .build();

    public static final FoodComponent CARAMEL = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.2f)
            .snack()
            .build();

    public static final FoodComponent CHEESE = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .snack()
            .build();

    public static final FoodComponent FISHCAKE = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.15f)
            .alwaysEdible()
            .snack()
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1200, 1), 20)
            .build();

    public static final FoodComponent GLASS_OF_WATER = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent GLOWBERRY_JAM = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.2f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent ICE_CREAM_CONE = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.15f)
            .snack()
            .build();

    public static final FoodComponent MILK_BOX = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.4f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent MINCED_BEEF = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.1f)
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 60, 1), 20)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 20)
            .build();

    public static final FoodComponent MINCED_CHICKEN = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.1f)
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 60, 1), 20)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 20)
            .build();

    public static final FoodComponent MINCED_LAMB = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.1f)
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 60, 1), 20)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 20)
            .build();

    public static final FoodComponent MINCED_PORK = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.1f)
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 60, 1), 20)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 20)
            .build();

    public static final FoodComponent NOODLES = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .snack()
            .build();

    public static final FoodComponent NUHTELLA = new FoodComponent.Builder()
            .hunger(5)
            .saturationModifier(0.5f)
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 800, 1), 60)
            .build();

    public static final FoodComponent RAW_BACON = new FoodComponent.Builder()
            .hunger(2)
            .saturationModifier(0.1f)
            .snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 15)
            .build();

    public static final FoodComponent RAW_CHIPS = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .snack()
            .build();

    public static final FoodComponent RAW_DINO_NUGGETS = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.1f)
            .snack()
            .meat()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 60, 1), 70)
            .build();

    public static final FoodComponent RAW_FRIES = new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.1f)
            .snack()
            .build();

    public static final FoodComponent SLICE_OF_BREAD = new FoodComponent.Builder()
            .hunger(5)
            .saturationModifier(0.3f)
            .snack()
            .build();

    public static final FoodComponent SUNNY_SIDE_UP_EGG = new FoodComponent.Builder()
            .hunger(3)
            .saturationModifier(0.4f)
            .snack()
            .build();

    public static final FoodComponent SWEETBERRY_JAM = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.3f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent TOAST = new FoodComponent.Builder()
            .hunger(7)
            .saturationModifier(0.55f)
            .build();

    public static final FoodComponent CROISSANT = new FoodComponent.Builder()
            .hunger(5)
            .saturationModifier(0.35f)
            .build();
}