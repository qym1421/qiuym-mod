package com.qiuym.qiuymmod.entity;

import com.qiuym.qiuymmod.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ErrorWitherSkull extends WitherSkull {
    public ErrorWitherSkull(EntityType<? extends WitherSkull> type, Level level) {
        super(type, level);
    }
    
    private int customAttackDamage = 19;  // 基础攻击伤害
    private float customSpeed = 0.6F;    // 移动速度
    
    public ErrorWitherSkull(Level level, LivingEntity shooter, double dx, double dy, double dz) {
        this(QiuymModEntity.ERROR_WITHER_SKULL.get(), level);
        this.setOwner(shooter);
        this.setPos(shooter.getX(), shooter.getEyeY(), shooter.getZ());
        this.setDeltaMovement(dx, dy, dz);
    }
    
    public ErrorWitherSkull(Level level, double x, double y, double z, double dx, double dy, double dz) {
        this(QiuymModEntity.ERROR_WITHER_SKULL.get(), level);
        this.setPos(x, y, z);
        this.setDeltaMovement(dx, dy, dz);
    }
}