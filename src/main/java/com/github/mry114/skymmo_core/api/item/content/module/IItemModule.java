package com.github.mry114.skymmo_core.api.item.content.module;

import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemUpdater;
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
