package com.github.mry114.skymmo_core.data.type;

import net.kyori.adventure.text.format.TextColor;

public enum Rarity {
    COMMON(TextColor.color(170, 170, 170)),
    UNCOMMON(TextColor.color(85, 180, 85)),
    RARE(TextColor.color(85, 85, 255)),
    EPIC(TextColor.color(170, 10, 170)),
    LEGENDARY(TextColor.color(255, 170, 0)),
    MYTHIC(TextColor.color(255, 85, 255))
    ;

    private final TextColor color;

    Rarity(TextColor color) {
        this.color = color;
    }

    public TextColor getColor() {
        return color;
    }
}
