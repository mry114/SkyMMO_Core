package com.github.mry114.skymmo_core.api.item.reader;

import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public interface IItemStatusReaderModule {
    @Nullable StatusContainer getStatus(ItemStack itemStack);
}
