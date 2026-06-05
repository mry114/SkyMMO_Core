package com.github.mry114.skymmo_core.core.item.context;

import com.github.mry114.skymmo_core.core.item.context.key.ItemContextKey;

import java.util.HashMap;
import java.util.Map;

public class ItemGeneratorContext {
    private final Map<ItemContextKey<?>, Object> context;

    public ItemGeneratorContext() {
        context = new HashMap<>();
    }

    public <V> void put(ItemContextKey<V> contextKey, V value) {
        context.put(contextKey, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(ItemContextKey<V> contextKey) {
        return (V) context.get(contextKey);
    }
}
