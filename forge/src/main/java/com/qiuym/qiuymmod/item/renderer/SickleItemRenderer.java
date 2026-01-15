package com.qiuym.qiuymmod.item.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.qiuym.qiuymmod.item.SickleItem;
import com.qiuym.qiuymmod.item.model.SickleItemModel;
import java.util.HashSet;
import java.util.Set;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

public class SickleItemRenderer
extends GeoItemRenderer<SickleItem> {
    private static final float SCALE_RECIPROCAL = 0.0625f;
    protected SickleItem animatable;
    protected MultiBufferSource currentBuffer;
    private final Set<String> hiddenBones = new HashSet<String>();
    protected boolean renderArms = false;
    protected RenderType renderType;
    private final Set<String> suppressedBones = new HashSet<String>();
    public ItemDisplayContext transformType;

    public SickleItemRenderer() {
        super((GeoModel)new SickleItemModel());
    }

    public void actuallyRender(PoseStack poseStack, SickleItem sickleItem, BakedGeoModel bakedGeoModel, RenderType renderType, MultiBufferSource multiBufferSource, VertexConsumer vertexConsumer, boolean bl, float f, int n, int n2, float f2, float f3, float f4, float f5) {
        this.currentBuffer = multiBufferSource;
        this.renderType = renderType;
        this.animatable = sickleItem;
        super.actuallyRender(poseStack, sickleItem, bakedGeoModel, renderType, multiBufferSource, vertexConsumer, bl, f, n, n2, f2, f3, f4, f5);
        if (this.renderArms) {
            this.renderArms = false;
        }
    }

    public RenderType getRenderType(SickleItem sickleItem, ResourceLocation resourceLocation, MultiBufferSource multiBufferSource, float f) {
        return RenderType.entityTranslucent((ResourceLocation)this.getTextureLocation(sickleItem));
    }

    public ResourceLocation getTextureLocation(SickleItem sickleItem) {
        return super.getTextureLocation(sickleItem);
    }

    public void renderByItem(ItemStack itemStack, ItemDisplayContext itemDisplayContext, PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight, int packedOverlay) {
        this.transformType = itemDisplayContext;
        if (this.animatable != null) {
          //  this.animatable.getTransformType(itemDisplayContext);
        }
        super.renderByItem(itemStack, itemDisplayContext, poseStack, multiBufferSource, packedLight, packedOverlay);
    }
}
