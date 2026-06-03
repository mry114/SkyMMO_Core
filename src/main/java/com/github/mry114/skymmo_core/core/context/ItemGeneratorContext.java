package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.core.context.key.ItemGeneratorContextKey;
import org.bukkit.inventory.ItemStack;

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
