package com.github.mry114.skymmo_core.core.item.equipment;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.Equipment.IEquipmentItem;
import com.github.mry114.skymmo_core.api.item.Equipment.capa.IEquipmentAttribute;
import com.github.mry114.skymmo_core.api.item.Equipment.capa.IEquipmentMainStatus;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class WeaponItem implements IEquipmentItem, IEquipmentMainStatus {
    private final int id;
    private final Component name;
    private final Rarity rarity;
    private final Material material;
    private final List<Component> lore;

    protected abstract StatusContainer getMainStats();
    protected abstract StatusContainer  getSecondaryStats();

    public WeaponItem(int id, Component name, Rarity rarity, Material material, List<Component> lore) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
        this.lore = lore;
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return getMainStats();
    }

    @Override
    public @NotNull StatusContainer getMainStatus() {
        return getSecondaryStats();
    }

    @Override
    public @NotNull List<Component> getLore() {
        return lore;
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
