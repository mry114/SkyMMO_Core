package com.github.mry114.skymmo_core.api.pdc;

import org.bukkit.persistence.PersistentDataType;

public interface IDataType<T, C extends IConvertData<T>> extends PersistentDataType<T, C> {
}
