package xyz.assossa.gol.mc.board;

import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import xyz.assossa.gol.GameOfLife;
import xyz.assossa.gol.ruleset.RuleSet;
import xyz.assossa.gol.util.Board;

public abstract class McBoard {

    protected Location min, max;
    protected Board board;
    protected RuleSet rule;
    protected int stepRate;

    protected BukkitTask stepTask;
    protected boolean paused;

    public McBoard(Location min, Location max, Board board, RuleSet rule, int stepRate) {
        this.min = min;
        this.max = max;
        this.board = board;
        this.rule = rule;
        this.stepRate = stepRate;

        resetTask();
    }

    public void resetTask() {
        if (stepTask != null)
            stepTask.cancel();

        stepTask = new BukkitRunnable() {
            @Override
            public void run() {
                if (!paused) {
                    board.setBoard(rule.step(board));
                    draw();
                }
            }
        }.runTaskTimer(GameOfLife.instance, 0, stepRate);
    }

    public abstract void draw();

    public Location getMin() {
        return min;
    }

    public void setMin(Location min) {
        this.min = min;
    }

    public Location getMax() {
        return max;
    }

    public void setMax(Location max) {
        this.max = max;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public RuleSet getRule() {
        return rule;
    }

    public void setRule(RuleSet rule) {
        this.rule = rule;
    }

    public int getStepRate() {
        return stepRate;
    }

    public void setStepRate(int stepRate) {
        this.stepRate = stepRate;
        resetTask();
    }

    public BukkitTask getStepTask() {
        return stepTask;
    }

    public void setStepTask(BukkitTask stepTask) {
        this.stepTask = stepTask;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
}
