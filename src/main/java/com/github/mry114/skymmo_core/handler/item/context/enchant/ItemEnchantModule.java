package com.github.mry114.skymmo_core.handler.item.context.enchant;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.item.module.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.api.item.module.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.api.item.module.context.IItemReaderContext;
import com.github.mry114.skymmo_core.api.item.module.context.IItemUpdaterContext;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemUpdater;
import com.github.mry114.skymmo_core.core.item.context.*;
import com.github.mry114.skymmo_core.core.item.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemEnchantModule implements IItemModule {
    private static final ItemEnchantModule INSTANCE = new ItemEnchantModule();
    private final ItemEnchantLogic logic;

    private ItemEnchantModule() {
        this.logic = new ItemEnchantLogic();
    }

    public static ItemEnchantModule getInstance() {
        return INSTANCE;
    }

    @Override
    public @Nullable IItemUpdater getItemUpdater() {
        return logic;
    }

    @Override
    public @Nullable IItemReader getItemReader() {
        return logic;
    }

    @Override
    public @Nullable IItemCalculator getItemCalculator() {
        return logic;
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return logic;
    }

    private static class ItemEnchantLogic implements IItemReader,  IItemUpdater, IItemCalculator, IItemProcessor {

        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {

        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {

        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, pdc.get(ItemEnchantModuleKeys.PDC_ENCHANT_DATA));
        }

        @Override
        public void updater(ICustomItem customItem, @NotNull ItemUpdaterContext updater, IItemUpdaterContext context) {
            List<EnchantConvertData> newList = context.get(ItemEnchantModuleKeys.ITEM_ENCHANT);
            newList.addAll(updater.get(ItemEnchantModuleKeys.ITEM_ENCHANT));
            context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, newList);
        }
    }
}
