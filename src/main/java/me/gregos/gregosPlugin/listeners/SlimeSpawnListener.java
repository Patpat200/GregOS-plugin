package me.gregos.gregosPlugin.listeners;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class SlimeSpawnListener implements Listener {

    @EventHandler
    public void onSpawn(CreatureSpawnEvent event) {

        if (!FeatureManager.slimeEnabled) return;

        if (event.getEntityType() == EntityType.SLIME) {
            event.setCancelled(true);
        }
    }
}