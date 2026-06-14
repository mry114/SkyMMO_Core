package com.github.mry114.skymmo_core.core.player.element;

import com.github.mry114.skymmo_core.SkyMMO_Core;
import com.github.mry114.skymmo_core.api.player.IElementCollectorModule;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.ServiceLoader;
import java.util.UUID;

public class ElementCollector {
    public void collectElementData(Player player) {
        ServiceLoader<IElementCollectorModule> modules = ServiceLoader.load(IElementCollectorModule.class);
        ElementContainer elementContainer = SkyMMO_Core.elementContainer;
        UUID uuid = player.getUniqueId();
        elementContainer.removeElements(uuid);

        for (IElementCollectorModule module : modules) {
            List<ElementData> elementDats = module.getElementData(player);

            if (elementDats == null) continue;
            for (ElementData elementData : elementDats) {
                elementContainer.addElement(uuid, elementData);
            }
        }
    }
}
