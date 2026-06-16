package com.github.mry114.skymmo_core.model.enchant;


import java.awt.*;

public enum EnchantTier {
    NORMAL(new Color(71, 110, 239), new Color(251, 167, 6)),
    ULTIMATE(new Color(201, 0, 255), new Color(225, 50, 50)),
    ;

    private final Color normalColor;
    private final Color maxLevelColor;

    EnchantTier(Color normalColor, Color maxLevelColor) {
        this.normalColor = normalColor;
        this.maxLevelColor = maxLevelColor;
    }

    public Color getNormalColor() {
        return normalColor;
    }

    public Color getMaxLevelColor() {
        return maxLevelColor;
    }
}
