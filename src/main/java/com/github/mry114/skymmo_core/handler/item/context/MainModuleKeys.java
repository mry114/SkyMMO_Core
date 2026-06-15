package com.github.mry114.skymmo_core.handler.item.context;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.core.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class MainModuleKeys {
    public static final PDCKey<Integer, Integer> PDC_ITEM_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_item_id"));
}
