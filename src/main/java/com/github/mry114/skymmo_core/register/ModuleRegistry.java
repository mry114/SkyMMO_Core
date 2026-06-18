package com.github.mry114.skymmo_core.register;

import com.github.mry114.skymmo_core.api.registry.IModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;

import java.util.ArrayList;
import java.util.List;

public class ModuleRegistry {
    private final List<IModuleRegistry<?>> registry;

    public ModuleRegistry() {
        // 最初から目的の型でリストを用意する
        List<IModuleRegistry<?>> tempRegistry = new ArrayList<>();

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            // ストリームは使わず、拡張for文で1つずつ安全に追加する
            scanResult.getClassesImplementing(IModuleRegistry.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .forEach(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            // 生タイプ（Raw Type）としてインスタンス化
                            Object instance = clazz.getDeclaredConstructor().newInstance();

                            if (instance instanceof IModuleRegistry<?> mod) {
                                tempRegistry.add(mod); // 型安全に追加
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
        }

        this.registry = tempRegistry;
    }

    public List<IModuleRegistry<?>> getRegister() {
        return registry;
    }

    @SuppressWarnings("unchecked")
    public <T extends IModuleRegistry<?>> T get(Class<T> clazz) {
        for (IModuleRegistry<?> mod : this.registry) {
            if (clazz.isInstance(mod)) {
                return (T) mod;
            }
        }
        return null;
    }
}
