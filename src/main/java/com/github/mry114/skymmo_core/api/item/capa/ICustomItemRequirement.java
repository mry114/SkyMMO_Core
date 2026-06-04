package com.github.mry114.skymmo_core.api.item.capa;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.can.IUseRequirement;
import org.jetbrains.annotations.Nullable;

public interface ICustomItemRequirement extends ICustomItem {
    /**
     * アイテムの使用条件の定義を返します。
     */
    @Nullable IUseRequirement getRequirement();
}
