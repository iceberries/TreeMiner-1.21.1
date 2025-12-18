package com.iceberry.treeminer.datagen.loot;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Set;

import static com.iceberry.treeminer.create.TreeMinerBlocks.*;

/**
 * 创建方块的战利品表
 */
public class BlockLootTable extends BlockLootSubProvider implements LootTableSubProvider {
    public BlockLootTable(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        // 原木和木板类
        dropSelf(LODE_LOG.block());
        dropSelf(NETHER_LODE_LOG.block());
        dropSelf(LODE_PLANKS.block());
        dropSelf(NETHER_LODE_PLANKS.block());
        
        // 建筑方块类
        dropSelf(LODE_SLAB.block());
        dropSelf(LODE_STAIR.block());
        dropSelf(LODE_FENCE.block());
        dropSelf(LODE_FENCE_GATE.block());
        dropSelf(NETHER_LODE_SLAB.block());
        dropSelf(NETHER_LODE_STAIR.block());
        dropSelf(NETHER_LODE_FENCE.block());
        dropSelf(NETHER_LODE_FENCE_GATE.block());
        
        // 树苗类
        dropSelf(LODE_SAPLING_COAL.block());
        dropSelf(LODE_SAPLING_IRON.block());
        dropSelf(LODE_SAPLING_COPPER.block());
        dropSelf(LODE_SAPLING_LAPIS.block());
        dropSelf(LODE_SAPLING_EMERALD.block());
        dropSelf(LODE_SAPLING_GOLD.block());
        dropSelf(LODE_SAPLING_REDSTONE.block());
        dropSelf(LODE_SAPLING_DIAMOND.block());
        dropSelf(NETHER_LODE_SAPLING_QUARTZ.block());
        dropSelf(NETHER_LODE_SAPLING_GLOWSTONE.block());
        dropSelf(NETHER_LODE_SAPLING_NETHERITE.block());
        dropSelf(NETHER_LODE_SAPLING_GOLD.block());
        
        // 树叶类 - 需要特殊处理，有几率掉落树苗和果实
        addLeavesRandom(LODE_LEAVES_COAL.block(), LODE_SAPLING_COAL.block());
        addLeavesRandom(LODE_LEAVES_IRON.block(), LODE_SAPLING_IRON.block());
        addLeavesRandom(LODE_LEAVES_COPPER.block(), LODE_SAPLING_COPPER.block());
        addLeavesRandom(LODE_LEAVES_LAPIS.block(), LODE_SAPLING_LAPIS.block());
        addLeavesRandom(LODE_LEAVES_EMERALD.block(), LODE_SAPLING_EMERALD.block());
        addLeavesRandom(LODE_LEAVES_GOLD.block(), LODE_SAPLING_GOLD.block());
        addLeavesRandom(LODE_LEAVES_REDSTONE.block(), LODE_SAPLING_REDSTONE.block());
        addLeavesRandom(LODE_LEAVES_DIAMOND.block(), LODE_SAPLING_DIAMOND.block());
        addLeavesRandom(NETHER_LODE_LEAVES_GLOWSTONE.block(), NETHER_LODE_SAPLING_GLOWSTONE.block());
        addLeavesRandom(NETHER_LODE_LEAVES_QUARTZ.block(), NETHER_LODE_SAPLING_QUARTZ.block());
        addLeavesRandom(NETHER_LODE_LEAVES_GOLD.block(), NETHER_LODE_SAPLING_GOLD.block());
        addLeavesRandom(NETHER_LODE_LEAVES_NETHERITE.block(), NETHER_LODE_SAPLING_NETHERITE.block());
    }

    /**
     * 为矿石果实创建特殊的战利品表
     * @param block 方块
     * @param item 掉落的物品
     */
    public void createLodeFruit(Block block, Item item) {
        add(block, this.createSilkTouchDispatchTable(block,
                this.applyExplosionDecay(block, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F))))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return getKnownBlocks(BLOCKS);
    }

    /**
     * 获取已注册的方块
     * @param deferredBlocks 方块注册器
     * @return 方块的可迭代对象
     */
    protected Iterable<Block> getKnownBlocks(DeferredRegister.Blocks deferredBlocks) {
        return deferredBlocks.getEntries().stream().map(Holder::value)::iterator;
    }

    /**
     * 为树叶添加随机掉落树苗的逻辑
     * @param leaves 树叶方块
     * @param sapling 对应的树苗方块
     * @param chance 掉落几率
     */
    protected void addLeavesRandom(Block leaves, Block sapling, float chance) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(leaves, blocks -> createSelfDropDispatchTable(leaves, this.hasSilkTouch(),
                ((LootPoolSingletonContainer.Builder<?>)this.applyExplosionCondition(leaves, LootItem.lootTableItem(sapling)))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), chance))));
    }

    /**
     * 为树叶添加随机掉落树苗的逻辑（使用默认几率）
     * @param leaves 树叶方块
     * @param sapling 对应的树苗方块
     */
    protected void addLeavesRandom(Block leaves, Block sapling){
        addLeavesRandom(leaves, sapling, 0.1F);
    }
}