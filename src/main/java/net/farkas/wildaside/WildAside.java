package net.farkas.wildaside;

import com.mojang.logging.LogUtils;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.block.entity.ModBlockEntities;
import net.farkas.wildaside.entity.ModEntities;
import net.farkas.wildaside.entity.client.ModBoatRenderer;
import net.farkas.wildaside.item.ModCreativeModeTabs;
import net.farkas.wildaside.item.ModItems;
import net.farkas.wildaside.util.ModWoodTypes;
import net.farkas.wildaside.worldgen.mushroom.ModStemPlacerTypes;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(WildAside.MOD_ID)
public class WildAside
{
    public static final String MOD_ID = "wildaside";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WildAside(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModEntities.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        ModStemPlacerTypes.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        //context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ModBlocks.VIBRION_GROWTH.getId(), ModBlocks.POTTED_VIBRION_GROWTH);
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            Sheets.addWoodType(ModWoodTypes.SUBSTILIUM);
            Sheets.addWoodType(ModWoodTypes.HICKORY);
            Sheets.addWoodType(ModWoodTypes.CYPRESS);

            EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
            EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));

            ItemBlockRenderTypes.setRenderLayer(ModBlocks.VIBRION_GLASS_PANE.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.LIT_VIBRION_GLASS_PANE.get(), RenderType.translucent());
        }
    }
}