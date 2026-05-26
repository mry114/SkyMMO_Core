package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.IEquipmentItem;
import com.github.mry114.skymmo_core.core.attribute.bute.IWeaponAttribute;
import com.github.mry114.skymmo_core.data.PDCStatus;
import com.github.mry114.skymmo_core.data.attribute.ExampleWeaponAttribute;
import com.github.mry114.skymmo_core.data.item.Armor.ExampleArmor;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItemFactory {
    public ItemStack createBaseItem(ICustomItem customItem) {
        ItemStack item = new ItemStack(customItem.getMaterial());
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.displayName(customItem.getName());
            meta.setCustomModelData(customItem.getId());

            PDCWrapper pdcWrapper = new PDCWrapper(meta);
            pdcWrapper.set(PDCStatus.ITEM_ID, customItem.getId());
            pdcWrapper.set(PDCStatus.RARITY, customItem.getRarity());
        }

        return item;
    }
}
