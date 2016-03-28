package xyz.assossa.gol.ruleset;

import xyz.assossa.gol.util.Board;

public class ConwayLife extends RuleSet {

    public ConwayLife() {
        super("23/3");
    }

    @Override
    public boolean[][] step(Board board) {
        boolean board2[][] = new boolean[board.getWidth()][board.getHeight()];

        for (int x = 0; x < board.getWidth(); x++) {
            for (int y = 0; y < board.getHeight(); y++) {
                int n = getNeighbors(board, x, y);

                if (board.getBoard()[x][y])
                    board2[x][y] = n >= 2 && n < 4;
                else
                    board2[x][y] = n == 3;
            }
        }

        return board2;
    }
}
