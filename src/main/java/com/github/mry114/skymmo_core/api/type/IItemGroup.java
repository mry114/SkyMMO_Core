package com.github.mry114.skymmo_core.api.type;

public interface IItemGroup<T extends Enum<T> & IItemGroup<T>> {
    String getName();
}
