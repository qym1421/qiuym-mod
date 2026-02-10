package com.qiuym.qiuymmod.client.renderer;

import com.qiuym.qiuymmod.entity.ErrorWitherSkull;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherSkullRenderer;
import net.minecraft.resources.ResourceLocation;

public class ErrorWitherSkullRenderer extends WitherSkullRenderer {
    private static final ResourceLocation ERROR_WITHER_SKULL_TEXTURE = 
        ResourceLocation.fromNamespaceAndPath("qiuymmod", "textures/entity/error_wither.png");
    
    public ErrorWitherSkullRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
    
    @Override
    public ResourceLocation getTextureLocation(net.minecraft.world.entity.projectile.WitherSkull entity) {
        if (entity instanceof ErrorWitherSkull) {
            return ERROR_WITHER_SKULL_TEXTURE;
        }
        return super.getTextureLocation(entity);
    }
}