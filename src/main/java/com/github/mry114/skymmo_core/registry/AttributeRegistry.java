package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.content.attribute.ExampleAttribute;

import java.util.HashMap;
import java.util.Map;

public class AttributeRegistry {
    private static final Map<Integer, IAttribute> REGISTRY = new HashMap<>();

    public static final IAttribute EXAMPLE_ATTRIBUTE = register(new ExampleAttribute());

    private static <T extends IAttribute> T register(T attribute) {
        REGISTRY.put(attribute.getId(), attribute);
        return attribute;
    }

    public static IAttribute getById(int id) {
        return REGISTRY.get(id);
    }
}
