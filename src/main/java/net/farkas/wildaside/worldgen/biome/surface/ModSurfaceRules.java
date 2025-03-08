package net.farkas.wildaside.worldgen.biome.surface;

import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SUBSTILIUM = makeStateRule(ModBlocks.SUBSTILIUM_SOIL.get());

    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(ModBiomes.VIBRION_HIVE),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SUBSTILIUM)),
                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SUBSTILIUM)),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SUBSTILIUM),

                SurfaceRules.sequence(SurfaceRules.ifTrue(
                                SurfaceRules.isBiome(ModBiomes.HICKORY_FOREST),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface))
        ));
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}