package com.github.mry114.skymmo_core.api.item.module.context;

import com.github.mry114.skymmo_core.core.item.context.ItemContextKey;

public interface IItemBaseContext {
    <V> V get(ItemContextKey<V> itemContextKey);
}
