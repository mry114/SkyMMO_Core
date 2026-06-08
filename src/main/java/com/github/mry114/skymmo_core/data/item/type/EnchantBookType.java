package com.github.mry114.skymmo_core.data.item.type;

import com.github.mry114.skymmo_core.api.type.IItemGroup;
import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.item.ItemGroup;

public enum EnchantBookType implements IItemType<EnchantBookType> {
    ENCHANT_BOOK_TYPE
    ;

    @Override
    public IItemGroup<ItemGroup> getItemGroup() {
        return ItemGroup.ENCHANTED_BOOK;
    }
}
