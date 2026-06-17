package com.github.mry114.skymmo_core.api.player;

import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;

public interface IElementCollectorModule {
    @Nullable List<ElementData> getElementData(Player player);
}
