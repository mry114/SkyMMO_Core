package com.github.mry114.skymmo_core.core.lore.renderer;

import com.github.mry114.skymmo_core.api.Status;
import com.github.mry114.skymmo_core.api.lore.ILoreRenderer;
import com.github.mry114.skymmo_core.util.StatusContainer;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

import java.util.ArrayList;
import java.util.List;

public class MainStatusRenderer implements ILoreRenderer {
    private final StatusContainer mainStatus;

    MainStatusRenderer(StatusContainer mainStatus) {
        this.mainStatus = mainStatus;
    }

    @Override
    public List<Component> build() {
        List<Component> components = new ArrayList<>();

        for (Status status : Status.values()) {
            double containerIndex = mainStatus.get(status);

            if (containerIndex != 0) {
                components.add(Component
                        .text(status.name() + ": " +containerIndex)
                        .color(TextColor.color(255, 255, 255))
                );
            }
        }

        return components;
    }
}
