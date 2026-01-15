package com.qiuym.qiuymmod.item;

import net.minecraft.world.item.*;

public class QuartzIngot extends Item {
    public QuartzIngot(Item.Properties properties) {
        super(properties
            .fireResistant()
            .stacksTo(64)
            .rarity(Rarity.UNCOMMON)
        );
    }
}