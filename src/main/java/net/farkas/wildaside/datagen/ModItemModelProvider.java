package net.farkas.wildaside.datagen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, WildAside.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.VIBRION);
        simpleItem(ModItems.ENTORIUM);


        simpleItem(ModItems.SUBSTILIUM_SIGN);
        simpleItem(ModItems.SUBSTILIUM_HANGING_SIGN);

        simpleBlockItem(ModBlocks.SUBSTILIUM_DOOR);
        trapdoorItem(ModBlocks.SUBSTILIUM_TRAPDOOR);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_STEM);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_WOOD);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_STAIRS);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_SLAB);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_FENCE_GATE);
        evenSimplerBlockItem(ModBlocks.SUBSTILIUM_PRESSURE_PLATE);
        fenceItem(ModBlocks.SUBSTILIUM_FENCE, ModBlocks.SUBSTILIUM_PLANKS);
        buttonItem(ModBlocks.SUBSTILIUM_BUTTON, ModBlocks.SUBSTILIUM_PLANKS);
        evenSimplerBlockItem(ModBlocks.VIBRION_GLASS_PANE);
        evenSimplerBlockItem(ModBlocks.LIT_VIBRION_GLASS_PANE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WildAside.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(WildAside.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(WildAside.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(WildAside.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(WildAside.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(WildAside.MOD_ID,"item/" + item.getId().getPath()));
    }
}