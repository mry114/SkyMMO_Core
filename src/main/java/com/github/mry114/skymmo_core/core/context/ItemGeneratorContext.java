package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.core.context.key.ItemGeneratorContextKey;

import java.util.HashMap;
import java.util.Map;

public class ItemGeneratorContext {
    private final Map<ItemGeneratorContextKey<?>, Object> context;

    public ItemGeneratorContext() {
        context = new HashMap<>();
    }

    public <V> void put(ItemGeneratorContextKey<V> itemContextKey, V value) {
        context.put(itemContextKey, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(ItemGeneratorContextKey<V> itemContextKey) {
        return (V) context.get(itemContextKey);
    }
}
