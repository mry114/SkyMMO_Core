package com.github.mry114.skymmo_core.util.pdc;

import com.github.mry114.skymmo_core.data.PDCStatus;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PDCWrapper {
    private final PersistentDataContainer persistentDataContainer;

    public PDCWrapper(ItemMeta meta) {
        this.persistentDataContainer = meta.getPersistentDataContainer();
    }

    public Object get(PDCStatus status) {
        return persistentDataContainer.get(status.getKey(), status.getDataType());
    }

    public void set(PDCStatus status, Object value) {
        persistentDataContainer.set(status.getKey(), status.getDataType(), value);
    }

    public void merge(PDCStatus status, Object value) {
        Object value1 = get(status);
        if (value1 != null) {
            persistentDataContainer.set(status.getKey(), status.getDataType(), value);
        }
        set(status, value);
    }
}
