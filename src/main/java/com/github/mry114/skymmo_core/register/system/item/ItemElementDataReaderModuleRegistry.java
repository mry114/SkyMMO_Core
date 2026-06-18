package com.github.mry114.skymmo_core.register.system.item;

import com.github.mry114.skymmo_core.api.item.reader.IItemElementDataReaderModule;
import com.github.mry114.skymmo_core.api.registry.IModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.List;
import java.util.Objects;

public class ItemElementDataReaderModuleRegistry implements IModuleRegistry<IItemElementDataReaderModule> {
    private final List<IItemElementDataReaderModule> modules;

    ItemElementDataReaderModuleRegistry() {
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

        this.modules = modules;
    }

    public List<IItemElementDataReaderModule> getModuleClass() {
        return modules;
    }
}
