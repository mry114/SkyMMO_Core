package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.api.module.context.IItemBaseContext;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;

public interface IItemReaderContext extends IItemBaseContext {
    <V> void put(ItemContextKey<V> itemContextKey, V value);
}
