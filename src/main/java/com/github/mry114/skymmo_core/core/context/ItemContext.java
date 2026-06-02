package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.api.module.context.IItemBaseContext;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;

import java.util.HashMap;
import java.util.Map;

public class ItemContext implements IItemBaseContext, IItemReaderContext, IItemUpdaterContext, IItemCalculatorContext, IItemProcessorContext {
    private final Map<ItemContextKey<?>, Object> context;

    public ItemContext() {
        context = new HashMap<>();
    }

    @Override
    public <V> void put(ItemContextKey<V> itemContextKey, V value) {
        context.put(itemContextKey, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <V> V get(ItemContextKey<V> itemContextKey) {
        return (V) context.get(itemContextKey);
    }
}
