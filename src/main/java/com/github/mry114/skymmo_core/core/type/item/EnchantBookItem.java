package com.github.mry114.skymmo_core.core.type.item;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemEnchant;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.handler.item.context.enchant.ItemEnchantModule;
import com.github.mry114.skymmo_core.handler.item.context.name.ItemNameModule;
import com.github.mry114.skymmo_core.handler.item.context.rarity.ItemRarityModule;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class EnchantBookItem implements ICustomItem, ICustomItemEnchant {

    @Override
    public @NotNull List<IItemModule> getProcessorModule() {
        return List.of(
                ItemNameModule.getInstance(),
                ItemEnchantModule.getInstance(),
                ItemRarityModule.getInstance()
        );
    }
}
