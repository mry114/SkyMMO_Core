package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;

public interface IItemCalculator {
    void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context);
}
