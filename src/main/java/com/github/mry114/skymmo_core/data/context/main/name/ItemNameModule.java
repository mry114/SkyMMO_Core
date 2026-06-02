package com.github.mry114.skymmo_core.data.context.main.name;

import com.github.mry114.skymmo_core.api.module.IItemModule;
import com.github.mry114.skymmo_core.api.module.processor.IItemProcessor;
import com.github.mry114.skymmo_core.api.module.processor.IItemReader;
import com.github.mry114.skymmo_core.api.module.processor.IItemUpdater;
import com.github.mry114.skymmo_core.core.context.*;
import com.github.mry114.skymmo_core.data.context.main.MainModuleKeys;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import com.github.mry114.skymmo_core.util.pdc.PDCWrapper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

public class ItemNameModule implements IItemModule {
    private final ItemNameLogic logic;

    private ItemNameModule() {
        this.logic = new ItemNameLogic();
    }

    @Override
    public @Nullable IItemReader getItemReader() {
        return logic;
    }

    @Override
    public @Nullable IItemUpdater getItemUpdater() {
        return logic;
    }

    @Override
    public @Nullable IItemProcessor getItemProcessor() {
        return logic;
    }

    private static class ItemNameLogic implements IItemReader, IItemUpdater, IItemProcessor {
        @Override
        public void process(ItemContext context) {

        }

        @Override
        public void read(ItemStack itemStack, IItemReaderContext context) {

        }

        @Override
        public void updater(ItemGeneratorContext generator, IItemUpdaterContext context) {

        }
    }
}
