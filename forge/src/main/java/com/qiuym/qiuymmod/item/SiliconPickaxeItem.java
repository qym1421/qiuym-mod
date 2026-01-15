package com.qiuym.qiuymmod.item;

import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.tags.BlockTags;
import java.util.List;
import java.util.function.Supplier;

public class SiliconPickaxeItem extends PickaxeItem {
    public SiliconPickaxeItem() {
        super(new Tier() {
            @Override
            public int getUses() {
                return 0;  // 使用次数
            }

            @Override
            public float getSpeed() {
                return 200.0F;  // 挖掘速度（钻石是8.0）
            }

            @Override
            public float getAttackDamageBonus() {
                return 3.0F;  // 攻击伤害加成
            }

            @Override
            public int getLevel() {
                return 4;  // 挖掘等级（钻石级别）
            }

            @Override
            public int getEnchantmentValue() {
                return 30;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of();
            }
        }, 
        13,  // 基础攻击伤害
        -1.3F,  // 攻击速度
        new Item.Properties()
            .fireResistant()  // 防火
            .stacksTo(1)      // 不能堆叠
            .rarity(Rarity.EPIC)  // 稀有度
        );
    }
}