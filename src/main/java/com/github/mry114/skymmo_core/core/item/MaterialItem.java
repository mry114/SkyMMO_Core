package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class MaterialItem implements ICustomItem {
    private int id;
    private String name;
    private Rarity rarity;
    private Material material;

    public MaterialItem(int id, String name, Rarity rarity, Material material) {
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
    public String getName() {
        return this.name;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }
}
