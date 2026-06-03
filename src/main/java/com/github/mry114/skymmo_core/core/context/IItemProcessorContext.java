package com.github.mry114.skymmo_core.core.context;

import com.github.mry114.skymmo_core.api.module.context.IItemBaseContext;
import com.github.mry114.skymmo_core.util.LoreUtil;
import org.bukkit.inventory.ItemStack;

public interface IItemProcessorContext extends IItemBaseContext {
    public ItemStack getItemStack();
    public LoreUtil getLoreUtil();
}
