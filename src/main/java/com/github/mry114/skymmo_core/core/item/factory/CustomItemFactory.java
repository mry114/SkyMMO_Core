package com.github.mry114.skymmo_core.core.item.factory;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.core.context.ItemContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.core.context.ItemUpdaterContext;
import com.github.mry114.skymmo_core.data.context.basic.MainModuleKeys;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * ItemStackを作る際、Moduleを順番通りに実行します
 * CalculatorはProcessorより前に実行されるため、ProcessorはCalculatorの結果を利用できます
 * 例えば、ModuleAとModuleBがあった場合、ModuleAのCalculatorとProcessorが先に実行され、その後ModuleBのCalculatorとProcessorが実行されます
 */
public class CustomItemFactory {
    ICustomItem customItem;

    public CustomItemFactory(ICustomItem customItem) {
        this.customItem = customItem;
    }

    public ItemStack create(@NotNull ItemGeneratorContext generator) {
        ItemStack item = new ItemStack(customItem.getMaterial());
        ItemContext context = new ItemContext(item);
        context.getItemStack().lore(new ArrayList<>());
        ItemMeta meta = item.getItemMeta();
        PDCWrapper pdcWrapper = new PDCWrapper(meta);
        pdcWrapper.set(MainModuleKeys.PDC_ITEM_ID, customItem.getId());
        item.setItemMeta(meta);

        for (IItemModule module : customItem.getProcessorModule()) {
            if (module.getItemCalculator() != null) {
                module.getItemCalculator().calculate(customItem, generator, context);
            }
        }

        for (IItemModule module : customItem.getProcessorModule()) {
            if (module.getItemProcessor() != null) {
                module.getItemProcessor().process(customItem, context);
            }
        }

        return item;
    }

    public ItemStack update(@NotNull ItemUpdaterContext updater, ItemStack item) {

        ItemContext context = new ItemContext(item);
        context.getItemStack().lore(new ArrayList<>());

        for (IItemModule module : customItem.getProcessorModule()) {
            if (module.getItemReader() != null) {
                module.getItemReader().reader(customItem, item, context);
            }
        }
        item.setItemMeta(null);

        for (IItemModule module : customItem.getProcessorModule()) {
            if (module.getItemUpdater() != null) {
                module.getItemUpdater().updater(customItem, updater, context);
            }
        }

        for (IItemModule module : customItem.getProcessorModule()) {
            if (module.getItemProcessor() != null) {
                module.getItemProcessor().process(customItem, context);
            }
        }

        return item;
    }
}
