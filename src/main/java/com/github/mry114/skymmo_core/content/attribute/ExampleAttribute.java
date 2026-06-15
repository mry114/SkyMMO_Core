package com.github.mry114.skymmo_core.content.attribute;

import com.github.mry114.skymmo_core.api.type.IAttributeType;
import com.github.mry114.skymmo_core.model.status.Status;
import com.github.mry114.skymmo_core.core.type.attribute.Attribute;
import com.github.mry114.skymmo_core.core.status.StatusContainer;
import com.github.mry114.skymmo_core.model.attribute.AttributeType;
import net.kyori.adventure.text.Component;

public class ExampleAttribute extends Attribute {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Component getDisplayName() {
        return Component.text("テスト修飾子");
    }

    @Override
    public StatusContainer getAddStatus() {
        return new StatusContainer.Builder()
                .add(Status.MOVE_SPEED, 0.5)
                .build();
    }

    @Override
    public IAttributeType<? extends Enum<?>> getAttributeType() {
        return AttributeType.ALL;
    }
}
