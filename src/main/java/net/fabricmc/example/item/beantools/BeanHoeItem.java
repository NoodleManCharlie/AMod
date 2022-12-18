package net.fabricmc.example.item.beantools;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

public class BeanHoeItem extends HoeItem {
    public BeanHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
