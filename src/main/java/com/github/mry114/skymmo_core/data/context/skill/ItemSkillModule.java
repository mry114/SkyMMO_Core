package com.github.mry114.skymmo_core.data.context.skill;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.module.processor.IItemUpdater;
import com.github.mry114.skymmo_core.core.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.core.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.core.context.ItemGeneratorContext;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemSkillModule implements IItemModule {
    @Override
    public @Nullable IItemReader getItemReader() {
        return IItemModule.super.getItemReader();
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return IItemModule.super.getItemProcessor();
    }

    @Override
    public @Nullable IItemCalculator getItemCalculator() {
        return IItemModule.super.getItemCalculator();
    }

    @Override
    public @Nullable IItemUpdater getItemUpdater() {
        return IItemModule.super.getItemUpdater();
    }

    private static class ItemSkillLogic implements IItemProcessor {

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            MetaDataUtil meta = new MetaDataUtil(context.getItemStack());

            if (customItem instanceof ICustomItemSkill skill) {
                IItemSkill itemSkill = skill.getItemSkill();
                if (itemSkill == null) {
                    return;
                }

                List<Component> allLore = new ArrayList<>(List.of(
                        Component.text("[", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)
                                .append(Component.text(" Skill ", TextColor.color(0xFFAA00)).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.ITALIC, false))
                                .append(Component.text("]", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false))
                ));

                allLore.addAll(itemSkill.getSkillLore());

                meta.setLore(allLore);
            }
        }
    }
}
