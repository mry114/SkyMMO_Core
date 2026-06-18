package com.github.mry114.skymmo_core.core.player.collector;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.data.IElementCollectorModule;
import com.github.mry114.skymmo_core.core.player.cache.ElementCache;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import org.bukkit.entity.Player;

import java.util.*;

public class ElementCollector {
    public static void collectElementData(Player player) {
        List<IElementCollectorModule> modules;

        try (ScanResult scanResult = new ClassGraph()
                .enableAllInfo()
                .acceptPackages("com.github.mry114.skymmo_core")
                .scan()) {

            modules = scanResult.getClassesImplementing(IElementCollectorModule.class.getName())
                    .filter(classInfo -> !classInfo.isAbstract())
                    .stream()
                    .map(classInfo -> {
                        try {
                            Class<?> clazz = classInfo.loadClass();
                            return (IElementCollectorModule) clazz.getDeclaredConstructor().newInstance();
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
