package net.daner.examplemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CompactorBlock extends Block {
    public CompactorBlock(Settings settings){
        super(settings);
    }

    @Override
    public ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getCount() >= 9){
            stack.decrement(9);
            BlockPos above = pos.up();
            world.setBlockState(above, this.getDefaultState());
            world.playSound(null, pos, SoundEvents.BLOCK_PISTON_EXTEND, SoundCategory.BLOCKS, 1f, 1f);

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }
}
