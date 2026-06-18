package com.github.mry114.skymmo_core.api.item.content.diff.capa;

import com.github.mry114.skymmo_core.core.player.element.ElementData;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ICustomItemPassive {
    @NotNull List<ElementData> getPassiveElementData();
}
