package com.github.mry114.skymmo_core.core.player.collector;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.data.IElementCollectorModule;
import com.github.mry114.skymmo_core.core.player.cache.ElementCache;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import com.github.mry114.skymmo_core.register.system.item.ItemStatusReaderModuleRegistry;
import com.github.mry114.skymmo_core.register.system.player.ElementCollectorModuleRegistry;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.entity.Player;

import java.util.*;

public class ElementCollector {
    public static void collectElementData(Player player) {
        List<IElementCollectorModule> modules = SkyMMO_Core.registry.get(ElementCollectorModuleRegistry.class).getModuleClass();

        if (modules.isEmpty()) {
            return;
        }
        ElementCache elementCache = SkyMMO_Core.elementCache;
        UUID uuid = player.getUniqueId();
        elementCache.removeElements(uuid);

        for (IElementCollectorModule module : modules) {
            List<ElementData> elementDats = module.getElementData(player);

            if (elementDats == null) continue;
            for (ElementData elementData : elementDats) {
                elementCache.addElement(uuid, elementData);
            }
        }
    }
}
