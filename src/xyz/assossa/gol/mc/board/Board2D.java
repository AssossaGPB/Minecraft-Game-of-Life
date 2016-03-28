package xyz.assossa.gol.mc.board;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import xyz.assossa.gol.ruleset.RuleSet;
import xyz.assossa.gol.util.Board;
import xyz.assossa.gol.util.RuleManager;

public class Board2D extends McBoard {

    private Material material = Material.STAINED_CLAY;
    private boolean useData = true;
    private int dataOffset = 0;

    public Board2D(Location center, Board board, String ruleId, int stepRate) {
        super(center.clone().subtract(board.getWidth() / 2, 0, board.getHeight() / 2), center.clone().add(board.getWidth() / 2, 0, board.getHeight() / 2), board, RuleManager.getRule(ruleId), stepRate);
    }

    public Board2D(Location center, int width, int height, String ruleId, int stepRate) {
        super(center.clone().subtract(width / 2, 0, height / 2), center.clone().add(width / 2, 0, height / 2), new Board(width, height), RuleManager.getRule(ruleId), stepRate);
    }

    public Board2D(Location center, Board board, RuleSet rule, int stepRate) {
        super(center.clone().subtract(board.getWidth() / 2, 0, board.getHeight() / 2), center.clone().add(board.getWidth() / 2, 0, board.getHeight() / 2), board, rule, stepRate);
    }

    public Board2D(Location center, int width, int height, RuleSet rule, int stepRate) {
        super(center.clone().subtract(width / 2, 0, height / 2), center.clone().add(width / 2, 0, height / 2), new Board(width, height), rule, stepRate);
    }

    public void setBlock(Material material) {
        this.material = material;
        this.useData = false;
    }

    public void setBlock(Material material, int dataOffset) {
        this.material = material;
        this.useData = true;
        this.dataOffset = dataOffset;
    }

    @Override
    public void draw() {
        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                if (rule.getCell(board, x, y)) {
                    Block b = min.clone().add(x, 0, y).getBlock();
                    b.setType(material);
                    if (useData)
                        b.setData((byte) (rule.getNeighbors(board, x, y) + dataOffset));
                } else {
                    min.clone().add(x, 0, y).getBlock().setType(Material.AIR);
                }
            }
        }
    }
}
