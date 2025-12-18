package com.iceberry.treeminer.common.blocks;

import com.iceberry.treeminer.datagen.tags.TreeMinerBlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

/** 下界矿脉树叶 */
public class CrystalLodeLeavesBlock extends LodeLeavesBlock {
    public CrystalLodeLeavesBlock(Properties properties) {
        super(properties);
    }

    public CrystalLodeLeavesBlock(Properties properties, Supplier<Item> fruit, Supplier<BlockItem> sapling) {
        super(properties, fruit, sapling);
    }

    @Override
    public TagKey<Block> getLodeLeaves() {
        return TreeMinerBlockTags.BlockTags.NETHER_LODE_LEAVES;
    }

    @Override
    public TagKey<Block> getLodeLog() {
        return TreeMinerBlockTags.BlockTags.NETHER_LODE_LOG;
    }
}