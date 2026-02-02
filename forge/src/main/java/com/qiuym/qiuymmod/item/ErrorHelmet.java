package com.qiuym.qiuymmod.item;

import java.util.UUID;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.qiuym.qiuymmod.item.materials.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;

public class ErrorHelmet extends ArmorItem {
    private static final UUID MAX_HEALTH_MODIFIER_UUID = UUID.fromString("5D6F0BA2-9999-4BAB-BC23-0A3C4B9D4D54");
    private static final UUID ARMOR_MODIFIER_UUID = UUID.fromString("6D6F0BA2-8888-4BAB-BC23-0A3C4B9D4D55");
    private static final UUID ARMOR_TOUGHNESS_UUID = UUID.fromString("7D6F0BA2-7777-4BAB-BC23-0A3C4B9D4D56");
    private static final UUID ATTACK_SPEED_UUID = UUID.fromString("8D6F0BA2-6666-4BAB-BC23-0A3C4B9D4D57");
    private static final UUID MOVEMENT_SPEED_UUID = UUID.fromString("9D6F0BA2-5555-4BAB-BC23-0A3C4B9D4D58");
    private static final UUID ATTACK_DAMAGE_UUID = UUID.fromString("AD6F0BA2-4444-4BAB-BC23-0A3C4B9D4D59");
    private static final UUID KNOCKBACK_RESISTANCE_UUID = UUID.fromString("BD6F0BA2-3333-4BAB-BC23-0A3C4B9D4D60");

    public ErrorHelmet(Item.Properties properties) {
        super(
            new ErrorMaterial(),
            ArmorItem.Type.HELMET,
            properties
                .fireResistant()
                .stacksTo(1)
                .durability(0)
                .rarity(Rarity.EPIC)
        );
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        if (equipmentSlot == EquipmentSlot.HEAD) {
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            
            builder.putAll(super.getAttributeModifiers(equipmentSlot, stack));
            
            builder.put(
                Attributes.MAX_HEALTH,
                new AttributeModifier(
                    MAX_HEALTH_MODIFIER_UUID,
                    "Error Helmet Health Boost",
                    200.0,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.ARMOR,
                new AttributeModifier(
                    ARMOR_MODIFIER_UUID,
                    "Error Helmet Armor Boost",
                    1.0,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(
                    ARMOR_TOUGHNESS_UUID,
                    "Error Helmet Toughness Boost",
                    0.5,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(
                    ATTACK_SPEED_UUID,
                    "Error Helmet Attack Speed Boost",
                    0.7,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.MOVEMENT_SPEED,
                new AttributeModifier(
                    MOVEMENT_SPEED_UUID,
                    "Error Helmet Movement Speed Boost",
                    0.3,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(
                    ATTACK_DAMAGE_UUID,
                    "Error Helmet Attack Damage Boost",
                    30.0,
                    AttributeModifier.Operation.ADDITION
                )
            );
            builder.put(
                Attributes.KNOCKBACK_RESISTANCE,
                new AttributeModifier(
                    KNOCKBACK_RESISTANCE_UUID,
                    "Error Helmet Knockback Resistance",
                    1.0,
                    AttributeModifier.Operation.ADDITION
                )
            );
            
            return builder.build();
        }
        return super.getAttributeModifiers(equipmentSlot, stack);
    }
}