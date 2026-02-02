package com.qiuym.qiuymmod.entity;

import com.qiuym.qiuymmod.*;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;

public class ErrorWither extends WitherBoss {
    public ErrorWither(EntityType<? extends WitherBoss> type, Level level) {
        super(type, level);
    }
    
    protected void dropCustomDeathLoot(ServerLevel level, DamageSource source, boolean recentlyHit) {
        this.spawnAtLocation(QiuymModItem.ERROR_STAR.get());
    }
    
    public ItemEntity spawnAtLocation(ItemStack stack) {
        if (stack.is(Items.NETHER_STAR)) {
            return super.spawnAtLocation(new ItemStack(QiuymModItem.ERROR_STAR.get()));
        } else {
            return super.spawnAtLocation(stack);
        }
    }
}