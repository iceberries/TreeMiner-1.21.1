package com.iceberry.treeminer.common.items;

import net.minecraft.core.Holder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Collection;

public class CookedNetherPodGlowstoneItem extends Item {
    public CookedNetherPodGlowstoneItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        Collection<MobEffectInstance> effects = livingEntity.getActiveEffects();
        for (MobEffectInstance effectInstance : effects) {
            Holder<MobEffect> effect = effectInstance.getEffect();
            final int duration = effectInstance.getDuration() / 2;
            final int amplifier = Math.min(255, effectInstance.getAmplifier() + 1);
            final boolean ambient = effectInstance.isAmbient();
            final boolean visible = effectInstance.isVisible();
            final boolean showIcon = effectInstance.showIcon();
            MobEffectInstance set = new MobEffectInstance(effect, duration, amplifier, ambient, visible, showIcon);
            effectInstance.update(set);
        }
        return super.finishUsingItem(stack, level, livingEntity);
    }
}