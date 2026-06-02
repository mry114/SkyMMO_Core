package com.github.mry114.skymmo_core.data.item.material;

import com.github.mry114.skymmo_core.data.type.Rarity;
import com.github.mry114.skymmo_core.core.item.type.MaterialItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public class ExampleItem extends MaterialItem {

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("テストアイテム");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_INGOT;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.COMMON;
    }
}
