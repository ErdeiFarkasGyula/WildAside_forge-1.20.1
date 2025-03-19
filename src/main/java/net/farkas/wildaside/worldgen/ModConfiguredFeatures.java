package net.farkas.wildaside.worldgen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.block.custom.SubstiliumSoil;
import net.farkas.wildaside.block.custom.vibrion.NaturalSporeBlaster;
import net.farkas.wildaside.worldgen.feature.ModFeatures;
import net.farkas.wildaside.worldgen.tree.hickory.HickoryTreeFoliagePlacer;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.*;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDLIKE_SUBSTILIUM_MUSHROOM = registerKey("redlike_substilium_mushroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BROWNLIKE_SUBSTILIUM_MUSHROOM = registerKey("brownlike_substilium_mushroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> VIBRION_GROWTH = registerKey("vibrion_growth");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VIBRION_SPOREHOLDER = registerKey("vibrion_sporeholder");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUBSTILIUM_SPROUTS = registerKey("substilium_sprouts");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_VIBRION_VINES = registerKey("hanging_vibrion_vines");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_VIBRION_GEL = registerKey("hanging_vibrion_gel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HANGING_LIT_VIBRION_GEL = registerKey("hanging_lit_vibrion_gel");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERGROWN_ENTORIUM_ORE = registerKey("overgrown_entorium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ENTORIUM_ORE = registerKey("entorium_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> COMPRESSED_SUBSTILIUM_SOIL = registerKey("compressed_substilium_soil");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NATURAL_SPORE_BLASTER_X = registerKey("natural_spore_blaster_x");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NATURAL_SPORE_BLASTER_Y = registerKey("natural_spore_blaster_y");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NATURAL_SPORE_BLASTER_Z = registerKey("natural_spore_blaster_z");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPOTTED_EVERGREEN = registerKey("spotted_evergreen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINKSTER_FLOWER = registerKey("pinkster_flower");

    public static final ResourceKey<ConfiguredFeature<?, ?>> HICKORY_TREE = registerKey("hickory_tree");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest overgrown_entorium_ore_replaceables = new BlockMatchTest(ModBlocks.SUBSTILIUM_SOIL.get());
        RuleTest entorium_ore_replaceables = new BlockMatchTest(ModBlocks.OVERGROWN_ENTORIUM_ORE.get());
        RuleTest compressed_substilium_soil_replaceables = new BlockMatchTest(ModBlocks.SUBSTILIUM_SOIL.get());

        List<OreConfiguration.TargetBlockState> overgrown_entorium_ore = List.of(OreConfiguration.target(overgrown_entorium_ore_replaceables, ModBlocks.OVERGROWN_ENTORIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> entorium_ore = List.of(OreConfiguration.target(entorium_ore_replaceables, ModBlocks.ENTORIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> compressed_substilium_soil = List.of(OreConfiguration.target(compressed_substilium_soil_replaceables, ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get().defaultBlockState()));

        register(context, OVERGROWN_ENTORIUM_ORE, Feature.ORE, new OreConfiguration(overgrown_entorium_ore, 9));
        register(context, ENTORIUM_ORE, Feature.ORE, new OreConfiguration(entorium_ore, 6));

        register(context, COMPRESSED_SUBSTILIUM_SOIL, Feature.ORE, new OreConfiguration(compressed_substilium_soil, 36));

        register(context, NATURAL_SPORE_BLASTER_X, ModFeatures.UPDATE_REPLACE_SINGLE_BLOCK.get(), new ReplaceBlockConfiguration(ModBlocks.SUBSTILIUM_SOIL.get().defaultBlockState(), ModBlocks.NATURAL_SPORE_BLASTER.get().defaultBlockState().setValue(NaturalSporeBlaster.AXIS, Direction.Axis.X)));
        register(context, NATURAL_SPORE_BLASTER_Y, ModFeatures.UPDATE_REPLACE_SINGLE_BLOCK.get(), new ReplaceBlockConfiguration(ModBlocks.SUBSTILIUM_SOIL.get().defaultBlockState(), ModBlocks.NATURAL_SPORE_BLASTER.get().defaultBlockState().setValue(NaturalSporeBlaster.AXIS, Direction.Axis.Y)));
        register(context, NATURAL_SPORE_BLASTER_Z, ModFeatures.UPDATE_REPLACE_SINGLE_BLOCK.get(), new ReplaceBlockConfiguration(ModBlocks.SUBSTILIUM_SOIL.get().defaultBlockState(), ModBlocks.NATURAL_SPORE_BLASTER.get().defaultBlockState().setValue(NaturalSporeBlaster.AXIS, Direction.Axis.Z)));

        register(context, VIBRION_GROWTH, Feature.FLOWER,
                new RandomPatchConfiguration(32, 8, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIBRION_GROWTH.get())))));
        register(context, VIBRION_SPOREHOLDER, Feature.FLOWER,
                new RandomPatchConfiguration(32, 8, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.VIBRION_SPOREHOLDER.get())))));
        register(context, SUBSTILIUM_SPROUTS, Feature.FLOWER,
                new RandomPatchConfiguration(32, 8, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SUBSTILIUM_SPROUTS.get())))));

        BlockStateProvider vines_plant = BlockStateProvider.simple(ModBlocks.HANGING_VIBRION_VINES_PLANT.get());
        BlockStateProvider vines = BlockStateProvider.simple(ModBlocks.HANGING_VIBRION_VINES.get());

        register(context, HANGING_VIBRION_VINES, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(
                new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 25), 3)
                        .add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 7).build()), vines_plant),
                BlockColumnConfiguration.layer(ConstantInt.of(1), vines)), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));

        register(context, HANGING_VIBRION_GEL, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(
                        new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 19), 3)
                                .add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 7).build()),
                BlockStateProvider.simple(ModBlocks.VIBRION_GEL.get()))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));

        register(context, HANGING_LIT_VIBRION_GEL, Feature.BLOCK_COLUMN, new BlockColumnConfiguration(List.of(BlockColumnConfiguration.layer(
                new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(UniformInt.of(0, 19), 3)
                        .add(UniformInt.of(0, 2), 3).add(UniformInt.of(0, 6), 7).build()),
                BlockStateProvider.simple(ModBlocks.LIT_VIBRION_GEL.get()))), Direction.DOWN, BlockPredicate.ONLY_IN_AIR_PREDICATE, true));

        register(context, REDLIKE_SUBSTILIUM_MUSHROOM, Feature.HUGE_RED_MUSHROOM, new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(ModBlocks.ENTORIUM_SHROOM.get()), BlockStateProvider.simple(ModBlocks.SUBSTILIUM_STEM.get()), 2));
        register(context, BROWNLIKE_SUBSTILIUM_MUSHROOM, Feature.HUGE_BROWN_MUSHROOM, new HugeMushroomFeatureConfiguration(
                BlockStateProvider.simple(ModBlocks.ENTORIUM_SHROOM.get()), BlockStateProvider.simple(ModBlocks.SUBSTILIUM_STEM.get()), 3));

        register(context, SPOTTED_EVERGREEN, Feature.FLOWER,
                new RandomPatchConfiguration(64, 16, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SPOTTED_WINTERGREEN.get())))));

        register(context, PINKSTER_FLOWER, Feature.FLOWER,
                new RandomPatchConfiguration(64, 16, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINKSTER_FLOWER.get())))));

        register(context, HICKORY_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.HICKORY_LOG.get()),
                new StraightTrunkPlacer(14, 0, 6),
                BlockStateProvider.simple(ModBlocks.HICKORY_LEAVES.get()),
                new HickoryTreeFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 12),
                new TwoLayersFeatureSize(1, 0, 2)).build());
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(WildAside.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}