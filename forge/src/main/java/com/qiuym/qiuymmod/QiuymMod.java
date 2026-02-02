package com.qiuym.qiuymmod;

import com.qiuym.qiuymmod.*;
import com.qiuym.qiuymmod.entity.*;
import com.qiuym.qiuymmod.tab.Tab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraft.resources.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.Map;

@Mod(QiuymMod.MODID)
public class QiuymMod {
    public static final String MODID = "qiuymmod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public static final DeferredRegister<CreativeModeTab> TABS = 
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<CreativeModeTab> QIUYMMOD_TAB = TABS.register("qiuymmod", () -> new Tab().output());
    
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        if (QiuymModEntity.ERROR_WITHER.isPresent()) {
            event.put(QiuymModEntity.ERROR_WITHER.get(), ErrorWither.createAttributes().build());
        } else {
            LOGGER.warn("Entity 'error_wither' not found when creating attributes");
        }
    }

    public QiuymMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        QiuymModEntity.register(modEventBus);
        QiuymModBlock.BLOCKS.register(modEventBus);
        QiuymModItem.register(modEventBus);
        TABS.register(modEventBus);
        
        modEventBus.addListener(this::onCommonSetup);
        modEventBus.addListener(QiuymMod::entityAttributeEvent);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        
        event.enqueueWork(() -> {
            LOGGER.info("QiuymMod is initializing.");
        });
    }
}