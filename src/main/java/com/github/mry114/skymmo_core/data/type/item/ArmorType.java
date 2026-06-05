package com.github.mry114.skymmo_core.data.type.item;

import com.github.mry114.skymmo_core.api.type.IItemGroup;
import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.type.ItemGroup;

public enum ArmorType implements IItemType<ArmorType> {
    HELMET,
    CHESTPLATE,
    LEGGINGS,
    BOOTS;

    @Override
    public IItemGroup<ItemGroup> getItemGroup() {
        return ItemGroup.ARMOR;
    }
}
