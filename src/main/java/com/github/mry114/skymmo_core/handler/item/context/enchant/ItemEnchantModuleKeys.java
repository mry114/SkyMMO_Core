package com.github.mry114.skymmo_core.handler.item.context.enchant;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.core.item.context.ItemContextKey;
import com.github.mry114.skymmo_core.core.pdc.PDCKey;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import com.github.mry114.skymmo_core.handler.pdc.type.EnchantDataType;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class ItemEnchantModuleKeys {
    public static final PDCKey<List<Integer>, List<EnchantConvertData>> PDC_ENCHANT_DATA = new PDCKey<>(PersistentDataType.LIST.listTypeFrom(EnchantDataType.INSTANCE), new NamespacedKey(SkyMMO_Core.getInstance(), "pdc_enchant_data"));

    public static final ItemContextKey<List<EnchantConvertData>> ITEM_ENCHANT = new ItemContextKey<>("item_enchant");
}
