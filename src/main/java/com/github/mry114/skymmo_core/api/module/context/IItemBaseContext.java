package com.github.mry114.skymmo_core.api.module.context;

import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;

public interface IItemBaseContext {
    <V> V get(ItemContextKey<V> itemContextKey);
}
