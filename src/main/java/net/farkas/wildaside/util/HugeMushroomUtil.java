package net.farkas.wildaside.util;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;

public class HugeMushroomUtil {
    public static boolean isValidMushroomPosition(LevelReader world, BlockPos pos) {
        BlockState block = world.getBlockState(pos.below());
        return block.is(ModTags.Blocks.HUGE_MUSHROOM_GROW_BLOCK);
    }
}