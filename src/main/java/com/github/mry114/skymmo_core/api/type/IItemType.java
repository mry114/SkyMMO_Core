package com.github.mry114.skymmo_core.api.type;

public interface IItemType<T extends Enum<T> & IItemType<T>> {
    IItemGroup<?> getItemGroup();
}
