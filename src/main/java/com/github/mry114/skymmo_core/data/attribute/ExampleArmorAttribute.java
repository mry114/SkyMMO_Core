package com.github.mry114.skymmo_core.data.attribute;

import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.core.attribute.impl.ArmorAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleArmorAttribute extends ArmorAttribute {
    protected ExampleArmorAttribute(int id, Component name, StatusContainer statusContainer) {
        super(1, Component.text("固いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.DEFENCE, 20.0)
                .build()
        );
    }
}
