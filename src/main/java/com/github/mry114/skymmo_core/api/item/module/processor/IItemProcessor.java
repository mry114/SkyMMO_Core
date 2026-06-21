package com.github.mry114.skymmo_core.api.item.module.processor;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.context.IItemProcessorContext;

public interface IItemProcessor {
    void process(ICustomItem customItem, IItemProcessorContext context);
}
