package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.content.item.armor.ExampleArmor;
import com.github.mry114.skymmo_core.content.item.weapon.ExampleWeapon;
import com.github.mry114.skymmo_core.content.item.material.ExampleItem;

import java.util.HashMap;
import java.util.Map;

public class ItemRegistry {
    private static final Map<Integer, ICustomItem> REGISTRY = new HashMap<>();

    // シンプルアイテム
    public static final ICustomItem EXAMPLE_ITEM = register(new ExampleItem());

    // 武器
    public static final ICustomItem EXAMPLE_WEAPON = register(new ExampleWeapon());

    // 防具
    public static final ICustomItem EXAMPLE_ARMOR  = register(new ExampleArmor());

    // 特殊アイテム
    public static final ICustomItem ENCHANT_BOOK  = register(new ExampleArmor());


    private static <T extends ICustomItem> T register(T item) {
        REGISTRY.put(item.getId(), item);
        return item;
    }

    public static ICustomItem getById(int id) {
        return REGISTRY.get(id);
    }
}
