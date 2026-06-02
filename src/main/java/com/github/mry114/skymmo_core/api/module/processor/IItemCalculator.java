package com.github.mry114.skymmo_core.api.module.processor;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.IItemCalculatorContext;

public interface IItemCalculator {
    void calculate(ICustomItem customItem, IItemCalculatorContext context);
}
