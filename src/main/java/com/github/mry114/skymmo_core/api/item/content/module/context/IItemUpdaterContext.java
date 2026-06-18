package com.github.mry114.skymmo_core.api.item.content.module.context;

import com.github.mry114.skymmo_core.core.item.context.key.ItemContextKey;

public interface IItemUpdaterContext extends IItemBaseContext {
    <V> void put(ItemContextKey<V> itemContextKey, V value);
}
