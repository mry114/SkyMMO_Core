package com.github.mry114.skymmo_core.data.context.basic.equipment.base_status;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.core.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.core.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.core.context.IItemReaderContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.data.context.basic.MainModuleKeys;
import com.github.mry114.skymmo_core.data.type.Status;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import com.github.mry114.skymmo_core.util.status.DisplayStatusUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.ArrayList;

public class ItemBaseStatusModule implements IItemModule {
    private static final ItemBaseStatusModule INSTANCE = new ItemBaseStatusModule();
    private final ItemBaseStatusLogic logic;

    private ItemBaseStatusModule() {
        this.logic = new ItemBaseStatusLogic();
    }

    public static ItemBaseStatusModule getInstance() {
        return INSTANCE;
    }

    @Override
    public @Nullable IItemReader getItemReader() {
        return logic;
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return logic;
    }

    @Override
    public @Nullable IItemCalculator getItemCalculator() {
        return logic;
    }

    private static class ItemBaseStatusLogic implements IItemReader, IItemCalculator, IItemProcessor {
        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {
            if (customItem instanceof IEquipmentItem equipment) {
                context.put(ItemBaseStatusModuleKeys.ITEM_BASE_STATUS, equipment.getBaseStatus());
            }
        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            MetaDataUtil meta = new MetaDataUtil(context.getItemStack());

            List<Component> newLore = new ArrayList<>();

            newLore.add(Component.text("[", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)
                    .append(Component.text(" Base Status ", TextColor.color(0xFFAA00)).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.ITALIC, false))
                    .append(Component.text("]", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)));

            boolean flg = false;
            for (Status status : Status.values()) {
                double value = context.get(ItemBaseStatusModuleKeys.ITEM_BASE_STATUS).get(status);
                if (value != 0) {
                    flg = true;
                    newLore.add(DisplayStatusUtil.getDisplayStatus(status, value));
                }
            }
            newLore.add(Component.empty());

            if (!flg) return;
            meta.loreAddAll(newLore);
            meta.setItemMeta();
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());

            if (ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID)) instanceof IEquipmentItem equipment) {
                context.put(ItemBaseStatusModuleKeys.ITEM_BASE_STATUS, equipment.getBaseStatus());
            }
        }
    }
}
