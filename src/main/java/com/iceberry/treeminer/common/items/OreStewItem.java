package com.iceberry.treeminer.common.items;

import com.google.common.collect.Maps;
import com.iceberry.treeminer.create.TreeMinerItems;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.Tag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 矿果杂炖
 */
public class OreStewItem extends Item {
    public static final HashMap<Holder<Item>, ItemFinishUsing> EFFECT_TABLE = Maps.newHashMap();

    public OreStewItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        if (level.isClientSide) {
            return getItemStack(stack, level, livingEntity);
        }

        returnBowlTo(livingEntity, level);

        var dat = stack.getComponents().get(DataComponents.CUSTOM_DATA);
        if (Objects.isNull(dat)) {
            return getItemStack(stack, level, livingEntity);
        }

        var tag = dat.copyTag();
        if (!tag.contains("ore_name")) {
            return getItemStack(stack, level, livingEntity);
        }

        var list = tag.getList("ore_name", Tag.TAG_STRING);
        if (list.isEmpty()) {
            return getItemStack(stack, level, livingEntity);
        }

        // 检查是否有荧石粉增强
        boolean hasGlowstone = tag.getBoolean("has_glowstone");

        list.forEach(it -> {
            var name = ResourceLocation.tryParse(it.getAsString());
            if (name == null) {
                return;
            }
            var item = BuiltInRegistries.ITEM.get(name);
            if (item == null) {return;}
            var holder = BuiltInRegistries.ITEM.getHolder(BuiltInRegistries.ITEM.getId(item));
            if (holder.isEmpty()) {
                return;
            }
            var backFunc = findOut(holder.get());
            if (Objects.isNull(backFunc)) {
                return;
            }
            backFunc.onFinishUsing(stack, level, livingEntity);
        });

        return getItemStack(stack, level, livingEntity);
    }

    private @NotNull ItemStack getItemStack(ItemStack stack, Level level, LivingEntity livingEntity) {
        return super.finishUsingItem(stack, level, livingEntity);
    }

    private void returnBowlTo(Entity entity, Level world) {
        ItemStack stackBowl = TreeMinerItems.LODE_BOWL.toStack();
        if (entity instanceof Player player) {
            if (player.isCreative()) {
                return;
            }
            if (!player.addItem(stackBowl)) {
                world.addFreshEntity(new ItemEntity(world, player.getX(), player.getY(), player.getZ(), stackBowl));
            }
        }
    }

    public ItemStack getCraftingRemainder(ItemStack itemStack) {
        return TreeMinerItems.LODE_BOWL.toStack();
    }

    @Nullable
    public static ItemFinishUsing findOut(Holder<Item> item) {
        return EFFECT_TABLE
                .entrySet()
                .stream()
                .filter(it -> item.is(it.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    @Nullable
    public static ItemFinishUsing findOut(ItemStack item) {
        return EFFECT_TABLE
                .entrySet()
                .stream()
                .filter(it -> item.is(it.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null);
    }

    public static Boolean findAny(ItemStack item) {
        return Objects.nonNull(EFFECT_TABLE
                .entrySet()
                .stream()
                .filter(it -> item.is(it.getKey()))
                .findFirst()
                .map(Map.Entry::getValue)
                .orElse(null));
    }

    @FunctionalInterface
    public interface ItemFinishUsing {
        void onFinishUsing(ItemStack item, Level world, LivingEntity entity);
    }
}