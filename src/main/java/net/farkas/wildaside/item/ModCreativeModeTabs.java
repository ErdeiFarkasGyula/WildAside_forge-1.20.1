package net.farkas.wildaside.item;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WildAside.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WILDASIDE_TAB = CREATIVE_MODE_TABS.register("wildaside_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.VIBRION_BLOCK.get()))
                    .title(Component.translatable("creativetab.wildaside_tab"))
                    .displayItems((pParamateres, pOutput) -> {
                        pOutput.accept(ModItems.VIBRION.get());
                        pOutput.accept(ModBlocks.VIBRION_BLOCK.get());
                        pOutput.accept(ModBlocks.VIBRION_GEL.get());
                        pOutput.accept(ModBlocks.LIT_VIBRION_GEL.get());
                        pOutput.accept(ModBlocks.VIBRION_GROWTH.get());
                        pOutput.accept(ModBlocks.VIBRION_SPOREHOLDER.get());
                        pOutput.accept(ModBlocks.VIBRION_GLASS.get());
                        pOutput.accept(ModBlocks.LIT_VIBRION_GLASS.get());
                        pOutput.accept(ModBlocks.VIBRION_GLASS_PANE.get());
                        pOutput.accept(ModBlocks.LIT_VIBRION_GLASS_PANE.get());

                        pOutput.accept(ModItems.ENTORIUM.get());
                        pOutput.accept(ModBlocks.ENTORIUM_SHROOM.get());

                        pOutput.accept(ModBlocks.SUBSTILIUM_SOIL.get());

                        pOutput.accept(ModBlocks.SUBSTILIUM_STEM.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_WOOD.get());
                        pOutput.accept(ModBlocks.STRIPPED_SUBSTILIUM_STEM.get());
                        pOutput.accept(ModBlocks.STRIPPED_SUBSTILIUM_WOOD.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_PLANKS.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_STAIRS.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_SLAB.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_FENCE.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_DOOR.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_BUTTON.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_SIGN.get());
                        pOutput.accept(ModBlocks.SUBSTILIUM_HANGING_SIGN.get());
                        pOutput.accept(ModItems.SUBSTILIUM_BOAT.get());
                        pOutput.accept(ModItems.SUBSTILIUM_CHEST_BOAT.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
