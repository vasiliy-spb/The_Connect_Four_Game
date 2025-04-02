package dev.cheercode.connectfour.renders;

import dev.cheercode.connectfour.models.Disk;

public class ConsoleRender implements Render {
    private static final String BLUE_DISK = "\uD83D\uDD35";
    private static final String RED_DISK = "\uD83D\uDD34";
    private static final String EMPTY_DISK = "⚪";
    private static final String SPACE = " ";

    @Override
    public void display(Disk[][] grid) {
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

    private void printGrid(Disk[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String representation = getRepresentation(grid[i][j]);
                System.out.print(representation + SPACE);
            }
            System.out.println();
        }
    }

    private String getRepresentation(Disk disk) {
        return switch (disk) {
            case BLUE -> BLUE_DISK;
            case RED -> RED_DISK;
            case EMPTY -> EMPTY_DISK;
            default -> throw new IllegalArgumentException("Unknown representation for disk: " + disk.name());
        };
    }
}