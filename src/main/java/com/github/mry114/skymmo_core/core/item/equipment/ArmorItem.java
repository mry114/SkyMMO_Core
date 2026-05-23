package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.api.item.IEquipmentItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public abstract class ArmorItem implements IEquipmentItem {
    private final int id;
    private final Component name;
    private final Rarity rarity;
    private final Material material;

    protected abstract StatusContainer getMainStats();
    protected abstract StatusContainer  getSecondaryStats();

    protected ArmorItem(int id, Component name, Rarity rarity, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
    }

    @Override
    public StatusContainer getAllStats() {
        return getMainStats().marge(getSecondaryStats());
    }

    @Override
    public List<Component> getLore() {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Component getName() {
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
