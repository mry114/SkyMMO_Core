package com.github.mry114.skymmo_core.api.item.diff.capa;

import com.github.mry114.skymmo_core.api.item.diff.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.can.IUseRequirement;
import org.jetbrains.annotations.Nullable;

public interface ICustomItemRequirement extends ICustomItem {
    /**
     * アイテムの使用条件の定義を返します。
     */
    @Nullable IUseRequirement getRequirement();
}
