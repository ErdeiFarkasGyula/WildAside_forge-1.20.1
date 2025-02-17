package net.farkas.wildaside.block.custom.vibrion.hanging_vines;

import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.WeepingVinesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class HangingVibrionVines extends WeepingVinesBlock {
    public HangingVibrionVines(Properties p_154966_) {
        super(p_154966_);
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return true;
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.HANGING_VIBRION_VINES_PLANT.get();
    }
}
