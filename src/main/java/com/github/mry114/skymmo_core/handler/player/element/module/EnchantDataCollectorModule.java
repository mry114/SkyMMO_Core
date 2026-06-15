package com.github.mry114.skymmo_core.handler.player.element.module;

import com.github.mry114.skymmo_core.api.player.IElementCollectorModule;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class EnchantDataCollectorModule implements IElementCollectorModule {
    @Override
    public @Nullable List<ElementData> getElementData(Player player) {
        return List.of();
    }
}
