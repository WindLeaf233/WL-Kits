package moe.windleaf.WLKits.Plugins.MineBoard;

import moe.windleaf.WLKits.Main;
import moe.windleaf.WLKits.Plugins.MineBoard.Commands.mineboard;
import moe.windleaf.WLKits.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.*;

import java.io.File;
import java.util.HashMap;

public class MineBoard {
    public static String path = Main.prefixPath + "MineBoard" + File.separator + "boardScores.bin";
    @SuppressWarnings("unchecked") public static HashMap<String, Integer> scores = (HashMap<String, Integer>) Utils.loadHashMap(path);
    public static ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
    @SuppressWarnings("all") public static Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
    public static Objective objective = scoreboard.registerNewObjective(
            "mineboard",
            "dummy",
            ChatColor.GOLD + "" + ChatColor.BOLD + "挖掘榜"
    );

    public static void load() {
        Utils.makeDir(Main.prefixPath + "MineBoard");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        Utils.eventRegister(new Events());
        Utils.commandRegister("mineboard", new mineboard());
    }
}
