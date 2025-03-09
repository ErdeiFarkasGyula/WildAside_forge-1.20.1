package net.farkas.wildaside.worldgen.feature;

import com.mojang.serialization.Codec;
import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class HangingVibrionVinesFeature extends Feature<NoneFeatureConfiguration> {
    public HangingVibrionVinesFeature(Codec<NoneFeatureConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        RandomSource randomsource = pContext.random();

        if (!worldgenlevel.isEmptyBlock(blockpos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(blockpos.above());
            if (!blockstate.is(Blocks.NETHERRACK) && !blockstate.is(Blocks.NETHER_WART_BLOCK)) {
                return false;
            } else {
                placeHangingVines(worldgenlevel, randomsource, new BlockPos.MutableBlockPos(), randomsource.nextInt(1, 15), 0,  15);
                return true;
            }
        }
    }

    private static void placeHangingVines(LevelAccessor pLevel, RandomSource pRandom, BlockPos.MutableBlockPos pPos, int pHeight, int pMinAge, int pMaxAge) {
        for (int i = 0; i <= pHeight; ++i) {
            if (pLevel.isEmptyBlock(pPos)) {
                if (i == pHeight || !pLevel.isEmptyBlock(pPos.below())) {
                    pLevel.setBlock(pPos, ModBlocks.HANGING_VIBRION_VINES.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Integer.valueOf(Mth.nextInt(pRandom, pMinAge, pMaxAge))), 2);
                    break;
                }

                pLevel.setBlock(pPos,ModBlocks.HANGING_VIBRION_VINES_PLANT.get().defaultBlockState(), 2);
            }

            pPos.move(Direction.DOWN);
        }

    }
}
