package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.api.module.context.IItemBaseContext;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.util.LoreUtil;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ItemContext implements IItemBaseContext, IItemReaderContext, IItemUpdaterContext, IItemCalculatorContext, IItemProcessorContext {
    private final Map<ItemContextKey<?>, Object> context;
    private final ItemStack itemStack;
    private final LoreUtil loreUtil;

    public ItemContext(ItemStack itemStack) {
        this.loreUtil = new LoreUtil(itemStack);
        this.context = new HashMap<>();
        this.itemStack = itemStack;
    }

    @Override
    public <V> void put(ItemContextKey<V> contextKey, V value) {
        context.put(contextKey, value);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <V> V get(ItemContextKey<V> contextKey) {
        return (V) context.get(contextKey);
    }

    @Override
    public ItemStack getItemStack() {
        return itemStack;
    }

    @Override
    public LoreUtil getLoreUtil() {
        return loreUtil;
    }
}
