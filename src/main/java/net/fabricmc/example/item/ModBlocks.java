package net.fabricmc.example.item;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

      public static Block registerBlocks(String name, Block block)
      {
        return Registry.register(Registries.BLOCK, new Identifier("modid", name), block);
      }

}
