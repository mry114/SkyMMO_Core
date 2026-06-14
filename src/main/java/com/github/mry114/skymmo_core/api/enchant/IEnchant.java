package com.github.mry114.skymmo_core.api.enchant;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.core.player.element.ElementData;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IEnchant {
    int getId();

    @NotNull Component getEnchantName();

    @NotNull List<Component> getEnchantLore();

    int getMaxLevel();

    @NotNull List<ElementData> getElements();

    boolean getUseTargetTypeBool(IItemType<?> type);
}
