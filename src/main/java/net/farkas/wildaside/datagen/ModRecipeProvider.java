package net.farkas.wildaside.datagen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
//    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.RAW_SAPPHIRE.get(),
//            ModBlocks.SAPPHIRE_ORE.get(), ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get(), ModBlocks.NETHER_SAPPHIRE_ORE.get(),
//            ModBlocks.END_STONE_SAPPHIRE_ORE.get());



    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, List.of(ModItems.VIBRION.get()), RecipeCategory.MISC, Items.YELLOW_DYE, 0.25f, 200, "yellow dye");
//        oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");


        //VIBRION
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.VIBRION_BLOCK.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.VIBRION.get())
                .unlockedBy(getHasName(ModItems.VIBRION.get()), has(ModItems.VIBRION.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.VIBRION.get(), 4)
                .requires(ModBlocks.VIBRION_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.VIBRION_BLOCK.get()), has(ModBlocks.VIBRION_BLOCK.get()))
                .save(pWriter);

        //ENTORIUM

        //SUBSTILIUM
        List<ItemLike> SUBSTILIUM_WOODSET = List.of(ModBlocks.SUBSTILIUM_STEM.get().asItem(), ModBlocks.STRIPPED_SUBSTILIUM_STEM.get(),
                ModBlocks.SUBSTILIUM_WOOD.get(), ModBlocks.STRIPPED_SUBSTILIUM_WOOD.get(), ModBlocks.SUBSTILIUM_PLANKS.get(),
                ModBlocks.SUBSTILIUM_STAIRS.get(), ModBlocks.SUBSTILIUM_SLAB.get(), ModBlocks.SUBSTILIUM_FENCE.get(),
                ModBlocks.SUBSTILIUM_FENCE_GATE.get(),  ModBlocks.SUBSTILIUM_PRESSURE_PLATE.get(), ModBlocks.SUBSTILIUM_BUTTON.get(),
                ModBlocks.SUBSTILIUM_DOOR.get(), ModBlocks.SUBSTILIUM_TRAPDOOR.get(), ModBlocks.SUBSTILIUM_SIGN.get(), ModBlocks.SUBSTILIUM_HANGING_SIGN.get(),
                ModItems.SUBSTILIUM_BOAT.get(), ModItems.SUBSTILIUM_CHEST_BOAT.get());

        defaultWoodSet(pWriter, SUBSTILIUM_WOODSET);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  WildAside.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    protected static void stairsRecipe(Consumer<FinishedRecipe> pWriter, ItemLike stairsBlock, ItemLike originBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairsBlock, 6)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', originBlock)
                .unlockedBy(getHasName(originBlock), has(originBlock))
                .save(pWriter, WildAside.MOD_ID + ":" + getItemName(stairsBlock) + "_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, stairsBlock, 6)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .define('S', originBlock)
                .unlockedBy(getHasName(originBlock), has(originBlock))
                .save(pWriter, WildAside.MOD_ID + ":" + getItemName(stairsBlock) + "_2");

    }

    protected static void defaultWoodSet(Consumer<FinishedRecipe> pWriter, List<ItemLike> blocks) {
        ItemLike log = blocks.get(0);
        ItemLike str_log = blocks.get(1);
        ItemLike wood = blocks.get(2);
        ItemLike str_wood = blocks.get(3);
        ItemLike planks = blocks.get(4);
        ItemLike stairs = blocks.get(5);
        ItemLike slab = blocks.get(6);
        ItemLike fence = blocks.get(7);
        ItemLike gate = blocks.get(8);
        ItemLike press = blocks.get(9);
        ItemLike button = blocks.get(10);
        ItemLike door = blocks.get(11);
        ItemLike trapdoor = blocks.get(12);
        ItemLike sign = blocks.get(13);
        ItemLike hang_sign = blocks.get(14);
        ItemLike boat = blocks.get(15);
        ItemLike chest_boat = blocks.get(16);

        List<ItemLike> PLANKS_ORIGIN = List.of(log, str_log, wood, str_wood);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, wood, 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', log.asItem())
                .unlockedBy(getHasName(log), has(log))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, str_wood, 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', str_log.asItem())
                .unlockedBy(getHasName(str_log), has(str_log))
                .save(pWriter);

        for (ItemLike itemLike : PLANKS_ORIGIN) {
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, planks, 4)
                    .requires(itemLike)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(pWriter, WildAside.MOD_ID + ":" + getItemName(planks) + "_" + getItemName(itemLike));
        }

        stairsRecipe(pWriter, stairs, planks);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, slab, 4)
                .pattern("SSS")
                .define('S', planks.asItem())
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, fence, 3)
                .pattern("SXS")
                .pattern("SXS")
                .define('S', planks.asItem())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, gate)
                .pattern("XSX")
                .pattern("XSX")
                .define('S', planks.asItem())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, press)
                .pattern("SS")
                .define('S', planks.asItem())
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, button)
                .requires(planks)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, door, 3)
                .pattern("SS")
                .pattern("SS")
                .pattern("SS")
                .define('S', planks.asItem())
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, trapdoor, 2)
                .pattern("SSS")
                .pattern("SSS")
                .define('S', planks.asItem())
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, sign, 3)
                .pattern("SSS")
                .pattern("SSS")
                .pattern(" X ")
                .define('S', planks.asItem())
                .define('X', Items.STICK)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, hang_sign, 6)
                .pattern("X X")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', planks.asItem())
                .define('X', Blocks.CHAIN)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, boat)
                .pattern("S S")
                .pattern("SSS")
                .define('S', planks.asItem())
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, chest_boat)
                .pattern("SXS")
                .pattern("SSS")
                .define('S', planks.asItem())
                .define('X', Items.CHEST)
                .unlockedBy(getHasName(planks), has(planks))
                .save(pWriter);
    }
}