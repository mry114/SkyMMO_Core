package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.IEquipmentItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class WeaponItem implements IEquipmentItem {
    private final int id;
    private final Component name;
    private final Rarity rarity;
    private final Material material;

    protected abstract StatusContainer getMainStats();
    protected abstract StatusContainer  getSecondaryStats();

    protected WeaponItem(int id, Component name, Rarity rarity, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
    }

    @Override
    public @NotNull StatusContainer getAllStats() {
        return getMainStats().marge(getSecondaryStats());
    }

    @Override
    public @NotNull List<Component> getLore() {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public @NotNull Component getName() {
        return name;
    }

    @Override
    public @NotNull Material getMaterial() {
        return material;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return rarity;
    }
}
