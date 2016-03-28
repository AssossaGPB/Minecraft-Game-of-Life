package xyz.assossa.gol.ruleset;

public class ConwayLife extends RuleSet {

    public ConwayLife() {
        super("23/3");
    }

    @Override
    public boolean[][] step(boolean[][] board, int width, int height) {
        boolean board2[][] = new boolean[width][height];

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int n = getNeighbors(board, x, y, width, height);

                if (board[x][y])
                    board2[x][y] = n >= 2 && n < 4;
                else
                    board2[x][y] = n == 3;
            }
        }

        return board2;
    }
}
