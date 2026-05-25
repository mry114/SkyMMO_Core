package com.github.mry114.skymmo_core.api.item;

import net.kyori.adventure.text.Component;

import java.util.List;

public interface ILoreModule {
    /**
     * Loreの一部となるComponentのListを返します。
     */
    List<Component> build();
}
