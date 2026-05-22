package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.api.item.IEquipmentItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.Map;

public abstract class ArmorItem implements IEquipmentItem {
    private final int id;
    private final String name;
    private final Rarity rarity;
    private final Material material;

    protected abstract Map<Status, Double>  getMainStats();
    protected abstract Map<Status, Double>  getSecondaryStats();

    protected ArmorItem(int id, String name, Rarity rarity, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
    }

    @Override
    public Map<Status, Double> getAllStats() {
        return null;
    }

    @Override
    public Component getLore() {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public Rarity getRarity() {
        return rarity;
    }
}
