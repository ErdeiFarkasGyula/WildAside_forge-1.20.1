package net.farkas.wildaside.block;

import net.farkas.wildaside.WildAside;
import net.farkas.wildaside.block.custom.*;
import net.farkas.wildaside.block.custom.sign.ModHangingSignBlock;
import net.farkas.wildaside.block.custom.sign.ModStandingSignBlock;
import net.farkas.wildaside.block.custom.sign.ModWallHangingSignBlock;
import net.farkas.wildaside.block.custom.sign.ModWallSignBlock;
import net.farkas.wildaside.block.custom.vibrion.Sporeholder;
import net.farkas.wildaside.block.custom.vibrion.VibrionGel;
import net.farkas.wildaside.block.custom.vibrion.VibrionGlass;
import net.farkas.wildaside.item.ModItems;
import net.farkas.wildaside.util.ModWoodTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WildAside.MOD_ID);


    //VIBRION
    public static final RegistryObject<Block> VIBRION_BLOCK = registerBlock("vibrion_block",
            () ->  new DropExperienceBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(2F,  1F)
                    .lightLevel(l -> 7),  UniformInt.of(1, 2)));

    public static final RegistryObject<Block> VIBRION_GEL = registerBlock("vibrion_gel",
            () ->  new VibrionGel(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.HONEY_BLOCK)
                    .strength(0.1F,  0F)
                    .noCollission()
                    .noOcclusion()
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
                    .noOcclusion()
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

    public static final RegistryObject<Block> VIBRION_GROWTH = registerBlock("vibrion_growth",
            () ->  new FlowerBlock(() -> MobEffects.POISON, 5, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.ROOTS)
                    .lightLevel(l -> 3)
                    .noCollission()
                    .noOcclusion()
                    .replaceable()
                    .instabreak()
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> POTTED_VIBRION_GROWTH = BLOCKS.register("potted_vibrion_growth",
            () ->  new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, ModBlocks.VIBRION_GROWTH, BlockBehaviour.Properties.copy(Blocks.POTTED_CRIMSON_ROOTS)
                    .mapColor(MapColor.COLOR_YELLOW)
                    .lightLevel(l -> 3)
                    .instabreak()
                    .pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> VIBRION_SPOREHOLDER = registerBlock("vibrion_sporeholder",
            () ->  new Sporeholder(() -> MobEffects.POISON, 500, BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_YELLOW)
                    .sound(SoundType.FUNGUS)
                    .lightLevel(l -> 5)
                    .noCollission()
                    .noOcclusion()
                    .strength(1.5f,  2f)
                    .offsetType(BlockBehaviour.OffsetType.XZ)
                    .pushReaction(PushReaction.DESTROY)));


    //ENTORIUM
    public static final RegistryObject<Block> ENTORIUM_SHROOM = registerBlock("entorium_shroom",
            () ->  new HugeMushroomBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_PURPLE)
                    .sound(SoundType.WART_BLOCK)
                    .strength(1.2F,  1.5F)));

    //SUBSTILIUM
    public static final RegistryObject<Block> SUBSTILIUM_SOIL = registerBlock("substilium_soil",
            () ->  new SubstiliumSoil(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .sound(SoundType.ROOTED_DIRT)
                    .strength(2,  5)));

    public static final RegistryObject<Block> SUBSTILIUM_STEM = registerBlock("substilium_stem",
            () ->  new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.STEM)
                    .strength(2,  2)));

    public static final RegistryObject<Block> STRIPPED_SUBSTILIUM_STEM = registerBlock("stripped_substilium_stem",
            () ->  new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(ModBlocks.SUBSTILIUM_STEM.get())));

    public static final RegistryObject<Block> SUBSTILIUM_WOOD = registerBlock("substilium_wood",
            () ->  new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .ignitedByLava()
                    .instrument(NoteBlockInstrument.BASS)
                    .sound(SoundType.STEM)
                    .strength(2,  2)));

    public static final RegistryObject<Block> STRIPPED_SUBSTILIUM_WOOD = registerBlock("stripped_substilium_wood",
            () ->  new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(ModBlocks.SUBSTILIUM_WOOD.get())));

    public static final RegistryObject<Block> SUBSTILIUM_PLANKS = registerBlock("substilium_planks",
            () ->  new ModFlammableBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_CYAN)
                    .instrument(NoteBlockInstrument.BANJO)
                    .sound(SoundType.WOOD)
                    .strength(2,  2), 10, 5));

    public static final RegistryObject<Block> SUBSTILIUM_STAIRS = registerBlock("substilium_stairs",
            () ->  new StairBlock(() -> ModBlocks.SUBSTILIUM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get())));

    public static final RegistryObject<Block> SUBSTILIUM_SLAB = registerBlock("substilium_slab",
            () ->  new SlabBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get())));

    public static final RegistryObject<Block> SUBSTILIUM_BUTTON = registerBlock("substilium_button",
            () ->  new ButtonBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()), BlockSetType.OAK, 5, true));

    public static final RegistryObject<Block> SUBSTILIUM_PRESSURE_PLATE = registerBlock("substilium_pressure_plate",
            () ->  new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()),
                    BlockSetType.OAK));

    public static final RegistryObject<Block> SUBSTILIUM_FENCE = registerBlock("substilium_fence",
            () ->  new FenceBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get())));

    public static final RegistryObject<Block> SUBSTILIUM_FENCE_GATE = registerBlock("substilium_fence_gate",
            () ->  new FenceGateBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()),
                    SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));

    public static final RegistryObject<Block> SUBSTILIUM_DOOR = registerBlock("substilium_door",
            () ->  new DoorBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()), BlockSetType.OAK));

    public static final RegistryObject<Block> SUBSTILIUM_TRAPDOOR = registerBlock("substilium_trapdoor",
            () ->  new TrapDoorBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()).noOcclusion(), BlockSetType.OAK));

    public static final RegistryObject<Block> SUBSTILIUM_SIGN = BLOCKS.register("substilium_sign",
            () ->  new ModStandingSignBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()).strength(1).forceSolidOn().noCollission(), ModWoodTypes.SUBSTILIUM));
    public static final RegistryObject<Block> SUBSTILIUM_WALL_SIGN = BLOCKS.register("substilium_wall_sign",
            () ->  new ModWallSignBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()).strength(1).forceSolidOn().noCollission(), ModWoodTypes.SUBSTILIUM));

    public static final RegistryObject<Block> SUBSTILIUM_HANGING_SIGN = BLOCKS.register("substilium_hanging_sign",
            () ->  new ModHangingSignBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()).strength(1).forceSolidOn().noCollission(), ModWoodTypes.SUBSTILIUM));
    public static final RegistryObject<Block> SUBSTILIUM_WALL_HANGING_SIGN = BLOCKS.register("substilium_hanging_wall_sign",
            () ->  new ModWallHangingSignBlock(BlockBehaviour.Properties.copy(SUBSTILIUM_PLANKS.get()).strength(1).forceSolidOn().noCollission(),  ModWoodTypes.SUBSTILIUM));

    //HICKORY
//    public static final RegistryObject<Block> HICKORY_LEAVES = registerBlock("hickory_leaves",
//            () ->  new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItem(name, blockObj);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, ()  -> new BlockItem(block.get(), new Item.Properties()));

    }

    private static <T extends Block> RegistryObject<T> registerBlockWithStackLimit(String name, Supplier<T> block, int stackLimit) {
        RegistryObject<T> blockObj = BLOCKS.register(name, block);
        registerBlockItemWithStackLimit(name, blockObj, stackLimit);
        return blockObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItemWithStackLimit(String name, RegistryObject<T> block, int stackLimit) {
        return ModItems.ITEMS.register(name, ()  -> new BlockItem(block.get(), new Item.Properties().stacksTo(stackLimit)));

    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
