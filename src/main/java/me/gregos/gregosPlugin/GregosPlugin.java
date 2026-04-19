package me.gregos.gregosPlugin;

import me.gregos.gregosPlugin.commands.AbilityCommand;
import me.gregos.gregosPlugin.commands.SneakGameCommand;
import me.gregos.gregosPlugin.commands.MenuCommand;
import me.gregos.gregosPlugin.listeners.SlimeSpawnListener;
import me.gregos.gregosPlugin.listeners.SneakDeathListener;
import me.gregos.gregosPlugin.gui.MenuClickListener;
import org.bukkit.plugin.java.JavaPlugin;
// test n2
public final class GregosPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().info("Plugin enabled!");

        // commands
        getCommand("ability").setExecutor(new AbilityCommand());
        getCommand("sneakgame").setExecutor(new SneakGameCommand());
        getCommand("menu").setExecutor(new MenuCommand());

        // listeners
        getServer().getPluginManager().registerEvents(new SlimeSpawnListener(), this);
        getServer().getPluginManager().registerEvents(new SneakDeathListener(), this);
        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
    }
}