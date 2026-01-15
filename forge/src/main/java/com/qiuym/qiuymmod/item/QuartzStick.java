package com.qiuym.qiuymmod.item;

import net.minecraft.world.item.*;

public class QuartzStick extends Item {
    public QuartzStick(Item.Properties properties) {
        super(properties
            .fireResistant()
            .stacksTo(64)
            .rarity(Rarity.UNCOMMON)
        );
    }
}