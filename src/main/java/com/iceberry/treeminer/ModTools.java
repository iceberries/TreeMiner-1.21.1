package com.iceberry.treeminer;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import java.util.Optional;

public class ModTools {
    /**
     * 根据给定的实体、资源键和注册表引用，获取对应的注册表条目，并将其包装为Holder对象。
     *
     * @param <T> 注册表条目的类型
     * @param entity 实体对象，用于获取当前世界的注册表访问器
     * @param key 资源键，用于查找注册表中的特定条目
     * @param ref 注册表引用，用于查找对应的注册表
     * @return 包含注册表条目的Holder对象
     */
    public static <T> Holder<T> getHolder(Entity entity, ResourceKey<T> key, ResourceKey<Registry<T>> ref) {
        // 获取实体所在世界的注册表访问器，并查找指定的注册表
        HolderLookup.RegistryLookup<T> registryLookup = entity.level().registryAccess().lookupOrThrow(ref);
        // 从注册表中获取与资源键对应的Holder对象
        Optional<Holder.Reference<T>> holder = registryLookup.get(key);
        return holder.orElseThrow(() -> new IllegalArgumentException("Holder not found for key: " + key));
    }

    /**
     * 根据给定的实体和附魔资源键，获取对应的附魔Holder对象。
     *
     * @param entity 实体对象，用于获取当前世界的注册表访问器
     * @param key 附魔资源键，用于查找附魔注册表中的特定条目
     * @return 包含附魔条目的Holder对象
     */
    public static Holder<Enchantment> getEnchantment(Entity entity, ResourceKey<Enchantment> key) {
        return getHolder(entity, key, Registries.ENCHANTMENT);
    }

    /**
     * 检查玩家主手物品是否具有指定的附魔效果。
     *
     * @param player 玩家对象，用于获取主手物品
     * @param key 附魔资源键，用于查找附魔注册表中的特定条目
     * @return 如果主手物品具有指定附魔，则返回该等级，否则返回0
     */
    public static int isMainHandItemEnchantmentLevel(Player player, ResourceKey<Enchantment> key) {
        // 获取主手物品的附魔效果，并检查是否包含指定的附魔
        Holder<Enchantment> enchantmentHolder = getEnchantment(player, key);
        return player.getMainHandItem().getEnchantments().getLevel(enchantmentHolder);
    }
}