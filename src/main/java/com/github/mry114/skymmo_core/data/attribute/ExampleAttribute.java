package com.github.mry114.skymmo_core.data.attribute;

import com.github.mry114.skymmo_core.data.type.Status;
import com.github.mry114.skymmo_core.core.attribute.EquipmentAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleAttribute extends EquipmentAttribute {
    public ExampleAttribute() {
        super(1, Component.text("素早いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.MOVE_SPEED, 0.5)
                .build()
        );
    }
}
