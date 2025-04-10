package dev.cheercode.connectfour;

import dev.cheercode.connectfour.models.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class GridFactory {
    private static final String BLUE = "\uD83D\uDD35";
    private static final String RED = "\uD83D\uDD34";
    private static final String NONE = "⚪";

    private GridFactory() {
    }

    public static Color[][] create(String templateFilePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(templateFilePath))) {
            List<String[]> lines = new ArrayList<>();
            while (reader.ready()) {
                String[] line = reader.readLine().trim().split(" ");
                lines.add(line);
            }
            int height = lines.size();
            int width = lines.get(0).length;
            Color[][] grid = new Color[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = getColor(lines.get(i)[j]);
                }
            }
            return grid;
        } catch (IOException ignored) {
        }
        return new Color[][]{};
    }

    private static Color getColor(String representation) {
        return switch (representation) {
            case RED -> Color.RED;
            case BLUE -> Color.BLUE;
            case NONE -> Color.NONE;
            default -> throw new IllegalArgumentException("Unknown color for representation: " + representation);
        };
    }
}
