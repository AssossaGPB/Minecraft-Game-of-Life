package xyz.assossa.gol.ruleset;

import xyz.assossa.gol.util.Board;

public abstract class RuleSet {

    public String id;

    protected RuleSet(String id) {
        this.id = id;
    }

    public abstract boolean[][] step(Board board);

    public int getNeighbors(Board board, int x, int y) {
        int n = 0;

        n += getCell(board, x + 1, y) ? 1 : 0;
        n += getCell(board, x, y + 1) ? 1 : 0;
        n += getCell(board, x - 1, y) ? 1 : 0;
        n += getCell(board, x, y - 1) ? 1 : 0;
        n += getCell(board, x - 1, y - 1) ? 1 : 0;
        n += getCell(board, x + 1, y + 1) ? 1 : 0;
        n += getCell(board, x + 1, y - 1) ? 1 : 0;
        n += getCell(board, x - 1, y + 1) ? 1 : 0;

        return n;
    }

    public boolean getCell(Board board, int x, int y) {
        if (x < 0)
            x = (x % (-1 * board.getWidth())) + board.getWidth();

        if (y < 0)
            y = (y % (-1 * board.getHeight())) + board.getHeight();

        if (x >= board.getWidth())
            x = (x % (board.getWidth() - 1)) - 1;

        if (y >= board.getHeight())
            y = (y % (board.getHeight() - 1)) - 1;

        return board.getBoard()[x][y];
    }
}
