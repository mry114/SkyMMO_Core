package com.github.mry114.skymmo_core.api.lore;

import net.kyori.adventure.text.Component;

import java.util.List;

public interface ILoreRenderer {
    /**
     * Loreの一部となるComponentのListを返します。
     */
    List<Component> build();
}
