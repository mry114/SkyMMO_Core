package com.github.mry114.skymmo_core.core.item;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.IItemProcessorModule;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class MaterialItem implements ICustomItem {

    @Override
    public @NotNull List<IItemProcessorModule> getProcessorModule() {
        return List.of(

        );
    }
}
