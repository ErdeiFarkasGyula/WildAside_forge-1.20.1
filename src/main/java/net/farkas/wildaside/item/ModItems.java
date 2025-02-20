package net.farkas.wildaside.item;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.entity.custom.ModBoatEntity;
import net.farkas.wildaside.item.custom.ModBoatItem;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WildAside.MOD_ID);

    public static final RegistryObject<Item> VIBRION = ITEMS.register("vibrion",
            () ->  new Item(new Item.Properties().food(ModFoods.VIBRION)));
    public static final RegistryObject<Item> ENTORIUM = ITEMS.register("entorium",
            () ->  new Item(new Item.Properties()));

    public static final RegistryObject<Item> SUBSTILIUM_SIGN = ITEMS.register("substilium_sign",
            () ->  new SignItem(new Item.Properties().stacksTo(16), ModBlocks.SUBSTILIUM_SIGN.get(), ModBlocks.SUBSTILIUM_WALL_SIGN.get()));
    public static final RegistryObject<Item> SUBSTILIUM_HANGING_SIGN = ITEMS.register("substilium_hanging_sign",
            () ->  new HangingSignItem(ModBlocks.SUBSTILIUM_HANGING_SIGN.get(), ModBlocks.SUBSTILIUM_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));
    public static final RegistryObject<Item> SUBSTILIUM_BOAT = ITEMS.register("substilium_boat",
            () ->  new ModBoatItem(false, ModBoatEntity.Type.SUBSTILIUM, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SUBSTILIUM_CHEST_BOAT = ITEMS.register("substilium_chest_boat",
            () ->  new ModBoatItem(true, ModBoatEntity.Type.SUBSTILIUM, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> HICKORY_SIGN = ITEMS.register("hickory_sign",
            () ->  new SignItem(new Item.Properties().stacksTo(16), ModBlocks.HICKORY_SIGN.get(), ModBlocks.HICKORY_WALL_SIGN.get()));
    public static final RegistryObject<Item> HICKORY_HANGING_SIGN = ITEMS.register("hickory_hanging_sign",
            () ->  new HangingSignItem(ModBlocks.HICKORY_HANGING_SIGN.get(), ModBlocks.HICKORY_WALL_HANGING_SIGN.get(), new Item.Properties().stacksTo(16)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
