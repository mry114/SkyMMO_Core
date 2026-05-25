package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface IEquipmentItem extends ICustomItem {
    /**
     * アイテムのすべてのステータスを集計した結果を返します。
     */
    @NotNull StatusContainer getAllStats();

    /**
     * アイテムの説明文となるLoreを返します。
     */
    @NotNull List<Component> getLore();
}