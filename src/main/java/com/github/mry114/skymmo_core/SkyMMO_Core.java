package com.github.mry114.skymmo_core;

import com.github.mry114.skymmo_core.core.player.cache.ElementCache;
import com.github.mry114.skymmo_core.core.player.cache.StatusCache;
import com.github.mry114.skymmo_core.listener.EventListener;
import com.github.mry114.skymmo_core.register.content.AttributeRegistry;
import com.github.mry114.skymmo_core.register.content.EnchantRegistry;
import com.github.mry114.skymmo_core.register.content.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMMO_Core extends JavaPlugin {
    public static ElementCache elementCache;
    public static StatusCache statusCache;

    private static SkyMMO_Core instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        elementCache = new ElementCache();
        statusCache = new StatusCache();

        ItemRegistry.getInstance().loadAll(this);
        AttributeRegistry.getInstance().loadAll(this);
        EnchantRegistry.getInstance().loadAll(this);

        getLogger().info("The RPG plugin has started successfully, and all data have been automatically loaded!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkyMMO_Core getInstance() {
        return instance;
    }
}
