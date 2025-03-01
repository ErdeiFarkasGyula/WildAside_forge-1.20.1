package net.farkas.wildaside.worldgen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.worldgen.tree.HickoryTreeFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ENTORIUM_ORE_KEY = registerKey("entorium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDLIKE_SUBSTILIUM_MUSHROOM_KEY = registerKey("redlike_substilium_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWNLIKE_SUBSTILIUM_MUSHROOM_KEY = registerKey("brownlike_substilium_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPOTTED_EVERGREEN_KEY = registerKey("spotted_evergreen_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINKSTER_FLOWER_KEY = registerKey("pinkster_flower_key");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HICKORY_TREE_KEY = registerKey("hickory_tree_key");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HICKORY_TREE_KEY_2 = registerKey("hickory_tree_key_2");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        //RuleTest entorium_ore_replaceables = new BlockMatchTest(ModBlocks.SUBSTILIUM_SOIL.get());
        RuleTest entorium_ore_replaceables = new BlockMatchTest(Blocks.STONE);

        List<OreConfiguration.TargetBlockState> entoriumOres = List.of(
                OreConfiguration.target(entorium_ore_replaceables, ModBlocks.ENTORIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(entorium_ore_replaceables, ModBlocks.ENTORIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_ENTORIUM_ORE_KEY, Feature.ORE, new OreConfiguration(entoriumOres, 9));

        register(context, REDLIKE_SUBSTILIUM_MUSHROOM_KEY, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(ModBlocks.ENTORIUM_SHROOM.get()), BlockStateProvider.simple(ModBlocks.SUBSTILIUM_STEM.get()), 2));
        register(context, BROWNLIKE_SUBSTILIUM_MUSHROOM_KEY, Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(ModBlocks.ENTORIUM_SHROOM.get()), BlockStateProvider.simple(ModBlocks.SUBSTILIUM_STEM.get()), 3));

        register(context, SPOTTED_EVERGREEN_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SPOTTED_WINTERGREEN.get())))));

        register(context, PINKSTER_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINKSTER_FLOWER.get())))));

        register(context, HICKORY_TREE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HICKORY_LOG.get()),
                new StraightTrunkPlacer(14, 0, 6),
                BlockStateProvider.simple(ModBlocks.HICKORY_LEAVES.get()),
                new HickoryTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 12),
                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, HICKORY_TREE_KEY_2, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HICKORY_LOG.get()),
                new StraightTrunkPlacer(20, 4, 10),
                BlockStateProvider.simple(ModBlocks.HICKORY_LEAVES.get()),
                new HickoryTreeFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 16),
                new TwoLayersFeatureSize(1, 1, 1)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(WildAside.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}