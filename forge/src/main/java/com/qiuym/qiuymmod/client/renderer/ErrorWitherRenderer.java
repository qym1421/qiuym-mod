package com.qiuym.qiuymmod.client.renderer;

import com.qiuym.qiuymmod.entity.ErrorWither;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.WitherBossRenderer;
import net.minecraft.resources.ResourceLocation;

public class ErrorWitherRenderer extends WitherBossRenderer {
    private static final ResourceLocation ERROR_WITHER_TEXTURE = 
        ResourceLocation.fromNamespaceAndPath("qiuymmod", "textures/entity/error_wither.png");
    private static final ResourceLocation INVULNERABLE_ERROR_WITHER_TEXTURE = 
        ResourceLocation.fromNamespaceAndPath("qiuymmod", "textures/entity/error_wither_invulnerable.png");
    
    public ErrorWitherRenderer(EntityRendererProvider.Context context) {
        super(context);
    }
    
    @Override
    public ResourceLocation getTextureLocation(net.minecraft.world.entity.boss.wither.WitherBoss entity) {
        if (entity instanceof ErrorWither errorWither) {
            int invulnerableTime = errorWither.getInvulnerableTicks();
            return invulnerableTime > 0 && (invulnerableTime > 80 || invulnerableTime / 5 % 2 != 1) 
                ? INVULNERABLE_ERROR_WITHER_TEXTURE 
                : ERROR_WITHER_TEXTURE;
        }
        return super.getTextureLocation(entity);
    }
}