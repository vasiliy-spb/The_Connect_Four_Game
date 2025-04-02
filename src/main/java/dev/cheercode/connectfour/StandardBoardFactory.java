package dev.cheercode.connectfour;

public final class StandardBoardFactory {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 7;

    private StandardBoardFactory() {
    }

    public static Board create() {
        return new Board(HEIGHT, WIDTH);
    }
}
