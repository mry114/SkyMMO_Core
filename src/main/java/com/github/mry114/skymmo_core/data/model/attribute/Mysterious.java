package com.github.mry114.skymmo_core.data.model.attribute;

import com.github.mry114.skymmo_core.core.attribute.EquipmentAttribute;
import com.github.mry114.skymmo_core.data.type.Status;
import com.github.mry114.skymmo_core.util.status.StatusContainer;
import net.kyori.adventure.text.Component;

public class Mysterious extends EquipmentAttribute {
    public Mysterious() {
        super(1, Component.text("Mysterious"), new StatusContainer.Builder()
                .add(Status.ATTACK_PERCENT, 0.3)
                .add(Status.CRITICAL_CHANCE, 0.12)
                .add(Status.CRITICAL_DAMAGE, 0.4)
                .build()
        );
    }
}
