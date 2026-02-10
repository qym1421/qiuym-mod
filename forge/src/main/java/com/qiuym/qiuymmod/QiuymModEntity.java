package com.qiuym.qiuymmod;

import com.qiuym.qiuymmod.QiuymMod;
import com.qiuym.qiuymmod.entity.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class QiuymModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITIES = 
        DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, QiuymMod.MODID);
    
    public static final RegistryObject<EntityType<ErrorWither>> ERROR_WITHER =
        ENTITIES.register("error_wither",
        () -> EntityType.Builder.of(ErrorWither::new, MobCategory.MONSTER)
            .sized(0.9F, 3.5F)
            .clientTrackingRange(10)
            .build("error_wither")
    );
    
    public static final RegistryObject<EntityType<ErrorWitherSkull>> ERROR_WITHER_SKULL = ENTITIES.register(
        "error_wither_skull",
        () -> EntityType.Builder.<ErrorWitherSkull>of(ErrorWitherSkull::new, MobCategory.MISC)
            .sized(0.3125F, 0.3125F)
            .clientTrackingRange(4)
            .updateInterval(10)
            .build("qiuymmod:error_wither_skull")
    );
    
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}