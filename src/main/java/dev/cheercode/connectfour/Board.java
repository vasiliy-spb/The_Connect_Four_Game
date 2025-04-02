package dev.cheercode.connectfour;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;
    private final Disk[][] grid;
    private final int[] positions;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Disk[height][width];
        this.positions = new int[width];
        Arrays.fill(positions, height - 1);
    }

    public void put(Disk disk, int column) {
        if (isOutOfBounds(column) || isFilled(column)) {
            return;
        }
        int position = positions[column];
        if (isSlotEmpty(column)) {
            grid[position][column] = disk;
            positions[column]--;
        }
    }

    private boolean isSlotEmpty(int column) {
        int position = positions[column];
        return grid[position][column] == null;
    }

    public boolean isFilled(int column) {
//        if (isOutOfBounds(column)) {
//            throw new IllegalArgumentException("Column number out of bounds.");
//        }
        return positions[column] < 0;
    }

    private boolean isOutOfBounds(int column) {
        return column < 0 || column >= width;
    }

    public boolean isFull() {
        for (int column = 0; column < width; column++) {
            if (!isFilled(column)) {
                return false;
            }
        }
        return true;
    }

    public Disk[][] getGrid() {
        Disk[][] gridCopy = new Disk[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                gridCopy[row][column] = grid[row][column];
            }
        }
        return gridCopy;
    }

    public int getWidth() {
        return width;
    }
}
