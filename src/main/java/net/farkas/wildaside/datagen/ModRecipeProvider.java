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
//      oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 0.25f, 100, "sapphire");


        //VIBRION
        oreSmelting(pWriter, List.of(ModItems.VIBRION.get()), RecipeCategory.MISC, Items.YELLOW_DYE, 0.25f, 200, "yellow dye");

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

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get(), 2)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.SUBSTILIUM_SOIL.get())
                .unlockedBy(getHasName(ModBlocks.SUBSTILIUM_SOIL.get()), has(ModBlocks.SUBSTILIUM_SOIL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get(), 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get())
                .unlockedBy(getHasName(ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get()), has(ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUBSTILIUM_TILES.get(), 4)
                .pattern("SS")
                .pattern("SS")
                .define('S', ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get())
                .unlockedBy(getHasName(ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get()), has(ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get()))
                .save(pWriter);

        Block tiles = ModBlocks.SUBSTILIUM_TILES.get();

        stoneCutting(pWriter, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get(), ModBlocks.CHISELLED_SUBSTILIUM_SOIL.get());
        stoneCutting(pWriter, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get(), ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get());
        stoneCutting(pWriter, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get(), tiles);
        stoneCutting(pWriter, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get(), ModBlocks.CRACKED_SUBSTILIUM_TILES.get());
        stoneCutting(pWriter, ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get(), tiles);
        stoneCutting(pWriter, ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get(), ModBlocks.CRACKED_SUBSTILIUM_TILES.get());
        stoneCutting(pWriter, tiles, ModBlocks.CRACKED_SUBSTILIUM_TILES.get());
        stoneCutting(pWriter, tiles, ModBlocks.SUBSTILIUM_TILE_STAIRS.get());
        stoneCutting(pWriter, tiles, ModBlocks.SUBSTILIUM_TILE_SLAB.get());
        stoneCutting(pWriter, tiles, ModBlocks.SUBSTILIUM_TILE_BUTTON.get());
        stoneCutting(pWriter, tiles, ModBlocks.SUBSTILIUM_TILE_PRESSURE_PLATE.get());
        stoneCutting(pWriter, tiles, ModBlocks.SUBSTILIUM_TILE_WALLS.get());

        stairsRecipe(pWriter, ModBlocks.SUBSTILIUM_TILE_STAIRS.get(), tiles);
        slab(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUBSTILIUM_TILE_SLAB.get(), tiles);
        buttonBuilder(ModBlocks.SUBSTILIUM_TILE_BUTTON.get(), Ingredient.of(tiles)).save(pWriter);
        pressurePlate(pWriter, ModBlocks.SUBSTILIUM_TILE_PRESSURE_PLATE.get(), tiles);
        wall(pWriter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUBSTILIUM_TILE_WALLS.get(), tiles);

        oreSmelting(pWriter, List.of(tiles), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_SUBSTILIUM_TILES.get(), 0.20f, 200, "cracked_substilium_tiles");

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

    protected static void stoneCutting(Consumer<FinishedRecipe> pWriter, ItemLike inputItem, ItemLike outputItem) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(inputItem), RecipeCategory.BUILDING_BLOCKS, outputItem).unlockedBy(getHasName(inputItem), has(inputItem))
                .save(pWriter, WildAside.MOD_ID + ":" + getItemName(outputItem) + "cut_from_" + getItemName(inputItem));
    }

    protected static void stairsRecipe(Consumer<FinishedRecipe> pWriter, ItemLike outputBlock, ItemLike inputBlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, outputBlock, 6)
                .pattern("S  ")
                .pattern("SS ")
                .pattern("SSS")
                .define('S', inputBlock)
                .unlockedBy(getHasName(inputBlock), has(inputBlock))
                .save(pWriter, WildAside.MOD_ID + ":" + getItemName(outputBlock) + "_1");

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, outputBlock, 6)
                .pattern("  S")
                .pattern(" SS")
                .pattern("SSS")
                .define('S', inputBlock)
                .unlockedBy(getHasName(inputBlock), has(inputBlock))
                .save(pWriter, WildAside.MOD_ID + ":" + getItemName(outputBlock) + "_2");

    }

    protected static void defaultWoodSet(Consumer<FinishedRecipe> pWriter, List<ItemLike> blocks) {
        ItemLike log = blocks.get(0);
        ItemLike str_log = blocks.get(1);
        ItemLike wood = blocks.get(2);
        ItemLike str_wood = blocks.get(3);
        Ingredient planks = Ingredient.of(blocks.get(4));
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
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, blocks.get(4), 4)
                    .requires(itemLike)
                    .unlockedBy(getHasName(itemLike), has(itemLike))
                    .group(getItemName(blocks.get(4)))
                    .save(pWriter, WildAside.MOD_ID + ":" + getItemName(blocks.get(4)) + "_" + getItemName(itemLike));
        }

        stairsRecipe(pWriter, stairs, blocks.get(4));
        slabBuilder(RecipeCategory.BUILDING_BLOCKS, slab, planks).save(pWriter);
        fenceBuilder(fence, planks).save(pWriter);
        fenceGateBuilder(gate, planks).save(pWriter);
        pressurePlateBuilder(RecipeCategory.REDSTONE, press, planks).save(pWriter);
        buttonBuilder(button, planks).save(pWriter);
        doorBuilder(door,  planks).save(pWriter);
        trapdoorBuilder(trapdoor, planks).save(pWriter);
        signBuilder(sign, planks).save(pWriter);
        hangingSign(pWriter, hang_sign, blocks.get(4));
        woodenBoat(pWriter, boat, blocks.get(4));
        chestBoat(pWriter, chest_boat, blocks.get(4));

    }
}