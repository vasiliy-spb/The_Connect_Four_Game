package dev.cheercode.connectfour.models;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;
    private final Color[][] grid;
    private final int[] positions;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new Color[height][width];
        this.positions = new int[width];
        init();
    }

    private void init() {
        initGrid();
        initPositions();
    }

    private void initGrid() {
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                grid[row][column] = Color.WHITE;
            }
        }
    }

    private void initPositions() {
        Arrays.fill(positions, height - 1);
    }

    public void put(Color color, int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
        if (isFilled(column)) {
            throw new IllegalArgumentException("Column %d is filled.".formatted(column + 1));
        }
        int row = positions[column];
        if (isSlotEmpty(column)) {
            grid[row][column] = color;
            positions[column]--;
        }
    }

    private boolean isSlotEmpty(int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
        int row = positions[column];
        return grid[row][column] == Color.WHITE;
    }

    public boolean isFilled(int column) {
        if (isOutOfBounds(column)) {
            throw new IndexOutOfBoundsException("Column number out of bounds.");
        }
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
