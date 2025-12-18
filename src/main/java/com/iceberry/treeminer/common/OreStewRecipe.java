package com.iceberry.treeminer.common;
import com.iceberry.treeminer.create.TreeMinerItems;
import com.iceberry.treeminer.create.TreeMinerRecipes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.google.common.collect.Lists;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class OreStewRecipe extends CustomRecipe {
    private final String group;
    private final CraftingBookCategory category;

    public OreStewRecipe(CraftingBookCategory category, String group) {
        super(category);
        this.group = group;
        this.category = category;
    }

    @Override
    public boolean matches(@NotNull CraftingInput input, @NotNull Level level) {
        boolean hasBowl = false;
        int oreCount = 0;
        boolean hasGlowstone = false;
        
        // 支持所有矿石浆果类型，最多2个矿物果
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.is(TreeMinerItems.LODE_BOWL.get())) {
                    if (hasBowl) return false;
                    hasBowl = true;
                } else if (stack.is(TreeMinerItems.COOKED_NETHER_POD_GLOWSTONE.get())) {
                    if (hasGlowstone) return false; // 只允许一个荧石果
                    hasGlowstone = true;
                } else if (isOreBerry(stack)) {
                    oreCount++;
                    if (oreCount > 2) return false; // 最多2个矿物果
                } else {
                    return false; // 其他物品不允许
                }
            }
        }
        return hasBowl && oreCount >= 1 && oreCount <= 2; // 1-2个矿物果
    }
    
    /**
     * 检查物品是否为矿石浆果
     */
    private boolean isOreBerry(ItemStack stack) {
        return stack.is(TreeMinerItems.COOKED_POD_COAL.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_IRON.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_COPPER.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_LAPIS.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_EMERALD.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_GOLD.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_REDSTONE.get()) ||
               stack.is(TreeMinerItems.COOKED_POD_DIAMOND.get()) ||
               stack.is(TreeMinerItems.COOKED_NETHER_POD_QUARTZ.get()) ||
               stack.is(TreeMinerItems.COOKED_NETHER_POD_GLOWSTONE.get()) ||
               stack.is(TreeMinerItems.COOKED_NETHER_POD_NETHERITE.get()) ||
               stack.is(TreeMinerItems.COOKED_NETHER_POD_GOLD.get());
    }

    @Override
    public @NotNull ItemStack assemble(@NotNull CraftingInput input, @NotNull HolderLookup.Provider registries) {
        ItemStack result = new ItemStack(TreeMinerItems.ORE_STEW.get());
        
        // 收集所有矿物浆果和荧石果信息
        List<StringTag> oreNames = Lists.newArrayList();
        boolean hasGlowstone = false;
        
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (!stack.isEmpty()) {
                if (stack.is(TreeMinerItems.COOKED_NETHER_POD_GLOWSTONE.get())) {
                    hasGlowstone = true;
                } else if (isOreBerry(stack)) {
                    // 添加矿物名称到列表
                    ResourceLocation oreType = BuiltInRegistries.ITEM.getKey(stack.getItem());
                    oreNames.add(StringTag.valueOf(oreType.toString()));
                }
            }
        }
        
        // 将成分信息存入标签
        if (!oreNames.isEmpty()) {
            ListTag oreNameTag = new ListTag();
            oreNameTag.addAll(oreNames);
            
            CompoundTag tag = new CompoundTag();
            tag.put("ore_name", oreNameTag);
            tag.putBoolean("has_glowstone", hasGlowstone);
            
            result.set(DataComponents.CUSTOM_DATA, CustomData.of(tag));
        }
        
        return result;
    }


    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width * height >= 3;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return TreeMinerRecipes.ORE_STEW_RECIPE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeType.CRAFTING;
    }

    public static class Serializer implements RecipeSerializer<OreStewRecipe> {
        private static final MapCodec<OreStewRecipe> CODEC = RecordCodecBuilder.mapCodec(
                builder -> builder.group(
                        CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(recipe -> recipe.category),
                        Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group)
                ).apply(builder, (category, group) -> new OreStewRecipe(category, group))
        );
        
        private static final StreamCodec<RegistryFriendlyByteBuf, OreStewRecipe> STREAM_CODEC = StreamCodec.of(
                (buffer, recipe) -> {
                    buffer.writeUtf(recipe.group);
                    buffer.writeEnum(recipe.category);
                },
                buffer -> {
                    String group = buffer.readUtf();
                    CraftingBookCategory category = buffer.readEnum(CraftingBookCategory.class);
                    return new OreStewRecipe(category, group);
                }
        );

        @Override
        public MapCodec<OreStewRecipe> codec() {
            return CODEC;
        }

        @Override
        public @NotNull StreamCodec<RegistryFriendlyByteBuf, OreStewRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}