package com.github.mry114.skymmo_core.api.item.diff.capa;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.type.IAttributeType;

import javax.annotation.Nullable;
import java.util.List;

public interface ICustomItemAttribute extends ICustomItem {
    /**
     * 装備品に付けれる修飾子を返します
     */
    @Nullable
    List<IAttributeType<? extends Enum<?>>> canAttributeType();
}
