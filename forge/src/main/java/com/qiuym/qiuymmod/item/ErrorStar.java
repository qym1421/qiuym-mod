package com.qiuym.qiuymmod.item;

import net.minecraft.world.item.*;

public class ErrorStar extends Item {
    public ErrorStar(Item.Properties properties) {
        super(properties
            .fireResistant()
            .stacksTo(1)
            .durability(0)
            .rarity(Rarity.EPIC)
        );
    }
}