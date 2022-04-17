package eu.mixeration.iomotd.iomotd;

import eu.mixeration.iomotd.iomotd.commands.adminisator;
import eu.mixeration.iomotd.iomotd.events.serverListener;
import eu.mixeration.iomotd.iomotd.modules.message;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static eu.mixeration.iomotd.iomotd.modules.file.loadConfig;

public final class IOMotd extends JavaPlugin {
    private static IOMotd instance;
    public static synchronized IOMotd getInstance() {
        return instance;
    }
    public static synchronized void setInstance(IOMotd mixeration) {
        instance = mixeration;
    }


    @Override
    public void onEnable() {
        setInstance(this);
        loadConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new serverListener(this), this);
        getCommand("IOMotd").setExecutor(new adminisator(this));
        message.console("&9[IO&bMotd&9] &fPlugin is working, now you can customize your server list.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
