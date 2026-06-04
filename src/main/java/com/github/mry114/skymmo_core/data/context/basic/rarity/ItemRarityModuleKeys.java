package com.github.mry114.skymmo_core.data.context.basic.rarity;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.data.type.Rarity;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class ItemRarityModuleKeys {
    public static final ItemContextKey<Rarity> ITEM_RARITY = new ItemContextKey<>("item_rarity");

    PDCKey<String, String> PDC_RARITY = new PDCKey<>(PersistentDataType.STRING, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_rarity"));
}
