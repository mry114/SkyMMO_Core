package com.github.mry114.skymmo_core.data.model.attribute;

import com.github.mry114.skymmo_core.core.attribute.EquipmentAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public class EmptyAttribute extends EquipmentAttribute {
    public EmptyAttribute() {
        super(0, Component.text(""), new StatusContainer.Builder()
                .build()
        );
    }
}