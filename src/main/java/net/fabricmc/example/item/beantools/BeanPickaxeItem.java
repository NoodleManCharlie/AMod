package net.fabricmc.example.item.beantools;

import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;

public class BeanPickaxeItem extends PickaxeItem {
    public BeanPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) 
    {
        super(material, attackDamage, attackSpeed, settings);
    }
}
