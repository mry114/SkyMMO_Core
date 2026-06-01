package com.github.mry114.skymmo_core.api.item.context;

import com.github.mry114.skymmo_core.core.context.key.Key;

public interface IBaseContext {
    <V> V get(Key<V> key);

    <V> void put(Key<V> key, V value);
}
