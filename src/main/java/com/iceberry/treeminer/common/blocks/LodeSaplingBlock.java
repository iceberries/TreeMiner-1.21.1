package com.iceberry.treeminer.common.blocks;

import com.google.common.collect.Sets;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Set;

/**
 * 一个自定义的树苗方块类，继承自 Minecraft 的 SaplingBlock。
 * 该类用于定义特定类型的树苗，支持自定义可放置和可生长的方块类型。
 */
public class LodeSaplingBlock extends SaplingBlock {
    private final SaplingProperties saplingProperties;

    /**
     * 构造函数，初始化 LodeSaplingBlock 实例。
     *
     * @param treeGrower      用于生成树的 TreeGrower 实例。
     * @param properties      方块的属性配置。
     * @param saplingProperties 树苗的自定义属性配置。
     */
    public LodeSaplingBlock(TreeGrower treeGrower, Properties properties, SaplingProperties saplingProperties) {
        super(treeGrower, properties);
        this.saplingProperties = saplingProperties;
    }

    public SaplingProperties getSaplingProperties() {
        return saplingProperties;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return isPlaceableBlock(state);
    }

    /**
     * 检查给定的方块状态是否是可放置的方块。
     *
     * @param state 方块状态。
     * @return 如果方块是可放置的，返回 true；否则返回 false。
     */
    private boolean isPlaceableBlock(BlockState state) {
        return this.isBlock(state, this.saplingProperties.getPlaceable(), this.saplingProperties.getPlaceableTags());
    }

    /**
     * 检查给定的方块状态是否是可生长的方块。
     *
     * @param state 方块状态。
     * @return 如果方块是可生长的，返回 true；否则返回 false。
     */
    private boolean isGrowableBlock(BlockState state) {
        return this.isPlaceableBlock(state);
    }

    /**
     * 检查给定的方块状态是否匹配指定的方块或标签。
     *
     * @param state 方块状态。
     * @param blocks 要匹配的方块数组。
     * @param tags 要匹配的标签数组。
     * @return 如果方块状态匹配任何一个方块或标签，返回 true；否则返回 false。
     */
    private boolean isBlock(@NotNull BlockState state, @NotNull Set<Block> blocks, @NotNull Set<TagKey<Block>> tags) {
        return blocks.stream().anyMatch(state::is) || tags.stream().anyMatch(state::is);
    }

    /**
     * 方块是否可以存在
     *
     * @param state 方块状态。
     * @param level LevelReader 对象，用于获取 surroundingBlockState。
     * @param pos 方块的位置。
     * @return 如果可以放置树苗，返回 true；否则返回 false。
     */
    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos){
        BlockPos blockpos = pos.below();
        BlockState belowBlockState = level.getBlockState(blockpos);
        if (!this.isPlaceableBlock(belowBlockState)) return false;
        return super.canSurvive(state, level, pos);
    }

    /**
     * 随机 tick，用于生成树。
     *
     * @param state 当前方块的状态。
     * @param level ServerLevel 对象，用于获取 surroundingBlockState。
     * @param pos 方块的位置。
     * @param randomSource RandomSource 对象，用于生成随机数。
     */
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        if (!this.isGrowableBlock(level.getBlockState(pos.below()))) return;
        this.advanceTree(level, pos, state, randomSource);
    }

    @Override
    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        if (random.nextInt(2) == 0) {
            super.advanceTree(level, pos, state, random);
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return false; // 是否允许骨粉催熟（测试用）
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false; // 骨粉是否成功（测试用）
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        // 执行骨粉催熟（测试用）advanceTree(level, pos, state, random);
    }

    /**
     * SaplingProperties 类用于定义树苗的可放置和可生长方块的属性。
     */
    public static class SaplingProperties {
        private final Set<Block> placeableBlocks = Sets.newHashSet();
        private final Set<TagKey<Block>> placeableBlocksTag = Sets.newHashSet();

        public static SaplingProperties instance(){
            return new SaplingProperties();
        }

        /**
         * 设置可放置的方块。
         *
         * @param placeableBlocks 可放置的方块数组。
         * @return 当前 SaplingProperties 实例。
         */
        public SaplingProperties placeable(Block... placeableBlocks) {
            this.placeableBlocks.addAll(List.of(placeableBlocks));
            return this;
        }

        @SafeVarargs
        public final SaplingProperties placeable(TagKey<Block>... placeableBlocksTag) {
            this.placeableBlocksTag.addAll(List.of(placeableBlocksTag));
            return this;
        }

        public Set<Block> getPlaceable() {
            return Set.copyOf(placeableBlocks);
        }

        public Set<TagKey<Block>> getPlaceableTags() {
            return Set.copyOf(placeableBlocksTag);
        }

        public static LodeSaplingBlock.SaplingProperties saplingProperties(){
            return new LodeSaplingBlock.SaplingProperties();
        }
    }
}