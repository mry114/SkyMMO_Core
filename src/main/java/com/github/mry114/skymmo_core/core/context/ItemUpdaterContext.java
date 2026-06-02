package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.core.context.key.ItemUpdaterContextKey;

import java.util.HashMap;
import java.util.Map;

public class ItemUpdaterContext {
    private final Map<ItemUpdaterContextKey<?>, Object> context;

    public ItemUpdaterContext() {
        context = new HashMap<>();
    }

    public <V> void put(ItemUpdaterContextKey<V> contextKey, V value) {
        context.put(contextKey, value);
    }

    @SuppressWarnings("unchecked")
    public <V> V get(ItemUpdaterContextKey<V> contextKey) {
        return (V) context.get(contextKey);
    }
}
