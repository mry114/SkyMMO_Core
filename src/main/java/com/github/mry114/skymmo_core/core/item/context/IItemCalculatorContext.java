package com.github.mry114.skymmo_core.core.item.context;

import com.github.mry114.skymmo_core.api.item.module.context.IItemBaseContext;
import com.github.mry114.skymmo_core.core.item.context.key.ItemContextKey;

public interface IItemCalculatorContext extends IItemBaseContext {
    <V> void put(ItemContextKey<V> itemContextKey, V value);
}
