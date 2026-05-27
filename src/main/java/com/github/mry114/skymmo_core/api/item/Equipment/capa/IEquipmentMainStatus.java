package com.github.mry114.skymmo_core.api.item.Equipment.capa;

import com.github.mry114.skymmo_core.util.StatusContainer;
import org.jetbrains.annotations.NotNull;

public interface IEquipmentMainStatus {
    /**
     * アイテムの固定メインステータスを返します。
     * BaseStatusとは別物となり、主にパーセントとして表記されるステータスをこれで返すことを想定しています。
     */
    @NotNull StatusContainer getMainStatus();
}
