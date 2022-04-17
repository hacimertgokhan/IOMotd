package eu.mixeration.iomotd.iomotd.modules;

import eu.mixeration.iomotd.iomotd.IOMotd;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class file {

    public static void loadConfig() {
        FileConfiguration config = IOMotd.getInstance().getConfig();
        new File(IOMotd.getInstance().getDataFolder(), "config.yml");
        IOMotd.getInstance().saveDefaultConfig();
    }

    public static String no_permission = IOMotd.getInstance().getConfig().getString("messages.no-permission");
    public static String plugin_reloaded = IOMotd.getInstance().getConfig().getString("messages.plugin-reloaded");
    public static String only_in_game = IOMotd.getInstance().getConfig().getString("messages.only-in-game");

    public static List<String> server_motd = IOMotd.getInstance().getConfig().getStringList("io-motd.server-motd");

    public static boolean boolean_maxPlayer = IOMotd.getInstance().getConfig().getBoolean("io-motd.maximumPlayer.boolean");
    public static int int_maxPlayer = IOMotd.getInstance().getConfig().getInt("io-motd.maximumPlayer.amount");

}
