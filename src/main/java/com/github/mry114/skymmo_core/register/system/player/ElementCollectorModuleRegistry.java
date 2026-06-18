package com.github.mry114.skymmo_core.register.system.player;

import com.github.mry114.skymmo_core.api.item.reader.IItemStatusReaderModule;
import com.github.mry114.skymmo_core.api.player.data.IElementCollectorModule;
import com.github.mry114.skymmo_core.api.registry.IModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.List;
import java.util.Objects;

public class ElementCollectorModuleRegistry implements IModuleRegistry<IElementCollectorModule> {
    private final List<IElementCollectorModule> modules;

    public ElementCollectorModuleRegistry() {
        List<IElementCollectorModule> modules;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            modules = scanResult.getClassesImplementing(IElementCollectorModule.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IElementCollectorModule) clazz.getDeclaredConstructor().newInstance();
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
        }

        this.modules = modules;
    }

    public List<IElementCollectorModule> getModuleClass() {
        return modules;
    }
}
