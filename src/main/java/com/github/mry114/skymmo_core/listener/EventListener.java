package com.github.mry114.skymmo_core.listener;

import com.github.mry114.skymmo_core.core.item.factory.CustomItemFactory;
import com.github.mry114.skymmo_core.registry.ItemRegistry;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventListener implements Listener {
    @EventHandler
    private void onPlayerChat(AsyncChatEvent event) {
        String message = PlainTextComponentSerializer.plainText().serialize(event.message());

        switch (message) {
            case "[1]" -> {
                Player player = event.getPlayer();

                player.getInventory().setItem(0, new CustomItemFactory(ItemRegistry.EXAMPLE_ITEM).create());
            }
            case "[2]" -> {
                Player player = event.getPlayer();

                player.getInventory().setItem(0, new CustomItemFactory(ItemRegistry.EXAMPLE_WEAPON).create());
            }
            case "[3]" -> {
                Player player = event.getPlayer();

                player.getInventory().setItem(0, new CustomItemFactory(ItemRegistry.EXAMPLE_ARMOR).create());
            }
        }
    }
}
