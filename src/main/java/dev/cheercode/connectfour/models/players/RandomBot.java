package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Disk;

import java.util.Random;

public class RandomBot extends AbstractPlayer {
    private static final Random RANDOM = new Random();

    public RandomBot(String name, Disk disk) {
        super(name, disk);
    }

    @Override
    public int select(Board board) {
        int firstColumn = 1;
        int lastColumn = board.getWidth();
        return RANDOM.nextInt(firstColumn, lastColumn + 1);
    }
}
