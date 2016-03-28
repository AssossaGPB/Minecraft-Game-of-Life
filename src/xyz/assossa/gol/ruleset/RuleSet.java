package xyz.assossa.gol.ruleset;

public abstract class RuleSet {

    public String id;

    protected RuleSet(String id) {
        this.id = id;
    }

    public abstract boolean[][] step(boolean[][] board, int width, int height);

    protected int getNeighbors(boolean[][] board, int x, int y, int width, int height) {
        int n = 0;

        n += getCell(board, x + 1, y, width, height) ? 1 : 0;
        n += getCell(board, x, y + 1, width, height) ? 1 : 0;
        n += getCell(board, x - 1, y, width, height) ? 1 : 0;
        n += getCell(board, x, y - 1, width, height) ? 1 : 0;
        n += getCell(board, x - 1, y - 1, width, height) ? 1 : 0;
        n += getCell(board, x + 1, y + 1, width, height) ? 1 : 0;
        n += getCell(board, x + 1, y - 1, width, height) ? 1 : 0;
        n += getCell(board, x - 1, y + 1, width, height) ? 1 : 0;

        return n;
    }

    protected boolean getCell(boolean[][] board, int x, int y, int width, int height) {
        if (x < 0)
            x = (x % (-1 * width)) + width;

        if (y < 0)
            y = (y % (-1 * height)) + height;

        if (x >= width)
            x = (x % (width - 1)) - 1;

        if (y >= height)
            y = (y % (height - 1)) - 1;

        return board[x][y];
    }
}
