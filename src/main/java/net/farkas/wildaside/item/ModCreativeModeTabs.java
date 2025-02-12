package net.farkas.wildaside.item;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WildAside.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WILDASIDE_TAB = CREATIVE_MODE_TABS.register("wildaside_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.VIBRION.get()))
                    .title(Component.translatable("creativetab.wildaside_tab"))
                    .displayItems((pParamateres, pOutput) -> {
                        pOutput.accept(ModItems.VIBRION.get());
                        pOutput.accept(ModBlocks.VIBRION_BLOCK.get());

                        pOutput.accept(ModItems.ENTORIUM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
