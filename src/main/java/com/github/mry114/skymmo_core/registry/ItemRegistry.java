package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.data.item.Armor.ExampleArmor;
import com.github.mry114.skymmo_core.data.item.Weapon.ExampleWeapon;
import com.github.mry114.skymmo_core.data.item.material.ExampleItem;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    // シンプルアイテム
    public static final ICustomItem EXAMPLE_ITEM = register(new ExampleItem());

    // 武器
    public static final ICustomItem EXAMPLE_WEAPON = register(new ExampleWeapon());

    // 防具
    public static final ICustomItem EXAMPLE_ARMOR  = register(new ExampleArmor());


    private static final Map<Integer, ICustomItem> REGISTRY = new HashMap<>();

    private static <T extends ICustomItem> T register(T item) {
        if (REGISTRY != null) {
            REGISTRY.put(item.getId(), item);
        }
        return item;
    }

    public static ICustomItem getById(int id) {
        return REGISTRY.get(id);
    }
}
