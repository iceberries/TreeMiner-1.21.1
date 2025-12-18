package com.iceberry.treeminer.datagen;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;
import org.jetbrains.annotations.NotNull;

import static com.iceberry.treeminer.create.TreeMinerBlocks.*;

/**
 * 数据生成器-模型（blockstates手写了）
 */
public class TreeMinerModelProvider extends ModelProvider {
    
    public TreeMinerModelProvider(PackOutput output) {
        super(output);
    }

    /**
     * 注册所有方块模型和状态
     */
    protected void registerModels(@NotNull BlockModelGenerators blockGenerators) {
        
        // 原木类方块
        blockGenerators.createTrivialCube(LODE_LOG.block());
        blockGenerators.createTrivialCube(NETHER_LODE_LOG.block());
        
        // 木板
        blockGenerators.createTrivialCube(LODE_PLANKS.block());
        blockGenerators.createTrivialCube(NETHER_LODE_PLANKS.block());
        
        // 楼梯
        blockGenerators.createTrivialCube(LODE_STAIR.block());
        blockGenerators.createTrivialCube(NETHER_LODE_STAIR.block());
        
        // 台阶
        blockGenerators.createTrivialCube(LODE_SLAB.block());
        blockGenerators.createTrivialCube(NETHER_LODE_SLAB.block());
        
        // 栅栏
        blockGenerators.createTrivialCube(LODE_FENCE.block());
        blockGenerators.createTrivialCube(NETHER_LODE_FENCE.block());
        
        // 栅栏门
        blockGenerators.createTrivialCube(LODE_FENCE_GATE.block());
        blockGenerators.createTrivialCube(NETHER_LODE_FENCE_GATE.block());
        
        // 树叶
        blockGenerators.createTrivialCube(LODE_LEAVES_COAL.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_IRON.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_COPPER.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_LAPIS.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_EMERALD.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_GOLD.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_REDSTONE.block());
        blockGenerators.createTrivialCube(LODE_LEAVES_DIAMOND.block());
        
        blockGenerators.createTrivialCube(NETHER_LODE_LEAVES_QUARTZ.block());
        blockGenerators.createTrivialCube(NETHER_LODE_LEAVES_GLOWSTONE.block());
        blockGenerators.createTrivialCube(NETHER_LODE_LEAVES_GOLD.block());
        blockGenerators.createTrivialCube(NETHER_LODE_LEAVES_NETHERITE.block());
        
        // 树苗
        blockGenerators.createTrivialCube(LODE_SAPLING_COAL.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_IRON.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_COPPER.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_LAPIS.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_EMERALD.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_GOLD.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_REDSTONE.block());
        blockGenerators.createTrivialCube(LODE_SAPLING_DIAMOND.block());
        
        blockGenerators.createTrivialCube(NETHER_LODE_SAPLING_QUARTZ.block());
        blockGenerators.createTrivialCube(NETHER_LODE_SAPLING_GLOWSTONE.block());
        blockGenerators.createTrivialCube(NETHER_LODE_SAPLING_NETHERITE.block());
        blockGenerators.createTrivialCube(NETHER_LODE_SAPLING_GOLD.block());
    }
    
    /**
     * 获取方块的资源位置
     */
    private @NotNull ResourceLocation getBlockResourceLocation(@NotNull Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }
    
    /**
     * 获取方块名称
     */
    private @NotNull String getBlockName(@NotNull Block block) {
        return getBlockResourceLocation(block).getPath();
    }
}