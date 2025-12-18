package com.iceberry.treeminer.datagen.tags;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import javax.annotation.Nonnull;

import java.util.concurrent.CompletableFuture;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.create.TreeMinerBlocks.*;

/**
 * 方块标签数据生成器
 */
public class TreeMinerBlockTags extends BlockTagsProvider {
    
    public TreeMinerBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MOD_ID, null);
    }

    @Override
    public void addTags(@Nonnull HolderLookup.Provider provider) {
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_AXE)
                .add(LODE_PLANKS.block())
                .add(NETHER_LODE_PLANKS.block())
                .add(LODE_SLAB.block())
                .add(NETHER_LODE_SLAB.block())
                .add(LODE_STAIR.block())
                .add(NETHER_LODE_STAIR.block())
                .add(LODE_FENCE.block())
                .add(NETHER_LODE_FENCE.block())
                .add(LODE_FENCE_GATE.block())
                .add(NETHER_LODE_FENCE_GATE.block());
        tag(net.minecraft.tags.BlockTags.SLABS)
                .add(LODE_SLAB.block())
                .add(NETHER_LODE_SLAB.block());
        tag(net.minecraft.tags.BlockTags.STAIRS)
                .add(LODE_STAIR.block())
                .add(NETHER_LODE_STAIR.block());
        tag(net.minecraft.tags.BlockTags.FENCES)
                .add(LODE_FENCE.block())
                .add(NETHER_LODE_FENCE.block());
        tag(net.minecraft.tags.BlockTags.FENCE_GATES)
                .add(LODE_FENCE_GATE.block())
                .add(NETHER_LODE_FENCE_GATE.block());
        tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_PICKAXE)
                .add(LODE_SLAB.block())
                .add(NETHER_LODE_SLAB.block())
                .add(LODE_STAIR.block())
                .add(NETHER_LODE_STAIR.block())
                .add(LODE_FENCE.block())
                .add(NETHER_LODE_FENCE.block())
                .add(LODE_FENCE_GATE.block())
                .add(NETHER_LODE_FENCE_GATE.block())
                .add(LODE_LEAVES_COAL.block())
                .add(LODE_LEAVES_IRON.block())
                .add(LODE_LEAVES_COPPER.block())
                .add(LODE_LEAVES_LAPIS.block())
                .add(LODE_LEAVES_EMERALD.block())
                .add(LODE_LEAVES_GOLD.block())
                .add(LODE_LEAVES_REDSTONE.block())
                .add(LODE_LOG.block())
                .add(LODE_PLANKS.block())
                .add(NETHER_LODE_LOG.block())
                .add(NETHER_LODE_PLANKS.block())
                .add(LODE_SAPLING_COAL.block())
                .add(LODE_SAPLING_IRON.block())
                .add(LODE_SAPLING_COPPER.block())
                .add(LODE_SAPLING_LAPIS.block())
                .add(LODE_SAPLING_EMERALD.block())
                .add(LODE_SAPLING_GOLD.block())
                .add(LODE_SAPLING_REDSTONE.block())
                .add(LODE_SAPLING_DIAMOND.block())
                .add(NETHER_LODE_LEAVES_QUARTZ.block())
                .add(NETHER_LODE_LEAVES_GLOWSTONE.block())
                .add(NETHER_LODE_LEAVES_NETHERITE.block())
                .add(NETHER_LODE_LEAVES_GOLD.block())
                .add(NETHER_LODE_LOG.block())
                .add(NETHER_LODE_SAPLING_QUARTZ.block())
                .add(NETHER_LODE_SAPLING_GLOWSTONE.block())
                .add(NETHER_LODE_SAPLING_NETHERITE.block())
                .add(NETHER_LODE_SAPLING_GOLD.block())
                .add(LODE_LEAVES_DIAMOND.block());
        tag(BlockTags.LODE_LEAVES)
                .add(LODE_LEAVES_COAL.block())
                .add(LODE_LEAVES_IRON.block())
                .add(LODE_LEAVES_COPPER.block())
                .add(LODE_LEAVES_LAPIS.block())
                .add(LODE_LEAVES_EMERALD.block())
                .add(LODE_LEAVES_GOLD.block())
                .add(LODE_LEAVES_REDSTONE.block())
                .add(LODE_LEAVES_DIAMOND.block());
        tag(BlockTags.LODE_LOG)
                .add(LODE_LOG.block());
        tag(BlockTags.LODE_SAPLING)
                .add(LODE_SAPLING_COAL.block())
                .add(LODE_SAPLING_IRON.block())
                .add(LODE_SAPLING_COPPER.block())
                .add(LODE_SAPLING_LAPIS.block())
                .add(LODE_SAPLING_EMERALD.block())
                .add(LODE_SAPLING_GOLD.block())
                .add(LODE_SAPLING_REDSTONE.block())
                .add(LODE_SAPLING_DIAMOND.block());
        tag(BlockTags.NETHER_LODE_LEAVES)
                .add(NETHER_LODE_LEAVES_QUARTZ.block())
                .add(NETHER_LODE_LEAVES_GLOWSTONE.block())
                .add(NETHER_LODE_LEAVES_NETHERITE.block())
                .add(NETHER_LODE_LEAVES_GOLD.block());
        tag(BlockTags.NETHER_LODE_LOG)
                .add(NETHER_LODE_LOG.block());
        tag(BlockTags.NETHER_LODE_SAPLING)
                .add(NETHER_LODE_SAPLING_QUARTZ.block())
                .add(NETHER_LODE_SAPLING_GLOWSTONE.block())
                .add(NETHER_LODE_SAPLING_NETHERITE.block())
                .add(NETHER_LODE_SAPLING_GOLD.block());
        tag(BlockTags.LODE_PLANKS)
                .add(LODE_PLANKS.block())
                .add(NETHER_LODE_PLANKS.block());
    }

    public static class BlockTags {
        public static final TagKey<Block> LODE_LEAVES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "lode_leaves"));
        public static final TagKey<Block> LODE_LOG = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "lode_log"));
        public static final TagKey<Block> LODE_PLANKS = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "lode_planks"));
        public static final TagKey<Block> LODE_SAPLING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "lode_sapling"));
        public static final TagKey<Block> NETHER_LODE_LEAVES = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "nether_lode_leaves"));
        public static final TagKey<Block> NETHER_LODE_LOG = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "nether_lode_log"));
        public static final TagKey<Block> NETHER_LODE_SAPLING = TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, "nether_lode_sapling"));
    }
}