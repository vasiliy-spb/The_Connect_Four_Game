package dev.cheercode.connectfour.game;

import dev.cheercode.connectfour.models.Disk;

public class ResultAnalyzer {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};

    public boolean hasWinner(Disk[][] grid, int countToVictory) {
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                Disk disk = grid[row][column];
                if (disk == Disk.EMPTY) {
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

    private boolean checkDirection(Disk[][] grid, int row, int column, int[] direction, int countToVictory) {
        final Disk diskSample = grid[row][column];
        int rowOffset = direction[0];
        int columnOffset = direction[1];
        int height = grid.length;
        int width = grid[0].length;

        while (countToVictory > 0) {
            if (!isValid(row, column, height, width)) {
                break;
            }

            Disk currentDisk = grid[row][column];
            if (currentDisk != diskSample) {
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
