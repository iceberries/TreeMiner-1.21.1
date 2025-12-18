package com.iceberry.treeminer.create;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static net.minecraft.world.level.block.state.properties.WoodType.OAK;

/**
 * @author 尽
 * @transplant by iceberry
 * @apiNote 创建方块
 */
public class TreeMinerBlocks {
    public static final IntegerProperty STAGE_3 = IntegerProperty.create("stage", 0, 3);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MOD_ID);

    public static final TreeMinerBlockCreate LODE_LOG = new TreeMinerBlockCreate("lode_log", RotatedPillarBlock::new, logProperties(MapColor.STONE, MapColor.STONE, SoundType.STONE, 3.0F, NoteBlockInstrument.BASS));
    public static final TreeMinerBlockCreate LODE_PLANKS = new TreeMinerBlockCreate("lode_planks", Block::new, createProperties(MapColor.STONE, SoundType.STONE , 3.0F));
    public static final TreeMinerBlockCreate LODE_SLAB = new TreeMinerBlockCreate("lode_slab", SlabBlock::new, createSlab(MapColor.STONE, SoundType.STONE , 3.0F));
    public static final TreeMinerBlockCreate LODE_STAIR = new TreeMinerBlockCreate("lode_stair", (it) -> new StairBlock(LODE_PLANKS.block().defaultBlockState(), it), createStair(MapColor.STONE, SoundType.STONE , 3.0F));
    public static final TreeMinerBlockCreate LODE_FENCE = new TreeMinerBlockCreate("lode_fence", FenceBlock::new, createFence(MapColor.STONE, SoundType.STONE , 3.0F));
    public static final TreeMinerBlockCreate LODE_FENCE_GATE = new TreeMinerBlockCreate("lode_fence_gate", (it) -> new FenceGateBlock(OAK, it), createGate(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));

    public static final TreeMinerBlockCreate NETHER_LODE_LOG = new TreeMinerBlockCreate("nether_lode_log", RotatedPillarBlock::new, logProperties(MapColor.NETHER, MapColor.NETHER, SoundType.NETHERRACK, 3.0F, NoteBlockInstrument.BASS));
    public static final TreeMinerBlockCreate NETHER_LODE_PLANKS = new TreeMinerBlockCreate("nether_lode_planks", Block::new, createProperties(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_SLAB = new TreeMinerBlockCreate("nether_lode_slab", SlabBlock::new, createSlab(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_STAIR = new TreeMinerBlockCreate("nether_lode_stair", (it) -> new StairBlock(NETHER_LODE_PLANKS.block().defaultBlockState(), it), createStair(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_FENCE = new TreeMinerBlockCreate("nether_lode_fence", FenceBlock::new, createFence(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_FENCE_GATE = new TreeMinerBlockCreate("nether_lode_fence_gate", (it) -> new FenceGateBlock(OAK, it), createGate(MapColor.NETHER, SoundType.NETHERRACK , 2.0F));

    public static final TreeMinerBlockCreate LODE_SAPLING_COAL = new TreeMinerBlockCreate("lode_sapling_coal", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_COAL, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.COAL_ORES)), createSaplingProperties(MapColor.PLANT, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_IRON = new TreeMinerBlockCreate("lode_sapling_iron", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_IRON, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.IRON_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_COPPER = new TreeMinerBlockCreate("lode_sapling_copper", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_COPPER, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.COPPER_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_LAPIS = new TreeMinerBlockCreate("lode_sapling_lapis", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_LAPIS, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.LAPIS_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_EMERALD = new TreeMinerBlockCreate("lode_sapling_emerald", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_EMERALD, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.EMERALD_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_GOLD = new TreeMinerBlockCreate("lode_sapling_gold", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_GOLD, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(Blocks.GOLD_ORE, Blocks.DEEPSLATE_GOLD_ORE)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_REDSTONE = new TreeMinerBlockCreate("lode_sapling_redstone", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_REDSTONE, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.REDSTONE_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate LODE_SAPLING_DIAMOND = new TreeMinerBlockCreate("lode_sapling_diamond", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.LODE_DIAMOND, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(BlockTags.DIAMOND_ORES)), createSaplingProperties(MapColor.STONE, SoundType.STONE));
    public static final TreeMinerBlockCreate NETHER_LODE_SAPLING_GLOWSTONE = new TreeMinerBlockCreate("nether_lode_sapling_glowstone", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.NETHER_LODE_GLOWSTONE, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(Blocks.GLOWSTONE)), createSaplingProperties(MapColor.NETHER, SoundType.NETHERRACK).lightLevel(blockState -> 13));
    public static final TreeMinerBlockCreate NETHER_LODE_SAPLING_QUARTZ = new TreeMinerBlockCreate("nether_lode_sapling_quartz", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.NETHER_LODE_QUARTZ, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(Blocks.NETHER_QUARTZ_ORE)), createSaplingProperties(MapColor.NETHER, SoundType.NETHERRACK));
    public static final TreeMinerBlockCreate NETHER_LODE_SAPLING_GOLD = new TreeMinerBlockCreate("nether_lode_sapling_gold", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.NETHER_LODE_GOLD, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(Blocks.NETHER_GOLD_ORE)), createSaplingProperties(MapColor.NETHER, SoundType.NETHERRACK));
    public static final TreeMinerBlockCreate NETHER_LODE_SAPLING_NETHERITE = new TreeMinerBlockCreate("nether_lode_sapling_netherite", (it) -> new com.iceberry.treeminer.common.blocks.LodeSaplingBlock(com.iceberry.treeminer.common.TreeMinerTreeGrower.NETHER_LODE_NETHERITE, it, com.iceberry.treeminer.common.blocks.LodeSaplingBlock.SaplingProperties.saplingProperties().placeable(Blocks.ANCIENT_DEBRIS)), createSaplingProperties(MapColor.NETHER, SoundType.NETHERRACK), new Item.Properties().fireResistant());

    public static final TreeMinerBlockCreate LODE_LEAVES_COAL = new TreeMinerBlockCreate("lode_leaves_coal", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_COAL, LODE_SAPLING_COAL.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_IRON = new TreeMinerBlockCreate("lode_leaves_iron", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_IRON, LODE_SAPLING_IRON.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_COPPER = new TreeMinerBlockCreate("lode_leaves_copper", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_COPPER, LODE_SAPLING_COPPER.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_LAPIS = new TreeMinerBlockCreate("lode_leaves_lapis", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_LAPIS, LODE_SAPLING_LAPIS.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_REDSTONE = new TreeMinerBlockCreate("lode_leaves_redstone", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_REDSTONE, LODE_SAPLING_REDSTONE.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_GOLD = new TreeMinerBlockCreate("lode_leaves_gold", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_GOLD, LODE_SAPLING_GOLD.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_EMERALD = new TreeMinerBlockCreate("lode_leaves_emerald", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_EMERALD, LODE_SAPLING_EMERALD.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate LODE_LEAVES_DIAMOND = new TreeMinerBlockCreate("lode_leaves_diamond", it -> new com.iceberry.treeminer.common.blocks.LodeLeavesBlock(it, TreeMinerItems.POD_DIAMOND, LODE_SAPLING_DIAMOND.blockItem), leavesProperties(MapColor.STONE, SoundType.STONE, 3.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_LEAVES_GLOWSTONE = new TreeMinerBlockCreate("nether_lode_leaves_glowstone", it -> new com.iceberry.treeminer.common.blocks.CrystalLodeLeavesBlock(it, TreeMinerItems.NETHER_POD_GLOWSTONE, NETHER_LODE_SAPLING_GLOWSTONE.blockItem), leavesProperties(MapColor.SAND, SoundType.GLASS, 2.0F).lightLevel(blockState -> blockState.getValue(STAGE_3) == 3 ? 13 : 0));
    public static final TreeMinerBlockCreate NETHER_LODE_LEAVES_QUARTZ = new TreeMinerBlockCreate("nether_lode_leaves_quartz", it -> new com.iceberry.treeminer.common.blocks.CrystalLodeLeavesBlock(it, TreeMinerItems.NETHER_POD_QUARTZ, NETHER_LODE_SAPLING_QUARTZ.blockItem), leavesProperties(MapColor.NETHER, SoundType.NETHER_ORE, 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_LEAVES_GOLD = new TreeMinerBlockCreate("nether_lode_leaves_gold", it -> new com.iceberry.treeminer.common.blocks.CrystalLodeLeavesBlock(it, TreeMinerItems.NETHER_POD_GOLD, NETHER_LODE_SAPLING_GOLD.blockItem), leavesProperties(MapColor.NETHER, SoundType.NETHER_GOLD_ORE, 2.0F));
    public static final TreeMinerBlockCreate NETHER_LODE_LEAVES_NETHERITE = new TreeMinerBlockCreate("nether_lode_leaves_netherite", it -> new com.iceberry.treeminer.common.blocks.CrystalLodeLeavesBlock(it, TreeMinerItems.NETHER_POD_NETHERITE, NETHER_LODE_SAPLING_NETHERITE.blockItem), leavesProperties(MapColor.NETHER, SoundType.ANCIENT_DEBRIS, 10.0F, 1200.0F));

    // ==================== XiaoJinBlockBehaviour 整合 ====================
    
    /**
     * 便捷方块属性创建
     */
    public static class Properties {
        private BlockBehaviour.Properties properties;
        
        private Properties() {
            this.properties = BlockBehaviour.Properties.of();
        }
        
        public static Properties of() {
            return new Properties();
        }
        
        public Properties mapColor(MapColor color) {
            properties = properties.mapColor(color);
            return this;
        }
        
        public Properties strength(float strength) {
            properties = properties.strength(strength);
            return this;
        }
        
        public Properties strength(float hardness, float resistance) {
            properties = properties.strength(hardness, resistance);
            return this;
        }
        
        public Properties sound(SoundType sound) {
            properties = properties.sound(sound);
            return this;
        }
        
        public Properties requiresCorrectToolForDrops() {
            properties = properties.requiresCorrectToolForDrops();
            return this;
        }
        
        public Properties pushReaction(PushReaction reaction) {
            properties = properties.pushReaction(reaction);
            return this;
        }
        
        public Properties noOcclusion() {
            properties = properties.noOcclusion();
            return this;
        }
        
        public Properties noCollission() {
            properties = properties.noCollission();
            return this;
        }
        
        public Properties randomTicks() {
            properties = properties.randomTicks();
            return this;
        }
        
        public Properties instabreak() {
            properties = properties.instabreak();
            return this;
        }
        
        public Properties lightLevel(java.util.function.ToIntFunction<net.minecraft.world.level.block.state.BlockState> lightLevel) {
            properties = properties.lightLevel(lightLevel);
            return this;
        }
        
        public Properties mapColor(java.util.function.Function<net.minecraft.world.level.block.state.BlockState, net.minecraft.world.level.material.MapColor> mapColorFunction) {
            properties = properties.mapColor(mapColorFunction);
            return this;
        }
        
        public Properties instrument(NoteBlockInstrument instrument) {
            properties = properties.instrument(instrument);
            return this;
        }
        
        public Properties ignitedByLava() {
            properties = properties.ignitedByLava();
            return this;
        }
        
        public Properties isValidSpawn(net.minecraft.world.level.block.state.BlockBehaviour.StateArgumentPredicate<net.minecraft.world.entity.EntityType<?>> predicate) {
            properties = properties.isValidSpawn(predicate);
            return this;
        }
        
        public Properties isSuffocating(net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate predicate) {
            properties = properties.isSuffocating(predicate);
            return this;
        }
        
        public Properties isViewBlocking(net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate predicate) {
            properties = properties.isViewBlocking(predicate);
            return this;
        }
        
        public Properties isRedstoneConductor(net.minecraft.world.level.block.state.BlockBehaviour.StatePredicate predicate) {
            properties = properties.isRedstoneConductor(predicate);
            return this;
        }
        
        public BlockBehaviour.Properties build() {
            return properties;
        }
    }

    // ==================== XiaoJinCreateBlock 整合 ====================

    /**
     * 生成一个用于原木类型方块的属性对象
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength, NoteBlockInstrument instrument) {
        return Properties.of()
                .mapColor(blockState -> blockState.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? sideColor : topColor)
                .instrument(instrument)
                .strength(strength)
                .sound(sound)
                .ignitedByLava()
                .build();
    }

    /**
     * 生成一个用于原木类型方块的属性对象
     */
    public static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound, float strength) {
        return logProperties(sideColor, topColor, sound, strength, NoteBlockInstrument.BASS);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     */
    public static BlockBehaviour.Properties leavesProperties(SoundType sound) {
        return leavesProperties(MapColor.PLANT, sound, 0.2F);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float strength) {
        return leavesProperties(color, sound, strength, strength);
    }

    /**
     * 生成一个用于树叶类型方块的属性对象。
     */
    public static BlockBehaviour.Properties leavesProperties(MapColor color, SoundType sound, float destroyTime, float explosionResistance) {
        return Properties.of()
                .mapColor(color)
                .strength(destroyTime, explosionResistance)
                .randomTicks()
                .sound(sound)
                .noOcclusion()
                .isValidSpawn((blockState, blockGetter, blockPos, entityType) -> Blocks.ocelotOrParrot(blockState, blockGetter, blockPos, entityType))
                .isSuffocating(TreeMinerBlocks::never)
                .isViewBlocking(TreeMinerBlocks::never)
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(TreeMinerBlocks::never)
                .build();
    }

    public static Boolean never(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    // ==================== 原有方法 ====================

    public static BlockBehaviour.Properties createProperties(MapColor color, SoundType sound, float strength){
        return Properties.of()
                .mapColor(color)
                .strength(strength)
                .sound(sound)
                .requiresCorrectToolForDrops()
                .build();
    }

    public static BlockBehaviour.Properties createSlab(MapColor color, SoundType sound, float strength){
        return Properties.of()
                .mapColor(color)
                .strength(strength)
                .sound(sound)
                .requiresCorrectToolForDrops()
                .build();
    }

    public static BlockBehaviour.Properties createStair(MapColor color, SoundType sound, float strength){
        return Properties.of()
                .mapColor(color)
                .strength(strength)
                .sound(sound)
                .requiresCorrectToolForDrops()
                .build();
    }

    public static BlockBehaviour.Properties createFence(MapColor color, SoundType sound, float strength){
        return Properties.of()
                .mapColor(color)
                .strength(strength)
                .sound(sound)
                .requiresCorrectToolForDrops()
                .build();
    }

    public static BlockBehaviour.Properties createGate(MapColor color, SoundType sound, float strength){
        return Properties.of()
                .mapColor(color)
                .strength(strength)
                .sound(sound)
                .requiresCorrectToolForDrops()
                .build();
    }

    public static BlockBehaviour.Properties createSaplingProperties(MapColor color, SoundType sound){
        return Properties.of()
                .mapColor(color)
                .sound(sound)
                .pushReaction(PushReaction.DESTROY)
                .strength(0.3f)
                .noOcclusion()
                .noCollission()
                .randomTicks()
                .instabreak()
                .build();
    }

    @Deprecated
    public static Block registerLegacyStair(String name, Block baseBlock) {
        return register(name, p_368077_ -> new StairBlock(baseBlock.defaultBlockState(), p_368077_), BlockBehaviour.Properties.ofLegacyCopy(baseBlock));
    }

    public static Block register(String name, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        return register(vanillaBlockId(name), factory, properties);
    }

    public static ResourceKey<Block> vanillaBlockId(String name) {
        return ResourceKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace(name));
    }

    private static Block register(ResourceKey<Block> resourceKey, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Block block = factory.apply(properties);
        return Registry.register(BuiltInRegistries.BLOCK, resourceKey, block);
    }
}