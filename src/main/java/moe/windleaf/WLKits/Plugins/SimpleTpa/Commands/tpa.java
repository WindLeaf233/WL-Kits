package moe.windleaf.WLKits.Plugins.SimpleTpa.Commands;

import moe.windleaf.WLKits.Plugins.SimpleTpa.SimpleTpa;
import moe.windleaf.WLKits.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class tpa implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Utils.mustPlayer(sender, SimpleTpa.name);
            return false;
        } else {
            if (args.length < 1) {
                Utils.smartSendPrefix(sender, "&a使用 &6/tpahelp &a查看帮助!", "SimpleTpa");
                return false;
            } else {
                Player player = Bukkit.getPlayer(args[0]);
                if (player == sender) {
                    Utils.smartSendPrefix(sender, "&c你不能给自己发送传送请求!", "SimpleTpa");
                    return false;
                } else {
                    if (player == null) {
                        Utils.smartSendPrefix(sender, "&c玩家 &6" + args[0] + " &c不存在!", "SimpleTpa");
                    } else {
                        SimpleTpa.tpaLogs.put(player, (Player) sender);

                        Utils.smartSendPrefix(player, "&a你有一个待接受的传送请求:", "SimpleTpa");
                        Utils.smartSendPrefix(player, String.format("&a玩家 &6%s &a想传送到你这里,", sender.getName()), "SimpleTpa");
                        Utils.smartSendPrefix(player, "&a接受请求: &2/tpaccept&a, 拒绝请求: &4/tpadeny&a.", "SimpleTpa");

                        Utils.smartSendPrefix(sender, String.format("&a已向玩家 &6%s &a发送一个传送请求, 等待对方接受!", player.getName()), "SimpleTpa");
                        Utils.smartSendPrefix(sender, "&a想要取消这个传送请求, 你可以输入 &6/tpacancel&a.", "SimpleTpa");
                    }
                    return true;
                }
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> tmp = new ArrayList<>();
        for (Player p : Bukkit.getOnlinePlayers()) { tmp.add(p.getName()); }
        List<Object> filter = Arrays.stream(tmp.toArray()).filter(s -> s.toString().startsWith(args[0])).collect(Collectors.toList());
        List<String> players = new ArrayList<>();
        for (Object i : filter) { players.add(i.toString()); }
        return players;
    }
}
