package com.github.mry114.skymmo_core.api.type;

public interface IEnchantType <T extends Enum<T> & IEnchantType<T>> {
    String name();
}
