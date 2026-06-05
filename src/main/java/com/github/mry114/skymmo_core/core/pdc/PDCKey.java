package com.github.mry114.skymmo_core.core.pdc;

import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public record PDCKey<P, C>(PersistentDataType<P, C> type, NamespacedKey key) {
}
