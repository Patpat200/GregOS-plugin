package me.gregos.gregosPlugin.abilities;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.RayTraceResult;

public class LightningAbility {

    public void execute(Player player) {

        Entity target = getTarget(player, 50);

        if (target == null) {
            player.sendMessage("§cNo target found!");
            return;
        }

        Location loc = target.getLocation();
        World world = loc.getWorld();

        if (world != null) {
            world.strikeLightning(loc);
            player.sendMessage("§e⚡ Ability used!");
        }
    }

    private Entity getTarget(Player player, double range) {

        RayTraceResult result = player.getWorld().rayTraceEntities(
                player.getEyeLocation(),
                player.getLocation().getDirection(),
                range,
                entity -> entity != player
        );

        if (result != null) {
            return result.getHitEntity();
        }

        return null;
    }
}