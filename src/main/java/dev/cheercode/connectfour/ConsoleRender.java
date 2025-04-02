package dev.cheercode.connectfour;

public class ConsoleRender implements Render {
    @Override
    public void display(Disk[][] grid) {
        for (int i = 1; i <= grid[0].length; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String representation = getRepresentation(grid[i][j]);
                System.out.print(representation + " ");
            }
            System.out.println();
        }
    }

    private String getRepresentation(Disk disk) {
        return switch (disk) {
            case BLUE -> "\uD83D\uDD35";
            case RED -> "\uD83D\uDD34";
            case EMPTY -> "⚪";
            default -> "";
        };
    }
}