package net.fabricmc.example.item;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.item.beantools.BeanAxeItem;
import net.fabricmc.example.item.beantools.BeanHoeItem;
import net.fabricmc.example.item.beantools.BeanPickaxeItem;

import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class BeanToolMaterial implements ToolMaterial {

    public static final BeanToolMaterial INSTANCE = new BeanToolMaterial();

    public static ToolItem BeanShovel = new ShovelItem(BeanToolMaterial.INSTANCE, -2, -3.0F, new Item.Settings());
    public static ToolItem BeanSword = new SwordItem(BeanToolMaterial.INSTANCE, -1, -2.4F, new Item.Settings());

    public static ToolItem BeanPickaxe = new BeanPickaxeItem(BeanToolMaterial.INSTANCE, -1, -2.8F, new Item.Settings());
    public static ToolItem BeanAxe = new BeanAxeItem(BeanToolMaterial.INSTANCE, 4, -2.2f, new Item.Settings());
    public static ToolItem BeanHoe = new BeanHoeItem(BeanToolMaterial.INSTANCE, -1, -3.2F, new Item.Settings());

    @Override
    public int getDurability() {
        return 20000;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.0F;
    }

    @Override
    public float getAttackDamage() {
        return 8F;
    }

    @Override
    public int getMiningLevel() {
        return 5;
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ExampleMod.Bean);
    }
}