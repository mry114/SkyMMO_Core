package com.github.mry114.skymmo_core.api.item.module;

import com.github.mry114.skymmo_core.api.item.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemUpdater;
import org.jetbrains.annotations.Nullable;

public interface IItemModule {
    @Nullable
    default IItemReader getItemReader() {
        return null;
    }

    @Nullable
    default IItemUpdater getItemUpdater() {
        return null;
    }

    @Nullable
    default IItemCalculator getItemCalculator() {
        return null;
    }

    @Nullable
    default IItemProcessor getItemProcessor() {
        return null;
    }
}
