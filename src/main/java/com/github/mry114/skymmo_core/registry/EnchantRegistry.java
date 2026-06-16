package com.github.mry114.skymmo_core.registry;

import com.github.mry114.skymmo_core.api.enchant.IEnchant;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnchantRegistry {
    private static final EnchantRegistry INSTANCE = new EnchantRegistry();

    public static EnchantRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, IEnchant> registry = new HashMap<>();

    private EnchantRegistry() {}

    public void loadAll(JavaPlugin plugin) {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            List<Class<IEnchant>> classes = scanResult
                    .getClassesImplementing(IEnchant.class.getName())
                    .getStandardClasses()
                    .loadClasses(IEnchant.class);

            for (Class<IEnchant> clazz : classes) {
                try {
                    IEnchant enchant = clazz.getDeclaredConstructor().newInstance();
                    this.registry.put(enchant.getId(), enchant);

                    plugin.getLogger().info("Sky_MMO_Enchant: " + clazz.getSimpleName() + " (ID: " + enchant.getId() + ")");
                } catch (Exception e) {
                    plugin.getLogger().severe("クラスの初期化に失敗: " + clazz.getName() + " -> " + e.getMessage());
                }
            }
        }
    }

    public static IEnchant getById(int id) {
        return INSTANCE.registry.get(id);
    }
}