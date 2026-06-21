package com.github.mry114.skymmo_core.api.item.module.processor;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.core.item.context.ItemGeneratorContext;

public interface IItemCalculator {
    void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context);
}
