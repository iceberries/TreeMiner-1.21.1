package com.iceberry.treeminer.datagen.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.VerticalAnchor;

import java.util.List;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.datagen.worldgen.TreeMinerConfiguredFeatures.*;

public class TreeMinerPlacedFeatures {

    // 主世界矿木树放置特征
    public static final ResourceKey<PlacedFeature> LODE_COAL_TREE_PLACED = registerKey("lode_coal_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_IRON_TREE_PLACED = registerKey("lode_iron_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_COPPER_TREE_PLACED = registerKey("lode_copper_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_LAPIS_TREE_PLACED = registerKey("lode_lapis_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_EMERALD_TREE_PLACED = registerKey("lode_emerald_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_GOLD_TREE_PLACED = registerKey("lode_gold_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_REDSTONE_TREE_PLACED = registerKey("lode_redstone_tree_placed");
    public static final ResourceKey<PlacedFeature> LODE_DIAMOND_TREE_PLACED = registerKey("lode_diamond_tree_placed");
    
    // 下界矿木树放置特征
    public static final ResourceKey<PlacedFeature> NETHER_LODE_QUARTZ_TREE_PLACED = registerKey("nether_lode_quartz_tree_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LODE_GLOWSTONE_TREE_PLACED = registerKey("nether_lode_glowstone_tree_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LODE_NETHERITE_TREE_PLACED = registerKey("nether_lode_netherite_tree_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LODE_GOLD_TREE_PLACED = registerKey("nether_lode_gold_tree_placed");

    /* 配置功能 */
    public static void bootstrapConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        TreeMinerConfiguredFeatures.bootstrap(context);
    }

    /* 放置功能 */
    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        // 注册主世界矿木树放置特征 - 使用地下装饰阶段和高度限制
        registerPlaced(context, LODE_COAL_TREE_PLACED, LODE_COAL_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_IRON_TREE_PLACED, LODE_IRON_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_COPPER_TREE_PLACED, LODE_COPPER_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_LAPIS_TREE_PLACED, LODE_LAPIS_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_EMERALD_TREE_PLACED, LODE_EMERALD_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_GOLD_TREE_PLACED, LODE_GOLD_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_REDSTONE_TREE_PLACED, LODE_REDSTONE_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(50)))
        );
        
        registerPlaced(context, LODE_DIAMOND_TREE_PLACED, LODE_DIAMOND_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(50)))
        );
        
        // 注册下界矿木树放置特征 - 使用下界高度限制
        registerPlaced(context, NETHER_LODE_QUARTZ_TREE_PLACED, NETHER_LODE_QUARTZ_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.absolute(40)))
        );
        
        registerPlaced(context, NETHER_LODE_GLOWSTONE_TREE_PLACED, NETHER_LODE_GLOWSTONE_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.absolute(40)))
        );
        
        registerPlaced(context, NETHER_LODE_NETHERITE_TREE_PLACED, NETHER_LODE_NETHERITE_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.absolute(40)))
        );
        
        registerPlaced(context, NETHER_LODE_GOLD_TREE_PLACED, NETHER_LODE_GOLD_TREE,
                InSquarePlacement.spread(),
                HeightRangePlacement.of(UniformHeight.of(VerticalAnchor.absolute(5), VerticalAnchor.absolute(40)))
        );
    }
    
    protected static ResourceKey<ConfiguredFeature<?, ?>> registerConfiguredKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }
    
    protected static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }

    protected static <FC extends FeatureConfiguration, F extends Feature<FC>> void registerConfigured(BootstrapContext<ConfiguredFeature<?, ?>> context,
        ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    
    protected static void registerPlaced(BootstrapContext<PlacedFeature> context,
                                       ResourceKey<PlacedFeature> key, 
                                       ResourceKey<ConfiguredFeature<?, ?>> configuredFeature,
                                       PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(configuredFeature), List.of(modifiers)));
    }
}