package com.iceberry.treeminer.datagen.language;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

import static com.iceberry.treeminer.create.TreeMinerTab.TREE_MINER_TAB;
import static com.iceberry.treeminer.create.TreeMinerItems.*;
import static com.iceberry.treeminer.create.TreeMinerBlocks.*;


public class Chinese extends LanguageProvider{
    public Chinese(PackOutput output, String modId) {
        this(output, modId, "zh_CN");
    }
    public Chinese(PackOutput output, String modId, String locale) {
        super(output, modId, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.treeminer.treeminer_tab", "矿树节");
        add(LODE_LOG.block(), "矿脉树原木");
        add(NETHER_LODE_LOG.block(), "下界矿脉树原木");
        add(LODE_PLANKS.block(), "矿脉树木板");
        add(LODE_SLAB.block(), "矿脉树木台阶");
        add(LODE_STAIR.block(), "矿脉树木楼梯");
        add(LODE_FENCE.block(), "矿脉树木栅栏");
        add(LODE_FENCE_GATE.block(), "矿脉树木栅栏门");
        add(NETHER_LODE_PLANKS.block(), "下界矿脉树木板");
        add(NETHER_LODE_SLAB.block(), "下界矿脉树木台阶");
        add(NETHER_LODE_STAIR.block(), "下界矿脉树木楼梯");
        add(NETHER_LODE_FENCE.block(), "下界矿脉树木栅栏");
        add(NETHER_LODE_FENCE_GATE.block(), "下界矿脉树木栅栏门");

        add(LODE_LEAVES_COAL.block(), "煤矿脉树树叶");
        add(LODE_LEAVES_IRON.block(), "铁矿脉树树叶");
        add(LODE_LEAVES_COPPER.block(), "铜矿脉树树叶");
        add(LODE_LEAVES_LAPIS.block(), "青金石矿脉树树叶");
        add(LODE_LEAVES_EMERALD.block(), "绿宝石矿脉树树叶");
        add(LODE_LEAVES_GOLD.block(), "金矿脉树树叶");
        add(LODE_LEAVES_REDSTONE.block(), "红石矿脉树树叶");
        add(LODE_LEAVES_DIAMOND.block(), "钻石矿脉树树叶");
        add(NETHER_LODE_LEAVES_QUARTZ.block(), "石英矿脉树树叶");
        add(NETHER_LODE_LEAVES_GLOWSTONE.block(), "萤石矿脉树树叶");
        add(NETHER_LODE_LEAVES_NETHERITE.block(), "远古残骸矿脉树树叶");
        add(NETHER_LODE_LEAVES_GOLD.block(), "下界金矿脉树树叶");

        add(LODE_SAPLING_COAL.block(), "煤矿脉树树苗");
        add(LODE_SAPLING_IRON.block(), "铁矿脉树树苗");
        add(LODE_SAPLING_COPPER.block(), "铜矿脉树树苗");
        add(LODE_SAPLING_LAPIS.block(), "青金石矿脉树树苗");
        add(LODE_SAPLING_EMERALD.block(), "绿宝石矿脉树树苗");
        add(LODE_SAPLING_GOLD.block(), "金矿脉树树苗");
        add(LODE_SAPLING_REDSTONE.block(), "红石矿脉树树苗");
        add(LODE_SAPLING_DIAMOND.block(), "钻石矿脉树树苗");
        add(NETHER_LODE_SAPLING_QUARTZ.block(), "石英矿脉树树苗");
        add(NETHER_LODE_SAPLING_GLOWSTONE.block(), "萤石矿脉树树苗");
        add(NETHER_LODE_SAPLING_NETHERITE.block(), "远古残骸矿脉树树苗");
        add(NETHER_LODE_SAPLING_GOLD.block(), "下界金矿脉树树苗");

        add(POD_COAL.get(), "煤矿果");
        add(POD_IRON.get(), "铁矿果");
        add(POD_COPPER.get(), "铜矿果");
        add(POD_LAPIS.get(), "青金石矿果");
        add(POD_EMERALD.get(), "绿宝石矿果");
        add(POD_GOLD.get(), "金矿果");
        add(POD_REDSTONE.get(), "红石矿果");
        add(POD_DIAMOND.get(), "钻石矿果");
        add(NETHER_POD_NETHERITE.get(), "远古残骸矿果");
        add(NETHER_POD_GLOWSTONE.get(), "萤石矿果");
        add(NETHER_POD_GOLD.get(), "下界金矿果");
        add(NETHER_POD_QUARTZ.get(), "石英矿果");

        add(COOKED_POD_COAL.get(), "熟煤矿果");
        add(COOKED_POD_IRON.get(), "熟铁矿果");
        add(COOKED_POD_COPPER.get(), "熟铜矿果");
        add(COOKED_POD_LAPIS.get(), "熟青金石矿果");
        add(COOKED_POD_EMERALD.get(), "熟绿宝石矿果");
        add(COOKED_POD_GOLD.get(), "熟金矿果");
        add(COOKED_POD_REDSTONE.get(), "熟红石矿果");
        add(COOKED_POD_DIAMOND.get(), "熟钻石矿果");
        add(COOKED_NETHER_POD_NETHERITE.get(), "熟远古残骸矿果");
        add(COOKED_NETHER_POD_GLOWSTONE.get(), "熟萤石矿果");
        add(COOKED_NETHER_POD_GOLD.get(), "熟下界金矿果");
        add(COOKED_NETHER_POD_QUARTZ.get(), "熟石英矿果");

        add(LODE_BOWL.get(), "矿木碗");
        add(ORE_STEW.get(), "矿果杂炖");
    }

    public <R, T extends R> void add(DeferredHolder<R, T> itemGroup, String name) {
        String itemGroupName = "itemGroup." + itemGroup.getId().toString().replace(":", ".");
        add(itemGroupName, name);
    }
}
