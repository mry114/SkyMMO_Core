package com.github.mry114.skymmo_core.data.item.material;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.core.item.MaterialItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class ExampleItem extends MaterialItem {
    public ExampleItem() {
        super(1, Component.text("テストアイテム"), Rarity.COMMON, Material.IRON_INGOT);
    }
}
