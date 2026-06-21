package com.github.mry114.skymmo_core.util.pdc;

import com.github.mry114.skymmo_core.core.pdc.PDCKey;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.jetbrains.annotations.NotNull;

public class PDCWrapper {
    private final PersistentDataContainer persistentDataContainer;

    public PDCWrapper(@NotNull ItemMeta meta) {
        this.persistentDataContainer = meta.getPersistentDataContainer();
    }
    public PDCWrapper(@NotNull Entity entity) {
        this.persistentDataContainer = entity.getPersistentDataContainer();
    }

    public <P, C> C get(PDCKey<P, C> key) {
        return persistentDataContainer.get(key.key(), key.type());
    }

    public <P, C> void set(PDCKey<P, C> key, C value) {
        persistentDataContainer.set(key.key(), key.type(), value);
    }
}
