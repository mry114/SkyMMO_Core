package com.github.mry114.skymmo_core.api.player.data;

import com.github.mry114.skymmo_core.api.system.IIgniterEvent;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.List;

public interface IElementCollectorModule extends IIgniterEvent {
    @Nullable List<ElementData> getElementData(Player player);
}
