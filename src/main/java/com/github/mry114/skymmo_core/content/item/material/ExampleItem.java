package com.github.mry114.skymmo_core.content.item.material;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.core.type.item.MaterialItem;
import com.github.mry114.skymmo_core.model.item.type.MaterialType;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class ExampleItem extends MaterialItem {

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("TestItem");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_INGOT;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public @NotNull IItemType<MaterialType> getItemType() {
        return MaterialType.ITEM;
    }
}
