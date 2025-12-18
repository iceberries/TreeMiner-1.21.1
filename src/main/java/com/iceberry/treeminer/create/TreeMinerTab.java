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
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TREE_MINER_TAB = CREATIVE_MODE_TABS.register(
        "treeminer_tab",
        () -> CreativeModeTab.builder()
            .title(net.minecraft.network.chat.Component.translatable("itemGroup.treeminer.treeminer_tab"))
            .icon(() -> POD_GOLD.get().getDefaultInstance())
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .displayItems((parameters, output) -> {
                output.accept(POD_COAL.get());
                output.accept(POD_IRON.get());
                output.accept(POD_COPPER.get());
                output.accept(POD_LAPIS.get());
                output.accept(POD_REDSTONE.get());
                output.accept(POD_GOLD.get());
                output.accept(POD_EMERALD.get());
                output.accept(POD_DIAMOND.get());
                output.accept(NETHER_POD_GLOWSTONE.get());
                output.accept(NETHER_POD_QUARTZ.get());
                output.accept(NETHER_POD_GOLD.get());
                output.accept(NETHER_POD_NETHERITE.get());

                output.accept(COOKED_POD_COAL.get());
                output.accept(COOKED_POD_IRON.get());
                output.accept(COOKED_POD_COPPER.get());
                output.accept(COOKED_POD_LAPIS.get());
                output.accept(COOKED_POD_REDSTONE.get());
                output.accept(COOKED_POD_GOLD.get());
                output.accept(COOKED_POD_EMERALD.get());
                output.accept(COOKED_POD_DIAMOND.get());
                output.accept(COOKED_NETHER_POD_GLOWSTONE.get());
                output.accept(COOKED_NETHER_POD_QUARTZ.get());
                output.accept(COOKED_NETHER_POD_GOLD.get());
                output.accept(COOKED_NETHER_POD_NETHERITE.get());

                output.accept(ORE_STEW.get());
                output.accept(LODE_BOWL.get());

                output.accept(LODE_LOG.item());
                output.accept(LODE_PLANKS.item());
                output.accept(LODE_SLAB.item());
                output.accept(LODE_STAIR.item());
                output.accept(LODE_FENCE.item());
                output.accept(LODE_FENCE_GATE.item());
                output.accept(NETHER_LODE_LOG.item());
                output.accept(NETHER_LODE_PLANKS.item());
                output.accept(NETHER_LODE_SLAB.item());
                output.accept(NETHER_LODE_STAIR.item());
                output.accept(NETHER_LODE_FENCE.item());
                output.accept(NETHER_LODE_FENCE_GATE.item());

                output.accept(LODE_LEAVES_COAL.item());
                output.accept(LODE_LEAVES_IRON.item());
                output.accept(LODE_LEAVES_COPPER.item());
                output.accept(LODE_LEAVES_LAPIS.item());
                output.accept(LODE_LEAVES_EMERALD.item());
                output.accept(LODE_LEAVES_GOLD.item());
                output.accept(LODE_LEAVES_REDSTONE.item());
                output.accept(LODE_LEAVES_DIAMOND.item());
                output.accept(NETHER_LODE_LEAVES_GLOWSTONE.item());
                output.accept(NETHER_LODE_LEAVES_QUARTZ.item());
                output.accept(NETHER_LODE_LEAVES_GOLD.item());
                output.accept(NETHER_LODE_LEAVES_NETHERITE.item());

                output.accept(LODE_SAPLING_COAL.item());
                output.accept(LODE_SAPLING_IRON.item());
                output.accept(LODE_SAPLING_COPPER.item());
                output.accept(LODE_SAPLING_LAPIS.item());
                output.accept(LODE_SAPLING_EMERALD.item());
                output.accept(LODE_SAPLING_GOLD.item());
                output.accept(LODE_SAPLING_REDSTONE.item());
                output.accept(LODE_SAPLING_DIAMOND.item());
                output.accept(NETHER_LODE_SAPLING_GLOWSTONE.item());
                output.accept(NETHER_LODE_SAPLING_QUARTZ.item());
                output.accept(NETHER_LODE_SAPLING_GOLD.item());
                output.accept(NETHER_LODE_SAPLING_NETHERITE.item());
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
