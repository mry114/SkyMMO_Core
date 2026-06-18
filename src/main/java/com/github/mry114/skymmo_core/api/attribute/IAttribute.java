package com.github.mry114.skymmo_core.api.attribute;

import com.github.mry114.skymmo_core.api.type.IAttributeType;
import com.github.mry114.skymmo_core.core.player.status.StatusContainer;
import net.kyori.adventure.text.Component;

public interface IAttribute {

    /**
     * 修飾子全体の固有IDを返します
     */
    int getId();

    /**
     * 修飾子の表示名を返します
     */
    Component getDisplayName();

    /**
     * 修飾子が付与された時の加算ステータスを返します
     */
    StatusContainer getAddStatus();

    /**
     * 修飾子のタイプを返します
     */
    IAttributeType<? extends Enum<?>> getAttributeType();
}
