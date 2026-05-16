package com.qiuym.fabricqiuymmod.item;

import java.util.UUID;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.qiuym.fabricqiuymmod.QiuymModFabric;
import com.qiuym.fabricqiuymmod.item.materials.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Rarity;

public class ErrorHelmet extends ArmorItem {
    private static final UUID MAX_HEALTH_MODIFIER_UUID = UUID.fromString("5D6F0BA2-9999-4BAB-BC23-0A3C4B9D4D54");
    private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("6D6F0BA2-8888-4BAB-BC23-0A3C4B9D4D55");
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.fromString("7D6F0BA2-7777-4BAB-BC23-0A3C4B9D4D56");
    private static final UUID ATTACK_SPEED_UUID = UUID.fromString("8D6F0BA2-6666-4BAB-BC23-0A3C4B9D4D57");
    private static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("9D6F0BA2-5555-4BAB-BC23-0A3C4B9D4D58");
    private static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("AD6F0BA2-4444-4BAB-BC23-0A3C4B9D4D59");
    private static final UUID KNOCKBACK_RESISTANCE_UUID = UUID.fromString("BD6F0BA2-3333-4BAB-BC23-0A3C4B9D4D60");

    public ErrorHelmet() {
        super(
            new ErrorMaterial(),  // 自定义盔甲材料
            Type.HELMET,
            new Item.Settings()
                .fireproof()           // Yarn映射中是fireproof()
                .maxCount(1)            // Yarn映射中是maxCount()
                .rarity(Rarity.EPIC)
        );
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.HEAD) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            
            // 先添加盔甲本身的属性
            builder.putAll(super.getAttributeModifiers(slot));
            
            // 添加自定义属性
            builder.put(
                EntityAttributes.GENERIC_MAX_HEALTH,
                new EntityAttributeModifier(
                    MAX_HEALTH_MODIFIER_UUID,
                    "Error Helmet Health Boost",
                    200.0,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_ARMOR,
                new EntityAttributeModifier(
                    ARMOR_MODIFIER_UUID,
                    "Error Helmet Armor Boost",
                    1.0,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_ARMOR_TOUGHNESS,
                new EntityAttributeModifier(
                    ARMOR_TOUGHNESS_UUID,
                    "Error Helmet Toughness Boost",
                    0.5,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_ATTACK_SPEED,
                new EntityAttributeModifier(
                    ATTACK_SPEED_UUID,
                    "Error Helmet Attack Speed Boost",
                    0.7,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                new EntityAttributeModifier(
                    MOVEMENT_SPEED_UUID,
                    "Error Helmet Movement Speed Boost",
                    0.3,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                new EntityAttributeModifier(
                    ATTACK_DAMAGE_UUID,
                    "Error Helmet Attack Damage Boost",
                    30.0,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            builder.put(
                EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                new EntityAttributeModifier(
                    KNOCKBACK_RESISTANCE_UUID,
                    "Error Helmet Knockback Resistance",
                    1.0,
                    EntityAttributeModifier.Operation.ADDITION
                )
            );
            
            return builder.build();
        }
        return super.getAttributeModifiers(slot);
    }
}