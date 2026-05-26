package com.github.mry114.skymmo_core.data.attribute;

import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.attribute.impl.EquipmentAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleEquipmentAttribute extends EquipmentAttribute {
    protected ExampleEquipmentAttribute(int id, Component name, StatusContainer statusContainer) {
        super(1, Component.text("素早いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.MOVE_SPEED, 0.5)
                .build()
        );
    }
}
