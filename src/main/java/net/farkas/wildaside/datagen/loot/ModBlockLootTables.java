package net.farkas.wildaside.datagen.loot;

import net.farkas.wildaside.block.ModBlocks;
import net.farkas.wildaside.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        //VIBRION
        this.dropSelf(ModBlocks.VIBRION_GEL.get());
        this.dropSelf(ModBlocks.LIT_VIBRION_GEL.get());
        this.dropSelf(ModBlocks.VIBRION_GROWTH.get());
        this.dropSelf(ModBlocks.HANGING_VIBRION_VINES.get());

        this.add(ModBlocks.HANGING_VIBRION_VINES_PLANT.get(),
                block -> createSingleItemTable(ModBlocks.HANGING_VIBRION_VINES.get()));
        this.add(ModBlocks.POTTED_VIBRION_GROWTH.get(),
                createPotFlowerItemTable(ModBlocks.VIBRION_GROWTH.get()));
        this.add(ModBlocks.VIBRION_BLOCK.get(),
                block -> createSilktouchedFortuneDrops(ModBlocks.VIBRION_BLOCK.get(), ModItems.VIBRION.get(), 1, 3));
        this.add(ModBlocks.VIBRION_SPOREHOLDER.get(),
                block -> createSilktouchedFortuneDrops(ModBlocks.VIBRION_SPOREHOLDER.get(), ModItems.VIBRION.get(), 1, 2));
        this.add(ModBlocks.VIBRION_GLASS.get(),
                block -> createSilktouchedDrops(ModBlocks.VIBRION_BLOCK.get(), ModItems.VIBRION.get()));
        this.add(ModBlocks.LIT_VIBRION_GLASS.get(),
                block -> createSilktouchedDrops(ModBlocks.VIBRION_BLOCK.get(), ModItems.VIBRION.get()));
        this.add(ModBlocks.VIBRION_GLASS_PANE.get(),
                block -> createSilktouchedDrops(ModBlocks.VIBRION_BLOCK.get(), ModItems.VIBRION.get()));
        this.add(ModBlocks.LIT_VIBRION_GLASS_PANE.get(),
                block -> createSilktouchedDrops(ModBlocks.VIBRION_BLOCK.get(), ModItems.VIBRION.get()));

        //ENTORIUM
        this.dropSelf(ModBlocks.ENTORIUM_SHROOM.get());
        this.add(ModBlocks.ENTORIUM_ORE.get(),
                block -> createSilktouchedFortuneDrops(ModBlocks.ENTORIUM_ORE.get(), ModItems.ENTORIUM.get(), 1, 2));
        this.dropSelf(ModBlocks.OVERGROWN_ENTORIUM_ORE.get());

        //SUBSTILIUM
        this.dropSelf(ModBlocks.SUBSTILIUM_SOIL.get());
        this.dropSelf(ModBlocks.COMPRESSED_SUBSTILIUM_SOIL.get());
        this.dropSelf(ModBlocks.SMOOTH_SUBSTILIUM_SOIL.get());
        this.dropSelf(ModBlocks.CHISELLED_SUBSTILIUM_SOIL.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TILES.get());
        this.dropSelf(ModBlocks.CRACKED_SUBSTILIUM_TILES.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TILE_STAIRS.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TILE_WALLS.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TILE_BUTTON.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TILE_PRESSURE_PLATE.get());

        this.dropSelf(ModBlocks.SUBSTILIUM_STEM.get());
        this.dropSelf(ModBlocks.STRIPPED_SUBSTILIUM_STEM.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_SUBSTILIUM_WOOD.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_PLANKS.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_STAIRS.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_FENCE.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_BUTTON.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_TRAPDOOR.get());
        this.dropSelf(ModBlocks.SUBSTILIUM_SPROUTS.get());

        this.add(ModBlocks.SUBSTILIUM_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.SUBSTILIUM_SIGN.get()));
        this.add(ModBlocks.SUBSTILIUM_WALL_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.SUBSTILIUM_SIGN.get()));
        this.add(ModBlocks.SUBSTILIUM_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.SUBSTILIUM_HANGING_SIGN.get()));
        this.add(ModBlocks.SUBSTILIUM_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.SUBSTILIUM_HANGING_SIGN.get()));


        this.add(ModBlocks.SUBSTILIUM_TILE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUBSTILIUM_TILE_SLAB.get()));
        this.add(ModBlocks.SUBSTILIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUBSTILIUM_SLAB.get()));
        this.add(ModBlocks.SUBSTILIUM_DOOR.get(),
                block -> createSlabItemTable(ModBlocks.SUBSTILIUM_DOOR.get()));

        this.add(ModBlocks.HICKORY_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.HICKORY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.HICKORY_SAPLING.get());
        this.dropSelf(ModBlocks.RED_GLOWING_HICKORY_SAPLING.get());
        this.dropSelf(ModBlocks.BROWN_GLOWING_HICKORY_SAPLING.get());
        this.dropSelf(ModBlocks.YELLOW_GLOWING_HICKORY_SAPLING.get());
        this.dropSelf(ModBlocks.GREEN_GLOWING_HICKORY_SAPLING.get());

        this.dropSelf(ModBlocks.HICKORY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_HICKORY_LOG.get());
        this.dropSelf(ModBlocks.HICKORY_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_HICKORY_WOOD.get());
        this.dropSelf(ModBlocks.HICKORY_PLANKS.get());
        this.dropSelf(ModBlocks.HICKORY_STAIRS.get());
        this.dropSelf(ModBlocks.HICKORY_FENCE.get());
        this.dropSelf(ModBlocks.HICKORY_FENCE_GATE.get());
        this.dropSelf(ModBlocks.HICKORY_BUTTON.get());
        this.dropSelf(ModBlocks.HICKORY_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.HICKORY_TRAPDOOR.get());

        this.add(ModBlocks.HICKORY_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.HICKORY_SIGN.get()));
        this.add(ModBlocks.HICKORY_WALL_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.HICKORY_SIGN.get()));
        this.add(ModBlocks.HICKORY_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.HICKORY_HANGING_SIGN.get()));
        this.add(ModBlocks.HICKORY_WALL_HANGING_SIGN.get(),
                block -> createSingleItemTable(ModBlocks.HICKORY_HANGING_SIGN.get()));

        this.add(ModBlocks.HICKORY_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HICKORY_SLAB.get()));
        this.add(ModBlocks.HICKORY_DOOR.get(),
                block -> createSlabItemTable(ModBlocks.HICKORY_DOOR.get()));

        this.dropSelf(ModBlocks.SPOTTED_WINTERGREEN.get());
        this.dropSelf(ModBlocks.PINKSTER_FLOWER.get());


    }

    protected LootTable.Builder createSilktouchedFortuneDrops(Block pBlock, Item item, int min, int max) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));

    }

    protected LootTable.Builder createSilktouchedFortuneDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 5)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    protected LootTable.Builder createSilktouchedDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item).apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}