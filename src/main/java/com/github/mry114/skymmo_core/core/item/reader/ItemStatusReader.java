package com.github.mry114.skymmo_core.core.item.reader;

import com.github.mry114.skymmo_core.api.item.reader.IItemStatusReaderModule;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

public class ItemStatusReader {
    public static StatusContainer read(@NotNull ItemStack itemStack) {
        List<IItemStatusReaderModule> modules;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            modules = scanResult.getClassesImplementing(IItemStatusReaderModule.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IItemStatusReaderModule) clazz.getDeclaredConstructor().newInstance();
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
        }

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
