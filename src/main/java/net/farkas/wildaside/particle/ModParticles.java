package net.farkas.wildaside.particle;

import net.farkas.wildaside.WildAside;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WildAside.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ENTORIUM_PARTICLES =
            PARTICLE_TYPES.register("entorium_particles", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> SUBSTILIUM_PARTICLES =
            PARTICLE_TYPES.register("substilium_particles", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}