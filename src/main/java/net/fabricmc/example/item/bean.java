package net.fabricmc.example.item;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
//import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class bean extends Item {
 
    public bean(Settings settings) {
        super(settings);
    }
 
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
 
        // formatted red text
        tooltip.add(Text.translatable("item.modid.Bean.tooltip").formatted(Formatting.RED));
        
    }
    
}
