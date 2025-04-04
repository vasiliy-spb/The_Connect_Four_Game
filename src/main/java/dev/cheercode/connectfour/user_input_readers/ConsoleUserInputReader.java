package dev.cheercode.connectfour.user_input_readers;

import java.util.Scanner;

public final class ConsoleUserInputReader implements UserInputReader {
    private final Scanner scanner;

    private ConsoleUserInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public static ConsoleUserInputReader getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public String readLine() {
        return scanner.nextLine();
    }

    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    @Override
    public void close() {
        scanner.close();
    }

    private static class Holder {
        private static final ConsoleUserInputReader INSTANCE = new ConsoleUserInputReader();
    }
}
