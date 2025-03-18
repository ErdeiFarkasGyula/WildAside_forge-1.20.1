package net.farkas.wildaside.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.recipe.BioengineeringWorkstationRecipe;
import net.farkas.wildaside.screen.BioengineeringWorkstationScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIWildAsidePlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(WildAside.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new BioengineeringCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<BioengineeringWorkstationRecipe> bioengineeringRecipes = recipeManager.getAllRecipesFor(BioengineeringWorkstationRecipe.Type.INSTANCE);
        registration.addRecipes(BioengineeringCategory.BIOENGINEERING_TYPE, bioengineeringRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(BioengineeringWorkstationScreen.class, 93, 35, 26, 11, BioengineeringCategory.BIOENGINEERING_TYPE);
    }
}