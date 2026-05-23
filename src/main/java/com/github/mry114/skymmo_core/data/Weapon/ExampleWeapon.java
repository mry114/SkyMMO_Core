package com.github.mry114.skymmo_core.data.Weapon;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.WeaponItem;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.Map;

public class ExampleWeapon extends WeaponItem {
    protected ExampleWeapon(int id, String name, Rarity rarity, Material material) {
        super(100_001, Component.text("テストウェポン"), Rarity.COMMON, Material.IRON_SWORD);
    }

    @Override
    protected StatusContainer getMainStats() {
        return new StatusContainer.Builder()
                .add(Status.ATTACK, 10.0)
                .build();
    }

    @Override
    protected StatusContainer getSecondaryStats() {
        return new StatusContainer.Builder()
                .add(Status.ATTACK_PERCENT, 20.0)
                .add(Status.ATTACK_SPEED, 10.0)
                .build();
    }
}
