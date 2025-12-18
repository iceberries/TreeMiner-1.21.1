package com.iceberry.treeminer.create;

import com.iceberry.treeminer.common.items.OreStewItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.component.DataComponents;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static com.iceberry.treeminer.TreeMinerMain.MOD_ID;

/**
 * @author 尽
 * @transplant by iceberry
 * @apiNote 创建物品
 */
public class TreeMinerItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public static final DeferredItem<Item> POD_COAL = ITEMS.registerItem("pod_coal", Item::new);
    public static final DeferredItem<Item> POD_IRON = ITEMS.registerItem("pod_iron", Item::new);
    public static final DeferredItem<Item> POD_COPPER = ITEMS.registerItem("pod_copper", Item::new);
    public static final DeferredItem<Item> POD_LAPIS = ITEMS.registerItem("pod_lapis", Item::new);
    public static final DeferredItem<Item> POD_EMERALD = ITEMS.registerItem("pod_emerald", Item::new);
    public static final DeferredItem<Item> POD_GOLD = ITEMS.registerItem("pod_gold", Item::new);
    public static final DeferredItem<Item> POD_REDSTONE = ITEMS.registerItem("pod_redstone", Item::new);
    public static final DeferredItem<Item> POD_DIAMOND = ITEMS.registerItem("pod_diamond", Item::new);
    public static final DeferredItem<Item> NETHER_POD_GLOWSTONE = ITEMS.registerItem("nether_pod_glowstone", Item::new);
    public static final DeferredItem<Item> NETHER_POD_QUARTZ = ITEMS.registerItem("nether_pod_quartz", Item::new);
    public static final DeferredItem<Item> NETHER_POD_GOLD = ITEMS.registerItem("nether_pod_gold", Item::new);
    public static final DeferredItem<Item> NETHER_POD_NETHERITE = ITEMS.registerItem("nether_pod_netherite", Item::new, new Item.Properties().fireResistant());

    public static final DeferredItem<Item> COOKED_POD_COAL = createCookedPod("cooked_pod_coal", Foods.COAL);
    public static final DeferredItem<Item> COOKED_POD_IRON = createCookedPod("cooked_pod_iron", Foods.IRON);
    public static final DeferredItem<Item> COOKED_POD_COPPER = createCookedPod("cooked_pod_copper", Foods.COPPER);
    public static final DeferredItem<Item> COOKED_POD_LAPIS = createCookedPod("cooked_pod_lapis", Foods.LAPIS);
    public static final DeferredItem<Item> COOKED_POD_EMERALD = createCookedPod("cooked_pod_emerald", Foods.EMERALD);
    public static final DeferredItem<Item> COOKED_POD_GOLD = createCookedPod("cooked_pod_gold", Foods.GOLD);
    public static final DeferredItem<Item> COOKED_POD_REDSTONE = createCookedPod("cooked_pod_redstone", Foods.REDSTONE);
    public static final DeferredItem<Item> COOKED_POD_DIAMOND = createCookedPod("cooked_pod_diamond", Foods.DIAMOND);
    public static final DeferredItem<Item> COOKED_NETHER_POD_GLOWSTONE = createCookedPod("cooked_nether_pod_glowstone", Foods.GLOWSTONE);
    public static final DeferredItem<Item> COOKED_NETHER_POD_QUARTZ = createCookedPod("cooked_nether_pod_quartz", Foods.QUARTZ);
    public static final DeferredItem<Item> COOKED_NETHER_POD_GOLD = createCookedPod("cooked_nether_pod_gold", Foods.NETHER_GOLD);
    public static final DeferredItem<Item> COOKED_NETHER_POD_NETHERITE = ITEMS.registerItem("cooked_nether_pod_netherite", Item::new, new Item.Properties().fireResistant().food(Foods.NETHERITE));

    public static final DeferredItem<Item> LODE_BOWL = ITEMS.registerItem("lode_bowl", Item::new);
    public static final DeferredItem<OreStewItem> ORE_STEW = ITEMS.registerItem("ore_stew", OreStewItem::new,
            new Item.Properties()
                    .stacksTo(1)
                    .food(new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.1f)
                    .alwaysEdible()
                    .build())
    );

    public static DeferredItem<Item> createCookedPod(String name, FoodProperties foodproperties) {
        return ITEMS.registerItem(name, props -> new Item(props.food(foodproperties)));
    }

    public static class Foods {
        public static final FoodProperties COAL = createFoodProperties(2, 0.1F);
        public static final FoodProperties IRON = createFoodProperties(4, 0.2F);
        public static final FoodProperties COPPER = createFoodProperties(3, 0.2F);
        public static final FoodProperties LAPIS = createFoodProperties(3, 0.2F);
        public static final FoodProperties EMERALD = createFoodProperties(4, 0.3F);
        public static final FoodProperties GOLD = createFoodProperties(2, 0.4F);
        public static final FoodProperties REDSTONE = createFoodProperties(3, 0.2F);
        public static final FoodProperties DIAMOND = createFoodProperties(5, 0.4F);
        public static final FoodProperties GLOWSTONE = createFoodProperties(3, 0.2F);
        public static final FoodProperties QUARTZ = createFoodProperties(3, 0.2F);
        public static final FoodProperties NETHER_GOLD = createFoodProperties(1, 0.4F);
        public static final FoodProperties NETHERITE = createFoodProperties(6, 0.4F);
    }

    public static FoodProperties createFoodProperties(int hunger, float saturation) {
        return new FoodProperties.Builder()
                .nutrition(hunger)
                .saturationModifier(saturation)
                .build();
    }

    public static class EffectDefinitions {
        // 矿物效果定义，用于在TreeMinerMain中创建效果
        public static final MobEffectInstance COAL_EFFECT = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60, 0);
        public static final MobEffectInstance IRON_EFFECT = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 15, 1);
        public static final MobEffectInstance COPPER_EFFECT = new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 30, 0);
        public static final MobEffectInstance LAPIS_EFFECT = new MobEffectInstance(MobEffects.WATER_BREATHING, 20 * 60, 0);
        public static final MobEffectInstance EMERALD_EFFECT = new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 20 * 60, 0);
        public static final MobEffectInstance GOLD_EFFECT = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60, 0);
        public static final MobEffectInstance REDSTONE_EFFECT = new MobEffectInstance(MobEffects.DIG_SPEED, 20 * 60, 0);
        public static final MobEffectInstance DIAMOND_EFFECT = new MobEffectInstance(MobEffects.ABSORPTION, 20 * 30, 2);
        public static final MobEffectInstance GLOWSTONE_EFFECT = new MobEffectInstance(MobEffects.GLOWING, 20 * 60, 0);
        public static final MobEffectInstance QUARTZ_EFFECT = new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 30, 0);
        public static final MobEffectInstance NETHER_GOLD_EFFECT = new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 30, 0);
        
        // 下界合金的复合效果
        public static final List<MobEffectInstance> NETHERITE_EFFECTS = List.of(
                new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60, 0),
                new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 60, 2)
        );
    }
}
