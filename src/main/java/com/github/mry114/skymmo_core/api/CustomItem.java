package com.github.mry114.skymmo_core.api;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface CustomItem {
    /**
     *
     * @return
     */
    public  int getId();

    /**
     *
     * @return
     */
    public String getName();

    /**
     *
     * @return
     */
    public ItemStack getItemStack();
}
