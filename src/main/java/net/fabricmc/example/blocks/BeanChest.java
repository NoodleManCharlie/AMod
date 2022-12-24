package net.fabricmc.example.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeanChest extends Block implements BlockEntityProvider  {

    public BeanChest(Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BeanChestEntity(pos, state);
    }

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);
 
 
        if (!player.getStackInHand(hand).isEmpty()) {
            if (blockEntity.getStack(0).isEmpty()) 
            {
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            } 
            else if (blockEntity.getStack(1).isEmpty()) 
            {
                blockEntity.setStack(1, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            } 
            else 
            {
                System.out.println("The first slot holds " + blockEntity.getStack(0) + " and the second slot holds " + blockEntity.getStack(1));
            }
        } 
        else {
            // If the player is not holding anything we'll get give him the items in the block entity one by one
 
             // Find the first slot that has an item and give it to the player
            if (!blockEntity.getStack(1).isEmpty()) 
            {
                player.getInventory().offerOrDrop(blockEntity.getStack(1));
                blockEntity.removeStack(1);
            } else if (!blockEntity.getStack(0).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
            }
        }
        
        return ActionResult.SUCCESS;
    }

    
}
