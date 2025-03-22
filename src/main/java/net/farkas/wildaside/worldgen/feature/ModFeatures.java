package net.farkas.wildaside.worldgen.feature;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.worldgen.feature.custom.RedlikeSubstiliumMushroomFeature;
import net.farkas.wildaside.worldgen.feature.custom.UpdateReplaceSingleBlockFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.HugeMushroomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ReplaceBlockConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, WildAside.MOD_ID);

    public static final RegistryObject<UpdateReplaceSingleBlockFeature> TICK_REPLACE_SINGLE_BLOCK = FEATURES.register("tick_replace_single_block",
            () -> new UpdateReplaceSingleBlockFeature(ReplaceBlockConfiguration.CODEC));
    public static final RegistryObject<RedlikeSubstiliumMushroomFeature> REDLIKE_SUBSTILIUM_MUSHROOM = FEATURES.register("redlike_substilium_mushroom",
            () -> new RedlikeSubstiliumMushroomFeature(HugeMushroomFeatureConfiguration.CODEC));
    public static void register(IEventBus eventBus) {
        FEATURES.register(eventBus);
    }
}