package com.iceberry.treeminer.create;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;

public class TreeMinerRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPES = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, MOD_ID);

    public static DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OreStewRecipe>> ORE_STEW_RECIPE_SERIALIZER =
            RECIPES.register("orestew", () -> new OreStewRecipe.Serializer());
}
