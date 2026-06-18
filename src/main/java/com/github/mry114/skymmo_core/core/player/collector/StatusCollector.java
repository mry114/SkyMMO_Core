package com.github.mry114.skymmo_core.core.player.collector;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.data.IStatusCollectorModule;
import com.github.mry114.skymmo_core.core.player.cache.StatusCache;
import com.github.mry114.skymmo_core.register.system.player.ElementCollectorModuleRegistry;
import com.github.mry114.skymmo_core.register.system.player.StatusCollectorModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class StatusCollector {
    public static void collectStatus(Player player) {
        List<IStatusCollectorModule> modules = SkyMMO_Core.registry.get(StatusCollectorModuleRegistry.class).getModuleClass();

        if (modules.isEmpty()) {
            return;
        }
        UUID uuid = player.getUniqueId();
        StatusCache statusCache = SkyMMO_Core.statusCache;
        statusCache.removeStatus(uuid);

        for (IStatusCollectorModule module : modules) {
            statusCache.addStatus(uuid, module.getStatusData(player));
        }
    }
}
