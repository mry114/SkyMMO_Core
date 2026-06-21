package com.github.mry114.skymmo_core.api.item.module.context;

import com.github.mry114.skymmo_core.core.item.context.ItemContextKey;

public interface IItemReaderContext extends IItemBaseContext {
    <V> void put(ItemContextKey<V> itemContextKey, V value);
}
