package com.github.mry114.skymmo_core.api.item.capa;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import org.jetbrains.annotations.Nullable;

public interface ICustomItemSkill extends ICustomItem {
    /**
     * アイテムのスキルの定義を返します。
     */
    @Nullable IItemSkill getItemSkill();
}
