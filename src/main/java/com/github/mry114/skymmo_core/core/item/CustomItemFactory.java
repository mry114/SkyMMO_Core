package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
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

            //meta.getPersistentDataContainer().set();
        }

        return item;
    }
}
