package dev.cheercode.connectfour.dialogs.impl;

import dev.cheercode.connectfour.user_input_readers.UserInputReader;

import java.util.Set;

public class StringDialog extends AbstractDialog<String> {
    public StringDialog(String title, String error, Set<String> keys, UserInputReader reader) {
        super(title,
                error,
                s -> s.trim().toUpperCase(),
                keys::contains,
                reader
        );
    }
}
