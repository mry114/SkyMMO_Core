package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.enchant.IEnchant;
import com.github.mry114.skymmo_core.content.enchant.ExampleEnchant;

import java.util.HashMap;
import java.util.Map;

public class EnchantRegistry {
    private static final Map<Integer, IEnchant> REGISTRY = new HashMap<>();

    public static final IEnchant EXAMPLE_ATTRIBUTE = register(new ExampleEnchant());

    private static <T extends IEnchant> T register(T enchant) {
        REGISTRY.put(enchant.getId(), enchant);
        return enchant;
    }

    public static IEnchant getById(int id) {
        return REGISTRY.get(id);
    }
}