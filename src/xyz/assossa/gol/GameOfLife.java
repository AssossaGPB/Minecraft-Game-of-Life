package xyz.assossa.gol;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.assossa.gol.mc.board.Board2D;
import xyz.assossa.gol.util.Board;
import xyz.assossa.gol.util.RuleManager;

public class GameOfLife extends JavaPlugin {

    public static GameOfLife instance;

    @Override
    public void onEnable() {
        instance = this;

        RuleManager.addDefaultRules();

        Board b = new Board(50, 50);
        b.generateRandomBoard();

        Board2D b2 = new Board2D(new Location(Bukkit.getWorlds().get(0), 0, 64, 0), b, "23/3", 5);
    }
}
