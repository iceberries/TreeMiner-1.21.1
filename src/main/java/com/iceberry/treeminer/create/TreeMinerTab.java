package com.iceberry.treeminer.create;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.create.TreeMinerBlocks.*;
import static com.iceberry.treeminer.create.TreeMinerItems.*;

/**
 * @author 尽
 * @transplant by iceberry
 * @apiNote 创建一个创造模式物品栏
 */
public class TreeMinerTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    // 注册表容器，用于管理所有需要显示在创造模式物品栏中的物品
    private static final java.util.List<java.util.function.Supplier<net.minecraft.world.item.ItemStack>> TAB_ITEMS = java.util.List.of(
        () -> POD_COAL.get().getDefaultInstance(),
        () -> POD_IRON.get().getDefaultInstance(),
        () -> POD_COPPER.get().getDefaultInstance(),
        () -> POD_LAPIS.get().getDefaultInstance(),
        () -> POD_REDSTONE.get().getDefaultInstance(),
        () -> POD_GOLD.get().getDefaultInstance(),
        () -> POD_EMERALD.get().getDefaultInstance(),
        () -> POD_DIAMOND.get().getDefaultInstance(),
        () -> NETHER_POD_GLOWSTONE.get().getDefaultInstance(),
        () -> NETHER_POD_QUARTZ.get().getDefaultInstance(),
        () -> NETHER_POD_GOLD.get().getDefaultInstance(),
        () -> NETHER_POD_NETHERITE.get().getDefaultInstance(),

        () -> COOKED_POD_COAL.get().getDefaultInstance(),
        () -> COOKED_POD_IRON.get().getDefaultInstance(),
        () -> COOKED_POD_COPPER.get().getDefaultInstance(),
        () -> COOKED_POD_LAPIS.get().getDefaultInstance(),
        () -> COOKED_POD_REDSTONE.get().getDefaultInstance(),
        () -> COOKED_POD_GOLD.get().getDefaultInstance(),
        () -> COOKED_POD_EMERALD.get().getDefaultInstance(),
        () -> COOKED_POD_DIAMOND.get().getDefaultInstance(),
        () -> COOKED_NETHER_POD_GLOWSTONE.get().getDefaultInstance(),
        () -> COOKED_NETHER_POD_QUARTZ.get().getDefaultInstance(),
        () -> COOKED_NETHER_POD_GOLD.get().getDefaultInstance(),
        () -> COOKED_NETHER_POD_NETHERITE.get().getDefaultInstance(),

        () -> ORE_STEW.get().getDefaultInstance(),
        () -> LODE_BOWL.get().getDefaultInstance(),

        () -> LODE_LOG.item().getDefaultInstance(),
        () -> LODE_PLANKS.item().getDefaultInstance(),
        () -> LODE_SLAB.item().getDefaultInstance(),
        () -> LODE_STAIR.item().getDefaultInstance(),
        () -> LODE_FENCE.item().getDefaultInstance(),
        () -> LODE_FENCE_GATE.item().getDefaultInstance(),
        () -> NETHER_LODE_LOG.item().getDefaultInstance(),
        () -> NETHER_LODE_PLANKS.item().getDefaultInstance(),
        () -> NETHER_LODE_SLAB.item().getDefaultInstance(),
        () -> NETHER_LODE_STAIR.item().getDefaultInstance(),
        () -> NETHER_LODE_FENCE.item().getDefaultInstance(),
        () -> NETHER_LODE_FENCE_GATE.item().getDefaultInstance(),

        () -> LODE_LEAVES_COAL.item().getDefaultInstance(),
        () -> LODE_LEAVES_IRON.item().getDefaultInstance(),
        () -> LODE_LEAVES_COPPER.item().getDefaultInstance(),
        () -> LODE_LEAVES_LAPIS.item().getDefaultInstance(),
        () -> LODE_LEAVES_EMERALD.item().getDefaultInstance(),
        () -> LODE_LEAVES_GOLD.item().getDefaultInstance(),
        () -> LODE_LEAVES_REDSTONE.item().getDefaultInstance(),
        () -> LODE_LEAVES_DIAMOND.item().getDefaultInstance(),
        () -> NETHER_LODE_LEAVES_GLOWSTONE.item().getDefaultInstance(),
        () -> NETHER_LODE_LEAVES_QUARTZ.item().getDefaultInstance(),
        () -> NETHER_LODE_LEAVES_GOLD.item().getDefaultInstance(),
        () -> NETHER_LODE_LEAVES_NETHERITE.item().getDefaultInstance(),

        () -> LODE_SAPLING_COAL.item().getDefaultInstance(),
        () -> LODE_SAPLING_IRON.item().getDefaultInstance(),
        () -> LODE_SAPLING_COPPER.item().getDefaultInstance(),
        () -> LODE_SAPLING_LAPIS.item().getDefaultInstance(),
        () -> LODE_SAPLING_EMERALD.item().getDefaultInstance(),
        () -> LODE_SAPLING_GOLD.item().getDefaultInstance(),
        () -> LODE_SAPLING_REDSTONE.item().getDefaultInstance(),
        () -> LODE_SAPLING_DIAMOND.item().getDefaultInstance(),
        () -> NETHER_LODE_SAPLING_GLOWSTONE.item().getDefaultInstance(),
        () -> NETHER_LODE_SAPLING_QUARTZ.item().getDefaultInstance(),
        () -> NETHER_LODE_SAPLING_GOLD.item().getDefaultInstance(),
        () -> NETHER_LODE_SAPLING_NETHERITE.item().getDefaultInstance()
    );

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TREE_MINER_TAB = CREATIVE_MODE_TABS.register(
        "treeminer_tab",
        () -> CreativeModeTab.builder()
            .title(net.minecraft.network.chat.Component.translatable("itemGroup.treeminer.treeminer_tab"))
            .icon(() -> POD_GOLD.get().getDefaultInstance())
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .displayItems((parameters, output) -> {
                // 使用注册表容器统一处理所有物品显示
                TAB_ITEMS.forEach(itemSupplier -> output.accept(itemSupplier.get()));
            })
            .build()
    );

    /**
     * 添加到创造模式物品栏
     */
    public static void registerCapabilities(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
//            event.accept(EXAMPLE_BLOCK.blockItem);
    }

    /**
     * 创建一个创造模式物品栏
     *
     * @param name                  命名空间
     * @param withTabsBefore        父物品栏
     * @param icon                  图标
     * @param displayItemsGenerator 显示物品
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon,
            CreativeModeTab.DisplayItemsGenerator displayItemsGenerator) {
        return CREATIVE_MODE_TABS.register(name, () -> CreativeModeTab.builder()
            .title(net.minecraft.network.chat.Component.translatable("itemGroup." + name))
            .icon(icon)
            .withTabsBefore(withTabsBefore)
            .displayItems(displayItemsGenerator)
            .build());
    }

    /**
     * 创建一个创造模式物品栏
     *
     * @param name           命名空间
     * @param withTabsBefore 父物品栏
     * @param icon           图标
     * @return 延迟注册器
     */
    public static DeferredHolder<CreativeModeTab, CreativeModeTab> register(
            String name,
            ResourceKey<CreativeModeTab> withTabsBefore,
            Supplier<ItemStack> icon) {
        return register(name, withTabsBefore, icon, (parameters, output) -> {});
    }
}
