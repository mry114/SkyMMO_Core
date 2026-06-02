package com.github.mry114.skymmo_core.core.item.type;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.data.context.main.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.context.main.rarity.ItemRarityModule;
import com.github.mry114.skymmo_core.data.type.ItemType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MaterialItem implements ICustomItem {

    @Override
    public @NotNull ItemType getItemType() {
        return ItemType.ITEM;
    }

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
