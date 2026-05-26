package com.github.mry114.skymmo_core.core.lore.module;

import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.api.attribute.IAttribute;
import com.github.mry114.skymmo_core.api.item.ILoreModule;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

import java.util.ArrayList;
import java.util.List;

public class MainStatusLoreModule implements ILoreModule {
    private final StatusContainer container;
    private final IAttribute attribute;

    MainStatusLoreModule(StatusContainer container, IAttribute attribute) {
        this.container = container;
        this.attribute = attribute;
    }

    @Override
    public List<Component> build() {
        List<Component> components = new ArrayList<>();

        for (Status status : Status.values()) {
            double containerIndex = container.get(status);
            double attributeIndex = attribute.getAddStatus().get(status);

            if (!(containerIndex == 0 && attributeIndex == 0)) {
                components.add(Component
                        .text(status.name() + ": " +containerIndex + " +" + attributeIndex)
                        .color(TextColor.color(255, 255, 255))
                );
            }
        }

        return components;
    }
}
