package com.iceberry.treeminer.datagen;

import com.iceberry.treeminer.TreeMinerMain;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

/**
 * TreeMiner配方提供器
 * 用于生成自定义配方
 */
public class TreeMinerRecipeProvider extends RecipeProvider {
    
    public TreeMinerRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput, HolderLookup.Provider provider) {
        // 为lode_planks创建木棍配方（有序合成：竖直两个木板）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
            .pattern("#")
            .pattern("#")
            .define('#', net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "lode_planks")
            ))
            .unlockedBy("has_lode_planks", has(
                net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "lode_planks")
                )
            ))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "stick_from_lode_planks"));

        // 为nether_lode_planks创建木棍配方（有序合成：竖直两个木板）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
            .pattern("#")
            .pattern("#")
            .define('#', net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "nether_lode_planks")
            ))
            .unlockedBy("has_nether_lode_planks", has(
                net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "nether_lode_planks")
                )
            ))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "stick_from_nether_lode_planks"));

        // 添加lode_planks合成工具和其他木制品的配方
        addWoodRecipes(recipeOutput, "lode_planks", "lode");
        
        // 添加nether_lode_planks合成工具和其他木制品的配方
        addWoodRecipes(recipeOutput, "nether_lode_planks", "nether_lode");
        
        // 添加果实烧制配方
        addFruitSmeltingRecipes(recipeOutput, provider);
        
        // 添加原木分解为木板的配方
        addLogToPlankRecipes(recipeOutput);
    }

    /**
     * 为特定类型的木板添加标准的木制品配方
     * @param recipeOutput 配方输出
     * @param planksName 木板名称（如 "lode_planks"）
     * @param woodPrefix 木材前缀（如 "lode"）
     */
    private void addWoodRecipes(RecipeOutput recipeOutput, String planksName, String woodPrefix) {
        var planksItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
            ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, planksName)
        );

        // 合成工作台
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.CRAFTING_TABLE)
            .pattern("##")
            .pattern("##")
            .define('#', planksItem)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "crafting_table_from_" + woodPrefix + "_planks"));

        // 合成箱子
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, Blocks.CHEST)
            .pattern("###")
            .pattern("# #")
            .pattern("###")
            .define('#', planksItem)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "chest_from_" + woodPrefix + "_planks"));

        // 合成木镐
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_PICKAXE)
            .pattern("III")
            .pattern(" S ")
            .pattern(" S ")
            .define('I', planksItem)
            .define('S', Items.STICK)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "wooden_pickaxe_from_" + woodPrefix + "_planks"));

        // 合成木斧
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_AXE)
            .pattern("II")
            .pattern("IS")
            .pattern(" S")
            .define('I', planksItem)
            .define('S', Items.STICK)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "wooden_axe_from_" + woodPrefix + "_planks"));

        // 合成木锹
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_SHOVEL)
            .pattern("I")
            .pattern("S")
            .define('I', planksItem)
            .define('S', Items.STICK)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "wooden_shovel_from_" + woodPrefix + "_planks"));

        // 合成木剑
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.WOODEN_SWORD)
            .pattern("I")
            .pattern("I")
            .pattern("S")
            .define('I', planksItem)
            .define('S', Items.STICK)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "wooden_sword_from_" + woodPrefix + "_planks"));

        // 合成木锄
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.WOODEN_HOE)
            .pattern("II")
            .pattern(" S")
            .pattern(" S")
            .define('I', planksItem)
            .define('S', Items.STICK)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "wooden_hoe_from_" + woodPrefix + "_planks"));

        // 合成木棍（重复配方，保持与上面的一致）
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
            .pattern("#")
            .pattern("#")
            .define('#', planksItem)
            .unlockedBy("has_" + woodPrefix + "_planks", has(planksItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "stick_alt_from_" + woodPrefix + "_planks"));
    }

    /**
     * 添加果实烧制配方
     * 包括熔炉、高炉和烟熏炉配方
     */
    private void addFruitSmeltingRecipes(RecipeOutput recipeOutput, HolderLookup.Provider provider) {
        // 果实到对应矿物的熔炉和高炉配方映射
        FruitSmeltingData[] smeltingData = {
            // 普通果实 -> 对应矿物
            new FruitSmeltingData("pod_coal", "coal", 0.15f),
            new FruitSmeltingData("pod_iron", "iron_ingot", 0.7f),
            new FruitSmeltingData("pod_copper", "copper_ingot", 0.35f),
            new FruitSmeltingData("pod_lapis", "lapis_lazuli", 0.2f),
            new FruitSmeltingData("pod_emerald", "emerald", 1.0f),
            new FruitSmeltingData("pod_gold", "gold_ingot", 1.0f),
            new FruitSmeltingData("pod_redstone", "redstone", 0.7f),
            new FruitSmeltingData("pod_diamond", "diamond", 1.0f),
            
            // 下界果实 -> 对应矿物
            new FruitSmeltingData("nether_pod_glowstone", "glowstone", 0.35f),
            new FruitSmeltingData("nether_pod_quartz", "quartz", 0.2f),
            new FruitSmeltingData("nether_pod_gold", "gold_ingot", 1.0f),
            new FruitSmeltingData("nether_pod_netherite", "netherite_scrap", 1.0f)
        };

        // 果实到熟果的烟熏炉配方
        FruitCookingData[] cookingData = {
            new FruitCookingData("pod_coal", "cooked_pod_coal", 0.35f, 100),
            new FruitCookingData("pod_iron", "cooked_pod_iron", 0.35f, 100),
            new FruitCookingData("pod_copper", "cooked_pod_copper", 0.35f, 100),
            new FruitCookingData("pod_lapis", "cooked_pod_lapis", 0.35f, 100),
            new FruitCookingData("pod_emerald", "cooked_pod_emerald", 0.35f, 100),
            new FruitCookingData("pod_gold", "cooked_pod_gold", 0.35f, 100),
            new FruitCookingData("pod_redstone", "cooked_pod_redstone", 0.35f, 100),
            new FruitCookingData("pod_diamond", "cooked_pod_diamond", 0.35f, 100),
            new FruitCookingData("nether_pod_glowstone", "cooked_nether_pod_glowstone", 0.35f, 100),
            new FruitCookingData("nether_pod_quartz", "cooked_nether_pod_quartz", 0.35f, 100),
            new FruitCookingData("nether_pod_gold", "cooked_nether_pod_gold", 0.35f, 100),
            new FruitCookingData("nether_pod_netherite", "cooked_nether_pod_netherite", 0.35f, 200)
        };

        // 生成熔炉和高炉配方（果实 -> 矿物）
        for (FruitSmeltingData data : smeltingData) {
            var fruitItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName)
            );
            var resultItem = data.resultName.startsWith("minecraft:") 
                ? net.minecraft.core.registries.BuiltInRegistries.ITEM.get(ResourceLocation.parse(data.resultName))
                : net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                    ResourceLocation.fromNamespaceAndPath("minecraft", data.resultName)
                );

            // 熔炉配方
            SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(fruitItem),
                RecipeCategory.MISC,
                resultItem,
                data.experience,
                200
            ).unlockedBy("has_" + data.fruitName, has(fruitItem))
             .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName + "_to_" + data.resultName.replace("minecraft:", "")));

            // 高炉配方（烧炼速度更快）
            SimpleCookingRecipeBuilder.blasting(
                Ingredient.of(fruitItem),
                RecipeCategory.MISC,
                resultItem,
                data.experience,
                100
            ).unlockedBy("has_" + data.fruitName, has(fruitItem))
             .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName + "_to_" + data.resultName.replace("minecraft:", "") + "_blasting"));
        }

        // 生成烟熏炉配方（果实 -> 熟果）
        for (FruitCookingData data : cookingData) {
            var fruitItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName)
            );
            var cookedItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
                ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.cookedName)
            );

            // 烟熏炉配方
            SimpleCookingRecipeBuilder.smoking(
                Ingredient.of(fruitItem),
                RecipeCategory.FOOD,
                cookedItem,
                data.experience,
                data.cookingTime
            ).unlockedBy("has_" + data.fruitName, has(fruitItem))
             .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName + "_to_" + data.cookedName));

            // 熔炉也可以烧制熟果（烧制时间更长）
            SimpleCookingRecipeBuilder.smelting(
                Ingredient.of(fruitItem),
                RecipeCategory.FOOD,
                cookedItem,
                data.experience,
                data.cookingTime * 2
            ).unlockedBy("has_" + data.fruitName, has(fruitItem))
             .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, data.fruitName + "_to_" + data.cookedName + "_furnace"));
        }
    }

    /**
     * 果实烧制数据类
     */
    private static class FruitSmeltingData {
        final String fruitName;
        final String resultName;
        final float experience;

        FruitSmeltingData(String fruitName, String resultName, float experience) {
            this.fruitName = fruitName;
            this.resultName = resultName;
            this.experience = experience;
        }
    }

    /**
     * 添加原木分解为木板的配方
     * 一个原木可以分解成4个对应的木板
     */
    private void addLogToPlankRecipes(RecipeOutput recipeOutput) {
        // 矿木原木 -> 矿木板配方
        var lodeLogItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
            ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "lode_log")
        );
        var lodePlanksItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
            ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "lode_planks")
        );
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, lodePlanksItem, 4)
            .requires(lodeLogItem)
            .unlockedBy("has_lode_log", has(lodeLogItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "lode_planks_from_lode_log"));

        // 下界矿木原木 -> 下界矿木板配方
        var netherLodeLogItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
            ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "nether_lode_log")
        );
        var netherLodePlanksItem = net.minecraft.core.registries.BuiltInRegistries.ITEM.get(
            ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "nether_lode_planks")
        );
        
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, netherLodePlanksItem, 4)
            .requires(netherLodeLogItem)
            .unlockedBy("has_nether_lode_log", has(netherLodeLogItem))
            .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(TreeMinerMain.MOD_ID, "nether_lode_planks_from_nether_lode_log"));
    }

    /**
     * 果实烹饪数据类
     */
    private static class FruitCookingData {
        final String fruitName;
        final String cookedName;
        final float experience;
        final int cookingTime;

        FruitCookingData(String fruitName, String cookedName, float experience, int cookingTime) {
            this.fruitName = fruitName;
            this.cookedName = cookedName;
            this.experience = experience;
            this.cookingTime = cookingTime;
        }
    }
}