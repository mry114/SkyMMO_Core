package com.github.mry114.skymmo_core.api.item;

import com.github.mry114.skymmo_core.api.Status;
import net.kyori.adventure.text.Component;

import java.util.Map;

public interface IEquipmentItem extends ICustomItem {
    /**
     * アイテムのすべてのステータスを集計した結果を返します。
     */
    Map<Status, Double>  getAllStats();

    /**
     * アイテムのLoreを返します
     */
    Component getLore();
}