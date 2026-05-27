package com.github.mry114.skymmo_core.api.item.Equipment.capa;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;

import javax.annotation.Nullable;
import java.util.List;

public interface IEquipmentAttribute {
    /**
     * 装備品についた修飾子を返します
     */
    @Nullable
    List<IAttribute> canAttributeType();
}
