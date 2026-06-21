package com.github.mry114.skymmo_core.handler.item.context.rarity;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.item.module.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.api.item.module.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.api.item.module.context.IItemReaderContext;
import com.github.mry114.skymmo_core.core.item.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.handler.item.context.ItemMainModuleKeys;
import com.github.mry114.skymmo_core.register.content.ItemRegistry;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemRarityModule implements IItemModule {
    private static final ItemRarityModule INSTANCE = new ItemRarityModule();
    private final ItemRarityLogic logic;

    private ItemRarityModule() {
        this.logic = new ItemRarityLogic();
    }

    public static ItemRarityModule getInstance() {
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

    private static class ItemRarityLogic implements IItemReader, IItemCalculator, IItemProcessor {

        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {
            context.put(ItemRarityModuleKeys.ITEM_RARITY, customItem.getRarity());
        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            MetaDataUtil meta = new MetaDataUtil(context.getItemStack());

            List<Component> lore = new ArrayList<>();
            lore.add(Component.text(context.get(ItemRarityModuleKeys.ITEM_RARITY).name() + " " + customItem.getItemType().getName())
                    .decorate(TextDecoration.BOLD)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(context.get(ItemRarityModuleKeys.ITEM_RARITY).getColor()));

            meta.loreAddAll(lore);
            meta.setItemMeta();
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemRarityModuleKeys.ITEM_RARITY, ItemRegistry.getById(pdc.get(ItemMainModuleKeys.PDC_ITEM_ID)).getRarity());
        }
    }
}
