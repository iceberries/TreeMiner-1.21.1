package com.iceberry.treeminer.datagen.worldgen;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;

/*
生物群系修改器
将矿木树添加到各个生物群系中，但实际生成受放置特征的矿洞过滤器限制
 */
public class TreeMinerBiomeModifiers {
    
    /*
    引导配置生物群系修改器
    @param context 引导上下文
     */
    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        // 配置特征 -> 放置特征 -> 生物群系修改器
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);
    }
    
    /*
    注册生物群系修改器
     */
    private static void register(BootstrapContext<BiomeModifier> context, String name, BiomeModifier modifier) {
        context.register(registerKey(name), modifier);
    }
    
    /**
     * 注册生物群系修改器的资源键
     * @param name 修改器名称
     * @return 生物群系修改器资源键
     */
    protected static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MOD_ID, name));
    }
}