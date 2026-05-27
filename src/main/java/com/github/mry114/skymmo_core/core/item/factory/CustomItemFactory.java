package com.github.mry114.skymmo_core.core.item.factory;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.core.lore.renderer.RarityRenderer;
import com.github.mry114.skymmo_core.data.PDCStatus;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItemFactory {
    ICustomItem customItem;
    IAttribute attribute;

    public CustomItemFactory(ICustomItem customItem) {
        this.customItem = customItem;
    }

    public CustomItemFactory setAttribute(IAttribute attribute) {
        this.attribute = attribute;
        return this;
    }

    public ItemStack create() {
        ItemStack item = new ItemStack(customItem.getMaterial());
        ItemMeta meta = item.getItemMeta();

        meta.setCustomModelData(customItem.getId());
        meta.displayName(customItem.getName().color(customItem.getRarity().getColor()));

        PDCWrapper pdcWrapper = new PDCWrapper(meta);
        pdcWrapper.set(PDCStatus.ITEM_ID, customItem.getId());
        pdcWrapper.set(PDCStatus.RARITY, customItem.getRarity());

        meta.lore(new RarityRenderer(customItem.getRarity()).build());

        return item;
    }
}
