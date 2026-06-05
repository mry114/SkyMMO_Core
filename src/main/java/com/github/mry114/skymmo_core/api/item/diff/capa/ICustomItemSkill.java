package com.github.mry114.skymmo_core.api.item.diff.capa;

import com.github.mry114.skymmo_core.api.item.diff.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.can.IItemSkill;
import org.jetbrains.annotations.Nullable;

public interface ICustomItemSkill extends ICustomItem {
    /**
     * アイテムのスキルの定義を返します。
     */
    @Nullable IItemSkill getItemSkill();
}
