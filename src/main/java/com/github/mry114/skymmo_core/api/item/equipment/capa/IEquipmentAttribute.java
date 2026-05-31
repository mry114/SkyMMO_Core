package com.github.mry114.skymmo_core.api.item.equipment.capa;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.api.item.equipment.IEquipmentItem;

import javax.annotation.Nullable;
import java.util.List;

public interface IEquipmentAttribute extends IEquipmentItem {
    /**
     * 装備品についた修飾子を返します
     */
    @Nullable
    List<IAttribute> canAttributeType();
}
