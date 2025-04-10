package dev.cheercode.connectfour.models;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;
    private final Color[][] grid;
    private final int[] rowPositions;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Color[height][width];
        this.rowPositions = new int[width];
        init();
    }

    private void init() {
        initGrid();
        initPositions();
    }

    private void initGrid() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                grid[row][column] = Color.NEUTRAL;
            }
        }
    }

    private void initPositions() {
        Arrays.fill(rowPositions, height - 1);
    }

    public void put(Color color, int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
        if (isFilled(column)) {
            throw new IllegalArgumentException("Column %d is filled.".formatted(column + 1));
        }
        if (isSlotEmpty(column)) {
            int row = rowPositions[column];
            grid[row][column] = color;
            rowPositions[column]--;
        }
    }

    private boolean isSlotEmpty(int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
        int row = rowPositions[column];
        return grid[row][column] == Color.NEUTRAL;
    }

    public boolean isFilled(int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
        return rowPositions[column] < 0;
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

    public Color[][] getGrid() {
        Color[][] gridCopy = new Color[height][width];
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
