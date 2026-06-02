package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemProcessorContext;

public interface IItemProcessor {
    void process(ICustomItem customItem, IItemProcessorContext context);
}
