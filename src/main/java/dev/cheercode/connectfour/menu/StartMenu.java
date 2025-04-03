package dev.cheercode.connectfour.menu;

import dev.cheercode.connectfour.menu.items.MenuItem;
import dev.cheercode.connectfour.user_input_readers.ConsoleUserInputReader;
import dev.cheercode.connectfour.dialogs.Dialog;
import dev.cheercode.connectfour.dialogs.impl.IntegerMinMaxDialog;

import java.util.List;

public class StartMenu implements Menu {
    private static final String DELIMITER = " — ";
    private final List<MenuItem> items;
    private final String title;

    public StartMenu(String title, List<MenuItem> items) {
        this.title = title;
        this.items = items;
    }

    @Override
    public void display() {
        System.out.println(title);
        for (MenuItem item : items) {
            int keyNumber = getKeyNumber(item);
            String description = getDescription(item);
            System.out.println(keyNumber + DELIMITER + description);
        }
    }

    private int getKeyNumber(MenuItem item) {
        return item.getKey().ordinal() + 1;
    }

    private String getDescription(MenuItem item) {
        return item.getTitle();
    }

    @Override
    public void select() {
        String dialogTitle = "Выберите тип игры:";
        String error = "Неправильный ввод.";
        Dialog<Integer> dialog = new IntegerMinMaxDialog(dialogTitle, error, 1, items.size(), ConsoleUserInputReader.getInstance());
        int itemNumber = dialog.input();
        MenuItem item = items.get(itemNumber - 1);
        item.execute();
    }
}
