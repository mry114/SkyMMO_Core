package com.github.mry114.skymmo_core.core.player.collector;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.data.IStatusCollectorModule;
import com.github.mry114.skymmo_core.core.player.cache.StatusCache;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StatusCollector {
    public static void collectStatus(Player player) {
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

        if (modules.isEmpty()) {
            return;
        }
        player.sendMessage("ステータス取得動作確認！");
        UUID uuid = player.getUniqueId();
        StatusCache statusCache = SkyMMO_Core.statusCache;
        statusCache.removeStatus(uuid);

        for (IStatusCollectorModule module : modules) {
            statusCache.addStatus(uuid, module.getStatusData(player));
        }
    }
}
