package com.github.mry114.skymmo_core.data.Weapon;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.WeaponItem;
import org.bukkit.Material;

import java.util.Map;

public class ExampleWeapon extends WeaponItem {
    protected ExampleWeapon(int id, String name, Rarity rarity, Material material) {
        super(100_001, "テストソード", Rarity.COMMON, Material.IRON_SWORD);
    }

    @Override
    protected Map<Status, Double> getMainStats() {
        return Map.of(
                Status.ATTACK, 10.0
        );
    }

    @Override
    protected Map<Status, Double> getSecondaryStats() {
        return Map.of(
                Status.ATTACK_PERCENT, 20.0,
                Status.ATTACK_SPEED, 10.0
        );
    }
}
