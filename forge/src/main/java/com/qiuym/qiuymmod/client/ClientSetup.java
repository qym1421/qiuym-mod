package com.qiuym.qiuymmod.client;

import com.qiuym.qiuymmod.QiuymMod;
import com.qiuym.qiuymmod.client.renderer.*;
import com.qiuym.qiuymmod.QiuymModEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = QiuymMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(QiuymModEntity.ERROR_WITHER.get(), ErrorWitherRenderer::new);
        event.registerEntityRenderer(QiuymModEntity.ERROR_WITHER_SKULL.get(), ErrorWitherSkullRenderer::new);
    }
}