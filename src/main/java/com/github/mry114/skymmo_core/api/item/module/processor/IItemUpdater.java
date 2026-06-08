package com.github.mry114.skymmo_core.api.item.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.item.context.IItemUpdaterContext;
import com.github.mry114.skymmo_core.core.item.context.ItemUpdaterContext;
import org.jetbrains.annotations.NotNull;

public interface IItemUpdater {
    void updater(ICustomItem customItem, @NotNull ItemUpdaterContext updater, IItemUpdaterContext context);
}
