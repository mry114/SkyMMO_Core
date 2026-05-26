package com.github.mry114.skymmo_core.data.item.Armor;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.ArmorItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class ExampleArmor extends ArmorItem {
    protected ExampleArmor(int id, String name, Rarity rarity, Material material) {
        super(200_001, Component.text("テストアーマー"), Rarity.COMMON, Material.IRON_CHESTPLATE);
    }

    @Override
    protected StatusContainer getMainStats() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE, 10.0)
                .build();
    }

    @Override
    protected StatusContainer getSecondaryStats() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE_PERCENT, 20.0)
                .add(Status.MOVE_SPEED, 10.0)
                .build();
    }
}
