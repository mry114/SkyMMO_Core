package com.github.mry114.skymmo_core.data.pdc;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public record PDCKey<P, C>(PersistentDataType<P, C> type, NamespacedKey key) {
}
