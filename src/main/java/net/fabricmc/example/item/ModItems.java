package net.fabricmc.example.item;

import net.fabricmc.example.ExampleMod;
import net.minecraft.item.BlockItem;
//import net.minecraft.util.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ModItems {

	//public static Item Bean = new Item(new FabricItemSettings().group(ItemGroups.FOOD_AND_DRINK));

        //registerItem
        public static Item registerItem(String name, Item item, ItemGroup group) {
                ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
                return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), item);
        }

        public static BlockItem registerBlockItem(String name, BlockItem block, ItemGroup group) {
                ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
                return Registry.register(Registries.ITEM, new Identifier(ExampleMod.MOD_ID, name), block);
        }
        
        //Making items
        //public static final Item ITEM_NAME = registerItem("item_name", new Item(new Item.Settings()), ItemGroups.FOOD_AND_DRINK);
        
        //Making custom item groups:
        /*public static final ItemGroup GROUP_NAME = FabricItemGroup.builder(new Identifier(TutorialMod.MOD_ID))
                    .displayName(Text.literal("Item Tab Name"))
                    .icon(() -> new ItemStack(ModItems.ITEM_NAME))
                    .build();
*/
}