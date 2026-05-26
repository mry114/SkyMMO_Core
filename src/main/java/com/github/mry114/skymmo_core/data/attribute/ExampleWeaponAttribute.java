package com.github.mry114.skymmo_core.data.attribute;

import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.attribute.impl.WeaponAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleWeaponAttribute extends WeaponAttribute {
    protected ExampleWeaponAttribute(int id, Component name, StatusContainer statusContainer) {
        super(1, Component.text("強いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.ATTACK, 20.0)
                .build()
        );
    }
}
