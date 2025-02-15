package net.farkas.wildaside.item;

import net.farkas.wildaside.WildAside;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WildAside.MOD_ID);

    public static final RegistryObject<Item> VIBRION = ITEMS.register("vibrion",
            () ->  new Item(new Item.Properties()));
    public static final RegistryObject<Item> VIBRION_2 = ITEMS.register("vibrion_2",
            () ->  new Item(new Item.Properties()));
    public static final RegistryObject<Item> ENTORIUM = ITEMS.register("entorium",
            () ->  new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
