package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemReaderContext;
import org.bukkit.inventory.ItemStack;

public interface IItemReader {
    void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context);
}
