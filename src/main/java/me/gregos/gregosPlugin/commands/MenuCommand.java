package me.gregos.gregosPlugin.commands;

import me.gregos.gregosPlugin.gui.MainMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        MainMenu.open(player);

        return true;
    }
}