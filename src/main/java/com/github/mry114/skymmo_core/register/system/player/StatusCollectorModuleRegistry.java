package com.github.mry114.skymmo_core.register.system.player;

import com.github.mry114.skymmo_core.api.player.data.IElementCollectorModule;
import com.github.mry114.skymmo_core.api.player.data.IStatusCollectorModule;
import com.github.mry114.skymmo_core.api.registry.IModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.List;
import java.util.Objects;

public class StatusCollectorModuleRegistry implements IModuleRegistry<IStatusCollectorModule> {
    private final List<IStatusCollectorModule> modules;

    StatusCollectorModuleRegistry() {
        List<IStatusCollectorModule> modules;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            modules = scanResult.getClassesImplementing(IStatusCollectorModule.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IStatusCollectorModule) clazz.getDeclaredConstructor().newInstance();
                        } catch (Exception e) {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .toList();
        }

        this.modules = modules;
    }

    public List<IStatusCollectorModule> getModuleClass() {
        return modules;
    }
}
