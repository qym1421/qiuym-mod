package com.qiuym.qiuymmod;

import com.qiuym.qiuymmod.item.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QiuymModItem {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, QiuymMod.MODID);
    
    // 注意：SickleItem 需要 Properties 参数
    public static final RegistryObject<Item> SICKLE = ITEMS.register("sickle", 
        () -> new SickleItem(
        ));
    
    // SiliconPickaxeItem 有自己的构造器，不需要参数
    public static final RegistryObject<Item> SILICON_PICKAXE = ITEMS.register("silicon_pickaxe", 
        () -> new SiliconPickaxeItem());
    
    // 需要给 QuartzStick 提供 Properties 参数
    public static final RegistryObject<Item> QUARTZ_STICK = ITEMS.register("quartz_stick", 
        () -> new QuartzStick(new Item.Properties()
        ));
    
    // 需要给 QuartzIngot 提供 Properties 参数
    public static final RegistryObject<Item> QUARTZ_INGOT = ITEMS.register("quartz_ingot", 
        () -> new QuartzIngot(new Item.Properties()
        ));
    
    // 需要给 QuartzPowder 提供 Properties 参数
    public static final RegistryObject<Item> QUARTZ_POWDER = ITEMS.register("quartz_powder", 
        () -> new QuartzPowder(new Item.Properties()
        ));
    
    // 方块物品
    public static final RegistryObject<Item> QUARTZ_ORE = ITEMS.register("quartz_ore",
        () -> new BlockItem(QiuymModBlock.QUARTZ_ORE.get(), new Item.Properties()));
    
    // 注册方法
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}