package dev.cheercode.connectfour.factories.players;

import dev.cheercode.connectfour.dialogs.Dialog;
import dev.cheercode.connectfour.user_input_readers.UserInputReader;
import dev.cheercode.connectfour.dialogs.impl.StringDialog;
import dev.cheercode.connectfour.models.Disk;
import dev.cheercode.connectfour.models.players.Player;
import dev.cheercode.connectfour.models.players.RealPlayer;

import java.util.HashSet;
import java.util.Set;

public class RealPlayerFactory implements PlayerFactory {
    private static final String RED_KEY = "R";
    private static final String BLUE_KEY = "B";
    private final Set<Disk> usedDisks = new HashSet<>();
    private final Set<String> usedNames = new HashSet<>();
    private final UserInputReader reader;

    public RealPlayerFactory(UserInputReader reader) {
        this.reader = reader;
        usedDisks.add(Disk.EMPTY);
    }

    @Override
    public Player create() {
        Disk[] disks = Disk.values();
        if (usedDisks.size() >= disks.length) {
            throw new RuntimeException("Cannot create new player: not disks enough.");
        }

        String name = askName();
        Disk disk = askDisk(name);
        return new RealPlayer(name, disk);
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

    private Disk askDisk(String name) {
        String title = """
                %s, выберите цвет:
                %s — красный
                %s — синий
                """.formatted(name, RED_KEY, BLUE_KEY);
        Dialog<String> dialog = new StringDialog(title, "Неправильный ввод.", Set.of(RED_KEY, BLUE_KEY), reader);
        String key = dialog.input();
        Disk disk = getDisk(key);
        while (usedDisks.contains(disk)) {
            System.out.println("Уже есть игрок с таким цветом.");
            key = dialog.input();
            disk = getDisk(key);
        }
        usedDisks.add(disk);
        return disk;
    }

    private Disk getDisk(String key) {
        return switch (key) {
            case RED_KEY -> Disk.RED;
            case BLUE_KEY -> Disk.BLUE;
            default -> throw new IllegalArgumentException("Unknown disk for key: " + key);
        };
    }
}
