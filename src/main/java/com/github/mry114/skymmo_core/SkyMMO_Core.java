package com.github.mry114.skymmo_core;

import com.github.mry114.skymmo_core.core.player.ModifyContainer;
import com.github.mry114.skymmo_core.listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMMO_Core extends JavaPlugin {
    public static ModifyContainer modifyContainer;

    private static SkyMMO_Core instance;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);

        modifyContainer = new ModifyContainer();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkyMMO_Core getInstance() {
        return instance;
    }
}
