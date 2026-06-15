package com.github.mry114.skymmo_core.handler.item.context.attribute;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
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
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.registry.ItemAttributeRegistry;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import com.github.mry114.skymmo_core.util.status.DisplayStatusUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
            IAttribute attribute = context.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE);

            meta.getPDC().set(ItemAttributeModuleKeys.PDC_ATTRIBUTE_ID, attribute.getId());

            List<Component> newLore = new ArrayList<>();

            newLore.add(Component.text("[", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)
                    .append(Component.text(" Attribute Status ", TextColor.color(0xFFAA00)).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.ITALIC, false))
                    .append(Component.text("]", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)));

            boolean flg = false;
            for (Status status : Status.values()) {
                double value = attribute.getAddStatus().get(status);
                if (value != 0) {
                    newLore.add(DisplayStatusUtil.getDisplayStatus(status, value));
                    flg = true;
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
            context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, ItemAttributeRegistry.getById(pdc.get(ItemAttributeModuleKeys.PDC_ATTRIBUTE_ID)));
        }

        @Override
        public void updater(ICustomItem customItem, @NotNull ItemUpdaterContext updater, IItemUpdaterContext context) {
            context.put(ItemAttributeModuleKeys.ITEM_ATTRIBUTE, updater.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE));
        }
    }
}