package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemUpdaterContext;
import com.github.mry114.skymmo_core.core.context.ItemUpdaterContext;

public interface IItemUpdater {
    void updater(ICustomItem customItem, ItemUpdaterContext updater, IItemUpdaterContext context);
}
