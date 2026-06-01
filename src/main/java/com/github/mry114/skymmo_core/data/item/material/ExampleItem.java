package com.github.mry114.skymmo_core.data.item.material;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import com.github.mry114.skymmo_core.api.item.can.ItemSkill;
import com.github.mry114.skymmo_core.api.item.can.UseRequirement;
import com.github.mry114.skymmo_core.core.item.MaterialItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleItem extends MaterialItem {
    public ExampleItem() {
        super(null, null);
    }

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
