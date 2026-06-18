package com.github.mry114.skymmo_core.handler.item.context.enchant;

import com.github.mry114.skymmo_core.api.enchant.IEnchant;
import com.github.mry114.skymmo_core.api.item.content.ICustomItem;
import com.github.mry114.skymmo_core.api.item.content.module.IItemModule;
import com.github.mry114.skymmo_core.api.item.content.module.context.IItemCalculatorContext;
import com.github.mry114.skymmo_core.api.item.content.module.context.IItemProcessorContext;
import com.github.mry114.skymmo_core.api.item.content.module.context.IItemReaderContext;
import com.github.mry114.skymmo_core.api.item.content.module.context.IItemUpdaterContext;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemCalculator;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.item.content.module.processor.IItemUpdater;
import com.github.mry114.skymmo_core.core.item.context.*;
import com.github.mry114.skymmo_core.handler.pdc.converter.EnchantConvertData;
import com.github.mry114.skymmo_core.model.item.ItemGroup;
import com.github.mry114.skymmo_core.register.content.EnchantRegistry;
import com.github.mry114.skymmo_core.util.MetaDataUtil;
import com.github.mry114.skymmo_core.util.RomanNumeralConverter;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ItemEnchantModule implements IItemModule {
    private static final ItemEnchantModule INSTANCE = new ItemEnchantModule();
    private final ItemEnchantLogic logic;

    private ItemEnchantModule() {
        this.logic = new ItemEnchantLogic();
    }

    public static ItemEnchantModule getInstance() {
        return INSTANCE;
    }

    @Override
    public @Nullable IItemUpdater getItemUpdater() {
        return logic;
    }

    @Override
    public @Nullable IItemReader getItemReader() {
        return logic;
    }

    @Override
    public @Nullable IItemCalculator getItemCalculator() {
        return logic;
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return logic;
    }

    private static class ItemEnchantLogic implements IItemReader,  IItemUpdater, IItemCalculator, IItemProcessor {

        @Override
        public void calculate(ICustomItem customItem, ItemGeneratorContext generator, IItemCalculatorContext context) {
            context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, generator.get(ItemEnchantModuleKeys.ITEM_ENCHANT));
        }

        @Override
        public void process(ICustomItem customItem, IItemProcessorContext context) {
            List<EnchantConvertData> sourceData = context.get(ItemEnchantModuleKeys.ITEM_ENCHANT);
            if (sourceData == null || sourceData.isEmpty()) {
                return;
            }

            Map<Integer, Integer> enchantMap = new LinkedHashMap<>();
            for (EnchantConvertData data : sourceData) {
                int currentLevel = enchantMap.getOrDefault(data.getId(), 0);
                enchantMap.put(data.getId(), currentLevel + data.getLevel());
            }

            List<EnchantConvertData> finalData = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : enchantMap.entrySet()) {
                finalData.add(new EnchantConvertData(entry.getKey(), entry.getValue()));
            }

            MetaDataUtil meta = new MetaDataUtil(context.getItemStack());
            List<Component> newLore = new ArrayList<>();

            newLore.add(Component.text("[", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)
                    .append(Component.text(" Enchant ", TextColor.color(0xFFAA00)).decoration(TextDecoration.BOLD, false).decoration(TextDecoration.ITALIC, false))
                    .append(Component.text("]", TextColor.color(0xFFFF55)).decorate(TextDecoration.BOLD).decoration(TextDecoration.ITALIC, false)));

            int index = 0;
            for (EnchantConvertData data : finalData) {
                IEnchant enchant = EnchantRegistry.getById(data.getId());
                if (enchant == null) {
                    continue;
                }

                Color color = enchant.getTier().getNormalColor();
                if (data.getLevel() >= enchant.getMaxLevel()) {
                    color = enchant.getTier().getMaxLevelColor();
                }
                Component nameLore;
                if (index == 0) {
                    nameLore = enchant.getEnchantName();
                } else {
                    nameLore = Component.text(", ").append(enchant.getEnchantName());
                }
                newLore.add(
                        nameLore.append(Component.text(" " + RomanNumeralConverter.toRoman(data.getLevel()) + " "))
                                .color(TextColor.color(color.getRGB()))
                                .decoration(TextDecoration.BOLD, false)
                                .decoration(TextDecoration.ITALIC, false)
                );
                if (customItem.getItemType().getItemGroup() == ItemGroup.ENCHANTED_BOOK) {
                    newLore.addAll(EnchantRegistry.getById(data.getId()).getEnchantLore());
                }
                index++;
            }
            newLore.add(Component.empty());

            meta.getPDC().set(ItemEnchantModuleKeys.PDC_ENCHANT_DATA, finalData);
            meta.loreAddAll(newLore);
            meta.setItemMeta();
        }

        @Override
        public void reader(ICustomItem customItem, ItemStack itemStack, IItemReaderContext context) {
            PDCWrapper pdc = new PDCWrapper(itemStack.getItemMeta());
            context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, pdc.get(ItemEnchantModuleKeys.PDC_ENCHANT_DATA));
        }

        @Override
        public void updater(ICustomItem customItem, @NotNull ItemUpdaterContext updater, IItemUpdaterContext context) {
            List<EnchantConvertData> newList = context.get(ItemEnchantModuleKeys.ITEM_ENCHANT);
            newList.addAll(updater.get(ItemEnchantModuleKeys.ITEM_ENCHANT));
            context.put(ItemEnchantModuleKeys.ITEM_ENCHANT, newList);
        }
    }
}
