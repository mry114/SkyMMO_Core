package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.data.item.context.basic.name.ItemNameModule;
import com.github.mry114.skymmo_core.data.item.context.basic.rarity.ItemRarityModule;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MaterialItem implements ICustomItem {

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
