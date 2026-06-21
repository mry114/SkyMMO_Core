package com.github.mry114.skymmo_core.api.item.content.capa;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.content.can.IUseRequirement;
import org.jetbrains.annotations.NotNull;

public interface ICustomItemRequirement extends ICustomItem {
    /**
     * アイテムの使用条件の定義を返します
     */
    @NotNull IUseRequirement getRequirement();
}
