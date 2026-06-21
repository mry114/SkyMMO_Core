package com.github.mry114.skymmo_core.handler.mob;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.core.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class MobMainModuleKeys {
    public static final PDCKey<Integer, Integer> PDC_MOB_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_mob_id"));
}
