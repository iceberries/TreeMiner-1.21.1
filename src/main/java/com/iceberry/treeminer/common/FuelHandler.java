package com.iceberry.treeminer.common;

import com.iceberry.treeminer.create.TreeMinerItems;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

/**
 * TreeMiner燃料处理类
 * 处理自定义物品的燃料属性
 */
@EventBusSubscriber(modid = com.iceberry.treeminer.TreeMinerMain.MOD_ID)
public class FuelHandler {
    
    /**
     * 监听燃料燃烧时间事件
     * 为煤果实添加燃料属性
     */
    @SubscribeEvent
    public static void onFurnaceFuelBurnTime(FurnaceFuelBurnTimeEvent event) {
        Item item = event.getItemStack().getItem();
        
        // 为煤果实添加燃料属性，燃烧时长与木板一致（300 ticks = 15秒）
        if (item == TreeMinerItems.POD_COAL.get()) {
            event.setBurnTime(300);
        }
    }
}