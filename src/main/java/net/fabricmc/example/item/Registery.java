package net.fabricmc.example.item;

import net.fabricmc.example.blocks.BeanChest;
import net.fabricmc.example.blocks.BeanChestEntity;
import net.fabricmc.example.ExampleMod;

import net.fabricmc.example.enchantments.BeanEnchant;
import net.fabricmc.example.enchantments.DepressionEnchant;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Registery {
    
    public static final ArmorMaterial CAM = new BeanArmorMaterial();
    //public static final Item CUSTOM_MATERIAL = new CustomMaterialItem(new Item.Settings());
    // If you made a new material, this is where you would note it.

    public static final BeanArmor BEAN_HELMET = new BeanArmor(CAM, EquipmentSlot.HEAD, new Item.Settings());
    public static final BeanArmor BEAN_CHESTPLATE = new BeanArmor(CAM, EquipmentSlot.CHEST, new Item.Settings());
    public static final BeanArmor BEAN_LEGGINGS = new BeanArmor(CAM, EquipmentSlot.LEGS, new Item.Settings());
    public static final BeanArmor BEAN_BOOTS = new BeanArmor(CAM, EquipmentSlot.FEET, new Item.Settings());

    public static Enchantment BeanEnchant = new BeanEnchant();
    public static Enchantment DepressionEnchant = new DepressionEnchant();

    public static final BlockEntityType<BeanChestEntity> BeanChestEntitie = FabricBlockEntityTypeBuilder.create(BeanChestEntity::new, ExampleMod.BeanChestBlock).build();

    public static void register()
    {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BEAN_HELMET));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BEAN_CHESTPLATE));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BEAN_LEGGINGS));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BEAN_BOOTS));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BeanToolMaterial.BeanSword));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(BeanToolMaterial.BeanPickaxe));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(BeanToolMaterial.BeanAxe));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> entries.add(BeanToolMaterial.BeanAxe));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(BeanToolMaterial.BeanShovel));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(BeanToolMaterial.BeanHoe));

        //Registry.register(Registries.ITEM, new Identifier("examplemod", "custom_material"), CUSTOM_MATERIAL);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanhelmet"), BEAN_HELMET);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanchestplate"), BEAN_CHESTPLATE);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanleggings"), BEAN_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanboots"), BEAN_BOOTS);

        Registry.register(Registries.ITEM, new Identifier("modid", "beansword"), BeanToolMaterial.BeanSword);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanpickaxe"), BeanToolMaterial.BeanPickaxe);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanaxe"), BeanToolMaterial.BeanAxe);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanshovel"), BeanToolMaterial.BeanShovel);
        Registry.register(Registries.ITEM, new Identifier("modid", "beanhoe"), BeanToolMaterial.BeanHoe);

        Registry.register(Registries.ENCHANTMENT, new Identifier("modid", "beanenchant"), BeanEnchant);
        Registry.register(Registries.ENCHANTMENT, new Identifier("modid", "depressionenchant"), DepressionEnchant);

        Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier("modid", "beanchest"), BeanChestEntitie);
    }
}
