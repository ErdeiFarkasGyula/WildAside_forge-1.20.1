package net.farkas.wildaside.block.custom;

import net.farkas.wildaside.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.IPlantable;

public class SubstiliumSoil extends Block {
    public SubstiliumSoil(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        for (int i = 0; i < Mth.nextInt(pRandom, 3, 5); i++) {
            pLevel.addParticle(ModParticles.SUBSTILIUM_PARTICLES.get(), (pPos.getX() + Math.random()), (pPos.getY() + 1), (pPos.getZ() + Math.random()),
                    0, (Mth.nextInt(pRandom, 7, 13) / 1000), 0);
        }
        super.animateTick(pState, pLevel, pPos, pRandom);
    }

    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }
}
