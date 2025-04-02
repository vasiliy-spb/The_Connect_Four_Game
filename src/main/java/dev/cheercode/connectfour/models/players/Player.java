package dev.cheercode.connectfour.models.players;

import dev.cheercode.connectfour.models.Board;
import dev.cheercode.connectfour.models.Disk;

public interface Player {
    int select(Board board);

    String getName();

    Disk getDisk();
}
