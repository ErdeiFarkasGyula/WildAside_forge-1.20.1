package net.farkas.wildaside.worldgen.biome;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.worldgen.biome.custom.ModGlowingHickoryForestRegion;
import net.farkas.wildaside.worldgen.biome.custom.ModVibrionHiveRegion;
import net.farkas.wildaside.worldgen.biome.custom.ModHickoryForestRegion;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

public class ModTerraBlenderAPI {
    public static void registerRegions() {
        Regions.register(new ModHickoryForestRegion(new ResourceLocation(WildAside.MOD_ID, "hickory_forest"), 5));
        Regions.register(new ModGlowingHickoryForestRegion(new ResourceLocation(WildAside.MOD_ID, "glowing_hickory_forest"), 2));
        Regions.register(new ModVibrionHiveRegion(new ResourceLocation(WildAside.MOD_ID, "vibrion_hive"), 5));
    }
}