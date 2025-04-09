package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.user_input_readers.ConsoleUserInputReader;
import dev.cheercode.connectfour.dialogs.Dialog;
import dev.cheercode.connectfour.dialogs.impl.IntegerMinMaxDialog;
import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Color;

public class RealPlayer extends AbstractPlayer {
    public RealPlayer(String name, Color color) {
        super(name, color);
    }

    @Override
    public int select(Board board) {
        int firstColumn = 1;
        int lastColumn = board.getWidth();
        String title = name + ", введите номер колонки:";
        String error = "Неправильный ввод.";
        Dialog<Integer> dialog = new IntegerMinMaxDialog(title, error, firstColumn, lastColumn, ConsoleUserInputReader.getInstance());
        return dialog.input();
    }
}
