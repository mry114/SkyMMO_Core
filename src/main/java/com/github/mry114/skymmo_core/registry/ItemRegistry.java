package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemRegistry {
    private static final ItemRegistry INSTANCE = new ItemRegistry();

    public static ItemRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, ICustomItem> registry = new HashMap<>();

    private ItemRegistry() {}

    public void loadAll(JavaPlugin plugin) {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            List<Class<ICustomItem>> classes = scanResult
                    .getClassesImplementing(ICustomItem.class.getName())
                    .getStandardClasses()
                    .loadClasses(ICustomItem.class);

            for (Class<ICustomItem> clazz : classes) {
                try {
                    ICustomItem item = clazz.getDeclaredConstructor().newInstance();
                    this.registry.put(item.getId(), item);

                    plugin.getLogger().info("Sky_MMO_Item: " + clazz.getSimpleName() + " (ID: " + item.getId() + ")");
                } catch (Exception e) {
                    plugin.getLogger().severe("クラスの初期化に失敗: " + clazz.getName() + " -> " + e.getMessage());
                }
            }
        }
    }

    public static ICustomItem getById(int id) {
        return INSTANCE.registry.get(id);
    }
}
