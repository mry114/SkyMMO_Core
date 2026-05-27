package com.github.mry114.skymmo_core.data.item.Armor;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.ArmorItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.List;

public class ExampleArmor extends ArmorItem {
    public ExampleArmor() {
        super(200_001, Component.text("テストアーマー"), Rarity.COMMON, Material.IRON_CHESTPLATE, List.of(
                Component.text("作成例です")
        ));
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
