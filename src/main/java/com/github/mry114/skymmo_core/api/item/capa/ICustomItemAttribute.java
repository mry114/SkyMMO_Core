package com.github.mry114.skymmo_core.api.item.capa;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.api.item.ICustomItem;

import javax.annotation.Nullable;
import java.util.List;

public interface ICustomItemAttribute extends ICustomItem {
    /**
     * 装備品についた修飾子を返します
     */
    @Nullable
    List<IAttribute> canAttributeType();
}
