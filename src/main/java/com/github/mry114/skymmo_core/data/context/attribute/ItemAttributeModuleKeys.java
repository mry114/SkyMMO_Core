package com.github.mry114.skymmo_core.data.context.attribute;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.data.pdc.PDCKey;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

public class ItemAttributeModuleKeys {
    public static final PDCKey<Integer, Integer> PDC_ATTRIBUTE_ID = new PDCKey<>(PersistentDataType.INTEGER, new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_attribute_id"));

    public static final ItemContextKey<IAttribute> ITEM_ATTRIBUTE = new ItemContextKey<>("item_attribute");
}
