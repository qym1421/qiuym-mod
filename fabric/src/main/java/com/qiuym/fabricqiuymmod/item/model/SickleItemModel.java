package com.qiuym.fabricqiuymmod.item.model;

import com.qiuym.fabricqiuymmod.item.SickleItem;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class SickleItemModel extends GeoModel<SickleItem> {
    @Override
    public Identifier getAnimationResource(SickleItem sickleItem) {
        return Identifier.of("qiuymmod", "animations/liandao_model.animation.json");
    }

    @Override
    public Identifier getModelResource(SickleItem sickleItem) {
        return Identifier.of("qiuymmod", "geo/liandao_model.geo.json");
    }

    @Override
    public Identifier getTextureResource(SickleItem sickleItem) {
        return Identifier.of("qiuymmod", "textures/item/liandao_texture.png");
    }
}