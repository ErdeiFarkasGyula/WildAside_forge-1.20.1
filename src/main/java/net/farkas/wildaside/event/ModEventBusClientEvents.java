package net.farkas.wildaside.event;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.entity.ModBlockEntities;
import net.farkas.wildaside.entity.client.ModModelLayers;
import net.farkas.wildaside.particle.EntoriumParticles;
import net.farkas.wildaside.particle.ModParticles;
import net.farkas.wildaside.particle.SubstiliumParticle;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WildAside.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ModModelLayers.SUBSTILIUM_BOAT_LAYER, BoatModel::createBodyModel);
        event.registerLayerDefinition(ModModelLayers.SUBSTILIUM_CHEST_BOAT_LAYER, ChestBoatModel::createBodyModel);
    }

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        //event.registerBlockEntityRenderer(ModBlockEntities.GEM_POLISHING_BE.get(), GemPolishingBlockEntityRenderer::new);

        event.registerBlockEntityRenderer(ModBlockEntities.MOD_SIGN.get(), SignRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.MOD_HANGING_SIGN.get(), HangingSignRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticles.ENTORIUM_PARTICLES.get(), EntoriumParticles.Provider::new);
        event.registerSpriteSet(ModParticles.SUBSTILIUM_PARTICLES.get(), SubstiliumParticle.Provider::new);
    }


}