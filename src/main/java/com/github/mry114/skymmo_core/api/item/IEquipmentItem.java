package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

import java.util.List;
import java.util.Map;

public interface IEquipmentItem extends ICustomItem {
    /**
     * アイテムのすべてのステータスを集計した結果を返します。
     */
    StatusContainer getAllStats();

    /**
     * アイテムのLoreを返します
     */
    List<Component> getLore();
}