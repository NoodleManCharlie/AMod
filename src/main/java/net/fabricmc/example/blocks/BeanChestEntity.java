package net.fabricmc.example.blocks;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.example.ImplementedInventory;
import net.fabricmc.example.item.Registery;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

public class BeanChestEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(90, ItemStack.EMPTY);

    public BeanChestEntity(BlockPos pos, BlockState state) {
        super(Registery.BeanChestEntitie, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }
 
    @Override
    public void writeNbt(NbtCompound nbt) {
        
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);
    }
}
