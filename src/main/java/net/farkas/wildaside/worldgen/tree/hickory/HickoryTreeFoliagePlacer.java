package net.farkas.wildaside.worldgen.tree.hickory;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.farkas.wildaside.worldgen.tree.ModFoliagePlacers;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import org.joml.Math;

public class HickoryTreeFoliagePlacer extends FoliagePlacer {
    public static final Codec<HickoryTreeFoliagePlacer> CODEC = RecordCodecBuilder.create(hickoryFoliagePlacerInstance
            -> foliagePlacerParts(hickoryFoliagePlacerInstance).and(Codec.intRange(0, 30).fieldOf("height")
            .forGetter(fp -> fp.height)).apply(hickoryFoliagePlacerInstance, HickoryTreeFoliagePlacer::new));

    private final int height;

    public HickoryTreeFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.HICKORY_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig,
                                 int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {

        int breakPoint = Math.round( pFoliageHeight * 0.35f);

        for (int i = -pFoliageHeight / 6; i < breakPoint; i++) {
            int c = i + pFoliageHeight / 6;
            int radius = Math.round((float) c / breakPoint * pFoliageRadius);

            if (radius > 1) {
                int xOff = pRandom.nextIntBetweenInclusive(-1, 1);
                int zOff = pRandom.nextIntBetweenInclusive(-1, 1);

                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i), radius - 1, 0, pAttachment.doubleTrunk());
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i).offset(xOff, 0, zOff), radius - 1, 0, pAttachment.doubleTrunk());
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i).offset(-xOff, 0, -zOff), radius - 2, 0, pAttachment.doubleTrunk());
            }
            else {
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i), radius, 0, pAttachment.doubleTrunk());
            }
        }

        int m = pFoliageHeight - breakPoint;
        for (int i = breakPoint; i < pFoliageHeight; i++) {
            int c = pFoliageHeight - i;

            int radius = Math.round((float) c / m * pFoliageRadius);

            if (radius > 1) {
                int xOff = pRandom.nextIntBetweenInclusive(-1, 1);
                int zOff = pRandom.nextIntBetweenInclusive(-1, 1);

                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i).offset(xOff, 0, zOff), radius - 1, 0, pAttachment.doubleTrunk());
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i).offset(-xOff, 0, -zOff), radius - 1, 0, pAttachment.doubleTrunk());
            }
            else {
                this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i), radius, 0, pAttachment.doubleTrunk());
            }

            this.placeLeavesRowWithHangingLeavesBelow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i), radius, 0, pAttachment.doubleTrunk(), 0.5f, 0.25f);
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return (((pLocalX == pRange && pLocalZ == pRange) && pRange > 0) || ((pLocalX == pRange || pLocalZ == pRange) && pRange > 1)) && pRandom.nextFloat() > 0.5f;
    }
}