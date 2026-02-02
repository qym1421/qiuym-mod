package com.qiuym.qiuymmod;

import net.minecraft.world.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SpawnEggItem;
import com.qiuym.qiuymmod.item.*;
import com.qiuym.qiuymmod.*;
import java.util.function.Supplier;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.*;

public class QiuymModItem {
    public static final DeferredRegister<Item> ITEMS = 
        DeferredRegister.create(ForgeRegistries.ITEMS, QiuymMod.MODID);
    
    public static final RegistryObject<Item> SICKLE = ITEMS.register("sickle", 
        () -> new SickleItem(
        ));
    
    public static final RegistryObject<Item> SILICON_PICKAXE = ITEMS.register("silicon_pickaxe", 
        () -> new SiliconPickaxeItem());
    
    public static final RegistryObject<Item> QUARTZ_STICK = ITEMS.register("quartz_stick", 
        () -> new QuartzStick(new Item.Properties()
        ));
    
    public static final RegistryObject<Item> QUARTZ_INGOT = ITEMS.register("quartz_ingot", 
        () -> new QuartzIngot(new Item.Properties()
        ));
    
    public static final RegistryObject<Item> QUARTZ_POWDER = ITEMS.register("quartz_powder", 
        () -> new QuartzPowder(new Item.Properties()
        ));

    public static final RegistryObject<Item> ERRORHELMET = ITEMS.register("errorhelmet", 
        () -> new ErrorHelmet(new Item.Properties()));
        
    public static final RegistryObject<Item> ERROR_STAR = ITEMS.register("error_star", 
        () -> new ErrorStar(new Item.Properties()));
    
    public static final RegistryObject<Item> ERROR_WITHER_SPAWN_EGG = ITEMS.register(
        "error_wither_spawn_egg", 
        () -> new ForgeSpawnEggItem(QiuymModEntity.ERROR_WITHER, 0x1A1A1A, 0xCC0000, new Item.Properties()));
    
    // 方块物品
    public static final RegistryObject<Item> QUARTZ_ORE = ITEMS.register("quartz_ore",
        () -> new BlockItem(QiuymModBlock.QUARTZ_ORE.get(), new Item.Properties()));
    
    // 注册方法
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}