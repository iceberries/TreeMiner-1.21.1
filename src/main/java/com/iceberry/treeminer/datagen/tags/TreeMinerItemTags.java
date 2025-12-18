package com.iceberry.treeminer.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.create.TreeMinerItems.*;
import static com.iceberry.treeminer.create.TreeMinerBlocks.*;

/**
 * @author 尽
 * @transplant by iceberry
 * @apiNote 物品标签数据生成器
 */
public class TreeMinerItemTags extends ItemTagsProvider {
    
    public TreeMinerItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        // 烹饪过的下界果实标签
        tag(ItemTags.COOKED_NETHER_POD)
                .add(COOKED_POD_COAL.get())
                .add(COOKED_POD_COPPER.get())
                .add(COOKED_POD_DIAMOND.get())
                .add(COOKED_POD_EMERALD.get())
                .add(COOKED_POD_GOLD.get())
                .add(COOKED_POD_IRON.get())
                .add(COOKED_POD_LAPIS.get())
                .add(COOKED_POD_REDSTONE.get())
                .add(COOKED_NETHER_POD_NETHERITE.get())
                .add(COOKED_NETHER_POD_GLOWSTONE.get())
                .add(COOKED_NETHER_POD_GOLD.get())
                .add(COOKED_NETHER_POD_QUARTZ.get());
        
        // 主世界果实标签
        tag(ItemTags.NETHER_POD)
                .add(POD_COAL.get())
                .add(POD_COPPER.get())
                .add(POD_DIAMOND.get())
                .add(POD_EMERALD.get())
                .add(POD_GOLD.get())
                .add(POD_IRON.get())
                .add(POD_LAPIS.get())
                .add(POD_REDSTONE.get());
        
        // 下界果实标签
        tag(ItemTags.NETHER_NETHER_POD)
                .add(NETHER_POD_NETHERITE.get())
                .add(NETHER_POD_GLOWSTONE.get())
                .add(NETHER_POD_GOLD.get())
                .add(NETHER_POD_QUARTZ.get());

        // 从方块标签复制到物品标签
        copy(TreeMinerBlockTags.BlockTags.LODE_PLANKS, ItemTags.LODE_PLANKS);
        
        // 创建nether lode标签
        tag(ItemTags.NETHER_LODE_PLANKS_TAG)
                .add(NETHER_LODE_PLANKS.item());
        
        // 添加到各种planks子标签以支持其他配方，但不包括主planks标签（避免制作原版碗）
        // 需要先导入TreeMinerBlocks来访问block对象
        tag(net.minecraft.tags.ItemTags.WOODEN_DOORS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_STAIRS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_SLABS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_FENCES)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_TRAPDOORS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_PRESSURE_PLATES)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.WOODEN_BUTTONS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.SIGNS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        tag(net.minecraft.tags.ItemTags.HANGING_SIGNS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        
        // 添加到船配方标签
        tag(net.minecraft.tags.ItemTags.BOATS)
                .add(LODE_PLANKS.item())
                .add(NETHER_LODE_PLANKS.item());
        
        // 不添加到原版planks标签，避免制作原版碗
        // 但需要添加到其他相关的planks子标签以支持其他配方
    }

    /**
     * 创建物品标签键
     * @param name 标签名称
     * @param modId 模组ID
     * @return 物品标签键
     */
    public static TagKey<Item> tag(String name, String modId) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(modId, name));
    }

    /**
     * 物品标签定义
     */
    public static class ItemTags {
        // 烹饪过的下界果实
        public static final TagKey<Item> COOKED_NETHER_POD = tag("cooked_nether_pod", MOD_ID);
        
        // 主世界果实
        public static final TagKey<Item> NETHER_POD = tag("nether_pod", MOD_ID);
        
        // 下界果实
        public static final TagKey<Item> NETHER_NETHER_POD = tag("nether_nether_pod", MOD_ID);
        
        // 矿木木板
        public static final TagKey<Item> LODE_PLANKS = tag("lode_planks", MOD_ID);
        
        // 下界矿木木板
        public static final TagKey<Item> NETHER_LODE_PLANKS_TAG = tag("nether_lode_planks", MOD_ID);
    }
}