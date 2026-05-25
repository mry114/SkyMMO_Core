package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.api.Rarity;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

public interface ICustomItem {
    /**
     * アイテムのIdを返します。
     */
    int getId();

    /**
     * アイテムの名前を返します。
     */
    @NotNull Component getName();

    /**
     * アイテムのMaterialを返します
     */
    @NotNull Material getMaterial();

    /**
     * アイテムのRarityを返します。
     */
    @NotNull Rarity getRarity();
}
