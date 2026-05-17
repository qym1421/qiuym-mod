package com.qiuym.fabricqiuymmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class QuartzOreBlock extends Block {
    public QuartzOreBlock() {
        super(Block.Settings.copy(Blocks.IRON_ORE));
    }
}