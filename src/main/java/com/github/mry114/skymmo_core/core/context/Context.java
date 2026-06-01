package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.api.item.context.IBaseContext;
import com.github.mry114.skymmo_core.core.context.key.Key;

import java.util.HashMap;
import java.util.Map;

public class Context implements IBaseContext {
    private final Map<Key<?>, Object> context;

    public Context() {
        context = new HashMap<>();
    }

    @Override
    public <V> void put(Key<V> key, V value) {
        context.put(key, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <V> V get(Key<V> key) {
        return (V) context.get(key);
    }
}
