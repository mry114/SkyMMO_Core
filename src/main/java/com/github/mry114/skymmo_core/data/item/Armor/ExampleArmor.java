package com.github.mry114.skymmo_core.data.item.Armor;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.ArmorItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleArmor extends ArmorItem {
    @Override
    public @NotNull StatusContainer getMainStatus() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE, 10.0)
                .build();
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return new StatusContainer.Builder()
                .add(Status.DEFENCE_PERCENT, 20.0)
                .add(Status.MOVE_SPEED, 10.0)
                .build();
    }

    @Override
    public @NotNull List<Component> getLore() {
        return List.of(
                Component.text("作成例です")
        );
    }

    @Override
    public int getId() {
        return 200_001;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("テストアーマー");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_CHESTPLATE;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.COMMON;
    }
}
