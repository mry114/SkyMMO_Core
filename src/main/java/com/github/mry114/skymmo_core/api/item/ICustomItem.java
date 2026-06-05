package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.data.type.ItemGroup;
import com.github.mry114.skymmo_core.data.type.Rarity;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.inventory.ItemType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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

    /**
     * アイテムのItemTypeを返します。
     */
    @NotNull IItemType getItemType();

    /**
     * アイテムを生成するときに、ItemStackに固める時の処理にどのProcessorを要求するかを返します。
     */
    @NotNull List<IItemModule> getProcessorModule();
}
