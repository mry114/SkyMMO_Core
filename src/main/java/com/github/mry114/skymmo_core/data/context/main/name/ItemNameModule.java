package com.github.mry114.skymmo_core.data.context.main.name;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.core.context.*;
import com.github.mry114.skymmo_core.data.context.attribute.ItemAttributeModuleKeys;
import com.github.mry114.skymmo_core.data.context.main.MainModuleKeys;
import com.github.mry114.skymmo_core.data.context.main.rarity.ItemRarityModuleKeys;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

public class ItemNameModule implements IItemModule {
    private static final ItemNameModule INSTANCE = new ItemNameModule();
    private final ItemNameLogic logic;

    private ItemNameModule() {
        this.logic = new ItemNameLogic();
    }

    public static ItemNameModule getInstance() {
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

    private static class ItemNameLogic implements IItemReader, IItemCalculator, IItemProcessor {
        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {
            context.put(ItemNameModuleKeys.ITEM_NAME, customItem.getName());
        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            ItemStack itemStack = context.getItemStack();
            ItemMeta meta = itemStack.getItemMeta();
            Component displayName;

            if (context.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE) != null) {
                displayName = context.get(ItemAttributeModuleKeys.ITEM_ATTRIBUTE).getDisplayName()
                        .append(Component.text(" "))
                        .append(context.get(ItemNameModuleKeys.ITEM_NAME))
                        .decorate(TextDecoration.BOLD)
                        .decoration(TextDecoration.ITALIC, false)
                        .color(context.get(ItemRarityModuleKeys.ITEM_RARITY).getColor());
            } else {
                displayName = context.get(ItemNameModuleKeys.ITEM_NAME)
                        .decorate(TextDecoration.BOLD)
                        .decoration(TextDecoration.ITALIC, false)
                        .color(context.get(ItemRarityModuleKeys.ITEM_RARITY).getColor());
            }

            meta.displayName(displayName);
            itemStack.setItemMeta(meta);
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemNameModuleKeys.ITEM_NAME, ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID)).getName());
        }
    }
}
