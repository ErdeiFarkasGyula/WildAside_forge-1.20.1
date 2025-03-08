package net.farkas.wildaside.worldgen;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> REDLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY = registerKey("redlike_substilium_mushroom_placed_key");
    public static final ResourceKey<PlacedFeature> BROWNLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY = registerKey("brownlike_substilium_mushroom_placed_key");

    public static final ResourceKey<PlacedFeature> VIBRION_GROWTH_PLACED_KEY = registerKey("vibrion_growth_placed_key");
    public static final ResourceKey<PlacedFeature> VIBRION_SPOREHOLDER_PLACED_KEY = registerKey("vibrion_sporeholder_placed_key");
    public static final ResourceKey<PlacedFeature> SUBSTILIUM_SPROUTS_PLACED_KEY = registerKey("substilium_sprouts_placed_key");

    public static final ResourceKey<PlacedFeature> ENTORIUM_ORE_PLACED_KEY = registerKey("entorium_ore_placed");

    public static final ResourceKey<PlacedFeature> SPOTTED_WINTERGREEN_PLACED_KEY = registerKey("spotted_wintergreen_placed_key");
    public static final ResourceKey<PlacedFeature> PINKSTER_FLOWER_PLACED_KEY = registerKey("pinkster_flower_placed_key");

    public static final ResourceKey<PlacedFeature> HICKORY_TREE_PLACED_KEY = registerKey("hickory_tree_placed_key");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, REDLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.REDLIKE_SUBSTILIUM_MUSHROOM_KEY),
                List.of(PlacementUtils.countExtra(16, 1, 2), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, BROWNLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BROWNLIKE_SUBSTILIUM_MUSHROOM_KEY),
                List.of(PlacementUtils.countExtra(16, 1, 2), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));

        register(context, VIBRION_GROWTH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIBRION_GROWTH_KEY),
                List.of(PlacementUtils.countExtra(64, 1f, 16), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, VIBRION_SPOREHOLDER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIBRION_SPOREHOLDER_KEY),
                List.of(PlacementUtils.countExtra(48, 0.5f, 32), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));
        register(context, SUBSTILIUM_SPROUTS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUBSTILIUM_SPROUTS_KEY),
                List.of(PlacementUtils.countExtra(64, 1f, 16), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome()));

        register(context, ENTORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ENTORIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, SPOTTED_WINTERGREEN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPOTTED_EVERGREEN_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, PINKSTER_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINKSTER_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, HICKORY_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HICKORY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.1f, 2),
                        ModBlocks.HICKORY_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(WildAside.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}