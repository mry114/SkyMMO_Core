package com.github.mry114.skymmo_core.data.model.attribute;

import com.github.mry114.skymmo_core.data.type.Status;
import com.github.mry114.skymmo_core.core.attribute.EquipmentAttribute;
import com.github.mry114.skymmo_core.util.status.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleAttribute extends EquipmentAttribute {
    public ExampleAttribute() {
        super(0, Component.text("素早いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.MOVE_SPEED, 0.5)
                .build()
        );
    }
}
