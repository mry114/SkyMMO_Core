package com.github.mry114.skymmo_core.data;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public interface PDCStatus {
    PDCKey<Byte, Boolean> CUSTOM_ITEM = new PDCKey<>(PersistentDataType.BOOLEAN, new NamespacedKey(SkyMMO_Core.getInstance(), "custom_item"));
    PDCKey<Integer, Integer> ITEM_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "id"));
    PDCKey<String, String> RARITY = new PDCKey<>(PersistentDataType.STRING, new NamespacedKey(SkyMMO_Core.getInstance(), "rarity"));
}
