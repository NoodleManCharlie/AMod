package net.fabricmc.example.item.beantools;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class BeanAxeItem extends AxeItem {
    public BeanAxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
