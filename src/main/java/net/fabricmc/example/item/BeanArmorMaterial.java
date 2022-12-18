package net.fabricmc.example.item;

import net.fabricmc.example.ExampleMod;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
//import net.minecraft.eve

public class BeanArmorMaterial implements ArmorMaterial {
	
	private static final int[] BASE_DURABILITY = new int[] {300, 300, 300, 300};
	private static final int[] PROTECTION_VALUES = new int[] {4, 7, 9, 4}; 
	// In which A is boots, B leggings, C chestplate, and D helmet. 
	// For reference, Leather uses {1, 2, 3, 1}, and Diamond/Netherite {3, 6, 8, 3}




	@Override
	public int getDurability(EquipmentSlot slot) {
		return BASE_DURABILITY[slot.getEntitySlotId()] * 40;
	}
 
	@Override
	public int getProtectionAmount(EquipmentSlot slot) {
		return PROTECTION_VALUES[slot.getEntitySlotId()];
	}
 
	@Override
	public int getEnchantability() {
		return 25;
	}
 
	@Override
	public SoundEvent getEquipSound() {
		return SoundEvents.ENTITY_PLAYER_BREATH;
	}
 
	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(ExampleMod.Bean);
	}
 
	@Override
	public String getName() {
		// Must be all lowercase
		return "bean";
	}
 
	@Override
	public float getToughness() {
		return 10;
	}
 
	@Override
	public float getKnockbackResistance() {
		return 0;
	}

}