package com.qiuym.qiuymmod.entity;

import com.qiuym.qiuymmod.*;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.phys.Vec3;

public class ErrorWither extends WitherBoss {
    public ErrorWither(EntityType<? extends WitherBoss> type, Level level) {
        super(type, level);
    }
    
    private int customAttackDamage = 16;  // 基础攻击伤害
    private float customSpeed = 0.6F;    // 移动速度
    private int customHealth = 600;      // 生命值
    private int customArmor = 6;         // 护甲值
    
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (this.level().isClientSide) return;
        
        double dx = target.getX() - this.getX();
        double dy = target.getY() + target.getEyeHeight() * 0.5 - this.getEyeY();
        double dz = target.getZ() - this.getZ();
        
        double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
        dx = dx / distance * 0.5;
        dy = dy / distance * 0.5;
        dz = dz / distance * 0.5;
        
        ErrorWitherSkull skull = new ErrorWitherSkull(this.level(), this, dx, dy, dz);
        
        Vec3 look = this.getLookAngle();
        skull.setPos(
            this.getX() + look.x * 1.5,
            this.getEyeY() - 0.2,
            this.getZ() + look.z * 1.5
        );
        
        this.level().addFreshEntity(skull);
    }
    
    protected void dropCustomDeathLoot(DamageSource source, boolean recentlyHit) {
        if (!this.level().isClientSide) {
            ServerLevel serverLevel = (ServerLevel) this.level();
            ItemStack errorStar = new ItemStack(QiuymModItem.ERROR_STAR.get());
            this.spawnAtLocation(errorStar);
        }
    }
}