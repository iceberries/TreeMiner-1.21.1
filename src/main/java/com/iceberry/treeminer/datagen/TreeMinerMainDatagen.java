package com.iceberry.treeminer.datagen;

import com.iceberry.treeminer.datagen.language.Chinese;
import com.iceberry.treeminer.datagen.tags.TreeMinerBlockTags;
import com.iceberry.treeminer.datagen.tags.TreeMinerItemTags;
import com.iceberry.treeminer.datagen.TreeMinerRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static com.iceberry.treeminer.datagen.TreeMinerDatapackProvider.BUILDER;

/**
 * 数据生成
 */
@EventBusSubscriber(modid = MOD_ID)
public class TreeMinerMainDatagen {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
         DataGenerator gen = event.getGenerator();
         PackOutput packOutput = gen.getPackOutput();
         CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
         
         // 注册数据包
         event.createDatapackRegistryObjects(BUILDER, Set.of(MOD_ID));
         
         // 语言生成 - 使用正确的构造函数
         event.createProvider((packOutput1, lookupProvider1) -> new Chinese(packOutput1, MOD_ID));
         
         // 标签生成
         event.createBlockAndItemTags(
             (packOutput1, lookupProvider1) -> new TreeMinerBlockTags(packOutput1, lookupProvider1),
             (packOutput1, lookupProvider1, blockTags) -> new TreeMinerItemTags(packOutput1, lookupProvider1, blockTags)
         );
         // 配方生成
         event.createProvider((packOutput1, lookupProvider1) -> new TreeMinerRecipeProvider(packOutput1, lookupProvider1));
         // 模型文件手动创建
         // event.createProvider((packOutput1) -> new TreeMinerModelProvider(packOutput1));
    }
}