package com.github.mry114.skymmo_core.data.item.context.skill;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.diff.can.IItemSkill;
import com.github.mry114.skymmo_core.api.item.diff.capa.ICustomItemSkill;
import com.github.mry114.skymmo_core.api.item.module.IItemModule;
import com.github.mry114.skymmo_core.api.item.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.core.item.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ItemSkillModule implements IItemModule {
    private static final ItemSkillModule INSTANCE = new ItemSkillModule();
    private final ItemSkillLogic logic;

    private ItemSkillModule() {
        this.logic = new ItemSkillLogic();
    }

    public static ItemSkillModule getInstance() {
        return INSTANCE;
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return logic;
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
                                .append(Component.text(" Skill Description ", TextColor.color(0xFFAA00)).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.ITALIC, false))
                                .append(Component.text("]", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false))
                ));

                allLore.addAll(itemSkill.getSkillLore());
                allLore.add(Component.empty());

                meta.loreAddAll(allLore);
                meta.setItemMeta();
            }
        }
    }
}
