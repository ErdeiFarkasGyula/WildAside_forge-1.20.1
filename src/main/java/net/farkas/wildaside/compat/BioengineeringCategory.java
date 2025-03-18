package net.farkas.wildaside.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.recipe.BioengineeringWorkstationRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class BioengineeringCategory implements IRecipeCategory<BioengineeringWorkstationRecipe> {
    public static final ResourceLocation UID = new ResourceLocation(WildAside.MOD_ID, "bioengineering");
    public static final ResourceLocation TEXTURE = new ResourceLocation(WildAside.MOD_ID, "textures/gui/bioengineering_workstation_gui.png");

    public static final RecipeType<BioengineeringWorkstationRecipe> BIOENGINEERING_TYPE =
            new RecipeType<>(UID, BioengineeringWorkstationRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public BioengineeringCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.BIOENGINEERING_WORKSTATION.get()));
    }

    @Override
    public RecipeType<BioengineeringWorkstationRecipe> getRecipeType() {
        return BIOENGINEERING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.wildaside.bioengineering_workstation");
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, BioengineeringWorkstationRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 32).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 14).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.INPUT, 61, 32).addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(RecipeIngredientRole.INPUT, 43, 50).addIngredients(recipe.getIngredients().get(3));
        builder.addSlot(RecipeIngredientRole.INPUT, 25, 32).addIngredients(recipe.getIngredients().get(4));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 32).addItemStack(recipe.getResultItem(null));
    }
}