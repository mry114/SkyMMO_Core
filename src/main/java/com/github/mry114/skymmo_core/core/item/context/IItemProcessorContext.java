package com.github.mry114.skymmo_core.core.item.context;

import com.github.mry114.skymmo_core.api.item.module.context.IItemBaseContext;
import org.bukkit.inventory.ItemStack;

public interface IItemProcessorContext extends IItemBaseContext {
    public ItemStack getItemStack();
}
