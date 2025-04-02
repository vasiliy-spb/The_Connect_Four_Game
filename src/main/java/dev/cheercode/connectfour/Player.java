package dev.cheercode.connectfour;

import dev.cheercode.connectfour.dialogs.Dialog;
import dev.cheercode.connectfour.dialogs.impl.IntegerMinMaxDialog;

public class Player {
    private final String name;
    private final Disk disk;

    public Player(String name, Disk disk) {
        this.name = name;
        this.disk = disk;
    }

    public String getName() {
        return name;
    }

    public Disk getDisk() {
        return disk;
    }

    public int select(Board board) {
        int firstColumn = 1;
        int lastColumn = board.getWidth();
        String title = name + ", введите номер колонки:";
        String error = "Неправильный ввод.";
        Dialog<Integer> dialog = new IntegerMinMaxDialog(title, error, firstColumn, lastColumn);
        return dialog.input();
    }
}
