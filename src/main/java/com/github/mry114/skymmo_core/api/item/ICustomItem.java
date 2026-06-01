package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.api.Rarity;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
     * アイテムの使用条件の定義を返します。
     */
    @Nullable IUseRequirement getRequirement();

    /**
     * アイテムのスキルの定義を返します。
     */
    @Nullable IItemSkill getItemSkill();

    /**
     * アイテムを生成するときに、ItemStackに固める時の処理にどのProcessorを要求するかを返します。
     */
    @NotNull List<IItemProcessorModule> getProcessorModule();
}
