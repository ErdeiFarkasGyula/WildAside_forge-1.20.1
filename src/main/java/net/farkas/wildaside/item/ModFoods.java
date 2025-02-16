package net.farkas.wildaside.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties VIBRION = new FoodProperties.Builder().nutrition(2).fast().alwaysEat()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.POISON, 200), 0.5f).build();
}