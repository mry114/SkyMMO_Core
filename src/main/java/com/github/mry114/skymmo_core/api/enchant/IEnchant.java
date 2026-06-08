package com.github.mry114.skymmo_core.api.enchant;

import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IEnchant {
    int getId();

    @NotNull Component getEnchantName();

    @NotNull List<Component> getEnchantLore();
}
