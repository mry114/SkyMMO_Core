package com.github.mry114.skymmo_core.core.item.factory;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.core.context.ItemContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import org.bukkit.inventory.ItemStack;

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

    public ItemStack create() {
        ItemStack item = new ItemStack(customItem.getMaterial());
        ItemContext context = new ItemContext(item);

        for (IItemModule module : customItem.getProcessorModule()) {
            // Calculator を実行
            if (module.getItemCalculator() != null) {
                module.getItemCalculator().calculate(customItem, context);
            }
        }

        for (IItemModule module : customItem.getProcessorModule()) {
            // Processor を実行
            if (module.getItemProcessor() != null) {
                module.getItemProcessor().process(customItem, context);
            }
        }

        return item;
    }

    public ItemStack update() {
        return null;
    }
}
