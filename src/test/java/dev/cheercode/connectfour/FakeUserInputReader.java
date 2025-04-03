package dev.cheercode.connectfour;

import dev.cheercode.connectfour.user_input_readers.UserInputReader;

import java.util.Arrays;
import java.util.List;

public class FakeUserInputReader implements UserInputReader {
    private final List<String> lines;
    private int lineIndex = 0;

    public FakeUserInputReader(List<String> lines) {
        this.lines = lines;
    }

    public FakeUserInputReader(String[] lineArray) {
        this.lines = Arrays.asList(lineArray);
    }

    @Override
    public String readLine() {
        if (lineIndex >= lines.size()) {
            throw new IllegalStateException("Reader doesn't have any lines.");
        }
        return lines.get(lineIndex++);
    }

    @Override
    public boolean hasNext() {
        return lineIndex < lines.size();
    }

    @Override
    public void close() {
    }
}
