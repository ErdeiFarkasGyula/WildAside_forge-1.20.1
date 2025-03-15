package net.farkas.wildaside.block.custom.vibrion;

import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class SporeBlaster extends Block {
    public static final DirectionProperty FACING = DirectionalBlock.FACING;
    public boolean natural = false;

    BlockState spore_air = ModBlocks.SPORE_AIR.get().defaultBlockState();

    public SporeBlaster(Properties pProperties, boolean natural) {
        super(pProperties);
        this.natural = natural;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getNearestLookingDirection().getOpposite());
    }

    @Override
    public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {
        return true;
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        pLevel.scheduleTick(pPos, this, 10);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        spawnSporeAir(pLevel, pPos, pRandom);
        if (natural) spawnSporeAirOpposite(pLevel, pPos, pRandom);
        pLevel.scheduleTick(pPos, this, 5);
        super.tick(pState, pLevel, pPos, pRandom);
    }

    public void spawnSporeAir(ServerLevel level, BlockPos pos, RandomSource random) {
        Direction direction = level.getBlockState(pos).getValue(FACING);
        int power = natural ? random.nextIntBetweenInclusive(1, 15) : level.getBestNeighborSignal(pos);

        for (int i = 1; i <= power; i++) {
            var nextBlock = level.getBlockState(pos.relative(direction, i));
            var position = pos.relative(direction, i);

            if (nextBlock.isCollisionShapeFullBlock(level, position)) return;
            if (nextBlock.isAir()) level.setBlockAndUpdate(position, spore_air);
        }
    }

    public void spawnSporeAirOpposite(ServerLevel level, BlockPos pos, RandomSource random) {
        Direction direction = level.getBlockState(pos).getValue(FACING).getOpposite();
        int power = random.nextIntBetweenInclusive(1, 15);

        for (int i = 1; i <= power; i++) {
            var nextBlock = level.getBlockState(pos.relative(direction, i));
            var position = pos.relative(direction, i);

            if (nextBlock.isCollisionShapeFullBlock(level, position)) return;
            if (nextBlock.isAir()) level.setBlockAndUpdate(position, spore_air);
        }
    }
}
