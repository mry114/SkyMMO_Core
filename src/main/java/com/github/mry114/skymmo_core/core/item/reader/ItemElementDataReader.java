package com.github.mry114.skymmo_core.core.item.reader;

import com.github.mry114.skymmo_core.api.item.reader.IItemElementDataReaderModule;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemElementDataReader {
    public static List<ElementData> read(@NotNull ItemStack itemStack) {
        List<IItemElementDataReaderModule> modules;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            modules = scanResult.getClassesImplementing(IItemElementDataReaderModule.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IItemElementDataReaderModule) clazz.getDeclaredConstructor().newInstance();
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
        List<ElementData> elementDataList = new ArrayList<>();
        for (IItemElementDataReaderModule module : modules) {
            List<ElementData> elements = module.getElements(itemStack);
            if (elements != null) {
                elementDataList.addAll(elements);
            }
        }

        return elementDataList;
    }
}
