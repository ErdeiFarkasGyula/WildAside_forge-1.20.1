package net.farkas.wildaside.worldgen.biome;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;

public class ModBiomes {
    public static final ResourceKey<Biome> HICKORY_FOREST = register("hickory_forest");
    public static final ResourceKey<Biome> VIBRION_HIVE = register("vibrion_hive");

    public static void boostrap(BootstapContext<Biome> context) {
        context.register(HICKORY_FOREST, hickoryForest(context));
        context.register(VIBRION_HIVE, vibrionHive(context));
    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
    }

    public static Biome hickoryForest(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
//        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, ModPlacedFeatures.ALEXANDRITE_GEODE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SPOTTED_WINTERGREEN_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PINKSTER_FLOWER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HICKORY_TREE_PLACED_KEY);
//        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.HICKORY_TREE_PLACED_KEY_2);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0x3F76E4)
                        .waterFogColor(0x3F76E4)
                        .skyColor(0x77A8FF)
                        .grassColorOverride(0x308114)
                        .foliageColorOverride(0x308114)
                        .fogColor(0xBADAFF)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)).build())
                .build();
    }

    public static Biome vibrionHive(BootstapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.ENTORIUM_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.REDLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.BROWNLIKE_SUBSTILIUM_MUSHROOM_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.VIBRION_GROWTH_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.VIBRION_SPOREHOLDER_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, ModPlacedFeatures.SUBSTILIUM_SPROUTS_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.5f)
                .temperature(0.5f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(-6184663)
                        .waterFogColor(-6184663)
                        .skyColor(7972607)
                        .grassColorOverride(-6184663)
                        .foliageColorOverride(-6184663)
                        .fogColor(12638463)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                        .backgroundMusic(Musics.createGameMusic(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)).build())
                .build();
    }

    public static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(WildAside.MOD_ID, name));
    }
}