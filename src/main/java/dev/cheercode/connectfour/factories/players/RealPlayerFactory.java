package dev.cheercode.connectfour.factories.players;

import dev.cheercode.connectfour.dialogs.Dialog;
import dev.cheercode.connectfour.user_input_readers.UserInputReader;
import dev.cheercode.connectfour.dialogs.impl.StringDialog;
import dev.cheercode.connectfour.models.Color;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RealPlayer;

import java.util.HashSet;
import java.util.Set;

public class RealPlayerFactory implements PlayerFactory {
    private static final String RED_KEY = "R";
    private static final String BLUE_KEY = "B";
    private final Set<Color> usedColors = new HashSet<>();
    private final Set<String> usedNames = new HashSet<>();
    private final UserInputReader reader;

    public RealPlayerFactory(UserInputReader reader) {
        this.reader = reader;
        usedColors.add(Color.WHITE);
    }

    @Override
    public Player create() {
        Color[] colors = Color.values();
        if (usedColors.size() >= colors.length) {
            throw new RuntimeException("Cannot create new player: not colors enough.");
        }

        String name = askName();
        Color color = askColor(name);
        return new RealPlayer(name, color);
    }

    private String askName() {
        System.out.println("Введите имя:");
        String name = reader.readLine().trim();
        while (usedNames.contains(name)) {
            System.out.println("Уже есть игрок с таким именем.");
            System.out.println("Введите имя:");
            name = reader.readLine().trim();
        }
        usedNames.add(name);
        return name;
    }

    private Color askColor(String name) {
        String title = """
                %s, выберите цвет:
                %s — красный
                %s — синий
                """.formatted(name, RED_KEY, BLUE_KEY);
        Dialog<String> dialog = new StringDialog(title, "Неправильный ввод.", Set.of(RED_KEY, BLUE_KEY), reader);
        String key = dialog.input();
        Color color = getColor(key);
        while (usedColors.contains(color)) {
            System.out.println("Уже есть игрок с таким цветом.");
            key = dialog.input();
            color = getColor(key);
        }
        usedColors.add(color);
        return color;
    }

    private Color getColor(String key) {
        return switch (key) {
            case RED_KEY -> Color.RED;
            case BLUE_KEY -> Color.BLUE;
            default -> throw new IllegalArgumentException("Unknown color for key: " + key);
        };
    }
}
