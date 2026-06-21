package com.github.mry114.skymmo_core.api.item.content.capa;

import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
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
