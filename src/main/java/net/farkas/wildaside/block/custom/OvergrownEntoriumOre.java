package net.farkas.wildaside.block.custom;

import net.farkas.wildaside.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

public class OvergrownEntoriumOre extends Block {
    public OvergrownEntoriumOre(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            var playerItem = pPlayer.getItemInHand(pHand);

            if (playerItem.getItem() == Items.SHEARS) {
                BlockState newBlock = ModBlocks.ENTORIUM_ORE.get().defaultBlockState();

                pLevel.setBlock(pPos, newBlock, 0);
                pLevel.playSound(null, pPos, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.mooshroom.shear")), SoundSource.BLOCKS, 1, 1);
                pPlayer.swing(pHand);

                if (!pPlayer.isCreative()) {
                    playerItem.hurt(1, RandomSource.create(), null);
                }

                return InteractionResult.SUCCESS;

            }
            return InteractionResult.PASS;
        }

        return InteractionResult.PASS;
    }
}
