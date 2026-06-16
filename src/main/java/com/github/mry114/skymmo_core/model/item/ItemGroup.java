package com.github.mry114.skymmo_core.model.item;

import com.github.mry114.skymmo_core.api.type.IItemGroup;

public enum ItemGroup implements IItemGroup<ItemGroup> {
    ITEM,
    ENCHANTED_BOOK,
    WEAPON,
    ARMOR,
    ACCESSORY
    ;

    @Override
    public String getName() {
        return name().replace("_", " ");
    }
}
