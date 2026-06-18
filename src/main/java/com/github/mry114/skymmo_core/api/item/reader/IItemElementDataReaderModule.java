package com.github.mry114.skymmo_core.api.item.reader;

import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface IItemElementDataReaderModule {
    @Nullable List<ElementData> getElements(ItemStack itemStack);
}
