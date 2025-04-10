package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Color;

import java.util.Random;

public class RandomBot extends AbstractPlayer {
    private static final Random RANDOM = new Random();

    public RandomBot(String name, Color color) {
        super(name, color);
    }

    @Override
    public int select(Board board) {
        System.out.println("Ходит " + name);
        int firstColumn = 1;
        int lastColumn = board.getWidth();
        return RANDOM.nextInt(firstColumn, lastColumn + 1);
    }
}
