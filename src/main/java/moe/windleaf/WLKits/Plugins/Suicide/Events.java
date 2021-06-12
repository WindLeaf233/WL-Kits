package moe.windleaf.WLKits.Plugins.Suicide;

import moe.windleaf.WLKits.MessageGetter;
import moe.windleaf.WLKits.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class Events implements Listener {
    MessageGetter m = new MessageGetter("Suicide");

    @EventHandler
    public void _PlayerDeathEvent(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (player == Suicide.lastSuicide) {
            event.setDeathMessage("");
            HashMap<String, String> i = new HashMap<>();
            i.put("playerName", player.getName());
            Utils.broadcastPlayers(Utils.getPluginPrefix("Suicide") + Utils.insert(m.get("自杀"), i));
            Suicide.lastSuicide = null;
        }
    }
}
