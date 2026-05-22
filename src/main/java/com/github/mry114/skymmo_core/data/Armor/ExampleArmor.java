package com.github.mry114.skymmo_core.data.Armor;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.item.equipment.ArmorItem;
import org.bukkit.Material;

import java.util.Map;

public class ExampleArmor extends ArmorItem {
    protected ExampleArmor(int id, String name, Rarity rarity, Material material) {
        super(200_001, "テストアーマー", Rarity.COMMON, Material.IRON_CHESTPLATE);
    }

    @Override
    protected Map<Status, Double> getMainStats() {
        return Map.of(
                Status.DEFENCE, 10.0
        );
    }

    @Override
    protected Map<Status, Double> getSecondaryStats() {
        return Map.of(
                Status.DEFENCE_PERCENT, 20.0,
                Status.MOVE_SPEED, 10.0
        );
    }
}
