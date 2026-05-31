package com.github.mry114.skymmo_core.data.item.Weapon;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.WeaponItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ExampleWeapon extends WeaponItem {
    @Override
    public @NotNull StatusContainer getMainStatus() {
        return new StatusContainer.Builder()
                .add(Status.ATTACK, 10.0)
                .build();
    }

    @Override
    public @NotNull StatusContainer getBaseStatus() {
        return new StatusContainer.Builder()
                .add(Status.ATTACK_PERCENT, 20.0)
                .add(Status.ATTACK_SPEED, 10.0)
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
        return 100_001;
    }

    @Override
    public @NotNull Component getName() {
        return Component.text("テストウェポン");
    }

    @Override
    public @NotNull Material getMaterial() {
        return Material.IRON_SWORD;
    }

    @Override
    public @NotNull Rarity getRarity() {
        return Rarity.COMMON;
    }
}
