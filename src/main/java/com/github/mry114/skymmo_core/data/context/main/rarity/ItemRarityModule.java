package com.github.mry114.skymmo_core.data.context.main.rarity;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.core.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.core.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.core.context.IItemReaderContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.data.context.main.MainModuleKeys;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
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
            List<Component> lore = new ArrayList<>();
            lore.add(Component.text(context.get(ItemRarityModuleKeys.ITEM_RARITY).name() + " " + customItem.getItemType().name())
                    .decorate(TextDecoration.BOLD)
                    .decoration(TextDecoration.ITALIC, false)
                    .color(context.get(ItemRarityModuleKeys.ITEM_RARITY).getColor()));

            context.getItemStack().getItemMeta().lore().addAll(lore);
            context.getItemStack().setItemMeta(context.getItemStack().getItemMeta());
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemRarityModuleKeys.ITEM_RARITY, ItemRegistry.getById(pdc.get(MainModuleKeys.PDC_ITEM_ID)).getRarity());
        }
    }
}
