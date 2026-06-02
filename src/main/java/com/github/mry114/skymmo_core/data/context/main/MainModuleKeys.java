package com.github.mry114.skymmo_core.data.context.main;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.context.ItemUpdaterContext;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.core.context.key.ItemGeneratorContextKey;
import com.github.mry114.skymmo_core.core.context.key.ItemUpdaterContextKey;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class MainModuleKeys {
    public static final PDCKey<Integer, Integer> PDC_ITEM_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "item_id"));
}
