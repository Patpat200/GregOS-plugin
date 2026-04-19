package me.gregos.gregosPlugin.manager;

import org.bukkit.Location;

import java.util.HashSet;
import java.util.Set;

public class TrapBlockManager {

    private static final Set<Location> trappedBlocks = new HashSet<>();

    public static void addTrap(Location loc) {
        trappedBlocks.add(loc.getBlock().getLocation());
    }

    public static boolean removeTrap(Location loc) {
        return trappedBlocks.remove(loc.getBlock().getLocation());
    }

    public static boolean isTrapped(Location loc) {
        return trappedBlocks.contains(loc.getBlock().getLocation());
    }

    public static int clearAll() {
        int count = trappedBlocks.size();
        trappedBlocks.clear();
        return count;
    }

    public static int count() {
        return trappedBlocks.size();
    }
}