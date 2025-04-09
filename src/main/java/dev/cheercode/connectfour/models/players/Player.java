package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Color;

public interface Player {
    int select(Board board);

    String getName();

    Color getColor();
}
