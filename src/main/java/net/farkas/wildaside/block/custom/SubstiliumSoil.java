package net.farkas.wildaside.block.custom;

import net.farkas.wildaside.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraftforge.common.IPlantable;

public class SubstiliumSoil extends Block {
    public static BooleanProperty FREE_X = BooleanProperty.create("free_x");
    public static BooleanProperty FREE_Y = BooleanProperty.create("free_y");
    public static BooleanProperty FREE_Z = BooleanProperty.create("free_z");

    public SubstiliumSoil(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FREE_X, false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FREE_Y, false));
        this.registerDefaultState(this.stateDefinition.any().setValue(FREE_Z, false));

    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FREE_X);
        builder.add(FREE_Y);
        builder.add(FREE_Z);
    }

    @Override
    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pMovedByPiston) {
        changeFaceProperties(pLevel, pPos);
        super.onPlace(pState, pLevel, pPos, pOldState, pMovedByPiston);
    }

    @Override
    public void onNeighborChange(BlockState state, LevelReader level, BlockPos pos, BlockPos neighbor) {
        changeFaceProperties((Level)level, pos);
        super.onNeighborChange(state, level, pos, neighbor);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.getBlockState(pPos.above()).isCollisionShapeFullBlock(pLevel, pPos.above())) {
            for (int i = 0; i < Mth.nextInt(pRandom, 1, 3); i++) {
                pLevel.addParticle(ModParticles.SUBSTILIUM_PARTICLE.get(), (pPos.getX() + Math.random()), (pPos.getY() + 1), (pPos.getZ() + Math.random()),
                        0, (Mth.nextInt(pRandom, 7, 13) / 1000), 0);
            }
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    public void changeFaceProperties(Level pLevel, BlockPos pPos) {
        pLevel.getBlockState(pPos).setValue(FREE_X, pLevel.getBlockState(pPos.west()).isCollisionShapeFullBlock(pLevel, pPos.west()) ||
                pLevel.getBlockState(pPos.east()).isCollisionShapeFullBlock(pLevel, pPos.east()));
        pLevel.getBlockState(pPos).setValue(FREE_Y, pLevel.getBlockState(pPos.above()).isCollisionShapeFullBlock(pLevel, pPos.above()) ||
                pLevel.getBlockState(pPos.below()).isCollisionShapeFullBlock(pLevel, pPos.below()));
        pLevel.getBlockState(pPos).setValue(FREE_Z, pLevel.getBlockState(pPos.north()).isCollisionShapeFullBlock(pLevel, pPos.north()) ||
                pLevel.getBlockState(pPos.south()).isCollisionShapeFullBlock(pLevel, pPos.south()));
    }
}
