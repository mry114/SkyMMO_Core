package com.github.mry114.skymmo_core.api.context;

import com.github.mry114.skymmo_core.core.context.key.Key;

public interface IBaseContext {
    <V> V get(Key<V> key);
}
