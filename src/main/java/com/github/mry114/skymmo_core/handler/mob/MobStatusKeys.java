package com.github.mry114.skymmo_core.handler.mob;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.core.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class MobStatusKeys {
    public static final PDCKey<Double, Double> PDC_MOB_HP = new PDCKey<>(PersistentDataType.DOUBLE, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_mob_hp"));
}
