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
    public static final ResourceKey<PlacedFeature> ENTORIUM_ORE_PLACED_KEY = registerKey("entorium_ore_placed");

    public static final ResourceKey<PlacedFeature> SPOTTED_WINTERGREEN_PLACED_KEY = registerKey("spotted_wintergreen_placed_key");
    public static final ResourceKey<PlacedFeature> PINKSTER_FLOWER_PLACED_KEY = registerKey("pinkster_flower_placed_key");

    public static final ResourceKey<PlacedFeature> HICKORY_TREE_PLACED_KEY = registerKey("hickory_tree_placed_key");
    public static final ResourceKey<PlacedFeature> HICKORY_TREE_PLACED_KEY_2 = registerKey("hickory_tree_placed_key_2");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, ENTORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ENTORIUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, SPOTTED_WINTERGREEN_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SPOTTED_EVERGREEN_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, PINKSTER_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINKSTER_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

        register(context, HICKORY_TREE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HICKORY_TREE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.HICKORY_SAPLING.get()));
        register(context, HICKORY_TREE_PLACED_KEY_2, configuredFeatures.getOrThrow(ModConfiguredFeatures.HICKORY_TREE_KEY_2),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2),
                        ModBlocks.RED_GLOWING_HICKORY_SAPLING.get()));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(WildAside.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}