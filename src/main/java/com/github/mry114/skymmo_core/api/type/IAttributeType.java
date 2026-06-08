package com.github.mry114.skymmo_core.api.type;

public interface IAttributeType <T extends Enum<T> & IAttributeType<T>> {
    String name();
}
