package com.qiuym.fabricqiuymmod.item;

import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Rarity;

public class SiliconPickaxeItem extends PickaxeItem {
    public SiliconPickaxeItem() {
        super(new ToolMaterial() {
            @Override
            public int getDurability() {
                return 0;
            }

            @Override
            public float getMiningSpeedMultiplier() {
                return 200.0F;
            }

            @Override
            public float getAttackDamage() {
                return 3.0F;
            }

            @Override
            public int getMiningLevel() {
                return 4;
            }

            @Override
            public int getEnchantability() {
                return 30;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.EMPTY;
            }
        }, 4, -2.8F, new Item.Settings().fireproof().maxCount(1).rarity(Rarity.EPIC));
    }
}