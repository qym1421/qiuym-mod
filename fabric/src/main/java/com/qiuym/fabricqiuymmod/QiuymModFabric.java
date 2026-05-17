package com.qiuym.fabricqiuymmod;

import com.qiuym.fabricqiuymmod.item.*;
import com.qiuym.fabricqiuymmod.block.*;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.block.*;
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
    public static Item QUARTZ_POWDER;
    public static Block QUARTZ_ORE;
    public static Item QUARTZ_ORE_ITEM;
    public static ArmorItem ERRORHELMET;
    
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
        registerBlocks();
        
        // 注册物品组
        Registry.register(Registries.ITEM_GROUP, new Identifier(MODID, "qiuymmod"), QIUYMMOD_TAB);
        
        // 添加物品到标签页
        ItemGroupEvents.modifyEntriesEvent(Registries.ITEM_GROUP.getKey(QIUYMMOD_TAB).orElseThrow()).register(content -> {
            content.add(SICKLE);
            content.add(SILICON_PICKAXE);
            content.add(QUARTZ_STICK);
            content.add(QUARTZ_INGOT);
            content.add(ERRORHELMET);
            content.add(QUARTZ_ORE_ITEM);
            content.add(QUARTZ_POWDER);
        });
        
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheNether(),      // 仅下界生物群系
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MODID, "quartz_ore"))
        );
        
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
        
        ERRORHELMET = Registry.register(Registries.ITEM, 
            new Identifier(MODID, "errorhelmet"), 
            new ErrorHelmet()
        );
        
        QUARTZ_POWDER = Registry.register(Registries.ITEM,
            new Identifier(MODID, "quartz_powder"),
            new QuartzPowder(new Item.Settings().maxCount(64))
        );
        
        System.out.println("Items registered successfully");
    }
    
    private void registerBlocks() {
        // 注册方块
        QUARTZ_ORE = Registry.register(Registries.BLOCK,
            new Identifier(MODID, "quartz_ore"),
            new QuartzOreBlock()
        );
        
        QUARTZ_ORE_ITEM = Registry.register(Registries.ITEM,
            new Identifier(MODID, "quartz_ore"),
            new BlockItem(QUARTZ_ORE, new Item.Settings())
        );
    }
}