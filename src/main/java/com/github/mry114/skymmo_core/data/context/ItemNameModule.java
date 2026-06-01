package com.github.mry114.skymmo_core.data.context;

import com.github.mry114.skymmo_core.api.item.ICustomItem;
import com.github.mry114.skymmo_core.api.item.processor.IItemLoader;
import com.github.mry114.skymmo_core.core.context.Context;
import org.jetbrains.annotations.NotNull;

public class ItemNameModule {
    private final ItemNameLogic logic;

    private ItemNameModule() {
        this.logic = new ItemNameLogic();
    }

    public @NotNull IItemLoader getItemLoader() {}

    private static class ItemNameLogic implements IItemLoader {
        @Override
        public void load(ICustomItem item, Context context) {

        }
    }
}
