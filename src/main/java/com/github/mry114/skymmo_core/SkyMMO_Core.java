package com.github.mry114.skymmo_core;

import com.github.mry114.skymmo_core.core.player.element.ElementContainer;
import com.github.mry114.skymmo_core.listener.EventListener;
import com.github.mry114.skymmo_core.registry.AttributeRegistry;
import com.github.mry114.skymmo_core.registry.EnchantRegistry;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMMO_Core extends JavaPlugin {
    public static ElementContainer elementContainer;

    private static SkyMMO_Core instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        elementContainer = new ElementContainer();

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
