package net.farkas.wildaside.recipe;

import net.farkas.wildaside.WildAside;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, WildAside.MOD_ID);

    public static final RegistryObject<RecipeSerializer<BioengineeringWorkstationRecipe>> BIOENGINEERING_RECIPE =
            SERIALIZERS.register("bioengineering", () -> BioengineeringWorkstationRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}