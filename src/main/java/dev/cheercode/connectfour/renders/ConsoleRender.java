package dev.cheercode.connectfour.renders;

import dev.cheercode.connectfour.models.Color;

public class ConsoleRender implements Render {
    private static final String BLUE_CELL = "\uD83D\uDD35";
    private static final String RED_CELL = "\uD83D\uDD34";
    private static final String NEUTRAL_CELL = "⚪";
    private static final String SPACE = " ";
    private static final String BACKGROUND_COLOR = "\033[45m";
    private static final String RESET_BACKGROUND = "\033[0m";

    @Override
    public void display(Color[][] grid) {
        int width = grid[0].length;
        printColumnNumbers(width);
        printGrid(grid);
    }

    private void printColumnNumbers(int width) {
        System.out.print(SPACE);
        for (int i = 1; i <= width; i++) {
            System.out.print(SPACE + i + SPACE);
        }
        System.out.println();
    }

    private void printGrid(Color[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            System.out.print(BACKGROUND_COLOR + SPACE);
            for (int j = 0; j < grid[i].length; j++) {
                String representation = getRepresentation(grid[i][j]);
                System.out.print(representation + SPACE);
            }
            System.out.println(RESET_BACKGROUND);
        }
        System.out.println();
    }

    private String getRepresentation(Color color) {
        return switch (color) {
            case BLUE -> BLUE_CELL;
            case RED -> RED_CELL;
            case NEUTRAL -> NEUTRAL_CELL;
            default -> throw new IllegalArgumentException("Unknown representation for color: " + color.name());
        };
    }
}