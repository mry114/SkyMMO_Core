package com.github.mry114.skymmo_core.core.item.reader;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.item.reader.IItemStatusReaderModule;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import com.github.mry114.skymmo_core.register.system.item.ItemStatusReaderModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ItemStatusReader {
    public static StatusContainer read(@NotNull ItemStack itemStack) {
        List<IItemStatusReaderModule> modules = SkyMMO_Core.registry.get(ItemStatusReaderModuleRegistry.class).getModuleClass();

        if (modules.isEmpty()) {
            return null;
        }
        StatusContainer statusContainer = new StatusContainer.Builder().build();
        for (IItemStatusReaderModule module : modules) {
            StatusContainer status = module.getStatus(itemStack);
            if (status != null) {
                statusContainer = statusContainer.merge(status);
            }
        }

        return statusContainer;
    }
}
