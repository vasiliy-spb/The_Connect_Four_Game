package dev.cheercode.connectfour.dialogs.impl;

import dev.cheercode.connectfour.user_input_readers.UserInputReader;

public class IntegerMinMaxDialog extends AbstractDialog<Integer> {
    public IntegerMinMaxDialog(String title, String error, int min, int max, UserInputReader reader) {
        super(title,
                error,
                s -> Integer.parseInt(s.trim().toLowerCase()),
                n -> n >= min && n <= max,
                reader
        );
    }
}
