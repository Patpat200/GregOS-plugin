package me.gregos.gregosPlugin.listeners;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class SneakDeathListener implements Listener {

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event) {

        if (!FeatureManager.sneakDeathEnabled) return;

        if (event.isSneaking()) {
            event.getPlayer().setHealth(0.0);
        }
    }
}