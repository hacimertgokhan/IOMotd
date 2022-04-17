package eu.mixeration.iomotd.iomotd.events;

import eu.mixeration.iomotd.iomotd.IOMotd;
import eu.mixeration.iomotd.iomotd.modules.file;
import eu.mixeration.iomotd.iomotd.modules.message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class serverListener implements Listener {
    public serverListener(IOMotd ioMotd) {}

    @EventHandler
    public void motdSettings(ServerListPingEvent listPingEvent) {
        int onlinePlayers = Bukkit.getServer().getOnlinePlayers().size();
        int maximumPlayer = Bukkit.getServer().getMaxPlayers();
        String version = Bukkit.getServer().getVersion();
        for(String motd : file.server_motd ) {
            if(file.server_motd.isEmpty()){
                message.console("&9[IO&bMotd&9] &fHey, is everything okey ? server motd list is empty. Add something !");
            } else {
                listPingEvent.setMotd(ChatColor.translateAlternateColorCodes('&', motd).replace("<line>", "\n").replace("<online>", String.valueOf(onlinePlayers))
                        .replace("<max>", String.valueOf(maximumPlayer)).replace("<version>", version));
                if (file.boolean_maxPlayer) {
                    listPingEvent.setMaxPlayers(file.int_maxPlayer);
                }
            }
        }
    }

}
