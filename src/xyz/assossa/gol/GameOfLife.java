package xyz.assossa.gol;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.assossa.gol.util.RuleManager;

public class GameOfLife extends JavaPlugin {

    @Override
    public void onEnable() {
        RuleManager.addDefaultRules();
    }
}
