package com.github.mry114.skymmo_core.data.context.main.name;

import com.github.mry114.skymmo_core.core.context.key.ItemContextKey;
import com.github.mry114.skymmo_core.core.context.key.ItemGeneratorContextKey;
import net.kyori.adventure.text.Component;

public class ItemNameModuleKeys {
    public static final ItemGeneratorContextKey<Component> GENERATOR_ITEM_NAME = new ItemGeneratorContextKey<>("generator_item_name");

    public static final ItemContextKey<Component> ITEM_NAME = new ItemContextKey<>("item_name");
}
