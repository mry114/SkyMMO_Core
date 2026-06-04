package com.github.mry114.skymmo_core.core.attribute;

import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.util.status.StatusContainer;
import net.kyori.adventure.text.Component;

public abstract class EquipmentAttribute implements IAttribute {
    private final int id;
    private final Component name;
    private final StatusContainer statusContainer;

    public EquipmentAttribute(int id, Component name, StatusContainer statusContainer) {
        this.id = id;
        this.name = name;
        this.statusContainer = statusContainer;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Component getDisplayName() {
        return name;
    }

    @Override
    public StatusContainer getAddStatus() {
        return statusContainer;
    }
}
