package net.farkas.wildaside.block;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.custom.VibrionBlock;
import net.farkas.wildaside.block.custom.VibrionGel;
import net.farkas.wildaside.block.custom.VibrionGlass;
import net.farkas.wildaside.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WildAside.MOD_ID);

    public static final RegistryObject<Block> VIBRION_BLOCK = registerBlock("vibrion_block",
            () ->  new VibrionBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(2F,  1F)
                    .lightLevel(l -> 7)
                    .randomTicks()));

    public static final RegistryObject<Block> VIBRION_GEL = registerBlock("vibrion_gel",
            () ->  new VibrionGel(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.HONEY_BLOCK)
                    .strength(0.1F,  0F)
                    .noCollission()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .speedFactor(0.2f)
                    .jumpFactor(0.6f)
                    .noOcclusion()));

    public static final RegistryObject<Block> LIT_VIBRION_GEL = registerBlock("lit_vibrion_gel",
            () ->  new VibrionGel(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.HONEY_BLOCK)
                    .strength(0.1F,  0F)
                    .lightLevel(l -> 7)
                    .noCollission()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .speedFactor(0.2f)
                    .jumpFactor(0.6f)
                    .noOcclusion()));

    public static final RegistryObject<Block> VIBRION_GLASS = registerBlock("vibrion_glass",
            () ->  new VibrionGlass(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.GLASS)
                    .strength(0.4F,  0.3F)
                    .noOcclusion()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .instrument(NoteBlockInstrument.HAT)));

    public static final RegistryObject<Block> LIT_VIBRION_GLASS = registerBlock("lit_vibrion_glass",
            () ->  new VibrionGlass(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.GLASS)
                    .strength(0.4F,  0.3F)
                    .noOcclusion()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .lightLevel(l -> 7)
                    .instrument(NoteBlockInstrument.HAT)));

    public static final RegistryObject<Block> VIBRION_GLASS_PANE = registerBlock("vibrion_glass_pane",
            () ->  new IronBarsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.GLASS)
                    .strength(0.4F,  0.3F)
                    .noOcclusion()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .instrument(NoteBlockInstrument.HAT)));

    public static final RegistryObject<Block> LIT_VIBRION_GLASS_PANE = registerBlock("lit_vibrion_glass_pane",
            () ->  new IronBarsBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.GLASS)
                    .strength(0.4F,  0.3F)
                    .noOcclusion()
                    .isRedstoneConductor((bs, br, bp) -> false)
                    .lightLevel(l -> 7)
                    .instrument(NoteBlockInstrument.HAT)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, ()  -> new BlockItem(block.get(), new Item.Properties()));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
