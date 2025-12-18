package com.iceberry.treeminer.common;

import com.iceberry.treeminer.datagen.worldgen.TreeMinerConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;

/**
 * 矿树节的树木集
 */
public class TreeMinerTreeGrower {
    public static String name(String name){
        return MOD_ID + ":" + name;
    }
    
    public static final TreeGrower LODE_COAL = new TreeGrower(
            name("lode_coal"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_COAL_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_IRON = new TreeGrower(
            name("lode_iron"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_IRON_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_COPPER = new TreeGrower(
            name("lode_copper"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_COPPER_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_LAPIS = new TreeGrower(
            name("lode_lapis"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_LAPIS_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_EMERALD = new TreeGrower(
            name("lode_emerald"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_EMERALD_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_GOLD = new TreeGrower(
            name("lode_gold"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_GOLD_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_REDSTONE = new TreeGrower(
            name("lode_redstone"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_REDSTONE_TREE),
            Optional.empty()
    );
    public static final TreeGrower LODE_DIAMOND = new TreeGrower(
            name("lode_diamond"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.LODE_DIAMOND_TREE),
            Optional.empty()
    );
    public static final TreeGrower NETHER_LODE_QUARTZ = new TreeGrower(
            name("nether_lode_quartz"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.NETHER_LODE_QUARTZ_TREE),
            Optional.empty()
    );
    public static final TreeGrower NETHER_LODE_GLOWSTONE = new TreeGrower(
            name("nether_lode_glowstone"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.NETHER_LODE_GLOWSTONE_TREE),
            Optional.empty()
    );
    public static final TreeGrower NETHER_LODE_NETHERITE = new TreeGrower(
            name("nether_lode_netherite"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.NETHER_LODE_NETHERITE_TREE),
            Optional.empty()
    );
    public static final TreeGrower NETHER_LODE_GOLD = new TreeGrower(
            name("nether_lode_gold"),
            Optional.empty(),
            Optional.of(TreeMinerConfiguredFeatures.NETHER_LODE_GOLD_TREE),
            Optional.empty()
    );
}