package com.qiuym.qiuymmod.item.model;

import com.qiuym.qiuymmod.item.SickleItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SickleItemModel
extends GeoModel<SickleItem> {
    public ResourceLocation getAnimationResource(SickleItem sickleItem) {
        return new ResourceLocation("qiuymmod", "animations/liandao_model.animation.json");
    }

    public ResourceLocation getModelResource(SickleItem sickleItem) {
        return new ResourceLocation("qiuymmod", "geo/liandao_model.geo.json");
    }

    public ResourceLocation getTextureResource(SickleItem sickleItem) {
        return new ResourceLocation("qiuymmod", "textures/item/liandao_texture.png");
    }
}
