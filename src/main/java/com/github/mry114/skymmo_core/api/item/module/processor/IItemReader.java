package com.github.mry114.skymmo_core.api.item.module.processor;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.context.IItemReaderContext;
import org.bukkit.inventory.ItemStack;

public interface IItemReader {
    void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context);
}
