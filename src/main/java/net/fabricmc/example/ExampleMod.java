package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.blocks.BeanChestEntity;
import net.fabricmc.example.blocks.BeanChest;
import net.fabricmc.example.item.ModBlocks;
import net.fabricmc.example.item.ModItems;
import net.fabricmc.example.item.Registery;
import net.fabricmc.example.item.bean;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and th log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors. 
	public static final Logger LOGGER = LoggerFactory.getLogger("modid");

	public static String MOD_ID = "modid";


	//public static final Item Bean = ModItems.registerItem("bean", new Item(new Item.Settings()), ItemGroups.FOOD_AND_DRINK);

	public static final Item Bean = new bean(new FabricItemSettings().food(new FoodComponent.Builder().hunger(20).saturationModifier(1000f).snack().meat().statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60), 1f).statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*10), 1f).alwaysEdible().build()));

	public static final Block Beanblock = ModBlocks.registerBlocks("beanblock", new Block(FabricBlockSettings.of(Material.METAL, MapColor.DIRT_BROWN).breakInstantly().jumpVelocityMultiplier(50).sounds(BlockSoundGroup.AZALEA_LEAVES).luminance(2000)));
    public static final BlockItem beanitem = ModItems.registerBlockItem("beanblock", new BlockItem(Beanblock, new FabricItemSettings()), ItemGroups.BUILDING_BLOCKS);

	public static final Block BeanChestBlock = ModBlocks.registerBlocks("beanchest", new Block(FabricBlockSettings.of(Material.METAL, MapColor.DIRT_BROWN)));
    public static final BlockItem BeanChestitem = ModItems.registerBlockItem("beanchest", new BlockItem(BeanChestBlock, new FabricItemSettings()), ItemGroups.BUILDING_BLOCKS);

	@Override
	public void onInitialize() {

		//Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bean"), beans);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(Bean));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bean"), Bean);

		//Bean = ModItems.registerItem( "bean", new Item(new FabricItemSettings()), ItemGroups.FOOD_AND_DRINK);
		FuelRegistry.INSTANCE.add(Bean, 800);
		CompostingChanceRegistry.INSTANCE.add(Bean, (float) 2000);

		LOGGER.info("Hello Fabric world!");

		Registery.register();
		

	}

	
}
