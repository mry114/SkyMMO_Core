package com.github.mry114.skymmo_core.handler.item.reader;

import com.github.mry114.skymmo_core.api.item.reader.IItemElementDataReaderModule;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ItemEnchantDataReader implements IItemElementDataReaderModule {
    @Override
    public @Nullable List<ElementData> getElements(ItemStack itemStack) {
        return List.of();
    }


}
