package com.iceberry.treeminer;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import com.iceberry.treeminer.create.TreeMinerBlocks;
import com.iceberry.treeminer.create.TreeMinerItems;
import com.iceberry.treeminer.create.TreeMinerRecipes;
import com.iceberry.treeminer.create.TreeMinerTab;
import com.iceberry.treeminer.common.items.OreStewItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;
import java.util.concurrent.atomic.AtomicBoolean;
import static com.iceberry.treeminer.create.TreeMinerItems.EffectDefinitions.*;

@Mod(TreeMinerMain.MOD_ID)
public class TreeMinerMain {
    public static final String MOD_ID = "treeminer";

    public TreeMinerMain(IEventBus modEventBus, ModContainer modContainer) {
        // 注册模组组件
        TreeMinerItems.ITEMS.register(modEventBus);
        TreeMinerBlocks.BLOCKS.register(modEventBus);
        TreeMinerRecipes.RECIPES.register(modEventBus);
        TreeMinerTab.CREATIVE_MODE_TABS.register(modEventBus);

        // 初始化配方和效果
        this.initRecipe();
    }

    public void initRecipe() {
        // 注册矿物炖汤效果
        this.registerOreStewEffects();
    }

    private void registerOreStewEffects() {
        // 煤炭浆果 - 火焰抗性
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_COAL, this.createEffect(COAL_EFFECT));
        
        // 铁浆果 - 伤害抗性
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_IRON, this.createEffect(IRON_EFFECT));
        
        // 铜浆果 - 速度提升
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_COPPER, this.createEffect(COPPER_EFFECT));
        
        // 青金石浆果 - 水下呼吸
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_LAPIS, this.createEffect(LAPIS_EFFECT));
        
        // 祖母绿浆果 - 村庄英雄
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_EMERALD, this.createEffect(EMERALD_EFFECT));
        
        // 金浆果 - 火焰抗性
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_GOLD, this.createEffect(GOLD_EFFECT));
        
        // 红石浆果 - 挖掘速度
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_REDSTONE, this.createEffect(REDSTONE_EFFECT));
        
        // 钻石浆果 - 吸收效果
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_POD_DIAMOND, this.createEffect(DIAMOND_EFFECT));
        
        // 下界石英浆果 - 力量效果
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_NETHER_POD_QUARTZ, this.createEffect(QUARTZ_EFFECT));
        
        // 荧石浆果 - 发光效果
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_NETHER_POD_GLOWSTONE, this.createEffect(GLOWSTONE_EFFECT));
        
        // 下界金浆果 - 火焰抗性
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_NETHER_POD_GOLD, this.createEffect(NETHER_GOLD_EFFECT));
        
        // 下界合金浆果 - 复合效果(抗性提升加抗火)
        OreStewItem.EFFECT_TABLE.put(TreeMinerItems.COOKED_NETHER_POD_NETHERITE, (stack, level, entity) -> {
            // 检查是否有荧石果增强
            boolean hasGlowstone = false;
            var data = stack.getComponents().get(DataComponents.CUSTOM_DATA);
            if (data != null) {
                var tag = data.copyTag();
                hasGlowstone = tag.getBoolean("has_glowstone");
            }
            
            // 应用复合效果
            for (MobEffectInstance effect : NETHERITE_EFFECTS) {
                MobEffectInstance finalEffect;
                if (hasGlowstone) {
                    // 有荧石果：效果等级+1，持续时间减半
                    finalEffect = new MobEffectInstance(
                        effect.getEffect(), 
                        effect.getDuration() / 2, 
                        effect.getAmplifier() + 1
                    );
                } else {
                    // 无荧石果：保持原效果
                    finalEffect = new MobEffectInstance(effect);
                }
                entity.addEffect(finalEffect);
            }
        });
    }

    /**
     * 直接创建效果实例的方法
     */
    public OreStewItem.ItemFinishUsing createEffect(MobEffectInstance effect) {
        return (item, level, entity) -> {
            // 检查是否有荧石果
            boolean Glowstone = false;
            var data = item.getComponents().get(DataComponents.CUSTOM_DATA);
            if (data != null) {
                var tag = data.copyTag();
                Glowstone = tag.getBoolean("has_glowstone");
            }
            
            // 根据是否有荧石果调整效果
            final MobEffectInstance finalEffect;
            if (Glowstone) {
                // 有荧石果：效果等级+1，持续时间减半
                finalEffect = new MobEffectInstance(
                    effect.getEffect(), 
                    effect.getDuration() / 2, 
                    effect.getAmplifier() + 1
                );
            } else {
                // 无荧石果：保持原效果
                finalEffect = new MobEffectInstance(effect);
            }
            
            entity.addEffect(finalEffect);
        };
    }
}
