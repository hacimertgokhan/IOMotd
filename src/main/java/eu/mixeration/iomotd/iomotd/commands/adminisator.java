package eu.mixeration.iomotd.iomotd.commands;

import eu.mixeration.iomotd.iomotd.IOMotd;
import eu.mixeration.iomotd.iomotd.modules.file;
import eu.mixeration.iomotd.iomotd.modules.message;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static eu.mixeration.iomotd.iomotd.modules.file.*;

public class adminisator implements CommandExecutor {
    public adminisator(IOMotd ioMotd) {}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(command.getName().equalsIgnoreCase("IOMotd")) {
                if(player.hasPermission("iomotd.adminisator")) {
                    if(args.length == 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lIO&b&lMotd &7: &freWork of TitanMotd"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &7- &f/IOMotd reload"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &7- &f/IOMotd getmotd"));
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                        return true;
                    } else if(args[0].equalsIgnoreCase("reload")) {
                        IOMotd.getInstance().reloadConfig();
                        IOMotd.getInstance().saveConfig();
                        message.player(player, plugin_reloaded);
                        return true;
                    } else if(args[0].equalsIgnoreCase("getmotd")) {
                        for(String motd : file.server_motd ) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', motd));
                        }
                        return true;
                    }
                } else {
                    message.player(player, no_permission);
                    return true;
                }
            }
        } else {
            message.console(only_in_game);
            return true;
        }
        return true;
    }
}
