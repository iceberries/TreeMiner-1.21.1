package com.iceberry.treeminer.datagen;

import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureSlot;

import java.util.Optional;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;
import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

/**
 * 模组模型数据生成器
 */
public class TreeMinerModels {
    public static final ModelTemplate CROSS = createBlockModel("cross", TextureSlot.CROSS);

    /**
     * 创建方块模型模板
     * @param name 模型名称
     * @param requiredSlots 需要的纹理槽
     * @return 模型模板
     */
    public static ModelTemplate createBlockModel(String name, TextureSlot... requiredSlots) {
        return new ModelTemplate(Optional.of(fromNamespaceAndPath(MOD_ID, "block/" + name)), Optional.empty(), requiredSlots);
    }
}