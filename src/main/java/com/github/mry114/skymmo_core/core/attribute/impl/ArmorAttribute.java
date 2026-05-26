package com.github.mry114.skymmo_core.core.attribute.impl;

import com.github.mry114.skymmo_core.core.attribute.bute.IArmorAttribute;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;

public abstract class ArmorAttribute implements IArmorAttribute {
    private final int id;
    private final Component name;
    private final StatusContainer statusContainer;

    protected ArmorAttribute(int id, Component name, StatusContainer statusContainer) {
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
