package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemUpdaterContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;

public interface IItemUpdater {
    void updater(ItemGeneratorContext generator, IItemUpdaterContext context);
}
