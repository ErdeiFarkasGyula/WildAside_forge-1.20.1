package net.farkas.wildaside.worldgen.mushroom;


import net.farkas.wildaside.worldgen.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class SubstiliumMushroomGrower extends AbstractTreeGrower {
    @Override
    protected @Nullable ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean b) {
        return Math.random() > 0.5f ? ModConfiguredFeatures.REDLIKE_SUBSTILIUM_MUSHROOM : ModConfiguredFeatures.BROWNLIKE_SUBSTILIUM_MUSHROOM;
    }
}
