package moe.windleaf.WLKits.Plugins.SimpleWarp;

import moe.windleaf.WLKits.Main;
import moe.windleaf.WLKits.Plugins.SimpleWarp.Commands.*;
import moe.windleaf.WLKits.Utils;

public class SimpleWarp {
    public static String path = Main.prefixPath  + "Warps.yml";
    public static final WarpManager warpManager = new WarpManager();

    public static void load() {
        warpManager.init();
        Utils.commandRegister("setwarp", new setwarp());
        Utils.commandRegister("delwarp", new delwarp());
        Utils.commandRegister("warps", new warps());
        Utils.commandRegister("warp", new warp());
        Utils.commandRegister("warphelp", new warphelp());
        Utils.commandRegister("showwarp", new showwarp());
    }
}
