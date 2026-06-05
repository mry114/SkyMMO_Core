package com.github.mry114.skymmo_core.util;

import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public record MetaDataUtil(ItemMeta meta, ItemStack item) {
    public MetaDataUtil(@NotNull ItemStack item) {
        this(item.getItemMeta(), item);
    }

    public MetaDataUtil(@NotNull ItemMeta meta) {
        this(meta, null);
    }

    public void setDisplayName(Component displayName) {
        meta.displayName(displayName);
    }

    public List<Component> getLore() {
        return meta.lore();
    }

    public void setLore(List<Component> lore) {
        meta.lore(lore);
    }

    public void loreAddAll(List<Component> lore) {
        List<Component> currentLore = meta.lore();
        if (currentLore == null) {
            currentLore = lore;
        } else {
            currentLore.addAll(lore);
        }
        meta.lore(currentLore);
    }

    public PDCWrapper getPDC() {
        return new PDCWrapper(meta);
    }

    public boolean nullable() {
        return meta.lore() == null;
    }

    public void setItemMeta() {
        if (item != null) {
            item.setItemMeta(meta);
        }
    }
}
