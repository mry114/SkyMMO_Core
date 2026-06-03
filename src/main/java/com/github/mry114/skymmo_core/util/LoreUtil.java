package com.github.mry114.skymmo_core.util;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LoreUtil {
    private final List<Component> lore;
    private final ItemStack item;
    private final ItemMeta meta;

    public LoreUtil(ItemStack itemStack) {
        this.meta = itemStack.getItemMeta();
        this.lore = new ArrayList<>();
        this.item = itemStack;
    }

    public LoreUtil add(Component line) {
        lore.add(line);
        return this;
    }

    public LoreUtil add(int index, Component line) {
        lore.add(index, line);
        return this;
    }

    public List<Component> getLoreList() {
        return lore;
    }

    public void addAllLore(List<Component> lore) {
        this.lore.addAll(lore);
    }

    public Component get(int index) {
        return lore.get(index);
    }

    public void setLoreMeta() {
        meta.lore(lore);
        item.setItemMeta(meta);
    }
}
