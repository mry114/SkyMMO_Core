package com.github.mry114.skymmo_core.core.factory;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.core.item.context.ItemContext;
import com.github.mry114.skymmo_core.core.item.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.core.item.context.ItemUpdaterContext;
import com.github.mry114.skymmo_core.handler.item.context.MainModuleKeys;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
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

    public ItemStack create(@NotNull ICustomItem customItem, @NotNull ItemGeneratorContext generator) {
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
        ICustomItem customItem = ItemRegistry.getById(new PDCWrapper(item.getItemMeta()).get(MainModuleKeys.PDC_ITEM_ID));

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
