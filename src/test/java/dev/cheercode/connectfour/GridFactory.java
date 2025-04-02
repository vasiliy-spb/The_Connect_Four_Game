package dev.cheercode.connectfour;

import dev.cheercode.connectfour.models.Disk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class GridFactory {
    private static final String BLUE_DISK = "\uD83D\uDD35";
    private static final String RED_DISK = "\uD83D\uDD34";
    private static final String EMPTY_DISK = "⚪";

    private GridFactory() {
    }

    public static Disk[][] create(String templateFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(templateFilePath))) {
            List<String[]> lines = new ArrayList<>();
            while (reader.ready()) {
                String[] line = reader.readLine().trim().split(" ");
                lines.add(line);
            }
            int height = lines.size();
            int width = lines.get(0).length;
            Disk[][] grid = new Disk[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = getDisk(lines.get(i)[j]);
                }
            }
            return grid;
        } catch (IOException ignored) {
        }
        return new Disk[][]{};
    }

    private static Disk getDisk(String representation) {
        return switch (representation) {
            case RED_DISK -> Disk.RED;
            case BLUE_DISK -> Disk.BLUE;
            case EMPTY_DISK -> Disk.EMPTY;
            default -> throw new IllegalArgumentException("Unknown disk for representation: " + representation);
        };
    }
}
