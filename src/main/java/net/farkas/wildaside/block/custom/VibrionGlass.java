package net.farkas.wildaside.block.custom;

import net.farkas.wildaside.util.ModTags;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.state.BlockState;

public class VibrionGlass extends GlassBlock {
    public VibrionGlass(Properties p_53640_) {
        super(p_53640_);
    }

    @Override
    public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.is(ModTags.Blocks.VIBRION_GLASSES)  ? true : super.skipRendering(state, adjacentBlockState, side);
    }
}
