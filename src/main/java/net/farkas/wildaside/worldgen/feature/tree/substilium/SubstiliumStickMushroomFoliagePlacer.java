//package net.farkas.wildaside.worldgen.feature.tree.substilium;
//
//import com.mojang.serialization.Codec;
//import com.mojang.serialization.codecs.RecordCodecBuilder;
//import net.farkas.wildaside.worldgen.feature.ModFoliagePlacers;
//import net.farkas.wildaside.worldgen.feature.tree.hickory.HickoryTreeFoliagePlacer;
//import net.minecraft.util.RandomSource;
//import net.minecraft.util.valueproviders.IntProvider;
//import net.minecraft.world.level.LevelSimulatedReader;
//import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
//
//public class SubstiliumStickMushroomFoliagePlacer extends FoliagePlacer {
//    private final int height;
//
//    public static final Codec<SubstiliumStickMushroomFoliagePlacer> CODEC = RecordCodecBuilder.create(substiliumStickMushroomFoliagePlacerInstance
//            -> foliagePlacerParts(substiliumStickMushroomFoliagePlacerInstance).and(Codec.intRange(0, 30).fieldOf("height")
//            .forGetter(fp -> fp.height)).apply(substiliumStickMushroomFoliagePlacerInstance, SubstiliumStickMushroomFoliagePlacer::new));
//
//    public SubstiliumStickMushroomFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
//        super(pRadius, pOffset);
//        this.height = height;
//    }
//
//    @Override
//    protected FoliagePlacerType<?> type() {
//        return ModFoliagePlacers.SUBSTILIUM_STICK_MUSHROOM_FOLIAGE_PLACER.get();
//    }
//
//    @Override
//    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
//        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos()., 0, 0, pAttachment.doubleTrunk());
//    }
//
//    @Override
//    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
//        return this.height;
//    }
//
//    @Override
//    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
//        return false;
//    }
//}
