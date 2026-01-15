package com.qiuym.fabricqiuymmod.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.*;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SickleItem extends Item implements GeoItem {
    
    // 属性修饰符的UUID常量
    public static final UUID BASE_ATTACK_DAMAGE_UUID = UUID.fromString("CB3F55D3-645C-4F38-A497-9C13A33DB5CF");
    public static final UUID BASE_ATTACK_SPEED_UUID = UUID.fromString("FA233E1C-4180-4865-B01B-BCCE9785ACA3");
    public static final UUID BASE_MAX_HEALTH_UUID = UUID.fromString("5D6F0BA2-1186-46AC-B896-C61C5CEE99CC");

    // GeckoLib 动画缓存
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    
    public String animationprocedure = "empty";
    public String prevAnim = "empty";

    public SickleItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    // GeoItem 接口实现
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        AnimationController<SickleItem> procedureController = new AnimationController<>(this, "procedureController", 0, this::procedurePredicate);
        controllers.add(procedureController);
        
        AnimationController<SickleItem> idleController = new AnimationController<>(this, "idleController", 0, this::idlePredicate);
        controllers.add(idleController);
    }

    // Fabric 需要创建渲染器提供者
    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            private GeoItemRenderer<SickleItem> renderer;

            @Override
            public net.minecraft.client.render.item.BuiltinModelItemRenderer getCustomRenderer() {
                if (this.renderer == null)
                    this.renderer = new software.bernie.geckolib.renderer.GeoItemRenderer<>(new com.qiuym.fabricqiuymmod.item.model.SickleItemModel());
                
                return this.renderer;
            }
        });
    }

    private PlayState idlePredicate(AnimationState<SickleItem> event) {
        if (this.animationprocedure.equals("empty")) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
            return PlayState.CONTINUE;
        }
        return PlayState.STOP;
    }

    private PlayState procedurePredicate(AnimationState<SickleItem> event) {
        if (!this.animationprocedure.equals("empty") && 
            event.getController().getAnimationState() == AnimationController.State.STOPPED || 
            !this.animationprocedure.equals(this.prevAnim) && !this.animationprocedure.equals("empty")) {
            
            if (!this.animationprocedure.equals(this.prevAnim)) {
                event.getController().forceAnimationReset();
            }
            event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
            
            if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
                this.animationprocedure = "empty";
                event.getController().forceAnimationReset();
            }
        } else if (this.animationprocedure.equals("empty")) {
            this.prevAnim = "empty";
            return PlayState.STOP;
        }
        
        this.prevAnim = this.animationprocedure;
        return PlayState.CONTINUE;
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        if (slot == EquipmentSlot.MAINHAND) {
            ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
            builder.putAll(super.getAttributeModifiers(slot));
            builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, 
                new EntityAttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 60.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_ATTACK_SPEED, 
                new EntityAttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.0, EntityAttributeModifier.Operation.ADDITION));
            builder.put(EntityAttributes.GENERIC_MAX_HEALTH, 
                new EntityAttributeModifier(BASE_MAX_HEALTH_UUID, "Item modifier", 80.0, EntityAttributeModifier.Operation.ADDITION));
            return builder.build();
        }
        return super.getAttributeModifiers(slot);
    }
}