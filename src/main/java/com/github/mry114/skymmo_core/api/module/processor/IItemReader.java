package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.core.context.IItemReaderContext;
import org.bukkit.inventory.ItemStack;

public interface IItemReader {
    void read(ItemStack itemStack, IItemReaderContext context);
}
