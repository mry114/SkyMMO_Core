package com.github.mry114.skymmo_core.content.mob;

import com.github.mry114.skymmo_core.api.mob.module.IMobModule;
import com.github.mry114.skymmo_core.core.type.mob.DummyMob;
import com.github.mry114.skymmo_core.handler.mob.module.hp.MobHpModule;
import com.github.mry114.skymmo_core.handler.mob.module.name.MobNameModule;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.EntityType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class StandardDummy extends DummyMob {
    @Override
    public int getId() {
        return 1;
    }

    @Override
    public @NotNull EntityType getType() {
        return EntityType.SKELETON;
    }

    @Override
    public @NotNull List<IMobModule> getProcessorModule() {
        return List.of(
                MobHpModule.getInstance(),
                MobNameModule.getInstance()
        );
    }

    @Override
    public Component getName() {
        return Component.text("Dummy", TextColor.color(255, 234, 0));
    }
}
