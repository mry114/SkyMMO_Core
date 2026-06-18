package com.github.mry114.skymmo_core.api.item.content.diff.equipment;

import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import org.jetbrains.annotations.NotNull;

public interface IEquipmentSubStatus extends IEquipmentItem {
    /**
     * アイテムのサブステータスを返します
     * 外部での決定や、アイテムごとに自由に値を決定できるサブステータスとして使用することを想定しています
     */
    @NotNull StatusContainer getSubStatus();
}
