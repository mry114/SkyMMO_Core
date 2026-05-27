package com.github.mry114.skymmo_core;

import com.github.mry114.skymmo_core.listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyMMO_Core extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SkyMMO_Core getInstance() {
        return new SkyMMO_Core();
    }
}
