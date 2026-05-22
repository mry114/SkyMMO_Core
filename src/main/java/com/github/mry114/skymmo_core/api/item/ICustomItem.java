package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.api.Rarity;
import org.bukkit.Material;

public interface ICustomItem {
    /**
     * アイテムのIdを返します。
     */
    int getId();

    /**
     * アイテムの名前を返します。
     */
    String getName();

    /**
     * アイテムのMaterialを返します
     */
    Material getMaterial();

    /**
     * アイテムのRarityを返します。
     */
    Rarity getRarity();
}
