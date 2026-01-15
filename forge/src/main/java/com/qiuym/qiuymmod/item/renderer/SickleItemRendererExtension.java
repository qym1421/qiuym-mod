package com.qiuym.qiuymmod.item.renderer;

import com.qiuym.qiuymmod.item.renderer.SickleItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class SickleItemRendererExtension implements IClientItemExtensions {
    private final BlockEntityWithoutLevelRenderer renderer;

    public SickleItemRendererExtension() {
        this.renderer = new SickleItemRenderer();
    }

    @Override
    public BlockEntityWithoutLevelRenderer getCustomRenderer() {
        return this.renderer;
    }
}