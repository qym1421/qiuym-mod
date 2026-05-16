package com.qiuym.fabricqiuymmod.item.materials;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ErrorMaterial implements ArmorMaterial {
    
    private static final int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    
    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.getEquipmentSlot().getEntitySlotId()] * 25;
    }
    
    @Override
    public int getProtection(ArmorItem.Type type) {
        switch (type) {
            case HELMET: return 30;
            case CHESTPLATE: return 50;
            case LEGGINGS: return 44;
            case BOOTS: return 41;
            default: return 100;
        }
    }
    
    @Override
    public int getEnchantability() {
        return 15;
    }
    
    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }
    
    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems();
    }
    
    @Override
    public String getName() {
        return "error";
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