package com.qiuym.qiuymmod;

import com.qiuym.qiuymmod.QiuymMod;
import com.qiuym.qiuymmod.block.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QiuymModBlock {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, QiuymMod.MODID);
    public static final RegistryObject<Block> QUARTZ_ORE = BLOCKS.register("quartz_ore", 
        () -> new QuartzOre(BlockBehaviour.Properties.of()));
    
    
}