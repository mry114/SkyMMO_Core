package com.github.mry114.skymmo_core.register.content;

import com.github.mry114.skymmo_core.api.mob.ICustomMob;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MobRegistry {
    private static final MobRegistry INSTANCE = new MobRegistry();

    public static MobRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, ICustomMob> registry = new HashMap<>();

    private MobRegistry() {}

    public void loadAll(JavaPlugin plugin) {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            List<Class<ICustomMob>> classes = scanResult
                    .getClassesImplementing(ICustomMob.class.getName())
                    .getStandardClasses()
                    .loadClasses(ICustomMob.class);

            for (Class<ICustomMob> clazz : classes) {
                try {
                    int modifiers = clazz.getModifiers();

                    if (java.lang.reflect.Modifier.isAbstract(modifiers) || clazz.isAnonymousClass()) {
                        continue;
                    }

                    ICustomMob mob = clazz.getDeclaredConstructor().newInstance();
                    this.registry.put(mob.getId(), mob);

                    plugin.getLogger().info("Sky_MMO_Mob: " + clazz.getSimpleName() + " (ID: " + mob.getId() + ")");
                } catch (Exception e) {
                    plugin.getLogger().severe("クラスの初期化に失敗: " + clazz.getName() + " -> " + e.getMessage());
                }
            }
        }
    }

    public static ICustomMob getById(int id) {
        return INSTANCE.registry.get(id);
    }
}
