package com.qiuym.qiuymmod.tab;

import com.qiuym.qiuymmod.QiuymModItem;
import com.qiuym.qiuymmod.QiuymModBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class Tab {
    public CreativeModeTab output() {
        return CreativeModeTab.builder(net.minecraft.world.item.CreativeModeTab.Row.BOTTOM, 5)
            .title(net.minecraft.network.chat.Component.translatable("§5§lQiuym Mod"))
            .icon(() -> new ItemStack(QiuymModItem.SICKLE.get()))
            .displayItems((parameters, output) -> {
                output.accept(new ItemStack(QiuymModItem.SICKLE.get()));
                output.accept(new ItemStack(QiuymModItem.SILICON_PICKAXE.get()));
                output.accept(new ItemStack(QiuymModItem.QUARTZ_STICK.get()));
                output.accept(new ItemStack(QiuymModItem.QUARTZ_INGOT.get()));
                output.accept(new ItemStack(QiuymModItem.QUARTZ_POWDER.get()));
                output.accept(new ItemStack(QiuymModItem.QUARTZ_ORE.get()));
                //output.accept(new ItemStack(QiuymModItem.ERRORHELMET.get()));
            })
            .build();
    }
}