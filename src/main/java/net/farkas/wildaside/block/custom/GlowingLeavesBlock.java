package net.farkas.wildaside.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.joml.Math;

public class GlowingLeavesBlock extends LeavesBlock {
    private static final int minLight = 0;
    private static final int maxLight = 7;
    public static final IntegerProperty LIGHT = IntegerProperty.create("light", minLight, maxLight);

    public GlowingLeavesBlock(Properties pProperties) {
        super(pProperties.lightLevel(s -> s.getValue(LIGHT)));
        this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(LIGHT, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(DISTANCE, PERSISTENT, WATERLOGGED, LIGHT);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.scheduleTick(pPos, this, 0);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);

        int time = (int)pLevel.dayTime();

        if (time > 22000) {
            int lightLevel = Math.round(7 - (maxLight * ((time - 22000f) / 2000f)));
            if (lightLevel < minLight) lightLevel = minLight;
            pLevel.setBlockAndUpdate(pPos, pLevel.getBlockState(pPos).setValue(LIGHT, lightLevel));
        } else
        if (time > 12000 && time < 14000) {
            int lightLevel = Math.round(maxLight * ((time - 12000f) / 2000f));
            if (lightLevel > maxLight) lightLevel = maxLight;
            pLevel.setBlockAndUpdate(pPos, pLevel.getBlockState(pPos).setValue(LIGHT, lightLevel));
        } else
        if (time > 14000) {
            pLevel.setBlockAndUpdate(pPos, pLevel.getBlockState(pPos).setValue(LIGHT, 7));
        } else
        if (time < 12000) {
            pLevel.setBlockAndUpdate(pPos, pLevel.getBlockState(pPos).setValue(LIGHT, 0));
        }

        int distance = pLevel.getBlockState(pPos).getValue(DISTANCE);
        pLevel.scheduleTick(pPos, this, 20 + (distance * 10));

    }
}
