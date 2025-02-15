package net.farkas.wildaside.datagen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.internal.ir.Block;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, WildAside.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.VIBRION_GELS)
                .add(ModBlocks.VIBRION_GEL.get())
                .add(ModBlocks.LIT_VIBRION_GEL.get());

        this.tag(ModTags.Blocks.VIBRION_GLASSES)
                .add(ModBlocks.VIBRION_GLASS.get())
                .add(ModBlocks.LIT_VIBRION_GLASS.get())
                .add(ModBlocks.VIBRION_GLASS_PANE.get())
                .add(ModBlocks.LIT_VIBRION_GLASS_PANE.get());

        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SUBSTILIUM_SOIL.get());

        this.tag(BlockTags.MINEABLE_WITH_HOE)
                .add(ModBlocks.VIBRION_GEL.get())
                .add(ModBlocks.LIT_VIBRION_GEL.get())
                .add(ModBlocks.VIBRION_GLASS.get())
                .add(ModBlocks.ENTORIUM_SHROOM.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SUBSTILIUM_STEM.get())
                .add(ModBlocks.SUBSTILIUM_WOOD.get())
                .add(ModBlocks.SUBSTILIUM_PLANKS.get())
                .add(ModBlocks.SUBSTILIUM_STAIRS.get())
                .add(ModBlocks.SUBSTILIUM_SLAB.get())
                .add(ModBlocks.SUBSTILIUM_PRESSURE_PLATE.get())
                .add(ModBlocks.SUBSTILIUM_BUTTON.get())
                .add(ModBlocks.SUBSTILIUM_DOOR.get())
                .add(ModBlocks.SUBSTILIUM_TRAPDOOR.get())
                .add(ModBlocks.SUBSTILIUM_FENCE.get())
                .add(ModBlocks.SUBSTILIUM_FENCE_GATE.get())
                .add(ModBlocks.SUBSTILIUM_SIGN.get())
                .add(ModBlocks.SUBSTILIUM_HANGING_SIGN.get());


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.SUBSTILIUM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.SUBSTILIUM_FENCE_GATE.get());
    }
}