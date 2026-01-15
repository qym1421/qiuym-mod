package com.qiuym.qiuymmod.item;

import net.minecraft.world.item.*;

public class QuartzPowder extends Item {
    public QuartzPowder(Item.Properties properties) {
        super(properties
            .fireResistant()
            .stacksTo(64)
            .rarity(Rarity.EPIC)
        );
    }
}