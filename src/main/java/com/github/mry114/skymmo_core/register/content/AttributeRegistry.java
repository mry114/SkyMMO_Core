package com.github.mry114.skymmo_core.register.content;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttributeRegistry {
    private static final AttributeRegistry INSTANCE = new AttributeRegistry();

    public static AttributeRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, IAttribute> registry = new HashMap<>();

    private AttributeRegistry() {}

    public void loadAll(JavaPlugin plugin) {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            List<Class<IAttribute>> classes = scanResult
                    .getClassesImplementing(IAttribute.class.getName())
                    .getStandardClasses()
                    .loadClasses(IAttribute.class);

            for (Class<IAttribute> clazz : classes) {
                try {
                    int modifiers = clazz.getModifiers();

                    if (java.lang.reflect.Modifier.isAbstract(modifiers) || clazz.isAnonymousClass()) {
                        continue;
                    }

                    IAttribute attribute = clazz.getDeclaredConstructor().newInstance();
                    this.registry.put(attribute.getId(), attribute);

                    plugin.getLogger().info("Sky_MMO_Attribute: " + clazz.getSimpleName() + " (ID: " + attribute.getId() + ")");
                } catch (Exception e) {
                    plugin.getLogger().severe("クラスの初期化に失敗: " + clazz.getName() + " -> " + e.getMessage());
                }
            }
        }
    }

    public static IAttribute getById(int id) {
        return INSTANCE.registry.get(id);
    }
}
