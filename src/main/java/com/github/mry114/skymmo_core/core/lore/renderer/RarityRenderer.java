package com.github.mry114.skymmo_core.core.lore.renderer;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.lore.ILoreRenderer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.List;

public class RarityRenderer implements ILoreRenderer {
    private final Rarity rarity;

    public RarityRenderer(Rarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public List<Component> build() {
        return List.of(
                Component.text(rarity.name()).color(rarity.getColor()).decorate(TextDecoration.BOLD)
        );
    }
}
