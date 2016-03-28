package xyz.assossa.gol.util;

import java.util.Random;

public class Board {

    private int width, height;
    private boolean[][] board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;

        clearBoard();
    }

    public void clearBoard() {
        board = new boolean[width][height];
    }

    public void setBoard(boolean[][] board) {
        this.board = board;
    }

    public void generateRandomBoard() {
        generateRandomBoard((int) (System.currentTimeMillis() * 1000));
    }

    public void generateRandomBoard(int seed) {
        Random r = new Random(seed);
        boolean[][] board = new boolean[width][height];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                board[x][y] = r.nextBoolean();

        setBoard(board);
    }
}
