package dev.cheercode.connectfour;

public final class BoardFactory {
    private static final int HEIGHT = 6;
    private static final int WIDTH = 7;

    private BoardFactory() {
    }

    public static Board create() {
        return new Board(HEIGHT, WIDTH);
    }
}
