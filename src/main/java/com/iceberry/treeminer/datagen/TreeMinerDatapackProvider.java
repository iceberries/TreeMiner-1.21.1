package com.iceberry.treeminer.datagen;

import com.iceberry.treeminer.datagen.worldgen.TreeMinerBiomeModifiers;
import com.iceberry.treeminer.datagen.worldgen.TreeMinerPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;

public class TreeMinerDatapackProvider extends DatapackBuiltinEntriesProvider {

    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, TreeMinerPlacedFeatures::bootstrapConfiguredFeatures)
            .add(Registries.PLACED_FEATURE, TreeMinerPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, TreeMinerBiomeModifiers::bootstrap);

    public TreeMinerDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MOD_ID));
    }

    public TreeMinerDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, RegistrySetBuilder builder, Set<String> modIds) {
        super(output, registries, builder, modIds);
    }
}