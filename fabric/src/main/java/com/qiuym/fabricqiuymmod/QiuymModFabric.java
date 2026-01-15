package com.qiuym.fabricqiuymmod;

import com.qiuym.fabricqiuymmod.item.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class QiuymModFabric implements ModInitializer {
    public static final String MODID = "qiuymmod";
    
    // 物品实例
    public static Item SICKLE;
    public static Item SILICON_PICKAXE;
    public static Item QUARTZ_STICK;
    public static Item QUARTZ_INGOT;
    
    // 创造模式标签页
    public static final ItemGroup QIUYMMOD_TAB = FabricItemGroup.builder()
        .icon(() -> new ItemStack(SICKLE))
        .displayName(Text.translatable("itemGroup.qiuymmod"))
        .build();

    @Override
    public void onInitialize() {
        System.out.println("Initializing Qiuym Mod for Fabric...");
        
        // 注册物品
        registerItems();
        
        // 注册物品组
        Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, "qiuymmod"), QIUYMMOD_TAB);
        
        // 添加物品到标签页
        ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(QIUYMMOD_TAB).orElseThrow()).register(content -> {
            content.add(SICKLE);
            content.add(SILICON_PICKAXE);
            content.add(QUARTZ_STICK);
            content.add(QUARTZ_INGOT);
        });
        
        System.out.println("Qiuym Mod initialized successfully!");
    }
    
    private void registerItems() {
        // 注册物品
        SICKLE = Registry.register(Registries.ITEM, 
            new Identifier(MODID, "sickle"), 
            new SickleItem(new Item.Settings().maxCount(1).rarity(net.minecraft.util.Rarity.EPIC))
        );
        
        SILICON_PICKAXE = Registry.register(Registries.ITEM, 
            new Identifier(MODID, "silicon_pickaxe"), 
            new SiliconPickaxeItem()
        );
        
        QUARTZ_STICK = Registry.register(Registries.ITEM, 
            new Identifier(MODID, "quartz_stick"), 
            new QuartzStick(new Item.Settings().maxCount(64).rarity(net.minecraft.util.Rarity.UNCOMMON).fireproof())
        );
        
        QUARTZ_INGOT = Registry.register(Registries.ITEM, 
            new Identifier(MODID, "quartz_ingot"), 
            new QuartzIngot(new Item.Settings().maxCount(64).rarity(net.minecraft.util.Rarity.UNCOMMON).fireproof())
        );
        
        System.out.println("Items registered successfully");
    }
}