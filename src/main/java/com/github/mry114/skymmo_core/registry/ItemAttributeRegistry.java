package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.data.model.attribute.ExampleAttribute;
import com.github.mry114.skymmo_core.data.model.attribute.Mysterious;

import java.util.HashMap;
import java.util.Map;

public class ItemAttributeRegistry {
    public static final IAttribute EXAMPLE_ATTRIBUTE = register(new ExampleAttribute());
    public static final IAttribute Mysterious = register(new Mysterious());

    private static final Map<Integer, IAttribute> REGISTRY = new HashMap<>();

    private static <T extends IAttribute> T register(T item) {
        if (REGISTRY != null) {
            REGISTRY.put(item.getId(), item);
        }
        return item;
    }

    public static IAttribute getById(int id) {
        return REGISTRY.get(id);
    }
}
