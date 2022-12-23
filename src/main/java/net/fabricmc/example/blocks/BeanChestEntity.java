package net.fabricmc.example.blocks;

import org.jetbrains.annotations.Nullable;

import net.fabricmc.example.item.Registery;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.math.BlockPos;

public class BeanChestEntity extends BlockEntity {
    private int number = 7;

    public BeanChestEntity(BlockPos pos, BlockState state) {
        super(Registery.BeanChestEntitie, pos, state);
    }

    public void writeNbt(NbtCompound nbt) {
        // Save the current value of the number to the nbt
        nbt.putInt("number", number);
 
        super.writeNbt(nbt);
        
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
 
        number = nbt.getInt("number");
    }

    /*@Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
      return BlockEntityUpdateS2CPacket.create(this);
    }
   
    @Override
    public NbtCompound toInitialChunkDataNbt() {
      return createNbt();
    }*/
}
