package com.github.mry114.skymmo_core.data.context.attribute;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.module.processor.IItemUpdater;
import com.github.mry114.skymmo_core.core.context.*;
import com.github.mry114.skymmo_core.registry.ItemAttributeRegistry;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ItemAttributeModule implements IItemModule {
    private static final ItemAttributeModule INSTANCE = new ItemAttributeModule();
    private final ItemAttributeLogic logic;

    private ItemAttributeModule() {
        this.logic = new ItemAttributeLogic();
    }

    public static ItemAttributeModule getInstance() {
        return INSTANCE;
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

    private static class ItemAttributeLogic implements IItemReader, IItemUpdater, IItemCalculator, IItemProcessor {
        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {
            context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, generator.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE));
        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            ItemStack itemStack = context.getItemStack();
            MetaDataUtil meta = new MetaDataUtil(itemStack);
            meta.getPDC().set(ItemAttributeModuleKeys.PDC_ATTRIBUTE_ID, context.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE).getId());
            meta.setItemMeta();
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, ItemAttributeRegistry.getById(pdc.get(ItemAttributeModuleKeys.PDC_ATTRIBUTE_ID)));
        }

        @Override
        public void updater(ICustomItem customItem, @NotNull ItemUpdaterContext updater, IItemUpdaterContext context) {
            context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, updater.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE));
        }
    }
}