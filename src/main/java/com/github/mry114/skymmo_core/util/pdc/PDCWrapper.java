package com.github.mry114.skymmo_core.util.pdc;

import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

public class PDCWrapper {
    private final PersistentDataContainer persistentDataContainer;

    public PDCWrapper(@NotNull ItemMeta meta) {
        this.persistentDataContainer = meta.getPersistentDataContainer();
    }

    public <P, C> C get(PDCKey<P, C> status) {
        return persistentDataContainer.get(status.key(), status.type());
    }

    public <P, C> void set(PDCKey<P, C> status, C value) {
        persistentDataContainer.set(status.key(), status.type(), value);
    }
}
