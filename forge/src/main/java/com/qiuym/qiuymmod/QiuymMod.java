package com.qiuym.qiuymmod;

import com.qiuym.qiuymmod.*;
import com.qiuym.qiuymmod.tab.Tab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(QiuymMod.MODID)
public class QiuymMod {
    public static final String MODID = "qiuymmod";

    public static final DeferredRegister<CreativeModeTab> TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> QIUYMMOD_TAB = TABS.register("qiuymmod", () -> new Tab().output());

    public QiuymMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        QiuymModItem.ITEMS.register(modEventBus);
        QiuymModBlock.BLOCKS.register(modEventBus);
        TABS.register(modEventBus);
        modEventBus.addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        event.enqueueWork(() -> {
        });
    }
}