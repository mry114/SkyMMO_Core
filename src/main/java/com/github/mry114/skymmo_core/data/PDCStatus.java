package com.github.mry114.skymmo_core.data;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public enum PDCStatus {
    ITEM_ID(PersistentDataType.INTEGER, "id"),
    RARITY(PersistentDataType.STRING, "rarity")
    ;

    private final PersistentDataType<?, ?> dataType;
    private final NamespacedKey key;

    PDCStatus(PersistentDataType<?, ?> dataType, String key) {
        this.dataType = dataType;
        this.key = new NamespacedKey(SkyMMO_Core.getInstance(), key.toLowerCase());
    }

    @SuppressWarnings("unchecked")
    public <T, Z> PersistentDataType<T, Z> getDataType() {
        return (PersistentDataType<T, Z>) dataType;
    }
    public NamespacedKey getKey() {
        return key;
    }
}
