package com.qiuym.qiuymmod.item.materials;

import java.util.*;
import java.util.stream.*;
import net.minecraft.world.item.*;
import net.minecraft.sounds.*;
import net.minecraft.world.item.crafting.*;

public class ErrorMaterial implements ArmorMaterial {
    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return switch(type) {
            case HELMET -> 0;
            case CHESTPLATE -> 0;
            case LEGGINGS -> 0;
            case BOOTS -> 0;
        };
    }
    
    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return switch(type) {
            case HELMET -> 30;
            case CHESTPLATE -> 50;
            case LEGGINGS -> 40;
            case BOOTS -> 20;
        };
    }
    
    @Override
    public int getEnchantmentValue() {
        return 15;
    }
    
    @Override
    public SoundEvent getEquipSound() {
        return null;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
    
    @Override
    public String getName() {
        return "qiuymmod:error";
    }
    
    @Override
    public float getToughness() {
        return 1.0F;
    }
    
    @Override
    public float getKnockbackResistance() {
        return 1.0F;
    }
}