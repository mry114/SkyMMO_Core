package com.github.mry114.skymmo_core.data.context.main;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

import java.awt.*;

public class MainModuleKeys {
    public static final PDCKey<Integer, Integer> PDC_ITEM_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_item_id"));
}
