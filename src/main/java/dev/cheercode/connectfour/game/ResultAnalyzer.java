package dev.cheercode.connectfour.game;

import dev.cheercode.connectfour.models.Color;

public class ResultAnalyzer {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

    public boolean hasWinner(Color[][] grid, int countToVictory) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                Color color = grid[row][column];
                if (color == Color.WHITE) {
                    continue;
                }

                for (int[] direction : DIRECTIONS) {
                    boolean winDirection = checkDirection(grid, row, column, direction, countToVictory);
                    if (winDirection) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkDirection(Color[][] grid, int row, int column, int[] direction, int countToVictory) {
        final Color colorSample = grid[row][column];
        int rowOffset = direction[0];
        int columnOffset = direction[1];
        int height = grid.length;
        int width = grid[0].length;

        while (countToVictory > 0) {
            if (!isValid(row, column, height, width)) {
                break;
            }

            Color currentColor = grid[row][column];
            if (currentColor != colorSample) {
                return false;
            }

            row += rowOffset;
            column += columnOffset;
            countToVictory--;
        }
        return countToVictory == 0;
    }

    private boolean isValid(int row, int column, int height, int width) {
        return row >= 0 && row < height && column >= 0 && column < width;
    }
}
