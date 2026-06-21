package com.github.mry114.skymmo_core.api.item.content;

import com.github.mry114.skymmo_core.api.type.IItemType;
import com.github.mry114.skymmo_core.model.item.Rarity;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ICustomItem {
    /**
     * アイテムのIdを返します
     */
    int getId();

    /**
     * アイテムの名前を返します
     */
    @NotNull Component getName();

    /**
     * アイテムのMaterialを返します
     */
    @NotNull Material getMaterial();

    /**
     * アイテムのRarityを返します
     */
    @NotNull Rarity getRarity();

    /**
     * アイテムのItemTypeを返します
     */
    @NotNull IItemType<?> getItemType();

    /**
     * アイテムを生成するときに、ItemStackに固める時の処理にどのProcessorを要求するかを返します
     */
    @NotNull List<IItemModule> getProcessorModule();
}
