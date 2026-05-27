package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.IItemProcessorModule;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MaterialItem implements ICustomItem {
    private final int id;
    private final Component name;
    private final Rarity rarity;
    private final Material material;

    public MaterialItem(int id, Component name, Rarity rarity, Material material) {
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.material = material;
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
    public @NotNull Rarity getRarity() {
        return rarity;
    }

    @Override
    public @NotNull Material getMaterial() {
        return material;
    }

    @Override
    public @NotNull List<IItemProcessorModule> getProcessorModule() {
        return List.of(

        );
    }
}
