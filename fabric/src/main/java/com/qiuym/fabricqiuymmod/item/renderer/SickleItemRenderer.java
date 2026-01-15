package com.qiuym.fabricqiuymmod.item.renderer;

import com.qiuym.fabricqiuymmod.item.SickleItem;
import com.qiuym.fabricqiuymmod.item.model.SickleItemModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class SickleItemRenderer extends GeoItemRenderer<SickleItem> {
    public SickleItemRenderer() {
        super(new SickleItemModel());
    }
}