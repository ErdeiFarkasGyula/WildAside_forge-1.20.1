package net.farkas.wildaside.datagen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, WildAside.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SUBSTILIUM_SOIL);
        axisBlock(((RotatedPillarBlock) ModBlocks.SUBSTILIUM_STEM.get()), modLoc("block/substilium_stem_side"), modLoc("block/substilium_stem_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.SUBSTILIUM_WOOD.get()), modLoc("block/substilium_stem_side"), modLoc("block/substilium_stem_side"));
        blockWithItem(ModBlocks.SUBSTILIUM_PLANKS);
        stairsBlock(((StairBlock)ModBlocks.SUBSTILIUM_STAIRS.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        slabBlock(((SlabBlock)ModBlocks.SUBSTILIUM_SLAB.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        buttonBlock(((ButtonBlock)ModBlocks.SUBSTILIUM_BUTTON.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock)ModBlocks.SUBSTILIUM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        fenceBlock(((FenceBlock)ModBlocks.SUBSTILIUM_FENCE.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock)ModBlocks.SUBSTILIUM_FENCE_GATE.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock)ModBlocks.SUBSTILIUM_DOOR.get()), modLoc("block/substilium_door_bottom"), modLoc("block/substilium_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock)ModBlocks.SUBSTILIUM_TRAPDOOR.get()), modLoc("block/substilium_trapdoor"), true, "cutout");

        blockWithItem(ModBlocks.VIBRION_BLOCK);
        translucentBlockWithItem(ModBlocks.VIBRION_GEL);
        simpleBlockWithItem(ModBlocks.LIT_VIBRION_GEL.get(), translucentAll(ModBlocks.VIBRION_GEL.get()));
        translucentBlockWithItem(ModBlocks.VIBRION_GLASS);
        simpleBlockWithItem(ModBlocks.LIT_VIBRION_GLASS.get(), translucentAll(ModBlocks.VIBRION_GLASS.get()));
        paneBlockWithRenderType(((IronBarsBlock)ModBlocks.VIBRION_GLASS_PANE.get()), modLoc("block/vibrion_glass"), modLoc("block/vibrion_glass"), "translucent");
        paneBlockWithRenderType(((IronBarsBlock)ModBlocks.LIT_VIBRION_GLASS_PANE.get()), modLoc("block/vibrion_glass"), modLoc("block/vibrion_glass"), "translucent");


        signBlock(((StandingSignBlock) ModBlocks.SUBSTILIUM_SIGN.get()), ((WallSignBlock) ModBlocks.SUBSTILIUM_WALL_SIGN.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
        hangingSignBlock((ModBlocks.SUBSTILIUM_HANGING_SIGN.get()), (ModBlocks.SUBSTILIUM_WALL_HANGING_SIGN.get()), blockTexture(ModBlocks.SUBSTILIUM_PLANKS.get()));
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation texture) {
        ModelFile sign = models().sign(name(signBlock), texture);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void translucentBlockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), translucentAll(blockRegistryObject.get()));
    }

    public ModelFile translucentAll(Block block) {
        return this.models().cubeAll(this.name(block), this.blockTexture(block)).renderType("translucent");
    }
}