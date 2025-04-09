package dev.cheercode.connectfour.renders;

import dev.cheercode.connectfour.models.Color;

public class ConsoleRender implements Render {
    private static final String BLUE = "\uD83D\uDD35";
    private static final String RED = "\uD83D\uDD34";
    private static final String WHITE = "⚪";
    private static final String SPACE = " ";

    @Override
    public void display(Color[][] grid) {
        int width = grid[0].length;
        printColumnNumbers(width);
        printGrid(grid);
    }

    private void printColumnNumbers(int width) {
        for (int i = 1; i <= width; i++) {
            System.out.print(SPACE + i + SPACE);
        }
        System.out.println();
    }

    private void printGrid(Color[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String representation = getRepresentation(grid[i][j]);
                System.out.print(representation + SPACE);
            }
            System.out.println();
        }
    }

    private String getRepresentation(Color color) {
        return switch (color) {
            case BLUE -> BLUE;
            case RED -> RED;
            case WHITE -> WHITE;
            default -> throw new IllegalArgumentException("Unknown representation for color: " + color.name());
        };
    }
}