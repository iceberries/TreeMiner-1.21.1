package com.iceberry.treeminer.datagen.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.CherryFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.CherryTrunkPlacer;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.create.TreeMinerBlocks.*;

/**
 * 树木生长配置特征（非自然）
 */
public class TreeMinerConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_COAL_TREE = registerKey("lode_coal_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_IRON_TREE = registerKey("lode_iron_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_COPPER_TREE = registerKey("lode_copper_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_LAPIS_TREE = registerKey("lode_lapis_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_EMERALD_TREE = registerKey("lode_emerald_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_GOLD_TREE = registerKey("lode_gold_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_REDSTONE_TREE = registerKey("lode_redstone_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_DIAMOND_TREE = registerKey("lode_diamond_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LODE_QUARTZ_TREE = registerKey("nether_lode_quartz_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LODE_GLOWSTONE_TREE = registerKey("nether_lode_glowstone_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LODE_NETHERITE_TREE = registerKey("nether_lode_netherite_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LODE_GOLD_TREE = registerKey("nether_lode_gold_tree");
    
    // 矿木自动生成特征
    public static final ResourceKey<ConfiguredFeature<?, ?>> LODE_TREE_GENERATION = registerKey("lode_tree_generation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LODE_TREE_GENERATION = registerKey("nether_lode_tree_generation");

    /**
     * 引导配置特征
     * @param context 引导上下文
     */
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // 基础引导方法
        bootstrapBasics(context);
        
        // 注册主世界矿木树
        registerBasics(context, LODE_COAL_TREE, LODE_LEAVES_COAL.block());
        registerBasics(context, LODE_IRON_TREE, LODE_LEAVES_IRON.block());
        registerBasics(context, LODE_COPPER_TREE, LODE_LEAVES_COPPER.block());
        registerBasics(context, LODE_LAPIS_TREE, LODE_LEAVES_LAPIS.block());
        registerBasics(context, LODE_EMERALD_TREE, LODE_LEAVES_EMERALD.block());
        registerBasics(context, LODE_GOLD_TREE, LODE_LEAVES_GOLD.block());
        registerBasics(context, LODE_REDSTONE_TREE, LODE_LEAVES_REDSTONE.block());
        registerBasics(context, LODE_DIAMOND_TREE, LODE_LEAVES_DIAMOND.block());
        
        // 注册下界矿木树
        netherRegisterBasics(context, NETHER_LODE_QUARTZ_TREE, NETHER_LODE_LEAVES_QUARTZ.block());
        netherRegisterBasics(context, NETHER_LODE_GLOWSTONE_TREE, NETHER_LODE_LEAVES_GLOWSTONE.block());
        netherRegisterBasics(context, NETHER_LODE_NETHERITE_TREE, NETHER_LODE_LEAVES_NETHERITE.block());
        netherRegisterBasics(context, NETHER_LODE_GOLD_TREE, NETHER_LODE_LEAVES_GOLD.block());
        
        // 注册矿木自动生成特征 - 暂时禁用
        // register(context, LODE_TREE_GENERATION, LODE_TREE_FEATURE.get(), NoneFeatureConfiguration.INSTANCE);
        // register(context, NETHER_LODE_TREE_GENERATION, LODE_TREE_FEATURE.get(), NoneFeatureConfiguration.INSTANCE);
    }
    
    /**
     * 基础引导方法
     * @param context 引导上下文
     */
    public static void bootstrapBasics(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        // 可以在这里添加基础配置特征的注册
        // 目前为空，保留扩展性
    }

    /**
     * 注册主世界矿木树（简化版本）
     * @param context 引导上下文
     * @param tree 树特征资源键
     * @param leaves 树叶方块
     */
    public static void registerBasics(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                      ResourceKey<ConfiguredFeature<?, ?>> tree,
                                      Block leaves){
        registerBasics(context, tree, LODE_LOG.block(), leaves, Blocks.STONE);
    }

    /**
     * 注册下界矿木树（简化版本）
     * @param context 引导上下文
     * @param tree 树特征资源键
     * @param leaves 树叶方块
     */
    public static void netherRegisterBasics(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                      ResourceKey<ConfiguredFeature<?, ?>> tree,
                                      Block leaves){
        registerBasics(context, tree, NETHER_LODE_LOG.block(), leaves, Blocks.NETHERRACK);
    }

    /**
     * 注册树（樱花树模板）
     * @param context 引导上下文
     * @param tree 树特征资源键
     * @param log 原木方块
     * @param leaves 树叶方块
     * @param dirt 下方替换的泥土方块
     */
    public static void registerBasics(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                      ResourceKey<ConfiguredFeature<?, ?>> tree,
                                      Block log, Block leaves, Block dirt) {
        if (leaves instanceof LeavesBlock leavesBlock){
            register(context, tree, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(log),
                    new CherryTrunkPlacer(7, 1, 0,
                            new WeightedListInt(SimpleWeightedRandomList.<IntProvider>builder().add(ConstantInt.of(1), 1)
                                    .add(ConstantInt.of(2), 1)
                                    .add(ConstantInt.of(3), 1).build()),
                            UniformInt.of(2, 4), UniformInt.of(-4, -3), UniformInt.of(-1, 0)),
                    BlockStateProvider.simple(
                            leavesBlock.getStateDefinition().any()
                                    .setValue(LeavesBlock.PERSISTENT, false)
                                    .setValue(LeavesBlock.WATERLOGGED, false)
                    ),
                    new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                    new TwoLayersFeatureSize(1, 0, 2)
            ).dirt(BlockStateProvider.simple(dirt)).build());
        }
    }
    
    /**
     * 注册配置特征资源键
     * @param modId 模组ID
     * @param name 特征名称
     * @return 配置特征资源键
     */
    protected static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String modId, String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(modId, name));
    }

    /**
     * 注册配置特征资源键（使用模组默认ID）
     * @param name 特征名称
     * @return 配置特征资源键
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return registerKey(MOD_ID, name);
    }

    /**
     * 注册配置特征
     * @param <FC> 特征配置类型
     * @param <F> 特征类型
     * @param context 引导上下文
     * @param key 资源键
     * @param feature 特征实例
     * @param configuration 特征配置
     */
    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}