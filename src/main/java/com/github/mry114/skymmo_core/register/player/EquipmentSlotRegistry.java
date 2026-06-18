package com.github.mry114.skymmo_core.register.player;

import com.github.mry114.skymmo_core.api.player.IEquipmentSlot;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentSlotRegistry {
    private static final EquipmentSlotRegistry INSTANCE = new EquipmentSlotRegistry();

    public static EquipmentSlotRegistry getInstance() {
        return INSTANCE;
    }

    private final Map<Integer, IEquipmentSlot> registry = new HashMap<>();

    private EquipmentSlotRegistry() {}

    public void loadAll(JavaPlugin plugin) {
        try (ScanResult scanResult = new ClassGraph()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            List<Class<IEquipmentSlot>> classes = scanResult
                    .getClassesImplementing(IEquipmentSlot.class.getName())
                    .getStandardClasses()
                    .loadClasses(IEquipmentSlot.class);

            for (Class<IEquipmentSlot> clazz : classes) {
                try {
                    int modifiers = clazz.getModifiers();

                    if (java.lang.reflect.Modifier.isAbstract(modifiers) || clazz.isAnonymousClass()) {
                        continue;
                    }

                    IEquipmentSlot slot = clazz.getDeclaredConstructor().newInstance();
                    this.registry.put(slot.slotIndex(), slot);

                    plugin.getLogger().info("Sky_MMO_EquipmentSlot: " + clazz.getSimpleName() + " (Index: " + slot.slotIndex() + ")");
                } catch (Exception e) {
                    plugin.getLogger().severe("クラスの初期化に失敗: " + clazz.getName() + " -> " + e.getMessage());
                }
            }
        }
    }

    public static IEquipmentSlot getById(int id) {
        return INSTANCE.registry.get(id);
    }

    public static Map<Integer, IEquipmentSlot> getRegistry() {
        return INSTANCE.registry;
    }
}
