package com.github.mry114.skymmo_core.content.attribute;

import com.github.mry114.skymmo_core.data.Status;
import com.github.mry114.skymmo_core.core.attribute.type.Attribute;
import com.github.mry114.skymmo_core.core.status.StatusContainer;
import net.kyori.adventure.text.Component;

public class ExampleAttribute extends Attribute {
    public ExampleAttribute() {
        super(0, Component.text("素早いテスト修飾子"), new StatusContainer.Builder()
                .add(Status.MOVE_SPEED, 0.5)
                .build()
        );
    }
}
