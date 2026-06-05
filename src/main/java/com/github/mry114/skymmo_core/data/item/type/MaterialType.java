package com.github.mry114.skymmo_core.data.item.type;

import com.github.mry114.skymmo_core.api.type.IItemGroup;
import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.item.ItemGroup;

public enum MaterialType implements IItemType<MaterialType> {
    ITEM;

    @Override
    public IItemGroup<ItemGroup> getItemGroup() {
        return ItemGroup.ITEM;
    }
}
