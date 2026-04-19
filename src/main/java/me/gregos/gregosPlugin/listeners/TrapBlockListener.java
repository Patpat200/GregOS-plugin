package me.gregos.gregosPlugin.listeners;

import me.gregos.gregosPlugin.manager.FeatureManager;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class TrapBlockListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        if (!FeatureManager.trapBlockEnabled) return;
        if (FeatureManager.trapBlockType == null) return;
        if (event.getBlock().getType() != FeatureManager.trapBlockType) return;

        Player player = event.getPlayer();
        Location loc = event.getBlock().getLocation().add(0.5, 0.5, 0.5);

        event.setDropItems(false);

        loc.getWorld().createExplosion(loc, 3.0f, false, true, player);
        loc.getWorld().spawnParticle(Particle.FLAME, loc, 30, 0.3, 0.3, 0.3, 0.1);
        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 1.0f, 0.8f);

        player.sendMessage("§c💥 Bloc piégé (" + FeatureManager.trapBlockType.name() + ") !");
    }
}