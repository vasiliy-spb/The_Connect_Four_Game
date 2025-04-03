package dev.cheercode.connectfour.user_input_readers;

public interface UserInputReader {
    String readLine();

    boolean hasNext();

    void close();
}
