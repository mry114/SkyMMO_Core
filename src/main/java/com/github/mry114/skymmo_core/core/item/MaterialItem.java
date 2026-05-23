package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class MaterialItem implements ICustomItem {
    private int id;
    private Component name;
    private Rarity rarity;
    private Material material;

    public MaterialItem(int id, Component name, Rarity rarity, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public Component getName() {
        return this.name;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }
}
