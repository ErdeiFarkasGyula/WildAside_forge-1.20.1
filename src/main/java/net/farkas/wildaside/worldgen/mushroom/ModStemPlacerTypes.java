package net.farkas.wildaside.worldgen.mushroom;

import net.farkas.wildaside.WildAside;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModStemPlacerTypes {
    public static final DeferredRegister<TrunkPlacerType<?>> STEM_PLACER =
            DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, WildAside.MOD_ID);

    public static final RegistryObject<TrunkPlacerType<SubstiliumMushroomStemPlacer>> SUBSTILIUM_STEM_PLACER =
            STEM_PLACER.register("substilium_stem_placer", () -> new TrunkPlacerType<>(SubstiliumMushroomStemPlacer.CODEC));

    public static void register(IEventBus eventBus) {
        STEM_PLACER.register(eventBus);
    }
}